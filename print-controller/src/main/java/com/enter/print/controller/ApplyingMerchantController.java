package com.enter.print.controller;

import com.enter.print.config.EnterPrintAppConfig;
import com.enter.print.config.EnterpriseWeChatMessageConfig;
import com.enter.print.context.secret.aes.WXBizMsgCrypt;
import com.enter.print.pojo.dto.other.EnterpriseWeChatMessageDTO;
import com.enter.print.pojo.vo.ApplyingMerchantVO;
import com.enter.print.result.ResultBean;
import com.enter.print.service.ApplyingMerchantService;
import com.enter.print.service.CallBackService;
import com.enter.util.exception.AesException;
import com.enter.util.exception.CheckedException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 * @author zqg
 * @version 1.0
 * 配置企业微信回调接收事件服务器   用于接收企业微信返回数据
 * @date 2019/10/5
 */

@Slf4j
@RestController
public class ApplyingMerchantController {

    @Autowired
    private CallBackService callBackService;

    @Autowired
    private ApplyingMerchantService applyingMerchantService;

    @GetMapping(value = "/Callback")
    public ResultBean coreJoinGet(@RequestParam(value = "msg_signature") String msgSignature,
                                  EnterpriseWeChatMessageDTO enterpriseWeChatMessageDTO, HttpServletRequest request, HttpServletResponse response)
            throws CheckedException, AesException, IOException {
        log.info(msgSignature, enterpriseWeChatMessageDTO.getTimestamp(), enterpriseWeChatMessageDTO.getNonce(), enterpriseWeChatMessageDTO.getEchostr());
        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
        WXBizMsgCrypt wxBizMsgCrypt = new WXBizMsgCrypt(EnterpriseWeChatMessageConfig.TOKEN, EnterpriseWeChatMessageConfig.EncodingAESKey, EnterPrintAppConfig.ENTERPRISE_WE_CHAT_APP_ID);
        String result = wxBizMsgCrypt.VerifyURL(msgSignature, enterpriseWeChatMessageDTO.getTimestamp(), enterpriseWeChatMessageDTO.getNonce(), enterpriseWeChatMessageDTO.getEchostr());
       /*msg_signature=09b61509792814d65af915129f40a10b701c8f79
       &timestamp=1561131149
       &nonce=1560926718
       &echostr=xybWHBueYdo2bJddAnVlUPBqWYFcmjYqL96PnRqWJp0A%2FrCO8HojYJ5LCc4qj1yO06hfNGuLZDfq2iDElumo7A%3D%3D HTTP/1.1" 200 97 "-" "Mozilla/4.0"*/
        if (result == null) {
            result = EnterpriseWeChatMessageConfig.TOKEN;
        }
        log.info("返回：" + result);

        PrintWriter out = response.getWriter();
        out.println(result);
        out.close();
        return new ResultBean();
    }

    @PostMapping("/Callback")
    public ResultBean coreJoinPost(@RequestParam(value = "msg_signature") String msgSignature, EnterpriseWeChatMessageDTO enterpriseWeChatMessageDTO,
                                   HttpServletRequest request, HttpServletResponse response) throws IOException, AesException, CheckedException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        InputStream inputStream = request.getInputStream();
        String postData = IOUtils.toString(inputStream, "UTF-8");

        WXBizMsgCrypt wxBizMsgCrypt = new WXBizMsgCrypt(EnterpriseWeChatMessageConfig.TOKEN, EnterpriseWeChatMessageConfig.EncodingAESKey, EnterPrintAppConfig.ENTERPRISE_WE_CHAT_APP_ID);
        String msg = wxBizMsgCrypt.DecryptMsg(msgSignature, enterpriseWeChatMessageDTO.getTimestamp(),
                enterpriseWeChatMessageDTO.getNonce(), postData);
        if (msg != null) {
            log.info("解析消息msg：" + msg);
        }

        callBackService.processRequestToAddMerchant(msg);

        return new ResultBean();
    }

    @RequestMapping("/getAllApplyingMerchant")
    public ResultBean getAllApplyingMerchantServices() {
        return new ResultBean<>(applyingMerchantService.selectAll());
    }

    @RequestMapping("/getApplyingMerchant")
    public ResultBean getApplyingMerchantService(ApplyingMerchantVO applyingMerchantVO) {
        return new ResultBean<>(applyingMerchantService.selectByPrimary(applyingMerchantVO));
    }

    @RequestMapping("/addApplyingMerchant")
    public ResultBean addApplyingMerchantService(ApplyingMerchantVO applyingMerchantVO) throws Exception {
        applyingMerchantService.insert(applyingMerchantVO);
        return new ResultBean<>();
    }

    @RequestMapping("/updateApplyingMerchant")
    public ResultBean updateApplyingMerchantService(ApplyingMerchantVO applyingMerchantVO) {
        applyingMerchantService.updateByPrimary(applyingMerchantVO);
        return new ResultBean<>();
    }

    @RequestMapping("/deleteApplyingMerchant")
    public ResultBean deleteApplyingMerchantService(ApplyingMerchantVO applyingMerchantVO) {
//        applyingMerchantService.deleteByPrimary(applyingMerchantVO);
        return new ResultBean<>();
    }
}

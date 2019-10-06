package com.enter.print.utils;

import com.alibaba.fastjson.JSONObject;
import com.enter.print.config.EnterPrintAppConfig;
import com.enter.print.pojo.dto.entity.ApplyingMerchantDTO;
import com.enter.util.exception.CheckedException;
import com.enter.util.utils.HttpUrlUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WeAppMessageUtil {



    public static void sendApplySuccessMessageToUser(ApplyingMerchantDTO applyingMerchantDTO) throws CheckedException {

        String formId = WeChatTemplateMessageConfig.formId1;
        String touser = applyingMerchantDTO.getUserOpenId();
        String params = WeChatMessageParamsUtils.getAppliedMerchantDTOJsonParams(applyingMerchantDTO,formId,touser);
        String json = HttpUrlUtils.sendPostWithParamsString(WeChatTemplateMessageConfig.WE_APP_URL + EnterPrintAppConfig.accessToken, params);
        String errcode = JSONObject.parseObject(json).get("errcode").toString();
        if (!WeChatTemplateMessageConfig.CORRECT_CODE.equals(errcode)) {
            String errmsg = JSONObject.parseObject(json).get("errmsg").toString();
            throw new CheckedException("发送给用户入驻成功模板通知失败：errmsg: " + errmsg);
        }

    }
    public static void sendApplicationMessageToUser(ApplyingMerchantDTO applyingMerchantDTO) throws CheckedException {

        String[] formIds = applyingMerchantDTO.getFormIds();
        String formId = formIds[0];
        WeChatTemplateMessageConfig.formId1=formIds[0];
        String touser = applyingMerchantDTO.getUserOpenId();
        String params = WeChatMessageParamsUtils.getApplyingMerchantDTOJsonParams(applyingMerchantDTO, formId, touser);
        String json = HttpUrlUtils.sendPostWithParamsString(WeChatTemplateMessageConfig.WE_APP_URL + EnterPrintAppConfig.accessToken, params);
        String errcode = JSONObject.parseObject(json).get("errcode").toString();
        if (!WeChatTemplateMessageConfig.CORRECT_CODE.equals(errcode)) {
            String errmsg = JSONObject.parseObject(json).get("errmsg").toString();
            throw new CheckedException("发送给用户申请入驻模板通知失败：errmsg: " + errmsg);
        }

    }

}

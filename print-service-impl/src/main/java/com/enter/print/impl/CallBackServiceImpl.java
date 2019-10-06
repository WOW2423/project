package com.enter.print.impl;

import com.enter.print.context.secret.aes.XMLParse;
import com.enter.print.database.mysql.mybatis.ApplyingMerchantMapper;
import com.enter.print.database.mysql.mybatis.MerchantMapper;
import com.enter.print.pojo.dto.entity.ApplyingMerchantDTO;
import com.enter.print.pojo.entity.ApplyingMerchant;
import com.enter.print.pojo.entity.Merchant;
import com.enter.print.service.CallBackService;
import com.enter.print.utils.WeAppMessageUtil;
import com.enter.util.exception.AesException;
import com.enter.util.exception.CheckedException;
import com.enter.util.utils.IdUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Liquid
 * @version 1.0
 * @date 2019/10/5
 */

@Slf4j
@com.alibaba.dubbo.config.annotation.Service(
        version = "1.0",
        timeout = 10000
)
@Service("callBackService")
public class CallBackServiceImpl implements CallBackService {
    @Autowired
    private MerchantMapper merchantMapper;
    @Autowired
    private ApplyingMerchantMapper applyingMerchantMapper;

    private static final String KEY="key111";

    @Override
    public void processRequestToAddMerchant(String msg) throws AesException, CheckedException {
        String[] result = XMLParse.extractTaskCard(msg);
        String eventKey = result[2];
        //线下审核人员
        if (isPass(eventKey)) {
            String id = result[3].substring(result[3].lastIndexOf("d") + 1);
            int applyingMerchantId = Integer.parseInt(id);
            ApplyingMerchant applyingMerchant = applyingMerchantMapper.selectByPrimaryKey(applyingMerchantId);
            insertMerchant(applyingMerchant);

            ApplyingMerchantDTO applyingMerchantDTO = new ApplyingMerchantDTO().convertToDTO(applyingMerchant);
            WeAppMessageUtil.sendApplySuccessMessageToUser(applyingMerchantDTO);
            //发审核通过
        } else {
            //发审核失败
            log.info("result ：线下审核该商家不合格");
        }
    }

    private boolean isPass(String eventKey) {
        return eventKey != null && eventKey.equals(KEY);
    }

    private void insertMerchant(ApplyingMerchant applyingMerchant) {
        Merchant merchant = new Merchant();
        merchant.setId(Integer.valueOf(IdUtils.getRandomStringId()));
        merchant.setUserId(applyingMerchant.getUserId());
        merchant.setName(applyingMerchant.getName());
        merchant.setEnterpriseWxId(applyingMerchant.getQywxId());
        merchant.setLinkman(applyingMerchant.getLinkman());
        merchant.setDistrict(applyingMerchant.getDistrict());
        merchant.setDetailAddress(applyingMerchant.getDetailAddress());
        merchant.setTelephone(applyingMerchant.getTelephone());
        merchant.setAllTime();
        merchantMapper.insert(merchant);
    }
}

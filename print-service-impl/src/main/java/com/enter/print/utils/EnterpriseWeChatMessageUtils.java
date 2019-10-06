package com.enter.print.utils;

import com.alibaba.fastjson.JSONObject;
import com.enter.print.config.EnterPrintAppConfig;
import com.enter.print.pojo.dto.entity.ApplyingMerchantDTO;
import com.enter.util.exception.CheckedException;
import com.enter.util.utils.HttpUrlUtils;

/**
 * @author Liquid
 * @类名： EnterpriseWeChatMessageUtils
 * @描述：
 * @date 2019/1/8
 */
public class EnterpriseWeChatMessageUtils {


    public static void sendApplicationToCorporateSector(ApplyingMerchantDTO applyingMerchantDTO) throws CheckedException {
        String params = WeChatMessageParamsUtils.getApplyingMerchantDTOJsonParamsToEnterpriseWeChat(applyingMerchantDTO, WeChatTemplateMessageConfig.TO_PARTY_ID);
        String json = HttpUrlUtils.sendPostWithParamsString(WeChatTemplateMessageConfig.ENTERPRISE_WE_CHAT_URL+ EnterPrintAppConfig.enterpriseWeChatAccessToken,params);
        String errcode = JSONObject.parseObject(json).get("errrcode").toString();
        if (!WeChatTemplateMessageConfig.CORRECT_CODE.equals(errcode)) {
            String errmsg = JSONObject.parseObject(json).get("errmsg").toString();
            throw new CheckedException("发送给企业微信项目组商家入驻任务通知失败：errmsg: " + errmsg);
        }
    }

   /* public static void sendFeedbackToCorporateSector(FeedbackDTO feedbackDTO) throws CheckedException {
        String params =WeChatMessageParamsUtils.getFeedbackDTOJsonParamsToEnterpriseWeChat(feedbackDTO,WeChatTemplateMessageConfig.TO_PARTY_ID);
        String json = HttpUrlUtils.sendPost(WeChatTemplateMessageConfig.ENTERPRISE_WE_CHAT_URL+ EnterPrintAppConfig.enterpriseWeChatAccessToken, params);
        String errcode = JSONObject.parseObject(json).get("errcode").toString();
        if (!WeChatTemplateMessageConfig.CORRECT_CODE.equals(errcode)) {
            String errmsg = JSONObject.parseObject(json).get("errmsg").toString();
            throw new CheckedException("发送给企业反馈通知失败：errmsg: " + errmsg);
        }
    }*/


}

 package com.enter.print.utils;

 import com.alibaba.fastjson.JSONObject;
 import com.alibaba.fastjson.PropertyNamingStrategy;
 import com.alibaba.fastjson.serializer.SerializeConfig;
 import com.alibaba.fastjson.serializer.SerializerFeature;
 import com.enter.print.config.EnterPrintAppConfig;
 import com.enter.print.pojo.dto.entity.ApplyingMerchantDTO;
 import com.enter.print.pojo.dto.other.EnterpriseWeChatTemplateDTO;
 import com.enter.print.pojo.dto.other.WeChatTemplateDTO;
 import com.enter.print.pojo.entity.other.BtnData;
 import com.enter.print.pojo.entity.other.TaskCard;
 import com.enter.util.exception.CheckedException;
 import com.enter.util.utils.TimeUtils;

 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;

 /**
 * @author Liquid
 * @类名： WeChatMessageParamsUtils
 * @描述：
 * @date 2019/1/8
 */
public class WeChatMessageParamsUtils {

    private static SerializeConfig serializeConfig;

    static {
        serializeConfig = new SerializeConfig();
        serializeConfig.setPropertyNamingStrategy(PropertyNamingStrategy.SnakeCase);
    }

   /* static String getFeedbackDTOJsonParams(FeedbackDTO feedbackDTO, String touser) {

        Map<String, TemplateData> data = new HashMap<>();
        TemplateData first = new TemplateData();
        TemplateData keyword2 = new TemplateData();
        TemplateData keyword4 = new TemplateData();
        TemplateData remark = new TemplateData();
        first.setValue("收到用户反馈信息");
        first.setColor("#173177");
        keyword2.setValue(feedbackDTO.getAdvice());
        keyword2.setColor("#173177");
        keyword4.setValue(TimeUtils.getCurrentTimeString());
        keyword4.setColor("#173177");
        String phone = StringUtils.isBlank(feedbackDTO.getTelephone()) ? "无" : feedbackDTO.getTelephone();
        remark.setValue("手机：" + phone);
        remark.setColor("#173177");
        data.put("first", first);
        data.put("keyword2", keyword2);
        data.put("keyword4", keyword4);
        data.put("remark", remark);
        Miniprogram miniprogram = new Miniprogram();
        miniprogram.setAppid(EnterPrintAppConfig.APP_ID);
        miniprogram.setPagepath(WeChatTemplateMessageConfig.INDEX_PAGE);
        WeChatPublicTemplateDTO weChatPublicTemplateDTO = new WeChatPublicTemplateDTO();
        weChatPublicTemplateDTO.setData(data);
        weChatPublicTemplateDTO.setTemplateId(WeChatTemplateMessageConfig.FEEDBACK_MESSAGE_ID);
        weChatPublicTemplateDTO.setTouser(touser);
        weChatPublicTemplateDTO.setMiniprogram(miniprogram);
        return JSONObject.toJSONString(weChatPublicTemplateDTO, serializeConfig, SerializerFeature.DisableCircularReferenceDetect);

    }*/

    /*static String getFeedbackDTOJsonParamsToEnterpriseWeChat(FeedbackDTO feedbackDTO, String to) {
        WeChatTemplateData phone = new WeChatTemplateData();
        WeChatTemplateData advice = new WeChatTemplateData();
        phone.setKey("反馈人联系电话");
        phone.setValue(!StringUtils.isBlank(feedbackDTO.getTelephone()) ? "无" : feedbackDTO.getTelephone());
        advice.setKey("反馈内容");
        advice.setValue(feedbackDTO.getAdvice());
        List<WeChatTemplateData> contentItem = new LinkedList<>();
        contentItem.add(phone);
        contentItem.add(advice);
        MiniprogramNotice miniprogramNotice = new MiniprogramNotice();
        miniprogramNotice.setAppid(EnterPrintAppConfig.APP_ID);
        miniprogramNotice.setPage(WeChatTemplateMessageConfig.INDEX_PAGE);
        miniprogramNotice.setTitle("用户反馈通知");
        miniprogramNotice.setDescription(TimeUtils.getCurrentTimeString());
        miniprogramNotice.setEmphasisFirstItem(false);
        miniprogramNotice.setContentItem(contentItem);
        EnterpriseWeChatTemplateDTO enterpriseWeChatTemplateDTO = new EnterpriseWeChatTemplateDTO();
        enterpriseWeChatTemplateDTO.setToparty(to);
        enterpriseWeChatTemplateDTO.setMsgtype(WeChatTemplateMessageConfig.MSGTYPE);
        enterpriseWeChatTemplateDTO.setMiniprogramNotice(miniprogramNotice);
        return JSONObject.toJSONString(enterpriseWeChatTemplateDTO, serializeConfig, SerializerFeature.DisableCircularReferenceDetect);
    }*/

    //推送企业微信任务消息卡片
    static String getApplyingMerchantDTOJsonParamsToEnterpriseWeChat(ApplyingMerchantDTO applyingMerchantDTO, String to){
        BtnData key1 =new BtnData();
        BtnData key2 =new BtnData();
        List<BtnData> btn =new ArrayList<BtnData>();
        key1.setKey("kay111");
        key1.setName("批准");
        key1.setReplace_name("已入驻");
        key2.setKey("key222");
        key2.setName("驳回");
        key2.setReplace_name("不合格");
        btn.add(key1);
        btn.add(key2);
        TaskCard taskCard =new TaskCard();
        taskCard.setTitle("商家入驻申请");
        taskCard.setDesrciption("申请人："+applyingMerchantDTO.getLinkman()+"<br>"+"电话："+applyingMerchantDTO.getTelephone()+"<br>"
        +"地址："+applyingMerchantDTO.getDetailAddress());
        taskCard.setTask_id("taskid"+applyingMerchantDTO.getId());
        taskCard.setBtn(btn);
        EnterpriseWeChatTemplateDTO enterpriseWeChatTemplateDTO = new EnterpriseWeChatTemplateDTO();
        enterpriseWeChatTemplateDTO.setToparty(to);
        enterpriseWeChatTemplateDTO.setAgentid(EnterPrintAppConfig.AGENT_ID);
        enterpriseWeChatTemplateDTO.setMsgtype(WeChatTemplateMessageConfig.MSGTYPE_TASK);
        enterpriseWeChatTemplateDTO.setTaskCard(taskCard);

        return JSONObject.toJSONString(enterpriseWeChatTemplateDTO, serializeConfig, SerializerFeature.DisableCircularReferenceDetect);
    }

     //向正在申请的商家推送微信模板通知
    static String getApplyingMerchantDTOJsonParams(ApplyingMerchantDTO applyingMerchantDTO, String formId, String touser) {
        String createTime = TimeUtils.dateDefaultFormatToString(applyingMerchantDTO.getCreateTime());
        String clerkname = "恩特打印团队";
        HashMap<String, String> linkman = new HashMap<>(2);
        HashMap<String, String> name = new HashMap<>(2);
        HashMap<String, String> detailAddress = new HashMap<>(2);
        HashMap<String,String>   applyingTime =new HashMap<>(2);
        HashMap<String,String>  clerk =new HashMap<>(2);
        HashMap<String, HashMap<String, String>> data = new HashMap<>(10);
        linkman.put("value",applyingMerchantDTO.getLinkman());
        name.put("value",applyingMerchantDTO.getName());
        detailAddress.put("vlaue",applyingMerchantDTO.getDetailAddress());
        applyingTime.put("value",createTime);
        clerk.put("value",clerkname);
        data.put("keyword1", linkman);
        data.put("keyword2", name);
        data.put("keyword3", detailAddress);
        data.put("keyword4", applyingTime);
        data.put("keyword5", clerk);
        WeChatTemplateDTO weChatTemplateDTO = new WeChatTemplateDTO();
        weChatTemplateDTO.setTouser(touser);
        weChatTemplateDTO.setTemplateId(WeChatTemplateMessageConfig.APPLYING_MESSAGE_ID);
        weChatTemplateDTO.setPage(WeChatTemplateMessageConfig.INDEX_PAGE);
        weChatTemplateDTO.setFormId(formId);
        weChatTemplateDTO.setData(data);
        weChatTemplateDTO.setEmphasisKeyword(WeChatTemplateMessageConfig.EMPHASIS_KEYWORD);
        return JSONObject.toJSONString(weChatTemplateDTO, serializeConfig, SerializerFeature.DisableCircularReferenceDetect);
    }

     //向用户推送已成功申请为入驻商家的通知
    static String getAppliedMerchantDTOJsonParams(ApplyingMerchantDTO applyingMerchantDTO, String formId, String touser) throws CheckedException {
        String createTime = TimeUtils.dateDefaultFormatToString((applyingMerchantDTO.getCreateTime()));
        HashMap<String, String> name = new HashMap<>(2);
        HashMap<String, String> linkman = new HashMap<>(2);
        HashMap<String, String> detailAddress = new HashMap<>(2);
        HashMap<String,String>  settlingTime =new HashMap<>(2);
        HashMap<String,String>   applyingTime =new HashMap<>(2);
        HashMap<String, HashMap<String, String>> data = new HashMap<>(10);
        name.put("value",applyingMerchantDTO.getName());
        linkman.put("value",applyingMerchantDTO.getLinkman());
        detailAddress.put("vlaue",applyingMerchantDTO.getDetailAddress());
        settlingTime.put("value", TimeUtils.getCurrentTimeString());
        applyingTime.put("value",createTime);
        data.put("keyword1", linkman);
        data.put("keyword2", name);
        data.put("keyword3", detailAddress);
        data.put("keyword4", applyingTime);
        data.put("keyword5", settlingTime);
        WeChatTemplateDTO weChatTemplateDTO = new WeChatTemplateDTO();
        weChatTemplateDTO.setTouser(touser);
        weChatTemplateDTO.setTemplateId(WeChatTemplateMessageConfig.APPLY_SUCCESS_ID);
        weChatTemplateDTO.setPage(WeChatTemplateMessageConfig.INDEX_PAGE);
        weChatTemplateDTO.setFormId(formId);
        weChatTemplateDTO.setData(data);
        weChatTemplateDTO.setEmphasisKeyword(WeChatTemplateMessageConfig.EMPHASIS_KEYWORD);
        return JSONObject.toJSONString(weChatTemplateDTO, serializeConfig, SerializerFeature.DisableCircularReferenceDetect);
    }

}

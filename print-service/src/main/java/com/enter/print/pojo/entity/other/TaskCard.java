package com.enter.print.pojo.entity.other;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class TaskCard implements Serializable {

    private static final long serialVersionUID = -8035861623526481781L;

    private String title;

    private String desrciption;

    private String task_id;

    private List<BtnData> btn;

    /**
     *回调URL，用户点击任务卡片的按钮后，企业微信会回调任务卡片事件到该URL。
     */
    private String url;


}

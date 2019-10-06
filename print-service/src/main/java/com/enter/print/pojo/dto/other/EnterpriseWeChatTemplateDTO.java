package com.enter.print.pojo.dto.other;

import com.enter.print.pojo.entity.other.MiniprogramNotice;
import com.enter.print.pojo.entity.other.TaskCard;
import lombok.Data;

import java.io.Serializable;

@Data
public class EnterpriseWeChatTemplateDTO implements Serializable{
    private static final long serialVersionUID = -4774301254866236848L;

    String touser;

    String toparty;

    String totag;

    String msgtype;

    MiniprogramNotice miniprogramNotice;

    String agentid;

    TaskCard taskCard;

}

package com.enter.print.pojo.entity;

import com.enter.util.exception.CheckedException;
import com.enter.util.utils.IdUtils;
import com.enter.util.utils.TimeUtils;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Table(name = "print_user")
public class PrintUser implements Serializable {
    private static final long serialVersionUID = -396524380916508321L;
    /**
     * 用户id
     */
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private String userId;

    /**
     * 微信userOpenid
     */
    @Column(name = "user_openid")
    private String userOpenid;

    /**
     * 用户会话钥匙
     */
    @Column(name = "user_session_key")
    private String userSessionKey;

    /**
     * 用户头像
     */
    @Column(name = "user_avatar_url")
    private String userAvatarUrl;

    /**
     * 用户微信昵称
     */
    @Column(name = "user_nickname")
    private String userNickname;

    /**
     * 用户所在城市
     */
    @Column(name = "user_city")
    private String userCity;

    /**
     * 用户微信绑定电话
     */
    @Column(name = "user_phone_number")
    private String userPhoneNumber;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 最后更新时间
     */
    @Column(name = "last_update_time")
    private Date lastUpdateTime;


    public void setUserIdAndAllTime() throws CheckedException {
        Date currentTime = TimeUtils.getCurrentTime();
        this.setCreateTime(currentTime);
        this.setLastUpdateTime(currentTime);
        this.setUserId(IdUtils.getRandomStringId());
    }

    public void refreshLastUpdateTime() throws CheckedException {
        Date currentTime = TimeUtils.getCurrentTime();
        this.setLastUpdateTime(currentTime);
    }
}

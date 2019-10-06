package com.enter.print.pojo.entity;

import com.enter.print.pojo.entity.infc.TimeSet;
import com.enter.util.utils.TimeUtils;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Liquid
 * @version 1.0
 * @date 2019/9/29
 */

@Data
@Table(name = "print_applying_merchant")
public class ApplyingMerchant implements Serializable, TimeSet {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    /**
     * 店主userId
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 企业微信Id
     */
    @Column(name = "enterprise_wx_id")
    private String qywxId;

    /**
     * 店名
     */
    @Column(name = "name")
    private String name;

    /**
     * 所在区域
     */
    @Column(name = "district")
    private String district;

    /**
     * 商家地址
     */
    @Column(name = "detail_address")
    private String detailAddress;

    /**
     * 商家联系人
     */
    @Column(name = "linkman")
    private String linkman;

    /**
     * 商家联系方式
     */
    @Column(name = "telephone")
    private String telephone;

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

    @Override
    public void setAllTime() {
        Date currentTime = TimeUtils.getCurrentTime();
        this.setCreateTime(currentTime);
        this.setLastUpdateTime(currentTime);
    }

    @Override
    public void refreshLastUpdateTime() {
        Date currentTime = TimeUtils.getCurrentTime();
        this.setLastUpdateTime(currentTime);
    }

}
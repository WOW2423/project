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
 * @date 2019/9/26
 */

@Data
@Table(name = "print_merchant")
public class Merchant implements Serializable,TimeSet {
    private static final long serialVersionUID = 1983437701692363737L;
    /**
     * 商家id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    /**
     * 店主userId
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 店名
     */
    private String name;

    /**
     * 商家微信号
     */
    @Column(name = "wechat_number")
    private String wechatNumber;

    /**
     * 是否在线
     */
    private Boolean online;

    /**
     * 企业微信Id
     */
    @Column(name = "enterprise_wx_id")
    private String enterpriseWxId;

    /**
     * 关联地区id
     */
    @Column(name = "district_id")
    private Integer districtId;

    /**
     * 地区
     */
    private String district;

    /**
     * 商家地址
     */
    @Column(name = "detail_address")
    private String detailAddress;

    /**
     * 营业状态
     */
    private Integer status;

    /**
     * 经度
     */
    private Integer longitude;

    /**
     * 纬度
     */
    private Integer latitude;

    /**
     * 商家联系人
     */
    private String linkman;

    /**
     * 商家联系电话
     */
    private String telephone;

    /**
     * 打印类型（用,分割）
     */
    @Column(name = "print_service_type")
    private String printServiceType;

    /**
     * 配送范围（用,分割）
     */
    @Column(name = "distribution_area")
    private String distributionArea;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 最后一次修改时间
     */
    @Column(name = "last_update_time")
    private Date lastUpdateTime;

    /**
     * 店铺简介(公告说明)
     */
    private String introduction;


    @Override
    public void setAllTime() {
        Date currentTime = TimeUtils.getCurrentTime();
        this.setCreateTime(currentTime);
        this.setLastUpdateTime(currentTime);
    }

    @Override
    public void refreshLastUpdateTime() {
        this.setLastUpdateTime(TimeUtils.getCurrentTime());
    }
}
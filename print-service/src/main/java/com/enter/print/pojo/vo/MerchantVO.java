package com.enter.print.pojo.vo;

import com.enter.print.pojo.vo.infc.VoPackageHelper;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Liquid
 * @类名： MerchantVO
 * @描述：
 * @date 2019/9/29
 */
@Data
public class MerchantVO implements Serializable,VoPackageHelper {
    private static final long serialVersionUID = 5820168823038809133L;


    /**
     * 商家id
     */

    private Integer id;

    /**
     * 店主userId
     */
    private String userId;

    /**
     * 店名
     */
    private String name;

    /**
     * 商家微信号
     */
    private String wechatNumber;

    /**
     * 是否在线
     */
    private Boolean online;

    /**
     * 企业微信Id
     */
    private String enterpriseWxId;

    /**
     * 关联地区id
     */
    private Integer districtId;

    /**
     * 地区
     */
    private String district;

    /**
     * 商家地址
     */
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
    private String printServiceType;

    /**
     * 配送范围（用,分割）
     */
    private String distributionArea;


    /**
     * 店铺简介(公告说明)
     */
    private String introduction;

    @Override
    public Integer getId(){
        return id;
    }


    @Override
    public Integer getParentId() {
        return districtId;
    }

    @Override
    public void setSons(List sons) {
    }
}

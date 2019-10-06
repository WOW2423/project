package com.enter.print.pojo.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @author Liquid
 * @类名： ApplyingMerchantVO
 * @描述：
 * @date 2019/10/5
 */
@Data
public class ApplyingMerchantVO implements Serializable {

    private static final long serialVersionUID = -7043751467973497115L;


    /**
     * id
     */
    private Integer id;

    /**
     * 用户openid
     */
    private String userOpenId;

    /**
     * 店主userId
     */
    private String userId;

    /**
     * 企业微信Id
     */
    private String qywxId;

    /**
     * 店名
     */
    private String name;

    /**
     * 所在区域
     */
    private String district;

    /**
     * 商家地址
     */
    private String detailAddress;

    /**
     * 商家联系人
     */
    private String linkman;

    /**
     * 商家联系方式
     */
    @Pattern(regexp = "^1(3|4|5|7|8)\\d{9}$")
    private String telephone;

    @NotNull
    private String[] formIds;
}

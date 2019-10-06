package com.enter.print.pojo.dto.entity;

import com.enter.print.pojo.DoConvertible;
import com.enter.print.pojo.VoConvertible;
import com.enter.print.pojo.entity.Merchant;
import com.enter.print.pojo.vo.MerchantVO;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

/**
 * @author Liquid
 * @version 1.0
 * @date 2019/10/2
 */

@Data
public class MerchantDTO implements Serializable {
    private static final long serialVersionUID = -7511540091411480705L;

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

    private static MerchantDoConvert merchantDoConvert;

    private static MerchantVoConvert merchantVoConvert;

    static {
        merchantDoConvert = new MerchantDoConvert();
        merchantVoConvert = new MerchantVoConvert();
    }

    public Merchant convertToDo() {
        return merchantDoConvert.convertToDO(this);
    }

    public MerchantDTO convertToDTO(Merchant merchant) {
        return merchantDoConvert.convertToDTO(merchant);
    }

    public MerchantVO convertToVo() {
        return merchantVoConvert.convertToVO(this);
    }

    public MerchantDTO convertToDTO(MerchantVO merchantVO) {
        return merchantVoConvert.convertToDTO(merchantVO);
    }

    private static class MerchantDoConvert implements DoConvertible<Merchant, MerchantDTO> {
        @Override
        public Merchant convertToDO(MerchantDTO merchantDTO) {
            Merchant merchant = new Merchant();
            BeanUtils.copyProperties(merchantDTO, merchant);
            return merchant;
        }

        @Override
        public MerchantDTO convertToDTO(Merchant merchant) {
            MerchantDTO merchantDTO = new MerchantDTO();
            BeanUtils.copyProperties(merchant, merchantDTO);
            return merchantDTO;
        }
    }

    private static class MerchantVoConvert implements VoConvertible<MerchantVO, MerchantDTO> {

        @Override
        public MerchantVO convertToVO(MerchantDTO merchantDTO) {
            MerchantVO merchantVO = new MerchantVO();
            BeanUtils.copyProperties(merchantDTO, merchantVO);
            return merchantVO;
        }

        @Override
        public MerchantDTO convertToDTO(MerchantVO merchantVO) {
            MerchantDTO merchantDTO = new MerchantDTO();
            BeanUtils.copyProperties(merchantVO, merchantDTO);
            return merchantDTO;
        }
    }
}

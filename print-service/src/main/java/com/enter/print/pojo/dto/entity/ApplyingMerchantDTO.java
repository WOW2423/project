package com.enter.print.pojo.dto.entity;

import com.enter.print.pojo.DoConvertible;
import com.enter.print.pojo.VoConvertible;
import com.enter.print.pojo.entity.ApplyingMerchant;
import com.enter.print.pojo.vo.ApplyingMerchantVO;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Liquid
 * @version 1.0
 * @date 2019/9/29
 */

@Data
public class ApplyingMerchantDTO implements Serializable {

    private static final long serialVersionUID = 4321546423137670925L;

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
    private String telephone;

    /**
     * 创建时间
     */
    private Date createTime;

    @NotNull
    private String[] formIds;

    private static ApplyingMerchantDoConvert applyingMerchantDoConvert;

    private static ApplyingMerchantVoConvert applyingMerchantVoConvert;

    static {
        applyingMerchantDoConvert = new ApplyingMerchantDoConvert();
        applyingMerchantVoConvert = new ApplyingMerchantVoConvert();
    }

    public ApplyingMerchant convertToDo() {
        return applyingMerchantDoConvert.convertToDO(this);
    }

    public ApplyingMerchantDTO convertToDTO(ApplyingMerchant applyingMerchant) {
        return applyingMerchantDoConvert.convertToDTO(applyingMerchant);
    }


    public ApplyingMerchantVO convertToVo() {
        return applyingMerchantVoConvert.convertToVO(this);
    }

    public ApplyingMerchantDTO convertToDTO(ApplyingMerchantVO applyingMerchantVO) {
        return applyingMerchantVoConvert.convertToDTO(applyingMerchantVO);
    }

    private static class ApplyingMerchantDoConvert implements DoConvertible<ApplyingMerchant, ApplyingMerchantDTO> {
        @Override
        public ApplyingMerchant convertToDO(ApplyingMerchantDTO applyingMerchantDTO) {
            ApplyingMerchant applyingMerchant = new ApplyingMerchant();
            BeanUtils.copyProperties(applyingMerchantDTO, applyingMerchant);
            return applyingMerchant;
        }

        @Override
        public ApplyingMerchantDTO convertToDTO(ApplyingMerchant applyingMerchant) {
            ApplyingMerchantDTO applyingMerchantDTO = new ApplyingMerchantDTO();
            BeanUtils.copyProperties(applyingMerchant, applyingMerchantDTO);
            return applyingMerchantDTO;
        }
    }

    private static class ApplyingMerchantVoConvert implements VoConvertible<ApplyingMerchantVO, ApplyingMerchantDTO> {

        @Override
        public ApplyingMerchantVO convertToVO(ApplyingMerchantDTO applyingMerchantDTO) {
            ApplyingMerchantVO applyingMerchantVO = new ApplyingMerchantVO();
            BeanUtils.copyProperties(applyingMerchantDTO,applyingMerchantVO );
            return applyingMerchantVO;
        }

        @Override
        public ApplyingMerchantDTO convertToDTO(ApplyingMerchantVO applyingMerchantVO) {
            ApplyingMerchantDTO applyingMerchantDTO = new ApplyingMerchantDTO();
            BeanUtils.copyProperties(applyingMerchantVO, applyingMerchantDTO);
            return applyingMerchantDTO;
        }
    }
}


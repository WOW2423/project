package com.enter.print.pojo.dto.entity;

import com.enter.print.pojo.DoConvertible;
import com.enter.print.pojo.VoConvertible;
import com.enter.print.pojo.entity.District;
import com.enter.print.pojo.vo.DistrictVO;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

/**
 * @author Liquid
 * @类名： DistrictDTO
 * @描述：
 * @date 2019/9/29
 */
@Data
public class DistrictDTO implements Serializable {
    private static final long serialVersionUID = -6162885867123547026L;

    /**
     * 区域id
     */

    private Integer id;

    /**
     * 区域名
     */
    private String name;

    /**
     * 关联学校id
     */
    private Integer schoolId;

    private static DistrictDoConvert districtDoConvert;

    private static DistrictVoConvert districtVoConvert;

    static {
        districtDoConvert = new DistrictDoConvert();
        districtVoConvert = new DistrictVoConvert();
    }

    public District convertToDo() {
        return districtDoConvert.convertToDO(this);
    }

    public DistrictDTO convertToDTO(District district) {
        return districtDoConvert.convertToDTO(district);
    }


    public DistrictVO convertToVo() {
        return districtVoConvert.convertToVO(this);
    }

    public DistrictDTO convertToDTO(DistrictVO districtVO) {
        return districtVoConvert.convertToDTO(districtVO);
    }

    private static class DistrictDoConvert implements DoConvertible<District, DistrictDTO> {
        @Override
        public District convertToDO(DistrictDTO districtDTO) {
            District district = new District();
            BeanUtils.copyProperties(districtDTO, district);
            return district;
        }

        @Override
        public DistrictDTO convertToDTO(District district) {
            DistrictDTO districtDTO = new DistrictDTO();
            BeanUtils.copyProperties(district, districtDTO);
            return districtDTO;
        }
    }

    private static class DistrictVoConvert implements VoConvertible<DistrictVO, DistrictDTO> {

        @Override
        public DistrictVO convertToVO(DistrictDTO districtDTO) {
            DistrictVO districtVO = new DistrictVO();
            BeanUtils.copyProperties(districtDTO,districtVO );
            return districtVO;
        }

        @Override
        public DistrictDTO convertToDTO(DistrictVO districtVO) {
            DistrictDTO districtDTO = new DistrictDTO();
            BeanUtils.copyProperties(districtVO, districtDTO);
            return districtDTO;
        }
    }
}

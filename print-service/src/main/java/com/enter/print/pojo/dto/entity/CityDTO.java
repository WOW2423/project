package com.enter.print.pojo.dto.entity;

import com.enter.print.pojo.DoConvertible;
import com.enter.print.pojo.VoConvertible;
import com.enter.print.pojo.entity.City;
import com.enter.print.pojo.vo.CityVO;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

/**
 * @author Liquid
 * @类名： CityDTO
 * @描述：
 * @date 2019/9/29
 */
@Data
public class CityDTO implements Serializable {
    private static final long serialVersionUID = -9121608284247556760L;

    /**
     * 城市id
     */

    private Integer id;

    /**
     * 城市名
     */
    private String name;


    private static CityDoConvert cityDoConvert;

    private static CityVoConvert cityVoConvert;

    static {
        cityDoConvert = new CityDoConvert();
        cityVoConvert = new CityVoConvert();
    }

    public City convertToDo() {
        return cityDoConvert.convertToDO(this);
    }

    public CityDTO convertToDTO(City city) {
        return cityDoConvert.convertToDTO(city);
    }


    public CityVO convertToVo() {
        return cityVoConvert.convertToVO(this);
    }

    public CityDTO convertToDTO(CityVO cityVO) {
        return cityVoConvert.convertToDTO(cityVO);
    }

    private static class CityDoConvert implements DoConvertible<City, CityDTO> {
        @Override
        public City convertToDO(CityDTO cityDTO) {
            City city = new City();
            BeanUtils.copyProperties(cityDTO, city);
            return city;
        }

        @Override
        public CityDTO convertToDTO(City city) {
            CityDTO cityDTO = new CityDTO();
            BeanUtils.copyProperties(city, cityDTO);
            return cityDTO;
        }
    }

    private static class CityVoConvert implements VoConvertible<CityVO, CityDTO> {

        @Override
        public CityVO convertToVO(CityDTO cityDTO) {
            CityVO cityVO = new CityVO();
            BeanUtils.copyProperties(cityDTO,cityVO );
            return cityVO;
        }

        @Override
        public CityDTO convertToDTO(CityVO cityVO) {
            CityDTO cityDTO = new CityDTO();
            BeanUtils.copyProperties(cityVO, cityDTO);
            return cityDTO;
        }
    }
}

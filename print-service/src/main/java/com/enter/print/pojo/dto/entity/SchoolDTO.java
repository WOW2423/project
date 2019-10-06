package com.enter.print.pojo.dto.entity;

import com.enter.print.pojo.DoConvertible;
import com.enter.print.pojo.VoConvertible;
import com.enter.print.pojo.entity.School;
import com.enter.print.pojo.vo.SchoolVO;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

/**
 * @author Liquid
 * @类名： SchoolDTO
 * @描述：
 * @date 2019/9/29
 */
@Data
public class SchoolDTO implements Serializable {
    private static final long serialVersionUID = -6914466613764260771L;

    /**
     * 学校id
     */
    private Integer id;

    /**
     * 学校名
     */
    private String name;

    /**
     * 关联school
     */
    private Integer cityId;

    private static SchoolDoConvert schoolDoConvert;

    private static SchoolVoConvert schoolVoConvert;

    static {
        schoolDoConvert = new SchoolDTO.SchoolDoConvert();
        schoolVoConvert = new SchoolDTO.SchoolVoConvert();
    }

    public School convertToDo() {
        return schoolDoConvert.convertToDO(this);
    }

    public SchoolDTO convertToDTO(School school) {
        return schoolDoConvert.convertToDTO(school);
    }

    public SchoolVO convertToVo() {
        return schoolVoConvert.convertToVO(this);
    }

    public SchoolDTO convertToDTO(SchoolVO schoolVO) {
        return schoolVoConvert.convertToDTO(schoolVO);
    }

    private static class SchoolDoConvert implements DoConvertible<School, SchoolDTO> {
        @Override
        public School convertToDO(SchoolDTO schoolDTO) {
            School school = new School();
            BeanUtils.copyProperties(schoolDTO, school);
            return school;
        }

        @Override
        public SchoolDTO convertToDTO(School school) {
            SchoolDTO schoolDTO = new SchoolDTO();
            BeanUtils.copyProperties(school, schoolDTO);
            return schoolDTO;
        }
    }

    private static class SchoolVoConvert implements VoConvertible<SchoolVO, SchoolDTO> {

        @Override
        public SchoolVO convertToVO(SchoolDTO schoolDTO) {
            SchoolVO schoolVO = new SchoolVO();
            BeanUtils.copyProperties(schoolDTO, schoolVO);
            return schoolVO;
        }

        @Override
        public SchoolDTO convertToDTO(SchoolVO schoolVO) {
            SchoolDTO schoolDTO = new SchoolDTO();
            BeanUtils.copyProperties(schoolVO, schoolDTO);
            return schoolDTO;
        }
    }
}

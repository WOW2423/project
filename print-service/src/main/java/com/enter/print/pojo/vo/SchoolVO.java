package com.enter.print.pojo.vo;

import com.enter.print.pojo.vo.infc.VoPackageHelper;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Liquid
 * @类名： SchoolVO
 * @描述：
 * @date 2019/9/29
 */
@Data
public class SchoolVO implements Serializable,VoPackageHelper<DistrictVO> {
    private static final long serialVersionUID = -4329262015562756561L;

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


    private List<DistrictVO> districts;

    @Override
    public Integer getParentId() {
        return cityId;
    }

    @Override
    public void setSons(List<DistrictVO> sons) {
        districts=sons;
    }
}

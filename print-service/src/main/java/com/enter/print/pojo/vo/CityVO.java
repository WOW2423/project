package com.enter.print.pojo.vo;

import com.enter.print.pojo.vo.infc.VoPackageHelper;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Liquid
 * @类名： CityVO
 * @描述：
 * @date 2019/9/29
 */
@Data
public class CityVO implements Serializable,VoPackageHelper<SchoolVO> {
    private static final long serialVersionUID = 5284458095854576167L;

    /**
     * 城市id
     */

    private Integer id;

    /**
     * 城市名
     */
    private String name;


    private List<SchoolVO> schools;

    @Override
    public Integer getId(){
        return id;
    }


    @Override
    public Integer getParentId() {
        return null;
    }

    @Override
    public void setSons(List<SchoolVO> sons) {
        this.schools=sons;
    }

}

package com.enter.print.pojo.vo;

import com.enter.print.pojo.vo.infc.VoPackageHelper;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Liquid
 * @类名： DistrictVO
 * @描述：
 * @date 2019/9/29
 */
@Data
public class DistrictVO implements Serializable,VoPackageHelper<MerchantVO> {
    private static final long serialVersionUID = -3157007688535026331L;

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


    private List<MerchantVO> merchants;

    @Override
    public Integer getId(){
        return id;
    }

    @Override
    public Integer getParentId() {
        return schoolId;
    }

    @Override
    public void setSons(List<MerchantVO> sons) {
        merchants=sons;
    }
}

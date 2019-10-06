package com.enter.print.pojo.vo;

import com.enter.print.pojo.vo.infc.VoPackageHelper;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Liquid
 * @类名： CollectionVO
 * @描述：
 * @date 2019/10/1
 */
@Data
public class CollectionVO implements Serializable,VoPackageHelper {
    private static final long serialVersionUID = -2897419220570466109L;

    /**
     * 个人收藏id
     */
    private Integer id;

    /**
     * 关联用户Id
     */
    private String userId;

    /**
     * 商家id
     */
    private Integer merchantId;

    /**
     * 商家名称
     */
    private String merchantName;

    /**
     * 商家头像url
     */
    private String merchantHeadPath;

    @Override
    public Integer getParentId() {
        return null;
    }

    @Override
    public void setSons(List sons) {

    }
}

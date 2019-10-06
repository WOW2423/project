package com.enter.print.pojo.dto.entity;

import com.enter.print.pojo.DoConvertible;
import com.enter.print.pojo.VoConvertible;
import com.enter.print.pojo.entity.Collection;
import com.enter.print.pojo.vo.CollectionVO;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

/**
 * @author Liquid
 * @类名： CollectionDTO
 * @描述：
 * @date 2019/9/26
 */
@Data
public class CollectionDTO implements Serializable {
    private static final long serialVersionUID = 7777609136306526252L;

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


    private static CollectionDoConvert collectionDoConvert;
    private static CollectionVoConvert collectionVoConvert;

    static {
        collectionDoConvert = new CollectionDoConvert();
        collectionVoConvert = new CollectionVoConvert();
    }

    public Collection convertToDo() {

        return collectionDoConvert.convertToDO(this);
    }

    public CollectionDTO convertToDTO(Collection collection) {
        return collectionDoConvert.convertToDTO(collection);
    }

    public CollectionVO convertToVo() {
        return collectionVoConvert.convertToVO(this);
    }

    public CollectionDTO convertToDTO(CollectionVO collectionVO) {
        return collectionVoConvert.convertToDTO(collectionVO);
    }

    public static class CollectionDoConvert implements DoConvertible<Collection, CollectionDTO> {

        @Override
        public Collection convertToDO(CollectionDTO collectionDTO) {
            Collection collection = new Collection();
            BeanUtils.copyProperties(collectionDTO, collection);
            return collection;
        }

        @Override
        public CollectionDTO convertToDTO(Collection collection) {
            CollectionDTO collectionDTO = new CollectionDTO();
            BeanUtils.copyProperties(collection, collectionDTO);
            return collectionDTO;
        }
    }

    public static class CollectionVoConvert implements VoConvertible<CollectionVO, CollectionDTO> {
        @Override
        public CollectionVO convertToVO(CollectionDTO collectionDTO) {
            CollectionVO collectionVO = new CollectionVO();
            BeanUtils.copyProperties(collectionDTO, collectionVO);
            return collectionVO;
        }

        @Override
        public CollectionDTO convertToDTO(CollectionVO collectionVO) {
            CollectionDTO collectionDTO = new CollectionDTO();
            BeanUtils.copyProperties(collectionVO, collectionDTO);
            return collectionDTO;
        }
    }
}

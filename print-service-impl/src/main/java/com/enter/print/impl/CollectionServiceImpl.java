package com.enter.print.impl;

import com.enter.print.database.mysql.mybatis.CollectionMapper;
import com.enter.print.pojo.dto.entity.CollectionDTO;
import com.enter.print.pojo.entity.Collection;
import com.enter.print.pojo.vo.CollectionVO;
import com.enter.print.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Liquid
 * @类名： CollectionServiceImpl
 * @描述：
 * @date 2019/9/26
 */
@com.alibaba.dubbo.config.annotation.Service(
        version = "1.0",
        timeout = 10000
)
@Service("collectionService")
public class CollectionServiceImpl implements CollectionService {

    @Autowired
    private CollectionMapper collectionMapper;


    @Override
    public void insert(CollectionVO collectionVO) throws Exception {
        Collection collection = new CollectionDTO().convertToDTO(collectionVO).convertToDo();
        collection.setAllTime();
        collectionMapper.insertSelective(collection);
    }

    @Override
    public List<CollectionVO> selectAll() {
        List<Collection> collections = collectionMapper.selectAll();
        List<CollectionVO> result = new ArrayList<>();
        for (Collection collection:collections){
            result.add(new CollectionDTO().convertToDTO(collection).convertToVo());
        }
        return  result;
    }

    @Override
    public CollectionVO selectByPrimary(CollectionVO collectionVO) {
        return new CollectionDTO()
                .convertToDTO(collectionMapper
                        .selectByPrimaryKey(new CollectionDTO().convertToDTO(collectionVO).getId()))
                .convertToVo();
    }

    @Override
    public void updateByPrimary(CollectionVO collectionVO) {
        Collection collection = new CollectionDTO().convertToDTO(collectionVO).convertToDo();
        collection.refreshLastUpdateTime();
        collectionMapper.updateByPrimaryKeySelective(collection);
    }

    @Override
    public void deleteByPrimary(CollectionVO collectionVO) {
        collectionMapper.deleteByPrimaryKey(new CollectionDTO().convertToDTO(collectionVO).getId());
    }
}

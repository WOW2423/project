package com.enter.print.controller;

import com.enter.print.pojo.vo.CollectionVO;
import com.enter.print.result.ResultBean;
import com.enter.print.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Liquid
 * @类名： CollectionController
 * @描述：
 * @date 2019/9/26
 */
@RestController
public class CollectionController {

    @Autowired
    private CollectionService collectionService;

    @RequestMapping("/getAllCollectionServices")
    public ResultBean getAllCollectionServices() {
        return new ResultBean<>(collectionService.selectAll());
    }

    @RequestMapping("/getCollectionService")
    public ResultBean getCollectionService(CollectionVO collectionVO) {
        return new ResultBean<>(collectionService.selectByPrimary(collectionVO));
    }

    @RequestMapping("/addCollectionService")
    public ResultBean addCollectionService(CollectionVO collectionVO)throws Exception{
        collectionService.insert(collectionVO);
        return new ResultBean<>();
    }

    @RequestMapping("/updateCollectionService")
    public ResultBean updateCollectionService(CollectionVO collectionVO){
        collectionService.updateByPrimary(collectionVO);
        return new ResultBean<>();
    }

    @RequestMapping("/deleteCollectionService")
    public ResultBean deleteCollectionService(CollectionVO collectionVO){
//        collectionService.deleteByPrimary(collectionVO);
        return new ResultBean<>();
    }

}

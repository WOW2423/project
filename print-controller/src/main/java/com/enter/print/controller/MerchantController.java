package com.enter.print.controller;

import com.enter.print.pojo.vo.*;
import com.enter.print.result.ResultBean;
import com.enter.print.service.ApplyingMerchantService;
import com.enter.print.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Liquid
 * @version 1.0
 * @date 2019/10/5
 */

@RestController
public class MerchantController {

    @Autowired
    private MerchantService merchantService;
    @Autowired
    private ApplyingMerchantService applyingMerchantService;

    @PostMapping("/getAllMerchants")
    public ResultBean getAllMerchants() {
        return new ResultBean<>(merchantService.selectAll());
    }

    @PostMapping("/applyToMerchant")
    public ResultBean applyToMerchant(@Validated ApplyingMerchantVO applyingMerchantVO) throws Exception {
        applyingMerchantService.insert(applyingMerchantVO);
        return new ResultBean();
    }

    @PostMapping("/getMerchantDetail")
    public ResultBean getMerchantDetail(MerchantVO merchantVO) {
        return new ResultBean<>(merchantService.selectByPrimary(merchantVO));
    }

    @GetMapping("/getMerchantList")
    public ResultBean getMerchantListByPageInfo(WeChatProgramMerchantListVO weChatProgramMerchantListVO) {
        return new ResultBean<>(merchantService.getMerchantListWithCitySchoolAndDistrict(weChatProgramMerchantListVO.getPageInfo()));
    }
    @GetMapping("/getConnectionList")
    public ResultBean getCollectionListByUserId(CollectionVO collectionVO){
       return  new ResultBean<>(merchantService.getCollectionListWithUserID(collectionVO.getUserInfo()));
    };
}

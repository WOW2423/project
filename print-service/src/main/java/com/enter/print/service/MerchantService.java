package com.enter.print.service;

import com.enter.print.pojo.dto.other.PageInfo;
import com.enter.print.pojo.vo.MerchantVO;
import com.enter.print.pojo.vo.WeChatProgramMerchantListVO;
import com.enter.print.service.infc.Cruder;

public interface MerchantService extends Cruder<MerchantVO> {


      WeChatProgramMerchantListVO getMerchantListWithCitySchoolAndDistrict(PageInfo pageInfo);


}

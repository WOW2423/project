package com.enter.print.pojo.vo;

import com.enter.print.pojo.dto.other.PageInfo;
import com.enter.print.pojo.vo.infc.VoPackageHelper;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Liquid
 * @类名： WeChatProgramMerchantListVO
 * @描述：
 * @date 2019/9/29
 */
@Data
public class WeChatProgramMerchantListVO implements Serializable {


    private static final long serialVersionUID = -3860491896190555023L;

    private List<VoPackageHelper> cities;

    private PageInfo pageInfo;


}

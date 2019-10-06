package com.enter.print.pojo.vo;

import com.enter.print.pojo.vo.infc.VoPackageHelper;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Liquid
 * @类名： WeChatProgramPrintCollectionListVO
 * @描述：
 * @date 2019/10/5
 */
@Data
public class WeChatProgramPrintCollectionListVO implements Serializable{

    private static final long serialVersionUID = -1043802208171519836L;

    private List<VoPackageHelper> cities;

}

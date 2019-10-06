package com.enter.print.pojo.vo.infc;

import java.util.List;

/**
 * @author Liquid
 * @类名： VoPackageHelper
 * @描述：
 * @date 2019/10/1
 */
public interface VoPackageHelper<S> {

    Integer getId();

    Integer getParentId();

    void  setSons(List<S> sons);
}

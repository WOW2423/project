package com.enter.print.pojo.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Liquid
 * @类名： PrintServiceVO
 * @描述：
 * @date 2019/10/1
 */
@Data
public class PrintServiceVO implements Serializable {
    private static final long serialVersionUID = 6156052393044546802L;

    /**
     * 服务项目id
     */
    private Integer id;

    /**
     * 关联商家id
     */

    private String merchantId;

    /**
     * 打印服务名称
     */
    private String item;

    /**
     * 打印服务类型（单面/双面）
     */
    private String type;

    /**
     * 打印服务价格
     */
    private String price;
}

package com.enter.print.pojo.entity;

import com.enter.print.pojo.entity.infc.TimeSet;
import com.enter.util.utils.TimeUtils;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Liquid
 * @version 1.0
 * @date 2019/9/26
 */
@Data
@Table(name = "print_service")
public class PrintService implements Serializable,TimeSet {

    private static final long serialVersionUID = -810909599164170774L;
    /**
     * 服务项目id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    /**
     * 关联商家id
     */
    @Column(name = "merchant_id")
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
     * 打印服务价格说明
     */
    private String price;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "last_update_time")
    private Date lastUpdateTime;

//    public PrintService() {
//    }

//    public PrintService(String merchantId, String item, String type, String price, Date createTime, Date lastUpdateTime) {
//        this.merchantId = merchantId;
//        this.item = item;
//        this.type = type;
//        this.price = price;
//        this.createTime = createTime;
//        this.lastUpdateTime = lastUpdateTime;
//    }

    @Override
    public void setAllTime() {
        Date currentTime = TimeUtils.getCurrentTime();
        this.setCreateTime(currentTime);
        this.setLastUpdateTime(currentTime);
    }

    @Override
    public void refreshLastUpdateTime() {
        this.setLastUpdateTime(TimeUtils.getCurrentTime());
    }
}
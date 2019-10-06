package com.enter.print.pojo.entity;

import com.enter.print.pojo.entity.infc.TimeSet;
import com.enter.util.utils.TimeUtils;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Liquid
 * @version 1.0
 * @date 2019/9/26
 */
@Data
@Table(name = "print_collection")
public class Collection implements TimeSet {
    /**
     * 个人收藏id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    /**
     * 关联用户Id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 商家id
     */
    @Column(name = "merchant_id")
    private Integer merchantId;

    /**
     * 商家名称
     */
    @Column(name = "merchant_name")
    private String merchantName;

    /**
     * 商家头像url
     */
    @Column(name = "merchant_head_path")
    private String merchantHeadPath;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 最后更新时间
     */
    @Column(name = "last_update_time")
    private Date lastUpdateTime;

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
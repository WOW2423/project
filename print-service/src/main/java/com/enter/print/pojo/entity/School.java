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
 * @date 2019/9/29
 */
@Data
@Table(name = "print_school")
public class School implements Serializable,TimeSet {
    private static final long serialVersionUID = 9192050578352376059L;
    /**
     * 学校id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    /**
     * 学校名
     */
    private String name;

    /**
     * 关联city
     */
    @Column(name = "city_id")
    private Integer cityId;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 最后一次更新时间
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
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
@Table(name = "print_district")
public class District implements Serializable,TimeSet {
    private static final long serialVersionUID = -7698375542956774991L;
    /**
     * 区域id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    /**
     * 区域名
     */
    private String name;

    /**
     * 关联学校id
     */
    @Column(name = "school_id")
    private Integer schoolId;

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
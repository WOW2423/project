package com.enter.print.database.mysql.mybatis;

import com.enter.print.pojo.entity.ApplyingMerchant;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author Liquid
 * @version 1.0
 * @date 2019/10/6
 */

@org.apache.ibatis.annotations.Mapper
@Repository
public interface ApplyingMerchantMapper extends Mapper<ApplyingMerchant> {

    int selectIdByName(String name);
}
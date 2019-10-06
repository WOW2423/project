package com.enter.print.database.mysql.mybatis;

import com.enter.print.pojo.entity.Merchant;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author Liquid
 * @version 1.0
 * @date 2019/9/26
 */

@org.apache.ibatis.annotations.Mapper
@Repository
public interface MerchantMapper extends Mapper<Merchant> {
}
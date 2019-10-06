package com.enter.print.database.mysql.mybatis;

import com.enter.print.pojo.entity.PrintUser;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
@org.apache.ibatis.annotations.Mapper
public interface PrintUserMapper extends Mapper<PrintUser> {
}

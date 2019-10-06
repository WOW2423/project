package com.enter.print.pojo.dto.other;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Liquid
 * @类名： LoginCheckDTO
 * @描述： 登录校验DTO
 * @date 2019/9/26
 */
@Data
public class LoginCheckDTO implements Serializable{

    private static final long serialVersionUID = -2255463046044981156L;
    private String projectType;

    private String token;

    private String resultInfo;

    private String userId;

    private Boolean result;
}

package com.enter.print.controller;

import com.enter.print.pojo.dto.other.TestDTO;
import com.enter.print.pojo.entity.Test;
import com.enter.print.result.ResultBean;
import com.enter.print.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Liquid
 * @description
 * @date 2019/9/20
 */
@RestController
public class WelcomeController {


    @Autowired
    private TestService testService;




    @RequestMapping("/welcome")
    public ResultBean welcome(TestDTO testDTO){
        String information="部署失败";
        List<Test> tests = testService.test();
        if (tests!=null && !tests.isEmpty()){
            information="部署成功";
        }
        return new ResultBean<String>(information);
    }

//    @RequestMapping("/dubbo-user")
//    public ResultBean welcome( ) throws CheckedException {
//
//        userService.getPhoneNumber(new UserVO());
//        return new ResultBean<>("成功");
//    }
}

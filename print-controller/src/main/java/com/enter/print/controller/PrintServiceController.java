package com.enter.print.controller;

import com.enter.print.pojo.vo.PrintServiceVO;
import com.enter.print.result.ResultBean;
import com.enter.print.service.PrintServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Liquid
 * @类名： PrintServiceController
 * @描述：
 * @date 2019/9/26
 */
@RestController
public class PrintServiceController {

    @Autowired
    private PrintServiceService printServiceService;

    @RequestMapping("/getAllPrintServices")
    public ResultBean getAllPrintServices() {

        return new ResultBean<>(printServiceService.selectAll());
    }

    @RequestMapping("/getPrintService")
    public ResultBean getPrintService(PrintServiceVO printServiceVO) {

        return new ResultBean<>(printServiceService.selectByPrimary(printServiceVO));
    }

    @RequestMapping("/addPrintService")
    public ResultBean addPrintService(PrintServiceVO printServiceVO) throws Exception {
        printServiceService.insert(printServiceVO);
        return new ResultBean<>();
    }

    @RequestMapping("/updatePrintService")
    public ResultBean updatePrintService(PrintServiceVO printServiceVO) {
        printServiceService.updateByPrimary(printServiceVO);
        return new ResultBean<>();
    }

    @RequestMapping("/deletePrintService")
    public ResultBean deletePrintService(PrintServiceVO printServiceVO) {
//        printServiceService.deleteByPrimary(printServiceVO);
        return new ResultBean<>();
    }

}

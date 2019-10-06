package com.enter.print.impl;

import com.enter.print.database.mysql.mybatis.PrintServiceMapper;
import com.enter.print.pojo.dto.entity.PrintServiceDTO;
import com.enter.print.pojo.entity.PrintService;
import com.enter.print.pojo.vo.PrintServiceVO;
import com.enter.print.service.PrintServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Liquid
 * @类名： PrintServiceServiceImpl
 * @描述：
 * @date 2019/9/26
 */
@com.alibaba.dubbo.config.annotation.Service(
        version = "1.0",
        timeout = 10000
)
@Service("printServiceService")
public class PrintServiceServiceImpl implements PrintServiceService {

    @Autowired
    private PrintServiceMapper printServiceMapper;

    @Override
    public void insert(PrintServiceVO printServiceVO)   {
        PrintService printService = new PrintServiceDTO().convertToDTO(printServiceVO).convertToDo();
        printService.setAllTime();
        printServiceMapper.insertSelective(printService);
    }

    @Override
    public List<PrintServiceVO> selectAll() {
        List<PrintService> printServices = printServiceMapper.selectAll();
        List<PrintServiceVO> result = new ArrayList<>();
        for (PrintService printService : printServices) {
            result.add(new PrintServiceDTO().convertToDTO(printService).convertToVo());
        }
        return result;
    }

    @Override
    public PrintServiceVO selectByPrimary(PrintServiceVO printServiceVO) {
        return new PrintServiceDTO()
                .convertToDTO(printServiceMapper
                        .selectByPrimaryKey(new PrintServiceDTO().convertToDTO(printServiceVO).getId()))
                .convertToVo();
    }

    @Override
    public void updateByPrimary(PrintServiceVO printServiceVO) {
        PrintService printService = new PrintServiceDTO().convertToDTO(printServiceVO).convertToDo();
        printService.refreshLastUpdateTime();
        printServiceMapper.updateByPrimaryKeySelective(printService);
    }

    @Override
    public void deleteByPrimary(PrintServiceVO printServiceVO) {
        printServiceMapper.deleteByPrimaryKey(new PrintServiceDTO().convertToDTO(printServiceVO).getId());
    }
}

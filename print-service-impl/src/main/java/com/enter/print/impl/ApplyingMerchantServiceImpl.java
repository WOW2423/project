package com.enter.print.impl;

import com.enter.print.database.mysql.mybatis.ApplyingMerchantMapper;
import com.enter.print.database.mysql.mybatis.MerchantMapper;
import com.enter.print.database.mysql.mybatis.PrintUserMapper;
import com.enter.print.pojo.dto.entity.ApplyingMerchantDTO;
import com.enter.print.pojo.entity.ApplyingMerchant;
import com.enter.print.pojo.entity.Merchant;
import com.enter.print.pojo.vo.ApplyingMerchantVO;
import com.enter.print.service.ApplyingMerchantService;
import com.enter.print.utils.EnterpriseWeChatMessageUtils;
import com.enter.print.utils.WeAppMessageUtil;
import com.enter.util.exception.CheckedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@com.alibaba.dubbo.config.annotation.Service(
        version = "1.0",
        timeout = 10000
)
@Service("applyingMerchantService")
public class ApplyingMerchantServiceImpl implements ApplyingMerchantService {

    @Autowired
    private ApplyingMerchantMapper applyingMerchantMapper;

    @Autowired
    private PrintUserMapper userMapper;

    @Autowired
    private MerchantMapper merchantMapper;

    @Override
    public void insert(ApplyingMerchantVO applyingMerchantVO) throws CheckedException {

        ApplyingMerchantDTO applyingMerchantDTO = new ApplyingMerchantDTO().convertToDTO(applyingMerchantVO);
        WeAppMessageUtil.sendApplicationMessageToUser(applyingMerchantDTO);
        ApplyingMerchant applyingMerchant = applyingMerchantDTO.convertToDo();
        String userId = applyingMerchantDTO.getUserId();
        Merchant merchant = new Merchant();
        merchant.setUserId(userId);
        if (merchantMapper.selectCount(merchant) == 0) {
            applyingMerchant.setAllTime();
            applyingMerchantMapper.insertSelective(applyingMerchant);
            applyingMerchantDTO.setUserOpenId(userMapper.selectByPrimaryKey(applyingMerchantDTO.getUserId()).getUserOpenid());
            if (applyingMerchantDTO.getUserOpenId() != null) {
                EnterpriseWeChatMessageUtils.sendApplicationToCorporateSector(applyingMerchantDTO);
            } else {
                log.info("openid不存在");
            }
        } else {
            log.info("该用户已入驻");
        }
    }

    @Override
    public List<ApplyingMerchantVO> selectAll() {
        List<ApplyingMerchant> applyingMerchants = applyingMerchantMapper.selectAll();
        List<ApplyingMerchantVO> result = new ArrayList<>();
        for (ApplyingMerchant applyingMerchant:applyingMerchants){
            result.add(new ApplyingMerchantDTO().convertToDTO(applyingMerchant).convertToVo());
        }
        return  result;
    }

    @Override
    public ApplyingMerchantVO selectByPrimary(ApplyingMerchantVO applyingMerchantVO) {
        return new ApplyingMerchantDTO()
                .convertToDTO(applyingMerchantMapper
                        .selectByPrimaryKey(new ApplyingMerchantDTO().convertToDTO(applyingMerchantVO).getId()))
                .convertToVo();
    }

    @Override
    public void updateByPrimary(ApplyingMerchantVO applyingMerchantVO) {
        ApplyingMerchant applyingMerchant = new ApplyingMerchantDTO().convertToDTO(applyingMerchantVO).convertToDo();
        applyingMerchant.refreshLastUpdateTime();
        applyingMerchantMapper.updateByPrimaryKeySelective(applyingMerchant);
    }

    @Override
    public void deleteByPrimary(ApplyingMerchantVO applyingMerchantVO) {
        applyingMerchantMapper.deleteByPrimaryKey(new ApplyingMerchantDTO().convertToDTO(applyingMerchantVO).getId());
    }


}

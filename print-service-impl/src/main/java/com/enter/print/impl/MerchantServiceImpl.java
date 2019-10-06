package com.enter.print.impl;

import com.enter.print.database.mysql.mybatis.MerchantMapper;
import com.enter.print.pojo.dto.entity.MerchantDTO;
import com.enter.print.pojo.dto.other.PageInfo;
import com.enter.print.pojo.entity.Merchant;
import com.enter.print.pojo.vo.MerchantVO;
import com.enter.print.pojo.vo.WeChatProgramMerchantListVO;
import com.enter.print.pojo.vo.infc.VoPackageHelper;
import com.enter.print.service.AddressService;
import com.enter.print.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Liquid
 * @类名： MerchantServiceImpl
 * @描述：
 * @date 2019/9/26
 */
@com.alibaba.dubbo.config.annotation.Service(
        version = "1.0",
        timeout = 10000
)
@Service("merchantService")
public class MerchantServiceImpl implements MerchantService {

    @Autowired
    private MerchantMapper merchantMapper;

    @Autowired
    private AddressService addressService;

    /**
     * @param
     * @return
     * @throws null
     * @author Liquid
     * @描述： 返回商家列表，包括关联的城市，学校，区域
     * @date 2019/10/1
     */
    @Override
    public WeChatProgramMerchantListVO getMerchantListWithCitySchoolAndDistrict(PageInfo pageInfo) {

        //获取VO打包接口实现对象
        List<VoPackageHelper> cityVOS = addressService.getAllCityForConvert();
        List<VoPackageHelper> schoolVOS = addressService.getAllSchoolForConvert();
        List<VoPackageHelper> districtVOS = addressService.getAllDistrictForConvert();
        List<VoPackageHelper> merchantVOS = getMerchantVOListForConvert();

        //调用接口通用方式实现VO填充
        packageVO(districtVOS, merchantVOS);
        packageVO(schoolVOS, districtVOS);
        packageVO(cityVOS, schoolVOS);

        //封装前端需要的VO对象
        WeChatProgramMerchantListVO weChatProgramMerchantListVO = new WeChatProgramMerchantListVO();
        weChatProgramMerchantListVO.setCities(cityVOS);
        return weChatProgramMerchantListVO;
    }

    private List<VoPackageHelper> getMerchantVOListForConvert() {
        List<Merchant> merchants = merchantMapper.selectAll();
        List<VoPackageHelper> result = new ArrayList<>();
        for (Merchant merchant : merchants) {
            MerchantVO merchantVO = new MerchantDTO().convertToDTO(merchant).convertToVo();
            result.add(merchantVO);
        }
        return result;
    }

    private void packageVO(List<VoPackageHelper> parentVos, List<VoPackageHelper> vos) {

        for (VoPackageHelper parentVo : parentVos) {
            int id = parentVo.getId();
            List<VoPackageHelper> sons = new ArrayList<>();
            for (VoPackageHelper vo : vos) {
                if (vo.getParentId() == id) {
                    sons.add(vo);
                }
            }
            parentVo.setSons(sons);

        }
    }

    @Override
    public void insert(MerchantVO merchantVO) throws Exception {
        merchantMapper.insertSelective(new MerchantDTO().convertToDTO(merchantVO).convertToDo());
    }

    @Override
    public List<MerchantVO> selectAll() {
        List<Merchant> merchants = merchantMapper.selectAll();
        List<MerchantVO> result = new ArrayList<>();
        for (Merchant merchant : merchants) {
            result.add(new MerchantDTO().convertToDTO(merchant).convertToVo());
        }
        return result;
    }

    @Override
    public MerchantVO selectByPrimary(MerchantVO merchantVO) {
        return new MerchantDTO()
                .convertToDTO(merchantMapper
                        .selectByPrimaryKey(new MerchantDTO().convertToDTO(merchantVO).getId()))
                .convertToVo();
    }

    @Override
    public void updateByPrimary(MerchantVO merchantVO) {
        Merchant merchant = new MerchantDTO().convertToDTO(merchantVO).convertToDo();
        merchant.refreshLastUpdateTime();
        merchantMapper.updateByPrimaryKeySelective(merchant);
    }

    @Override
    public void deleteByPrimary(MerchantVO merchantVO) {
        merchantMapper.deleteByPrimaryKey(new MerchantDTO().convertToDTO(merchantVO).getId());
    }

}

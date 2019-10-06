package com.enter.print.impl;

import com.enter.print.database.mysql.mybatis.CityMapper;
import com.enter.print.database.mysql.mybatis.DistrictMapper;
import com.enter.print.database.mysql.mybatis.SchoolMapper;
import com.enter.print.pojo.dto.entity.CityDTO;
import com.enter.print.pojo.dto.entity.DistrictDTO;
import com.enter.print.pojo.dto.entity.SchoolDTO;
import com.enter.print.pojo.dto.other.PageInfo;
import com.enter.print.pojo.entity.City;
import com.enter.print.pojo.entity.District;
import com.enter.print.pojo.entity.School;
import com.enter.print.pojo.vo.CityVO;
import com.enter.print.pojo.vo.DistrictVO;
import com.enter.print.pojo.vo.SchoolVO;
import com.enter.print.pojo.vo.infc.VoPackageHelper;
import com.enter.print.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Liquid
 * @类名： AddressServiceImpl
 * @描述：
 * @date 2019/9/29
 */
@com.alibaba.dubbo.config.annotation.Service(
        version = "1.0",
        timeout = 10000
)
@Service("addressService")
public class AddressServiceImpl implements AddressService {

    @Autowired
    private CityMapper cityMapper;

    @Autowired
    private SchoolMapper schoolMapper;

    @Autowired
    private DistrictMapper districtMapper;

    @Override
    public void addCity(CityDTO cityDTO) {
        City city = cityDTO.convertToDo();
        city.setAllTime();
        cityMapper.insert(city);
    }

    @Override
    public void addSchool(SchoolDTO schoolDTO) {
        School school = schoolDTO.convertToDo();
        school.setAllTime();
        schoolMapper.insert(school);
    }

    @Override
    public void addDistrict(DistrictDTO districtDTO) {
        District district = districtDTO.convertToDo();
        district.setAllTime();
        districtMapper.insert(district);
    }

    @Override
    public void getCityLimit(CityDTO cityDTO,PageInfo pageInfo) {

    }

    @Override
    public void getSchoolLimit(CityDTO cityDTO, PageInfo pageInfo) {

    }

    @Override
    public void getDistrictLimit(CityDTO cityDTO, PageInfo pageInfo) {

    }

    @Override
    public List<VoPackageHelper> getAllCityForConvert() {
        List<City> cities = cityMapper.selectAll();
        List<VoPackageHelper> result = new ArrayList<>();
        for (City city : cities) {
            CityVO cityVO = new CityDTO().convertToDTO(city).convertToVo();
            result.add(cityVO);
        }
        return result;
    }

    @Override
    public List<VoPackageHelper> getAllSchoolForConvert() {
        List<School> schools = schoolMapper.selectAll();
        List<VoPackageHelper> result = new ArrayList<>();
        for (School school : schools) {
            SchoolVO schoolVO = new SchoolDTO().convertToDTO(school).convertToVo();
            result.add(schoolVO);
        }
        return result;
    }

    @Override
    public List<VoPackageHelper> getAllDistrictForConvert() {
        List<District> districts = districtMapper.selectAll();
        List<VoPackageHelper> result = new ArrayList<>();
        for (District district : districts) {
            DistrictVO districtVO = new DistrictDTO().convertToDTO(district).convertToVo();
            result.add(districtVO);
        }
        return result;
    }

    @Override
    public List<CityVO> getAllCity() {
        return null;
    }

}

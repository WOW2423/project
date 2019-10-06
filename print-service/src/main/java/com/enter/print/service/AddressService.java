package com.enter.print.service;

import com.enter.print.pojo.dto.entity.CityDTO;
import com.enter.print.pojo.dto.entity.DistrictDTO;
import com.enter.print.pojo.dto.entity.SchoolDTO;
import com.enter.print.pojo.dto.other.PageInfo;
import com.enter.print.pojo.vo.CityVO;
import com.enter.print.pojo.vo.infc.VoPackageHelper;

import java.util.List;

/**
 * @author Liquid
 * @类名： AddressService
 * @描述：
 * @date 2019/9/29
 */
public interface AddressService {

    void addCity(CityDTO cityDTO);

    void addSchool(SchoolDTO schoolDTO);

    void addDistrict(DistrictDTO districtDTO);

    void getCityLimit(CityDTO cityDTO, PageInfo pageInfo);

    void getSchoolLimit(CityDTO cityDTO, PageInfo pageInfo);

    void getDistrictLimit(CityDTO cityDTO, PageInfo pageInfo);

    List<VoPackageHelper> getAllCityForConvert();

    List<VoPackageHelper> getAllSchoolForConvert();

    List<VoPackageHelper> getAllDistrictForConvert();


    List<CityVO> getAllCity();

}

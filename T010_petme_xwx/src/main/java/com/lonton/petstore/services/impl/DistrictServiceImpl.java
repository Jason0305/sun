package com.lonton.petstore.services.impl;

import com.lonton.petstore.entity.District;
import com.lonton.petstore.mappers.DistrictMapper;
import com.lonton.petstore.services.IDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("districtService")
public class DistrictServiceImpl implements IDistrictService {
    @Autowired
    private DistrictMapper districtMapper;
    @Override
    public List<District> getDistricts(String parent) {
        return selectDistrictByParent(parent);
    }
    
    @Override
    public List<District> getDistrictsArr(String parent) {
        List list = districtMapper.selectDistrictsAll();
        return list;
    }
    
    private List<District> selectDistrictByParent(String parent){
        return  districtMapper.selectDistrictByParent(parent);
    }
}

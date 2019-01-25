package com.lonton.petstore.services;

import com.lonton.petstore.entity.District;

import java.util.List;

/**
 *
 *
 * @author xuwanxing
 */
public interface IDistrictService {
    
    List<District> getDistricts(String code);
    List<District> getDistrictsArr(String code);
}

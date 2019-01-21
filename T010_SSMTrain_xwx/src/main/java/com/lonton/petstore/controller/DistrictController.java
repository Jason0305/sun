package com.lonton.petstore.controller;

import com.lonton.petstore.entity.District;
import com.lonton.petstore.entity.ResponseResult;
import com.lonton.petstore.services.IDistrictService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Log4j
@Controller
@RequestMapping("/district")
public class DistrictController {
    @Autowired
    private IDistrictService districtService;
    
    @ResponseBody
    @RequestMapping("/list.do")
    private ResponseResult listAction(String parent){
        List<District> districts = districtService.getDistricts(parent);
        return new ResponseResult<List<District>>(districts);
    }
}

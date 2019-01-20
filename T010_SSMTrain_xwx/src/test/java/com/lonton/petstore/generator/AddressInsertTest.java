package com.lonton.petstore.generator;

import com.lonton.petstore.entity.Address;
import com.lonton.petstore.entity.District;
import com.lonton.petstore.entity.User;
import com.lonton.petstore.mappers.AddressMapper;
import com.lonton.petstore.mappers.DistrictMapper;
import com.lonton.petstore.mappers.UserMapper;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:Spring/spring-*.xml"})
public class AddressInsertTest {
    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DistrictMapper districtMapper;
    
    @Test
    public void addressInsert() {
        Long startTime = System.currentTimeMillis();
        Address address = new Address();
        District area = null;
        for (int i = 0; i < 10000; i++) {
            int uid = (int) (Math.random() * 10000 + 1);
            address.setUid(uid);
            try {
                User user = userMapper.selectByPrimaryKey(uid);
                if (user == null) {
                    log.warn(i);
                    continue;
                }
//                log.info("user=" + user);
                address.setRecvName(user.getUsername());
                
                area = districtMapper.selectRandomArea();
                String areaCode = area.getCode();
                String areaName = area.getName();
                address.setRecvArea(areaCode);
                
                String cityCode = area.getParent();
                District city = districtMapper.selectByCode(cityCode);
                String cityName = city.getName();
                address.setRecvCity(cityCode);
                
                String provinceCode = city.getParent();
                District province = districtMapper.selectByCode(provinceCode);
                String provinceName = province.getName();
                address.setRecvProvince(provinceCode);
                
                address.setRecvAddress(provinceName + cityName + areaName);
                address.setRecvPhone(user.getPhone());
                address.setRecvTel("400-123-1313");
                address.setRecvZipCode(areaCode);
                address.setRecvTag(Math.random() < 0.5 ? "家" : (Math.random() < 0.5 ? "公司" : "代收点"));
                address.setIsDefault(1);
                address.setCreatedTime(new Date());
                addressMapper.insertSelective(address);
            } catch (NullPointerException e) {
                i--;
                continue;
            }
        }
        log.info("插入花费的时间为：" + (System.currentTimeMillis() - startTime) / 1000F + "s");
    }
    
    @Test
    public void test() {
        //        int uid = (int)( Math.random() * 10000+1);
        //        log.info("uid = " + uid);
        //        User user = userMapper.selectByPrimaryKey(uid);
        //        log.info("user=" + user);
        District district = districtMapper.selectByCode("110104");
        log.warn("district = " + district);
        
    }
}

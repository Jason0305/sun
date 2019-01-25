package com.lonton.petstore.services.impl;

import com.lonton.petstore.entity.Address;
import com.lonton.petstore.entity.District;
import com.lonton.petstore.mappers.AddressMapper;
import com.lonton.petstore.mappers.DistrictMapper;
import com.lonton.petstore.services.IAddressService;
import com.lonton.petstore.services.exceptions.AddressNotExistsException;
import com.lonton.petstore.services.exceptions.ArgumentException;
import com.lonton.petstore.services.exceptions.InsertDataException;
import com.lonton.petstore.services.exceptions.UpdateDataException;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 收货地址业务.
 *
 * @author xuwanxing
 */
@Log4j
@Service("addressService")
public class AddressServiceImpl implements IAddressService {
    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private DistrictMapper districtMapper;
    
    /**
     * 新增收货地址.
     *
     * @param address 收货地址
     * @return 当前用户收货地址列表
     */
    @Override
    public void addAddress(Address address) {
        int count = getCountByUid(address.getUid());
        address.setCreatedTime(new Date());
        if (count == 0) {
            // 0:默认收货地址
            address.setIsDefault(0);
        }
        log.error(address);
        insertAddress(address);
    }
    
    private int getCountByUid(Integer uid) {
        return addressMapper.countAddressByUid(uid);
    }
    
    /**
     * 删除当前用户指定id的收货地址.
     *
     * @param id 收货地址id
     */
    @Override
    @Transactional(rollbackForClassName = {"AddressNotExistsException", "ArgumentException", "UpdateDataException"})
    public void deleteAddress(Integer uid, Integer id) throws AddressNotExistsException, ArgumentException, UpdateDataException {
        Address address = getAddressById(id);
        // 1 判断是否存在该收货地址
        if (address == null) {
            //1.1 是,地址存在,比较该地址是否为当前用户的收货地址
            if (address.getUid().equals(uid)) {
                // 1.1.1 是,该收货地址所属于当前用户,
                // 判断是否当前删除地址是否为默认收货地址
                deleteAddressById(id);
                Address lastedAddress = getLatestAddress(uid);
                if (lastedAddress != null) {
                    // 添加最近一条收货地址为默认收货地址
                    updateAddress(lastedAddress);
                }
            } else {
                // 1.1.2 否,尝试删除不为当前用户的数据,参数错误
                throw new ArgumentException("删除失败!参数错误!");
            }
        } else {
            //1.2 否,地址不存在
            throw new AddressNotExistsException("删除失败!当前收货地址不存在!");
        }
    }
    
    @Override
    public Address updateAddress(Integer uid, Address address) throws AddressNotExistsException, UpdateDataException, ArgumentException {
        Address result = getAddressById(address.getId());
        if (result != null) {
            //  否,尝试修改不为当前用户的数据,参数错误
            if (result.getUid().equals(uid)) {
                // 当当前地址设为默认时,将其他默认收货地址设为一般收货地址
                if (address.getIsDefault() == 0) {
                    updateAllNotDefault(uid);
                }
                updateAddress(address);
            } else throw new ArgumentException("修改失败!参数错误!");
            
        }else{
            throw new  AddressNotExistsException("删除失败!当前收货地址不存在!");
        }
        return null;
    }
    
    private void updateAllNotDefault(Integer uid) throws UpdateDataException {
        int rows = addressMapper.updateAllNotDefault(uid);
        if (rows != 1) {
            throw new UpdateDataException("更新收货地址失败!");
        }
    }
    
    private void updateAddress(Address address) throws UpdateDataException {
        int rows = addressMapper.updateByPrimaryKeySelective(address);
        if (rows != 1) {
            throw new UpdateDataException("更新收货地址失败!");
        }
    }
    
    private Address getLatestAddress(Integer uid) {
        return addressMapper.selectLatestAddress(uid);
    }
    
    @Override
    public Address getAddressById(Integer id) {
        return addressMapper.selectByPrimaryKey(id);
    }
    
    /**
     * 获取当前用户的收货地址列表.
     *
     * @param uid 用户id
     * @return 收货地址列表
     */
    @Override
    public List<Address> getAddressList(Integer uid) {
        return selectAddressByUid(uid);
    }
    
    /**
     * 插入收货地址.
     *
     * @param address 地址
     */
    private void insertAddress(Address address) throws InsertDataException {
        address.setCreatedTime(new Date());
        int rows = addressMapper.insertSelective(address);
        if (rows != 1) {
            throw new InsertDataException("未知错误,新增收货地址失败!");
        }
    }
    
    /**
     * 查询用户当前用户的收货地址列表.
     *
     * @param uid 当前用户id
     * @return 收货地址集合
     */
    private List<Address> selectAddressByUid(Integer uid) {
        return addressMapper.selectAddressByUid(uid);
    }
    
    /**
     * 以id为依据删除收货地址.
     *
     * @param id 收货地址id
     * @return 删除成功的条数
     */
    private void deleteAddressById(Integer id) throws UpdateDataException {
        int rows = addressMapper.deleteByPrimaryKey(id);
        if (rows != 1) {
            throw new UpdateDataException("位置错误,地址更新失败!");
        }
    }
    
    private String getAddressDistrict(Address address) {
        District province = districtMapper.selectByCode(address.getRecvProvince());
        District city = districtMapper.selectByCode(address.getRecvCity());
        District area = districtMapper.selectByCode(address.getRecvArea());
        return province.getName() + city.getCode() + area.getName();
    }
}

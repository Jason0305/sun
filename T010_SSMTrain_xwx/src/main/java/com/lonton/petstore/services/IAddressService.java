package com.lonton.petstore.services;

import com.lonton.petstore.entity.Address;
import com.lonton.petstore.services.exceptions.AddressNotExistsException;
import com.lonton.petstore.services.exceptions.ArgumentException;
import com.lonton.petstore.services.exceptions.InsertDataException;
import com.lonton.petstore.services.exceptions.UpdateDataException;

import java.util.List;

/**
 * @author xuwanxing
 */
public interface IAddressService {
    
    Address getAddressById(Integer id);
    
    /**
     * 获取用户所有收货地址。
     *
     * @param uid 用户id
     * @return 收货地址列表
     */
    List<Address> getAddresses(Integer uid);
    
    /**
     * 插入收货地址。
     *
     * @param address     收货地址
     * @return 返回当前新增地址
     * @throws InsertDataException 插入异常
     */
    Address addAddress(Address address);
    
    /**
     *
     * @param id
     * @param uid
     */
    void deleteAddress(Integer uid,Integer id) throws AddressNotExistsException, UpdateDataException, ArgumentException;
    
    Address updateAddress(Integer uid, Address address)throws AddressNotExistsException, UpdateDataException, ArgumentException;
}

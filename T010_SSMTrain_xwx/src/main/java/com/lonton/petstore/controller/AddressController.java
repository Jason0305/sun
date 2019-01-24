package com.lonton.petstore.controller;

import com.lonton.petstore.entity.Address;
import com.lonton.petstore.entity.ResponseResult;
import com.lonton.petstore.services.IAddressService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 地址控制器。
 *
 * @author xuwanxing
 */
@Log4j
@Controller
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private IAddressService addressService;
    
    @RequestMapping("/page.do")
    private String pageAction() {
        return "address";
    }
    
    @RequestMapping(value = "/add_address.do", method = RequestMethod.GET)
    private ResponseResult addAddressAction(Address address, HttpSession session) {
        Integer uid = (Integer) session.getAttribute("uid");
        address.setUid(uid);
        address = addressService.addAddress(address);
        return new ResponseResult<>(address);
    }
    
    @ResponseBody
    @RequestMapping(value = "/list.do", method = RequestMethod.GET)
    private ResponseResult<List<Address>> listAction(HttpSession session) {
        Integer uid = (Integer) session.getAttribute("uid");
        log.error("uid==="+uid);
        List<Address> addresses = addressService.getAddresses(uid);
        return new ResponseResult<>(addresses);
    }
    
    @RequestMapping(value = "/delete.do", method = RequestMethod.GET)
    private ResponseResult deleteAction(Integer id, HttpSession session) {
        Integer uid = (Integer) session.getAttribute("uid");
        addressService.deleteAddress(uid, id);
        return new ResponseResult();
    }
    
    @RequestMapping(value = "/update.do", method = RequestMethod.GET)
    private ResponseResult updateAction(Address address, HttpSession session) {
        Integer uid = (Integer) session.getAttribute("uid");
        addressService.updateAddress(uid, address);
        return new ResponseResult<>(addressService.getAddresses(uid));
    }
}

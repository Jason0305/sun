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

@Log4j
@Controller
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private IAddressService addressService;
    
    @RequestMapping("/page.do")
    private String addressAction() {
        return "address";
    }
    
    @ResponseBody
    @RequestMapping(value="/list.do",method = RequestMethod.GET)
    private ResponseResult listAction(HttpSession session){
        Integer uid = (Integer) session.getAttribute("uid");
        List<Address> addresses = addressService.getAddresses(uid);
        log.info(addresses);
        return new ResponseResult<>(addresses);
    }
}

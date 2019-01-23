package com.lonton.petstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shopcart")
public class ShopCartController {
    @RequestMapping("/page.do")
    private String orderlist(){
        return "shopcart";
    }
}

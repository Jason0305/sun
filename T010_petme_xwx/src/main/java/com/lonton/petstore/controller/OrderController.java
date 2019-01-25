package com.lonton.petstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderController {
    @RequestMapping("/page.do")
    private String orderlist(){
        return "order";
    }
}

package com.lonton.petstore.utils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class VerifyRegularUtilTest {
    
    @Before
    public void setUp() throws Exception {
    }
    
    @After
    public void tearDown() throws Exception {
    }
    
    @Test
    public void verify() {
        HashMap<String, String> pMap = new HashMap<>();
        pMap.put("name", "944593237@qq.com");
        pMap.put("pwd", "123456");
        pMap.put("phone", "15138456324");
        pMap.put("tel", "123456");
        pMap.put("yzbm", "3100562");
        pMap.put("sfz", "413025199802243366");
        pMap.put("url", "http://www.baidu.com");
        pMap.put("ip", "172.1.4.113");
        pMap.put("mac", "EC-B1-D7-49-20-33");
        pMap.put("decimal", "123456.22");
        pMap.put("num", "123");
        pMap.put("n", "2");
        try {
            String errorInfo = Xmlparse4FormVerify.verifyForm("test2", pMap);
            if (errorInfo != null) {
                System.out.println(errorInfo);
            } else {
                System.out.println("表单验证通过！");
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
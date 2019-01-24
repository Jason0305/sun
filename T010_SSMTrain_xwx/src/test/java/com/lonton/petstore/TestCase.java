package com.lonton.petstore;

import lombok.extern.log4j.Log4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

@Log4j
public class TestCase {
    @Test
    public void test(){
        List<String[]> listStr = new ArrayList<>();
        listStr.add(7, new String[]{"asdf","asdf"});
        log.warn(listStr.indexOf(new String[]{"asdf","asdf"}));
        
    }
}

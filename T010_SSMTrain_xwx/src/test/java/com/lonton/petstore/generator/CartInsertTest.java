package com.lonton.petstore.generator;

import com.lonton.petstore.entity.OrderItem;
import com.lonton.petstore.entity.Pet;
import com.lonton.petstore.entity.ShopCart;
import com.lonton.petstore.mappers.ShopCartMapper;
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
public class CartInsertTest {
    @Autowired
    private ShopCartMapper cartMapper;
    
    @Test
    public void CartInsert() {
        Long startTime = System.currentTimeMillis();
        ShopCart cart = new ShopCart();
        for (int i = 1; i < 10000; i++) {
            double count = Math.random() * 10;
            for (int j = 0; j < count; j++) {
                cart.setPetId((int) (Math.random() * 10000) + 1);
                cart.setPetNum((int) (Math.random() * 10) + 1);
                cart.setUid((int) (Math.random() * 10000) + 1);
                cartMapper.insert(cart);
            }
        }
        log.info("插入花费的时间为：" + (System.currentTimeMillis() - startTime) / 1000F + "s");
    }
}

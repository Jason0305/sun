package com.lonton.petstore.generator;

import com.lonton.petstore.entity.OrderItem;
import com.lonton.petstore.entity.Pet;
import com.lonton.petstore.mappers.OrderItemMapper;
import com.lonton.petstore.mappers.PetMapper;
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
public class OrderItemInsertTest {
    @Autowired
    private OrderItemMapper orderItemMapper;
    @Autowired
    private PetMapper petMapper;
    
    @Test
    public void OrderItemInsert() {
        Long startTime = System.currentTimeMillis();
        OrderItem orderItem = new OrderItem();
        for (int i = 1; i < 10000; i++) {
            double count = Math.random() * 3;
            for (int j = 0; j < count; j++) {
                int petId = (int) (Math.random() * 10000);
                Pet pet = petMapper.selectByPrimaryKey(petId);
                if (pet == null) {
                    if (i != 0) i--;
                    continue;
                }
                // Pet pet = petMapper.findPetRandom();
                orderItem.setOrderId(i);
                orderItem.setPetId(petId);
                orderItem.setPetName(pet.getName());
                orderItem.setPetAge((int) (new Date().getTime() - pet.getBirth().getTime()) / (1000 * 365 * 24 * 60 * 60));
                orderItem.setPetColor(pet.getColor());
                orderItem.setPetPrice(pet.getPrice());
                orderItem.setPetImage(pet.getImage());
                orderItem.setPetNum((int) (Math.random() * 10) + 1);
                orderItemMapper.insert(orderItem);
            }
        }
        log.info("插入花费的时间为：" + (System.currentTimeMillis() - startTime) / 1000F + "s");
    }
    
    
}

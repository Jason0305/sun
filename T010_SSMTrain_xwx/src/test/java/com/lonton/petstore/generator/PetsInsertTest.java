package com.lonton.petstore.generator;

import com.lonton.petstore.entity.Pet;
import com.lonton.petstore.mappers.PetMapper;
import com.lonton.petstore.mappers.UserMapper;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:Spring/spring-*.xml"})
public class PetsInsertTest {
    @Autowired
    private PetMapper petMapper;
    @Autowired
    private UserMapper userMapper;
    private Pet pets;
    
    @Test
    public void insertPets() {
        Long startTime = System.currentTimeMillis();
        String[][] names = {
                {"哈士奇", "狗", "小型", "家庭犬", "可爱，小巧", "纯种"},
                {"博美", "狗", "小型", "家庭犬", "可爱，小巧", "纯种"},
                {"柯基", "狗", "小型", "家庭犬", "可爱，短腿", "纯种"},
                {"阿拉斯加", "狗", "小型", "工作犬", "可爱，小巧", "纯种"},
                {"柴犬", "狗", "中型型", "家庭犬", "可爱，小巧", "纯种"},
                {"吉娃娃", "狗", "小型", "家庭犬", "可爱，小巧", "纯种"},
                {"松狮", "狗", "大型", "家庭犬", "可爱，小巧", "纯种"},
                {"牧羊犬", "狗", "小型", "牧羊犬", "可爱，小巧", "纯种"},
                {"藏獒", "狗", "小型", "枪猎犬", "可爱，小巧", "纯种"}};
        String[] colors = {"红色", "斑马色", "白色", "黑色", "黑白相间", "棕色", "奶白色", "咖啡色"};
        //超小型,超大型,小型,中型,大型
        //家庭犬、玩具犬、工作犬、梗类犬、牧羊犬、狩猎犬、枪猎犬
        //聪明,粘人,不掉毛,不爱叫,友善,会看家,耐热,易训
        //int[] admins = userMapper.getAllAdmins();
        for (int i = 0; i < 10000; i++) {
            Pet pet = new Pet();
            int randomNum = (int) Math.floor(Math.random() * names.length);
            pet.setName(names[randomNum][0]);
            pet.setFamily(names[randomNum][1]);
            pet.setSize(names[randomNum][2]);
            pet.setFnFeature(names[randomNum][3]);
            pet.setAdvantages(names[randomNum][4]);
            pet.setVariety(names[randomNum][5]);
            pet.setBirth(new Date(2334));
            pet.setLove(4);
            pet.setColor(colors[(int) Math.floor(Math.random() * colors.length)]);
            pet.setPrice(BigDecimal.valueOf(Math.random() * 7000 + 100));
            pet.setImage("hasiqi.jpg");
            pet.setNum(((int) (Math.random() * 200)) + 10);
            pet.setStatus((int) Math.round(Math.random()));
            pet.setCreatedTime(new Date());
            pet.setCreatedUser(2);
            petMapper.insert(pet);
        }
        log.info("插入花费的时间为：" + (System.currentTimeMillis() - startTime)/1000F + "s");
    }
    
    @Test
    public void test() {
        Date date = null;
//        try {
//            date = new SimpleDateFormat("yyyy-MM-dd").parse("2017-01-01");
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        log.info(date.getTime());
    }
}

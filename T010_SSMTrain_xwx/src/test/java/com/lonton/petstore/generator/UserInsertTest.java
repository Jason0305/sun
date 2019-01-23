package com.lonton.petstore.generator;


import com.lonton.petstore.entity.User;
import com.lonton.petstore.mappers.UserMapper;
import com.lonton.petstore.services.IUserService;
import com.lonton.petstore.services.exceptions.InsertDataException;
import com.lonton.petstore.services.exceptions.UsernameConflictException;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 测试批量插入。
 *
 * @author xuwanxing
 */
@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:Spring/spring-*.xml"})
public class UserInsertTest {
    
    @Autowired
    private UserMapper userMapper;
    private User user;
    @Autowired
    private IUserService userService;
    
    public static int getNum(int start, int end) {
        return (int) (Math.random() * (end - start + 1) + start);
    }
    
    private static String[] telFirst = "134,135,136,137,138,139,150,151,152,157,158,159,130,131,132,155,156,133,153".split(",");
    
    private static String getTel() {
        int index = getNum(0, telFirst.length - 1);
        String first = telFirst[index];
        String second = String.valueOf(getNum(1, 888) + 10000).substring(1);
        String third = String.valueOf(getNum(1, 9100) + 10000).substring(1);
        return first + second + third;
    }
    
    @Test
    public void userInsert() {
        Long startTime = System.currentTimeMillis();
        String firstname = "赵钱孙李周吴郑王冯陈诸卫蒋沈韩杨朱秦尤许何吕施张孔曹严华金魏陶姜戚谢邹喻柏水窦章云苏潘葛奚范彭郎鲁韦昌马苗凤花方俞任袁柳酆鲍史唐费廉岑薛雷贺倪汤滕殷罗毕郝邬安常乐于时傅皮齐康伍余元卜顾孟平黄和穆萧尹姚邵堪汪祁毛禹狄米贝明臧计伏成戴谈宋茅庞熊纪舒屈项祝董粱杜阮蓝闵席季麻强贾路娄危江童颜郭梅盛林刁钟徐邱骆高夏蔡田樊胡凌霍虞万支柯咎管卢莫经房裘干解应宗丁宣贲邓郁单杭洪包诸左石崔吉钮龚";
        String lastname = "明国华建文平志伟东海强晓生光林小民永杰军金健一忠洪江福祥中正振勇耀春大宁亮宇兴宝少剑云学仁涛瑞飞鹏安亚泽世汉达卫利胜敏群波成荣新峰刚家龙德庆斌辉良玉俊立浩天宏子松克清长嘉红山贤阳乐锋智青跃元武广思雄锦威启昌铭维义宗英凯鸿森超坚旭政传康继翔栋仲权奇礼楠炜友年震鑫雷兵万星骏伦绍麟雨行才希彦兆贵源有景升惠臣慧开章润高佳虎根远力进泉茂毅富博霖顺信凡豪树和恩向道川彬柏磊敬书鸣芳培全炳基冠晖京欣廷哲保秋君劲轩帆若连勋祖锡吉崇钧田石奕发洲彪钢运伯满庭申湘皓承梓雪孟其潮冰怀鲁裕翰征谦航士尧标洁城寿枫革纯风化逸腾岳银鹤琳显焕来心凤睿勤延凌昊西羽百捷定琦圣佩麒虹如靖日咏会久昕黎桂玮燕可越彤雁孝宪萌颖艺夏桐月瑜沛诚夫声冬奎扬双坤镇楚水铁喜之迪泰方同滨邦先聪朝善非恒晋汝丹为晨乃秀岩辰洋然厚灿卓杨钰兰怡灵淇美琪亦晶舒菁真涵爽雅爱依静棋宜男蔚芝菲露娜珊雯淑曼萍珠诗璇琴素梅玲蕾艳紫珍丽仪梦倩伊茜妍碧芬儿岚婷菊妮媛莲娟一";
        String en = "zxcvbnmasdfghjklqwertyuiop1234567890ZXCVBNMASDFGHJKLQWERTYUIOP";
        long time = System.nanoTime();
        user = new User();
        for (int i = 0; i < 10000; i++) {
            String username = "" + firstname.charAt((int) (Math.random() * firstname.length())) +
                    lastname.charAt((int) (Math.random() * lastname.length())) +
                    (Math.random() < 0.7 ? "" : lastname.charAt((int) (Math.random() * lastname.length())));
            user.setUsername(username);
            user.setPassword("123abc");
            user.setGender(Math.random() < 0.5 ? 0 : 1);
            user.setEmail(UUID.randomUUID().toString().substring(0, 6) + (Math.random() < 0.5 ? "@qq.com" : "foxmail.com"));
            user.setPhone(getTel());
            user.setAvatar("avatar_default.jpg");
            user.setStatus(Math.random() < 0.1 ? 0 : 1);
            user.setGrade((int) (Math.random() * 3));
            Date createTime = randomDate("2017-07-01","2018-12-12");
            user.setLastLogin(randomDate(new SimpleDateFormat("yyyy-MM-dd").format(createTime).toString(),"2019-01-07"));
            user.setCreatedTime(createTime);
            try {
                userService.register(user);
            } catch (UsernameConflictException e) {
                i--;
            } catch (InsertDataException e) {
                i--;
            }
        }
        log.info(System.nanoTime() - time);
        log.info("插入花费的时间为：" + (System.currentTimeMillis() - startTime) / 1000F + "s");
    }
    
    @Test
    public void Insert() {
        log.warn("1" + (int) (Math.random() * 100 + 30) + (int) (Math.random() * 100000000));
        //        userInsert();
        //        new PetsInsertTest().insertPets();
        //        new AddressInsertTest().addressInsert();
        //        new OrderInsertTest().orderInsert();
        //        new OrderItemInsertTest().OrderItemInsert();
        //        new CartInsertTest().CartInsert();
    }
    
    @Test
    public void testRondomDate() {
        Date date = randomDate("2017-07-01","2019-01-01");
        System.out.println(new SimpleDateFormat("yyyy.MM.dd").format(date));
    }
    
    
    /**
     * 获取随机日期
     * @param beginDate 起始日期，格式为：yyyy-MM-dd
     * @param endDate 结束日期，格式为：yyyy-MM-dd
     * @return
     */
    private static Date randomDate(String beginDate,String endDate){
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date start = format.parse(beginDate);
            Date end = format.parse(endDate);
            
            if(start.getTime() >= end.getTime()){
                return null;
            }
            
            long date = random(start.getTime(),end.getTime());
            
            return new Date(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    private static long random(long begin,long end){
        long rtn = begin + (long)(Math.random() * (end - begin));
        if(rtn == begin || rtn == end){
            return random(begin,end);
        }
        return rtn;
    }
    
}

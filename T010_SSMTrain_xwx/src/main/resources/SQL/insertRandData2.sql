
TRUNCATE TABLE t_user;
DROP PROCEDURE IF EXISTS add_user;
#创建存储过程
DELIMITER //
create PROCEDURE add_user(in num INT)
BEGIN
  DECLARE rowid INT DEFAULT 0;
  DECLARE username VARCHAR(20) DEFAULT '';
  DECLARE first VARCHAR(1000);
  DECLARE lastnames VARCHAR(1000);
  DECLARE gender CHAR(1);
  DECLARE score CHAR(2);
  DECLARE sql_part VARCHAR(100) DEFAULT "insert into t_user(username,password,gender,email,phone,salt,grade,status) values ";
  SET firstname =
      '赵钱孙李周郑王冯陈楮卫蒋沈韩杨朱秦尤许何吕施张孔曹严华金魏陶姜戚谢喻柏水窦章云苏潘葛奚范彭郎鲁韦昌马苗凤花方俞任袁柳酆鲍史唐费廉岑薛雷贺倪汤滕殷罗毕郝邬安常乐于时傅皮齐康伍余元卜顾孟平黄和穆萧尹姚邵湛汪祁毛禹狄米贝明臧计伏成戴谈宋茅庞熊纪舒屈项祝董梁杜阮蓝闽席季麻强贾路娄危江童颜郭梅盛林刁锺徐丘骆高夏蔡田樊胡凌霍虞万支柯昝管卢莫经裘缪干解应宗丁宣贲邓郁单杭洪包诸左石崔吉钮龚程嵇邢滑裴陆荣翁';
  SET lastnames =
      '嘉懿煜城懿轩烨伟苑博伟泽熠彤鸿煊博涛烨霖烨华煜祺智宸正豪昊然明杰诚立轩立辉峻熙弘文熠彤鸿煊烨霖哲瀚鑫鹏致远俊驰雨泽烨磊晟睿天佑文昊修洁黎昕远航旭尧鸿涛伟祺轩越泽浩宇瑾瑜皓轩擎苍擎宇志泽睿渊楷瑞轩弘文哲瀚雨泽鑫磊梦琪忆之桃慕青问兰尔岚元香初夏沛菡傲珊曼文乐菱痴珊恨玉惜文香寒新柔语蓉海安夜蓉涵柏水桃醉蓝春儿语琴从彤傲晴语兰又菱碧彤元霜怜梦紫寒妙彤曼易南莲紫翠雨寒易烟如萱若南寻真晓亦向珊慕灵以蕊寻雁映易雪柳孤岚笑霜海云凝天沛珊寒云冰旋宛儿绿真盼儿晓霜碧凡夏菡曼香若烟半梦雅绿冰蓝灵槐平安书翠翠风香巧代云梦曼幼翠友巧听寒梦柏醉易访旋亦玉凌萱访卉怀亦笑蓝春翠靖柏夜蕾冰夏梦松书雪乐枫念薇靖雁寻春恨山从寒忆香觅波静曼凡旋以亦念露芷蕾千兰新波代真新蕾雁玉冷卉紫山千琴恨天傲芙盼山怀蝶冰兰山柏翠萱乐丹翠柔谷山之瑶冰露尔珍谷雪乐萱涵菡海莲傲蕾青槐冬儿易梦惜雪宛海之柔夏青亦瑶妙菡春竹修杰伟诚建辉晋鹏天磊绍辉泽洋明轩健柏煊昊强伟宸博超君浩子骞明辉鹏涛炎彬鹤轩越彬风华靖琪明诚高格光华国源宇晗昱涵润翰飞翰海昊乾浩博和安弘博鸿朗华奥华灿嘉慕坚秉建明金鑫锦程瑾瑜鹏经赋景同靖琪君昊俊明季同开济凯安康成乐语力勤良哲理群茂彦敏博明达朋义彭泽鹏举濮存溥心璞瑜浦泽奇邃祥荣轩';
  SET @exedata = "";
  #循环拼接sql，并执行
  WHILE rowid < num DO
  #截取姓氏字符串中的一个字符
  SET firstname = SUBSTRING(firstnamme, CEILING(194 * RAND()), 1);
  #截取名字字符串中的一个或两个字符
  SET username = CONCAT(SUBSTRING(SUBSTRING(firstnamme,CEILING(194 * RAND()), 1),lastname, CEILING(522 * RAND()), 1),SUBSTRING(lastname, CEILING(522 * RAND()), ROUND(Rand())));
  SET gender = FLOOR(0 + (RAND() * 2));
  SET score = FLOOR(40 + (RAND() * 60));
  SET rowid = rowid + 1;
  #该判断保证拼接sql字符串格式正确
  IF length(@exedata) > 0 THEN
    SET @exedata = CONCAT(@exedata, ',');
  END IF;
#   username,password,gender,email,phone,salt,grade,status
  SET @exedata = concat(@exedata, "('", username, "','","123456", "',", gender, ",'", "123sadf@qq.com",
    "','", "13156657489", "','", "1111234", "',", 1, "," , "1",")");
  #当数据达到1000条时执行插入
  IF rowid % 1000 = 0 THEN
    SET @exesql = concat(sql_part, @exedata);
    prepare stmt from @exesql;
    execute stmt;
    DEALLOCATE prepare stmt;
    SET @exedata = "";
  END IF;
  END WHILE;
  #跳出循环时判断是否还有数据未插入，保证数据插入完全
  IF length(@exedata) > 0
  THEN
    SET @exesql = concat(sql_part, @exedata);
    prepare stmt from @exesql;
    execute stmt;
    DEALLOCATE prepare stmt;
  END IF;

END //
DELIMITER ;

#插入一万条数据
call add_user(10000);

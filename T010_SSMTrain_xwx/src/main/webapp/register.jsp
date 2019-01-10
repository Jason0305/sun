<%--
  Created by IntelliJ IDEA.
  User: xuwanxing
  Date: 2019/1/8
  Time: 9:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>宠物商城-注册</title>
    <%--<link type="text/css" rel="stylesheet" href="/bootstrap/css/bootstrap.min.css">--%>
    <link rel="stylesheet" type="text/css" href="css/base.css"/>
    <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="js/jquery1.42.min.js"></script>
    <script type="text/javascript" src="js/jquery.SuperSlide.2.1.1.js"></script>
    <script type="text/javascript" src="js/publicNav.js"></script>
    <script type="text/javascript" src="js/jquery.blockUI.js"></script>
    <script type="text/javascript" src="js/jquery.cookie.js"></script>
    <script type="text/javascript" src="js/index.js"></script>
    <style>
        /***********注册************/
        .register_box {
            width: 700px;
            margin: 50px auto 0;
        }

        .register_box .group {
            margin-bottom: 10px;
        }

        .register_box .group p {
            display: inline-block;
            width: 90px;
            margin-right: 10px;
            font-size: 15px;
            color: #2E2E2E;
            text-align: right;
        }

        .register_box .group input:not([type='radio']) {
            width: 319px;
            height: 44px;
            padding: 0 10px;
            border: 1px solid #CBCBCB;
            font-size: 13px;
            color: #8C8C8C;
        }

        .register_box .group2 input:not([type='radio']) {
            width: 182px;
            margin-right: 10px;
        }

        .register_box .group2 button {
            width: 123px;
            height: 44px;
            color: #fff;
            cursor: pointer;
            font-size: 14px;
            background: #F09E0B;
            border: 0;
        }

        .register_box .group span {
            margin-left: 10px;
            padding-left: 25px;
        }

        .register_box .group .error {
            background: url(images/psw-error.gif) no-repeat left center;
            /*visibility: hidden;*/
        }

        .register_box .group .correct {
            background: url(images/psw-correct.gif) no-repeat left center;
            /*visibility: hidden;*/
        }

        .register_box .login_btn {
            width: 340px;
            height: 44px;
            cursor: pointer;
            color: #fff;
            margin-left: 103px;
            font-size: 16px;
            background: #F09E0B;
            border: none;
        }

        .register_box .group3 input {
            width: 162px;
        }

        .register_box .psw4 input {
            width: 132px;
        }

        .register_box .verification_code .yz-tu {
            width: 163px;
            height: 64px;
            border: 1px solid #C0C0C0;
            margin-left: 103px;
        }

        .register_box .verification_code p {
            display: inline-block;
            line-height: 66px;
            font-size: 14px;
            color: #000;
            margin-left: 10px;
        }

        .register_box .verification_code p a {
            color: #F19F0B;
        }

        .f-l {
            float: left;
        }

        .register_box .agreement {
            margin: 10px 0 10px 103px;
        }

        .register_box .agreement p {
            display: inline-block;
            font-size: 14px;
            color: #000;
            margin-left: 5px;
        }

        .register_box .agreement p span {
            color: #F19F0B;
        }

        .register_box .sign-in {
            font-size: 14px;
            color: #000;
            margin: 10px 0 10px 103px;
        }

        .register_box .sign-in a {
            color: #F19F0B;
        }

    </style>
</head>

<body>

<!--顶部top-->
<div class="topMenu">
    <div class="indexCont">
        <ul class="fl tW tL" style="width:190px;">
            <li class="b1"><i></i><a href="javascript:;">收藏</a></li>
            <li class="b2"><i></i><a href="javascript:;">移动客户端</a></li>
        </ul>
        <div class="fr tW">
            <ul class="fl">
                <li class="login" style="white-space:nowrap;height:32px;line-height:32px;"><b>您好，欢迎您来到宠物商城</b> <a
                        href="login.html" target="_blank">登录</a><ahref="userOrder.html">我的订单 </a></li>
            </ul>
            <ul id="tMenu" class="fr tW tmCont">
                <li class="webnav"><strong class="top_icon"><a href="javascript:;"> 我的素品 </a></strong>
                    <div class="top_hidebox wdsp">
                        <div class=""><a href="userAccount/userOrder.html">我的订单</a></div>
                        <div><a href="userAccount/integral.html">我的积分</a></div>
                    </div>
                </li>
                <li class="webnav"><strong class="top_icon"><a href="javascript:;">帮助中心</a></strong>
                    <div class="top_hidebox">
                        <div class=""><a href="help/help_index.html">购物流程</a></div>
                        <div><a href="help/pssm.html">配送方式</a></div>
                        <div><a href="help/zxzf.html">支付方式</a></div>
                        <div><a href="help/thzc.html">售后服务</a></div>
                    </div>
                </li>
                <li class="webnavdh" style="background:none"><strong class="top_icon"><a href="javascript:;"> 网站导航 </a></strong>
                    <div class="top_hidebox">
                        <ul class="dh-list">
                            <li class="dh_title">
                                <a href="javascript:;" style="padding-left:0;">生鲜食品</a>
                                <a href="javascript:;">酒水饮料</a>
                                <a href="javascript:;">粮油副食</a>
                                <a href="javascript:;">休闲食品</a>
                                <a href="javascript:;">营养养生</a>
                            </li>
                            <li class="line"></li>
                            <li class="dh_wenzi">
                                <h4>饼干点心</h4>
                                <a class="dh_oneTle" href="javascript:;">服饰</a><s>|</s>
                                <a href="javascript:;">图书</a><s>|</s>
                                <a href="javascript:;">办公直通车</a><s>|</s>
                                <a href="javascript:;">视频购物</a><s>|</s>
                                <a href="javascript:;">品牌街</a><s>|</s>
                                <a href="javascript:;">礼品卡</a><s>|</s>
                                <a href="javascript:;">电子书</a><s>|</s>
                                <a href="javascript:;">运动馆</a>
                            </li>

                            <li class="line"></li>

                            <li class="dh_wenzi">
                                <h4>冲调茶饮</h4>
                                <a class="dh_oneTle" href="javascript:;">商旅</a><s>|</s>
                                <a href="javascript:;">保险</a><s>|</s>
                                <a href="javascript:;">彩票</a><s>|</s>
                                <a href="javascript:;">水电煤</a><s>|</s>
                                <a href="javascript:;">游戏</a><s>|</s>
                                <a href="javascript:;">PPTV下载</a>
                            </li>
                            <li class="line"></li>
                            <li class="dh_wenzi">
                                <h4>美食用品</h4>
                                <a class="dh_oneTle" href="javascript:;">应用商店</a><s>|</s>
                                <a href="javascript:;">苏宁云</a><s>|</s>
                                <a href="javascript:;">社区</a><s>|</s>
                                <a href="javascript:;">客户端</a><s>|</s>
                                <a href="javascript:;">对公销售</a><s>|</s>
                                <a href="javascript:;">会员联盟</a><s>|</s>
                                <a href="javascript:;">商家入驻</a>
                            </li>
                        </ul>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</div>

<!--注册表单-->
<div class="register_box">
    <form id="registerForm">
        <div class="group">
            <p>用户名</p>
            <input type="text" name="username" placeholder="请输入用户名"/>
            <span class="correct"></span>
        </div>
        <div class="group">
            <p>输入密码</p>
            <input type="text" name="password" placeholder="请输入密码" value="123"/>
            <span class="error">密码由6-16的字母、数字、符号组成</span>
        </div>
        <div class="group">
            <p>确认密码</p>
            <input type="text" placeholder="请再次确认密码" value="123"/>
            <span class="error">密码不一致，请重新输入</span>
        </div>
        <div class="group">
            <p>性别</p>
            <input type="radio" class="" name="gender" id="male" value="1" checked="checked">
            <label for="male">男</label>
            <input type="radio" name="gender" id="female" value="0">
            <label for="female">女</label>
        </div>
        <div class="group group3">
            <p>手机号</p>
            <input type="text" name="phone" placeholder="请输入手机号码" value="13166668888"/>
        </div>
        <%--<div class="psw psw2">
            <p class="psw-p1">短信验证码</p>
            <input type="text" placeholder="请输入手机验证码"/>
            <button>获取短信验证码</button>
        </div>--%>
        <div class="group group3">
            <p>邮箱</p>
            <input type="text" name="email" placeholder="请输入邮箱" value="666777888@qq.com"/>
        </div>
        <div class="group group2">
            <p>邮箱验证码</p>
            <input type="text" placeholder="请输入邮箱验证码"/>
            <button>获取邮箱验证码</button>
        </div>
        <div class="group psw4">
            <p>验证码</p>
            <input type="text" placeholder="请输入验证码"/>
            <%--<span class="verification_code">
                <div class="yz-tu f-l">
                    <img src="images/psw_verification_code.gif"/>
                </div>
                <p class="f-l">看不清？<a href="#">换张图</a></p>
                <div style="clear:both;"></div>
            </span>--%>
        </div>
        <div class="agreement">
            <input type="checkbox" name="agreement"/>
            <p>我有阅读并同意<span>《宅客微购网站服务协议》</span></p>
        </div>
        <button type="button" class="login_btn" id="register">立即注册</button>
        <p class="sign-in">已有账号?<a href="login.html">现在登录</a></p>
    </form>
</div>
<script type="text/javascript" src="pet/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="pet/js/jquery.blockUI.js"></script>
<script type="text/javascript" src="pet/js/petstore.js"></script>
<script type="text/javascript">
    register.onclick = function () {
        $.ajax({
            url: "${pageContext.servletContext.contextPath}/user/register.do",
            data: $("#registerForm").serialize(),
            type: "get",
            dataType: "json",
            beforeSend: function () {
                console.log("send Before...");
            },
            success: function (data) {
                console.log("response success...");
                if (data.responseStatusCode === 600) {
                    location.href = "index.html";
                } else {
                    alert("未知错误！");
                }
                setTimeout($.unblockUI, 200);
            }
        });
    };

    //1、校验用户名
    function validate_username(obj) {
        var empName = obj.val();
        var regName = /(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})/;
        if (!regName.test(empName)) {
            alert("邮箱格式不正确");
            return false;
        } else {
            alert("邮箱格式正确")
        }
        ;
    }

    //2、校验邮箱信息
    function validate_email(obj) {
        var email = obj.val();
        var regEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
        if (!regEmail.test(email)) {
            alert("邮箱格式不正确");
            return false;
        } else {
            alert("邮箱格式正确")
        }
        return true;
    }


</script>
<!--底部服务-->
<div class="footer">
    <div class="foot-cont">
        <dl class="fore1">
            <dt><b></b><strong>购物指南</strong></dt>
            <dd>
                <div><a href="#">购物流程</a></div>
                <div><a href="#">会员介绍</a></div>
                <div><a href="#">团购/机票</a></div>
                <div><a href="#">常见问题</a></div>
                <div><a href="#">大家电</a></div>
                <div><a href="#">联系客服</a></div>
            </dd>
        </dl>
        <dl class="fore2">
            <dt><b></b><strong>配送方式</strong></dt>
            <dd>
                <div><a href="#">上门自提</a></div>
                <div><a href="#">211限时达</a></div>
                <div><a href="#">配送服务查询</a></div>
                <div><a href="#">配送费收取标准</a></div>
                <div><a href="#">海外配送</a></div>
            </dd>
        </dl>
        <dl class="fore3">
            <dt><b></b><strong>支付方式</strong></dt>
            <dd>
                <div><a href="javascript:;">货到付款</a></div>
                <div><a href="javascript:;">在线支付</a></div>
                <div><a href="javascript:;">分期付款</a></div>
                <div><a href="javascript:;">邮局汇款</a></div>
                <div><a href="javascript:;">公司转账</a></div>
            </dd>
        </dl>
        <dl class="fore4">
            <dt><b></b><strong>售后服务</strong></dt>
            <dd>
                <div><a href="javascript:;">售后政策</a></div>
                <div><a href="javascript:;">价格保护</a></div>
                <div><a href="javascript:;">退款说明</a></div>
                <div><a href="javascript:;">返修/退换货</a></div>
                <div><a href="javascript:;">取消订单</a></div>
            </dd>
        </dl>
        <!--    <dl class="fore5">
  <dt><b></b><strong>特色服务</strong></dt>
  <dd>
    <div><a href="javascript:;">夺宝岛</a></div>
    <div><a href="javascript:;">DIY装机</a></div>
    <div><a href="javascript:;">延保服务</a></div>
    <div><a href="javascript:;">素品卡</a></div>
    <div><a href="javascript:;">节能补贴</a></div>
  </dd>
</dl>
<dl class="fore6">
  <dt><b></b><strong>关注我们</strong></dt>
  <dd>
    <div><a href="javascript:;"><img src="images/footerweix.jpg" width="93" height="94"></a></div>
  </dd>
</dl> -->
    </div>

    <div class="footer_center">
        <div class="links">
            <a href="javascript:;">关于我们</a>|
            <a href="javascript:;">联系我们</a>|
            <a href="javascript:;">友情链接</a>|
            <a href="javascript:;">免责条款</a>|
            <a href="javascript:;">广告服务</a>|
            <a href="javascript:;">食品流通许可证</a>|
            <a href="javascript:;">营业执照</a>
        </div>
    </div>
    <div class="footer_copyright">
        <p> Copyright © 2014-2019 5RICE.吾米网 版权所有 黑ICP备11002788号 保留一切权利。 客服热线：400-400-5555 </p>
        <p>京公网安备 110105001608 | 京ICP证111033号 | 食品流通许可证 SP1101051110165515（1-1） | 营业执照</p>
    </div>
    <div class="footer_cx">
        <p>
            <a href="javascript:;"><img src="images/footerbomC.png" width="112" height="40"></a>
            <a href="javascript:;"><img src="images/footerbomX.gif" width="112" height="40"></a>

        </p>
    </div>
</div>
</body>
</html>

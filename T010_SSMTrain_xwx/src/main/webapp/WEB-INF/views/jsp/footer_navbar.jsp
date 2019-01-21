<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <% String root = request.getContextPath();
        System.err.println("root = " + root);%>
    <meta charset="UTF-8">
    <title>FooterNavbar</title>
    <script type="text/javascript" src="<%=root%>/js/jquery.cookie.js"></script>
</head>
<body>

<nav class="navbar navbar-default footer_nav" role="navigation">
    <div class="container">

        <div id="navbar" class="collapse navbar-collapse">
            <div class="col-md-10">
                <ul class="col-md-3">
                    <li><span class=""></span>购物指南</li>
                    <li><a href="javascript:;">购物流程</a></li>
                    <li><a href="javascript:;">会员介绍</a></li>
                    <li><a href="javascript:;">团购/活动</a></li>
                    <li><a href="javascript:;">宠物护理</a></li>
                    <li><a href="javascript:;">常见问题</a></li>
                    <li><a href="javascript:;">联系客服</a></li>
                </ul>
                <ul class="col-md-3">
                    <li><span class=""></span>配送方式</li>
                    <li><a href="javascript:;">上门自提</a></li>
                    <li><a href="javascript:;">211限时达</a></li>
                    <li><a href="javascript:;">配送服务查询</a></li>
                    <li><a href="javascript:;">配送费收取标准</a></li>
                    <li><a href="javascript:;">海外配送</a></li>
                </ul>
                <ul class="col-md-3">
                    <li><span class=""></span>支付方式</li>
                    <li><a href="javascript:;">货到付款</a></li>
                    <li><a href="javascript:;">在线支付</a></li>
                    <li><a href="javascript:;">分期付款</a></li>
                    <li><a href="javascript:;">银行汇款</a></li>
                    <li><a href="javascript:;">公司转账</a></li>
                </ul>
                <ul class="col-md-3">
                    <li><span class=""></span>售后服务</li>
                    <li><a href="javascript:;">售后说明</a></li>
                    <li><a href="javascript:;">价格保护</a></li>
                    <li><a href="javascript:;">退款说明</a></li>
                    <li><a href="javascript:;">退换规则</a></li>
                    <li><a href="javascript:;">取消订单</a></li>
                </ul>
            </div>
            <div class="col-md-2">
                <ul>
                    <li>关注我们</li>
                    <li>
                        <div>
                            <a href="javascript:;">
                                <img src="<%=root%>/images/QR_code.png" class="img-responsive" width="234" height="233"
                                     alt="">
                            </a>
                        </div>
                    </li>
                </ul>
            </div>
        </div>

        <div class="nav navbar-nav col-md-12" style="text-align:center;">
            <span href="javascript:;">关于我们</span>|
            <span href="javascript:;">联系我们</span>|
            <span href="javascript:;">友情链接</span>|
            <span href="javascript:;">免责条款</span>|
            <span href="javascript:;">广告服务</span>|
            <span href="javascript:;">商品流通许可证</span>|
            <span href="javascript:;">营业执照</span>
        </div>
        <div>
            <p class="nav navbar-nav col-md-12" style="text-align:center;"> Copyright © 2014-2019 5RICE.宠吾网 版权所有
                鄂ICP备11002788号 保留一切权利。
                客服热线：400-400-6666 </p>
            <p class="nav navbar-nav col-md-12" style="text-align:center;"> 鄂公网安备 110105001608 | 鄂ICP证111033号 |
                商品流通许可证 SP1101051110165515（1-1） | 营业执照 </p>
            <p class="nav navbar-nav col-md-12" style="text-align:center;">
                <a href="javascript:;">
                    <img src="<%=root%>/images/footerbomX.gif" width="108" height="40">
                </a>
                <a href="javascript:;">
                    <img src="<%=root%>/images/footerbomC.png" width="112" height="40">
                </a>
            </p>
        </div>
    </div>
    </div>

    </div>
</nav>
</body>
</html>
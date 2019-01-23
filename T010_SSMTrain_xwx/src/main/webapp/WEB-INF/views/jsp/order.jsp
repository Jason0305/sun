<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String root = request.getContextPath() + "/";%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>宠物商城-地址管理</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,shrink-to-fit=no">
    <link rel="stylesheet" type="text/css" href="<%=root%>static/plug-in/bootstrap-3.4.0-dist/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="<%=root%>static/plug-in/font-awesome-4.7.0/css/font-awesome.min.css"/>
    <link rel="stylesheet" type="text/css" href="<%=root%>static/css/style.css"/>
    <link rel="stylesheet" type="text/css" href="<%=root%>static/css/shopping-mall-index.css"/>
    <link rel="shortcut icon" href="<%=root%>static/images/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="<%=root%>static/css/base.css" type="text/css">
    <script type="text/javascript" src="<%=root%>static/js/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="<%=root%>static/plug-in/bootstrap-3.4.0-dist/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=root%>static/js/jquery.blockUI.js"></script>
    <script type="text/javascript" src="<%=root%>static/js/jquery.cookie.js"></script>
    <script type="text/javascript" src="<%=root%>static/js/base.js"></script>
    <script type="text/javascript" src="<%=root%>static/js/login.js"></script>
    <script type="text/javascript" src="<%=root%>static/js/base2.js"></script>
    <script type="text/javascript">
        let root = "<%=root%>";
    </script>
</head>
<body>

<!--引入顶部导航栏-->
<script type="text/javascript">
    $("body").append($("<header id='header_navbar'></header>").load("<%=root%>header_navbar.do"));
</script>
<!--引入顶部导航栏-->

<!--路径地址-->
<div class="breadcrumbs container panel-title">
    <a href="<%=root%>index.do">首页</a><span>&gt;</span><a href="#">个人中心</a><span>&gt;</span>编辑个人信息
</div>
<%--<div style="clear:both;"></div>--%>
<div class="container" style="">
    <!--个人资料-->
    <div class="personal w1200">
        <div class="personal_menu f-l">
            <div class="personal_title">
                <h3>个人中心</h3>
            </div>
            <ul>
                <%--<li><a href="#">消息中心<span>></span></a></li>--%>
                <li class="current_active"><a href="#">个人资料<span>></span></a></li>
                <li><a href="#">我的订单<span>></span></a></li>
                <%--<li><a href="#">我的预约<span>></span></a></li>--%>
                <li><a href="#">购物车<span>></span></a></li>
                <li><a href="#">管理收货地址<span>></span></a></li>
                <li><a href="#">我的收藏<span>></span></a></li>
                <li><a href="#">交易记录<span>></span></a></li>
                <li><a href="#">浏览记录<span>></span></a></li>
                <%--<li><a href="#">会员积分<span>></span></a></li>--%>
            </ul>
        </div>
        <div class="order-right f-r">
            <div class="order-hd">
                <dl class="f-l">
                    <dt>
                        <a href="#"><img src="<%=root%>static/images/img/data-tu2.gif" /></a>
                    </dt>
                    <dd>
                        <h3><a href="#">Jerry</a></h3>
                        <p>Jerry@foxmail.com</p>
                    </dd>
                    <div style="clear:both;"></div>
                </dl>
                <div class="ord-dai f-l">
                    <p>待付款<span>1</span></p>
                    <p>待发货<span>1</span></p>
                    <p>待收货<span>1</span></p>
                    <p>待评价<span>1</span></p>
                </div>
                <div style="clear:both;"></div>
            </div>
            <div class="order-md">
                <div class="md-tit">
                    <h3>我的订单</h3>
                </div>
                <div class="md-hd">
                    <P class="md-p1"><input type="checkbox" name="hobby" value=""/><span>全选</span></P>
                    <p class="md-p2">商品信息</p>
                    <p class="md-p3">规格</p>
                    <p class="md-p4">单价（元）</p>
                    <p class="md-p5">金额（元）</p>
                    <p class="md-p6">操作</p>
                </div>
                <div class="md-info">
                    <div class="dai">
                        <input type="checkbox" name="hobby" value=""/><span>待付款</span>
                    </div>
                    <div class="dai-con">
                        <dl class="dl1">
                            <dt>
                                <input type="checkbox" name="hobby" value="" class="f-l"/>
                                <a href="#" class="f-l"><img src="<%=root%>static/images/bomei_white2.jpg" /></a>
                                <div style="clear:both;"></div>
                            </dt>
                            <dd>
                                <p>登高阁紫菜肉松鸡蛋卷 海苔蛋卷 糕点江西特产小吃 休闲办公零食</p>
                                <span>X 1</span>
                            </dd>
                            <div style="clear:both;"></div>
                        </dl>
                        <div class="dai-right f-l">
                            <P class="d-r-p1">颜色：蓝色<br />尺码：XL</P>
                            <p class="d-r-p2">¥ 66.00</p>
                            <p class="d-r-p3">¥ 66.00</p>
                            <p class="d-r-p4"><a href="#">移入收藏夹</a><br /><a href="#">删除</a><br /><a href="#">付款</a></p>
                        </div>
                        <div style="clear:both;"></div>
                    </div>
                    <div class="dai-con">
                        <dl class="dl1">
                            <dt>
                                <input type="checkbox" name="hobby" value="" class="f-l"/>
                                <a href="#" class="f-l"><img src="<%=root%>static/images/bomei_white2.jpg" /></a>
                                <div style="clear:both;"></div>
                            </dt>
                            <dd>
                                <p>登高阁紫菜肉松鸡蛋卷 海苔蛋卷 糕点江西特产小吃 休闲办公零食</p>
                                <span>X 1</span>
                            </dd>
                            <div style="clear:both;"></div>
                        </dl>
                        <div class="dai-right f-l">
                            <P class="d-r-p1">颜色：蓝色<br />尺码：XL</P>
                            <p class="d-r-p2">¥ 66.00</p>
                            <p class="d-r-p3">¥ 66.00</p>
                            <p class="d-r-p4"><a href="#">移入收藏夹</a><br /><a href="#">删除</a><br /><a href="#">付款</a></p>
                        </div>
                        <div style="clear:both;"></div>
                    </div>
                </div>
                <div class="md-info">
                    <div class="dai">
                        <input type="checkbox" name="hobby" value=""/><span>待发货</span>
                    </div>
                    <div class="dai-con">
                        <dl class="dl1">
                            <dt>
                                <input type="checkbox" name="hobby" value="" class="f-l"/>
                                <a href="#" class="f-l"><img src="<%=root%>static/images/bomei_white2.jpg" /></a>
                                <div style="clear:both;"></div>
                            </dt>
                            <dd>
                                <p>登高阁紫菜肉松鸡蛋卷 海苔蛋卷 糕点江西特产小吃 休闲办公零食</p>
                                <span>X 1</span>
                            </dd>
                            <div style="clear:both;"></div>
                        </dl>
                        <div class="dai-right f-l">
                            <P class="d-r-p1">颜色：蓝色<br />尺码：XL</P>
                            <p class="d-r-p2">¥ 66.00</p>
                            <p class="d-r-p3">¥ 66.00</p>
                            <p class="d-r-p4" style="margin-top:20px;"><a href="#">移入收藏夹</a><br /><a href="#">删除</a></p>
                        </div>
                        <div style="clear:both;"></div>
                    </div>
                </div>
                <div class="md-info">
                    <div class="dai">
                        <input type="checkbox" name="hobby" value=""/><span>待收货</span>
                    </div>
                    <div class="dai-con">
                        <dl class="dl1">
                            <dt>
                                <input type="checkbox" name="hobby" value="" class="f-l"/>
                                <a href="#" class="f-l"><img src="<%=root%>static/images/bomei_white2.jpg" /></a>
                                <div style="clear:both;"></div>
                            </dt>
                            <dd>
                                <p>登高阁紫菜肉松鸡蛋卷 海苔蛋卷 糕点江西特产小吃 休闲办公零食</p>
                                <span>X 1</span>
                            </dd>
                            <div style="clear:both;"></div>
                        </dl>
                        <div class="dai-right f-l">
                            <P class="d-r-p1" style=" position:relative;top:-20px;">颜色：蓝色<br />尺码：XL</P>
                            <p class="d-r-p2" style="top:-43px;">¥ 66.00</p>
                            <p class="d-r-p3" style="top:-43px;">¥ 66.00</p>
                            <p class="d-r-p4"><a href="#">移入收藏夹</a><br />
                                <a href="#">删除</a><br /><a href="#">确认收货</a><br />
                                <a href="JavaScript:;" ckwl="">查看物流</a>
                            </p>
                        </div>
                        <div style="clear:both;"></div>
                    </div>
                </div>
                <div class="md-info">
                    <div class="dai">
                        <input type="checkbox" name="hobby" value=""/><span>待评价</span>
                    </div>
                    <div class="dai-con">
                        <dl class="dl1">
                            <dt>
                                <input type="checkbox" name="hobby" value="" class="f-l"/>
                                <a href="#" class="f-l"><img src="<%=root%>static/images/bomei_white2.jpg" /></a>
                                <div style="clear:both;"></div>
                            </dt>
                            <dd>
                                <p>登高阁紫菜肉松鸡蛋卷 海苔蛋卷 糕点江西特产小吃 休闲办公零食</p>
                                <span>X 1</span>
                            </dd>
                            <div style="clear:both;"></div>
                        </dl>
                        <div class="dai-right f-l">
                            <P class="d-r-p1">颜色：蓝色<br />尺码：XL</P>
                            <p class="d-r-p2">¥ 66.00</p>
                            <p class="d-r-p3">¥ 66.00</p>
                            <p class="d-r-p4" style="margin-top:20px;"><a href="#">移入收藏夹</a><br /><a href="#">删除</a></p>
                        </div>
                        <div style="clear:both;"></div>
                    </div>
                </div>
                <!--分页-->
                <div class="paging">
                    <div class="pag-left f-l">
                        <a href="#" class="about left-r f-l"><</a>
                        <ul class="left-m f-l">
                            <li><a href="#">1</a></li>
                            <li class="current"><a href="#">2</a></li>
                            <li><a href="#">3</a></li>
                            <li><a href="#">4</a></li>
                            <li><a href="#">5</a></li>
                            <li><a href="#">6</a></li>
                            <li><a href="#">...</a></li>
                            <li><a href="#">100</a></li>
                            <div style="clear:both;"></div>
                        </ul>
                        <a href="#" class="about left-l f-l">></a>
                        <div style="clear:both;"></div>
                    </div>
                    <div class="pag-right f-l">
                        <div class="jump-page f-l">
                            到第<input type="text" />页
                        </div>
                        <button class="f-l">确定</button>
                        <div style="clear:both;"></div>
                    </div>
                    <div style="clear:both;"></div>
                </div>
                <div class="md-ft">
                    <P class="md-p1"><input type="checkbox" name="hobby" value=""/><span>全选</span></P>
                    <a href="#">删除</a>
                    <a href="#"><span>加入收藏夹</span></a>
                    <button>结算</button>
                </div>
            </div>

        </div>
        <div style="clear:both;"></div>
    </div>
    <!--个人资料-->
</div>

<!--引入底部导航start-->
<script type="text/javascript">
    $("body").append($("<section id='top_navbar'></section>").load("<%=root%>footer_navbar.do"));
</script>
<!--引入底部导航end-->
</body>
</html>
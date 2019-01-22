<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String root = request.getContextPath() + "/";%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>HeaderNavbar</title>
</head>
<body>
<nav class="navbar navbar-default navbar-inverse navbar-fixed-top header_nav" role="navigation">
    <div class="container nav_header">
        <div class="navbar-header">
            <a href="<%=root%>index.do" class="navbar-brand projectName">
                <span><img src="<%=root%>static/images/logo.png" alt="" width="20" height="20"></span>
                <span>宠物商城</span>
            </a>
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#nav_title" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <div class="collapse navbar-collapse" id="nav_title">
            <ul class="nav navbar-nav navbar-left">
                <li>
                    <a href="javascript:;">
                        <span class="fa fa-star navCollectionIcon"></span>
                        <span data-toggle="tooltip" data-placement="bottom" title=""
                              data-original-title="收藏会有惊喜哦">收藏本网站</span>
                    </a>
                </li>
                <li class="mobile_QR_code">
                    <a href="javascript:;" data-link-color="orange">
                        <span class="fa fa-mobile fa-lg navCollectionIcon"></span>
                        <span>手机客户端</span>
                        <span class="caret"></span>
                        <img src="static/images/mobile_download.png" width="130" alt=""/></a>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="javascript:;" class="fa fa-user dropdown-toggle" data-toggle="dropdown"> 个人中心</a>
                    <ul class="dropdown-menu dropdown-menu-left" role="menu" style="min-width:100%">
                        <li><a href="<%=root%>user/info.do">个人资料</a></li>
                        <li><a href="javascript:;">收货地址</a></li>
                        <li><a href="javascript:;">修改密码</a></li>
                        <li class="divider"></li>
                        <li><a href="javascript:;">切换账号</a></li>
                        <li><a href="javascript:;">退出登录</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown">
                        <span class="fa fa-shopping-cart text-info"></span>
                        <span> 购物车</span>
                        <span class="badge badge-danger">100</span>
                        <ul class="dropdown-menu dropdown-menu-left group_list" role="menu"
                            style="min-width: max-content">
                            <li style="">
                                <div>
                                    <div class="img">
                                        <img src="<%=root%>static/images/shopping_cart.jpg" alt="">
                                    </div>
                                    <div class="content" width="100">
                                        <p><a href="#">宠物名称</a></p>
                                        <p>宠物类型:柯基8255</p>
                                    </div>
                                    <div class="Operations">
                                        <p class="Price">￥55.00</p>
                                        <p><a href="#">删除</a></p>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div>
                                    <div class="img"><img src="<%=root%>static/images/shopping_cart.jpg" alt=""></div>
                                    <div class="content"><p><a href="#">宠物名称</a></p>
                                        <p>宠物类型:柯基8255</p></div>
                                    <div class="Operations">
                                        <p class="Price">￥55.00</p>
                                        <p><a href="#">删除</a></p></div>
                                </div>
                            </li>
                            <!--<li>-->
                            <!--<button type="button" class="btn btn-outline-info btn-block">购买</button>-->
                            <!--</li>-->
                            <li role="separator" class="divider"></li>
                            <li class="">
                                <div class="shopping_style">
                                    <div class="p-total">共<b>1</b>件商品　共计<strong>￥ 515.00</strong></div>
                                    <a href="#" title="去购物车结算" id="btn-payforgoods" class="Shopping">去购物车结算</a>
                                </div>
                            </li>
                        </ul>

                    </a>
                </li>
                <li>
                    <a href="javascript:;">
                        <span class="fa fa-heart"></span> 收藏夹
                    </a>
                </li>
                <li id="help_select" class="dropdown">

                    <a href="http://www.baidu.com" class="dropdown-toggle" data-toggle="dropdown">
                        <span class="icon-heart">帮助中心</span>
                        <span class="caret"></span>
                        <ul class="dropdown-menu dropdown-menu-left" role="menu" style="min-width:100%">
                            <li><a href="javascript:;">购物流程</a></li>
                            <li><a href="javascript:;">配送方式</a></li>
                            <li><a href="javascript:;">支付方式</a></li>
                            <li><a href="javascript:;">售后服务</a></li>
                        </ul>
                    </a>
                </li>
                <li><a href="<%=root%>user/login.do" class="" data-toggle="tooltip" data-placement="bottom" title=""
                       data-original-title="你好,请先登录">登录</a></li>
                <li><a href="<%=root%>user/reg.do" class="" data-toggle="tooltip" data-placement="bottom" title=""
                       data-original-title="没有账号?注册一个">免费注册</a></li>
            </ul>
        </div>

    </div>
    <script type="text/javascript">
        $("[data-toggle='tooltip']").tooltip();
        $(document).off('click.bs.dropdown.data-api');
        $(document).ready(function () {
            dropdownOpen();//调用
        });

        /**
         * 鼠标划过就展开子菜单，免得需要点击才能展开
         */
        function dropdownOpen() {

            var $dropdownLi = $('li.dropdown');

            $dropdownLi.mouseover(function () {
                $(this).addClass('open');
            }).mouseout(function () {
                $(this).removeClass('open');
            });
        }

    </script>
</nav>
<!--页头-->
<div class="page-header container">
    <h1>宠物商城
        <small>欢迎您</small>
    </h1>
</div>
</body>
</html>
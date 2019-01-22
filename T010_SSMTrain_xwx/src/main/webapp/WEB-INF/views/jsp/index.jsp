<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String root = request.getContextPath() + "/";
    System.err.println("root = " + root);%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>宠物商城-首页</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,shrink-to-fit=no">
    <link rel="stylesheet" type="text/css" href="<%=root%>static/plug-in/bootstrap-3.4.0-dist/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="<%=root%>static/plug-in/font-awesome-4.7.0/css/font-awesome.min.css"/>
    <link rel="shortcut icon" href="<%=root%>static/images/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="<%=root%>static/css/base.css" type="text/css">
    <script type="text/javascript" src="<%=root%>static/js/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="<%=root%>static/plug-in/bootstrap-3.4.0-dist/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=root%>static/js/jquery.blockUI.js"></script>
    <script type="text/javascript" src="<%=root%>static/js/jquery.cookie.js"></script>
    <script type="text/javascript" src="<%=root%>static/js/base.js"></script>
</head>
<body>
<!--引入顶部导航栏-->
<script type="text/javascript">
    $("body").append($("<header id='header_navbar'></header>").load("<%=root%>header_navbar.do"));
</script>
<!--引入顶部导航栏-->

<!-- 轮播图start -->
<div class="container">
    <div id="carousel_box" class="carousel slide" data-ride="carousel" data-interval="4000">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#carousel_box" data-slide-to="0" class="active"></li>
            <li data-target="#carousel_box" data-slide-to="1"></li>
            <li data-target="#carousel_box" data-slide-to="2"></li>
        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner" role="listbox">
            <div class="item active">
                <a href="javascript:;">
                    <img src="static/images/slide_img1.jpg" height="357" alt=""/>
                </a>
                <div class="carousel-caption">
                </div>
            </div>
            <div class="item">
                <a href="javascript:;">
                    <img src="static/images/slide_img1.jpg" alt=""/>
                </a>
                <div class="carousel-caption">
                </div>
            </div>
            <div class="item">
                <a href="javascript:;">
                    <img src="static/images/slide_img1.jpg"/>
                </a>
                <div class="carousel-caption">
                </div>
            </div>
        </div>

        <!-- Controls -->
        <a class="left carousel-control" href="#carousel_box" role="button" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#carousel_box" role="button" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>

    </div>
</div>
<!-- 轮播图end -->

<!-- 商品展示start -->
<div class="container">
    <div class="row">
        <span style="font-size: 30px;padding-left:33px;">
            热门商品   <img src="static/images/login_bg_1.jpg" height="30" width="80%">
        </span>
    </div>
    <div class="row">
        <%--<div class="col-md-2 col-sm-2 hidden-xs hidden-sm" style="height: 400px;">--%>
            <%--<img src="static/images/login_bg_1.jpg" height="100%" width="100%">--%>
        <%--</div>--%>
        <div class="col-md-12 col-sm-12" style="padding-left: 10px;">
            <div class="row">
                <div class="col-md-6 hidden-xs hidden-sm" style="height:200px;width: 480px;">
                    <div class="thumbnail">
                        <img src="static/images/bomei_white.jpg"/>
                        <div class="caption" style="position:absolute;">
                            <h3>博美宠物犬</h3>
                            <p>纯种博美，居家必备！<span class="badger text-danger label-info h2"><b>￥999.00</b></span></p>
                            <p>
                                <a href="#" class="btn btn-primary" role="button">收藏</a>
                                <a href="#" class="btn btn-default" role="button">购买</a>
                            </p>
                        </div>
                    </div>
                </div>
                <div class="col-md-3 col-sm-4 col-xs-6" align="center">
                    <div class="thumbnail">
                        <img src="static/images/bomei_white.jpg"/>
                        <div class="caption">
                            <h3>博美宠物犬</h3>
                            <p>纯种博美，居家必备！<span class="badger text-danger label-info h2"><b>￥999.00</b></span></p>
                            <p>
                                <a href="#" class="btn btn-primary" role="button">收藏</a>
                                <a href="#" class="btn btn-default" role="button">购买</a>
                            </p>
                        </div>
                    </div>
                </div>
                <div class="col-md-3 col-sm-4 col-xs-6" align="center">
                    <div class="thumbnail">
                        <img src="static/images/bomei_white.jpg"/>
                        <div class="caption">
                            <h3>博美宠物犬</h3>
                            <p>纯种博美，居家必备！<span class="badger text-danger label-info h2"><b>￥999.00</b></span></p>
                            <p>
                                <a href="#" class="btn btn-primary" role="button">收藏</a>
                                <a href="#" class="btn btn-default" role="button">购买</a>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-3 col-sm-4 col-xs-6" align="center">
                    <div class="thumbnail">
                        <img src="static/images/bomei_white.jpg"/>
                        <div class="caption">
                            <h3>博美宠物犬</h3>
                            <p>纯种博美，居家必备！<span class="badger text-danger label-info h2"><b>￥999.00</b></span></p>
                            <p>
                                <a href="#" class="btn btn-primary" role="button">收藏</a>
                                <a href="#" class="btn btn-default" role="button">购买</a>
                            </p>
                        </div>
                    </div>
                </div>
                <div class="col-md-3 col-sm-4 col-xs-6" align="center">
                    <div class="thumbnail">
                        <img src="static/images/bomei_white.jpg"/>
                        <div class="caption">
                            <h3>博美宠物犬</h3>
                            <p>纯种博美，居家必备！<span class="badger text-danger label-info h2"><b>￥999.00</b></span></p>
                            <p>
                                <a href="#" class="btn btn-primary" role="button">收藏</a>
                                <a href="#" class="btn btn-default" role="button">购买</a>
                            </p>
                        </div>
                    </div>
                </div>
                <div class="col-md-3 col-sm-4 col-xs-6" align="center">
                    <div class="thumbnail">
                        <img src="static/images/bomei_white.jpg"/>
                        <div class="caption">
                            <h3>博美宠物犬</h3>
                            <p>纯种博美，居家必备！<span class="badger text-danger label-info h2"><b>￥999.00</b></span></p>
                            <p>
                                <a href="#" class="btn btn-primary" role="button">收藏</a>
                                <a href="#" class="btn btn-default" role="button">购买</a>
                            </p>
                        </div>
                    </div>
                </div>
                <div class="col-md-3 col-sm-4 col-xs-6" align="center">
                    <div class="thumbnail">
                        <img src="static/images/bomei_white.jpg"/>
                        <div class="caption">
                            <h3>博美宠物犬</h3>
                            <p>纯种博美，居家必备！<span class="badger text-danger label-info h2"><b>￥999.00</b></span></p>
                            <p>
                                <a href="#" class="btn btn-primary" role="button">收藏</a>
                                <a href="#" class="btn btn-default" role="button">购买</a>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- 商品展示end -->

<!--引入底部导航start-->
<script type="text/javascript">
    $("body").append($("<section id='top_navbar'></section>").load("<%=root%>footer_navbar.do"));
</script>
<!--引入底部导航end-->
</body>
</html>
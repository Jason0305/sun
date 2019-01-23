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
        <div class="management f-r">
            <div class="tanchuang-con">
                <div class="tc-title">
                    <h3>我的收货地址</h3>
                </div>
                <!--收货地址列表-->
                <div class="man-info">
                    <font>您已经保存三个地址！</font>
                    <div class="man-if-con">
                        <div class="man-tit">
                            <p class="p1">收货人</p>
                            <p class="p2">所在地区</p>
                            <p class="p3">详细地址</p>
                            <p class="p4">邮编</p>
                            <p class="p5">电话/手机</p>
                            <p class="p6">操作</p>
                        </div>
                        <ul class="man-ul1">
                            <li>
                                <p class="p1">赵珍珍</p>
                                <p class="p2">重庆 重庆市 南岸区</p>
                                <p class="p3">南坪左岸阳光c2-10-3</p>
                                <p class="p4">563000</p>
                                <p class="p5">18983945092</p>
                                <p class="p6">
                                    <a href="#">修改</a> |
                                    <a href="#">删除</a>
                                </p>
                                <p class="p7"><a href="#">默认地址</a></p>
                                <div style="clear:both;"></div>
                            </li>
                            <li>
                                <p class="p1">赵珍珍</p>
                                <p class="p2">重庆 重庆市 南岸区 南坪街道</p>
                                <p class="p3">南岸区南坪福红路19号乙单元7-2</p>
                                <p class="p4">000000</p>
                                <p class="p5">18983945092</p>
                                <p class="p6">
                                    <a href="#">修改</a> |
                                    <a href="#">删除</a>
                                </p>
                                <div style="clear:both;"></div>
                            </li>
                            <li>
                                <p class="p1">赵珍珍</p>
                                <p class="p2">浙江省 杭州市 余杭区崇贤街道</p>
                                <p class="p3">崇贤镇大安工业区彩诗纺织有限公司</p>
                                <p class="p4">311108</p>
                                <p class="p5">18983945092</p>
                                <p class="p6">
                                    <a href="#">修改</a> |
                                    <a href="#">删除</a>
                                </p>
                                <div style="clear:both;"></div>
                            </li>
                        </ul>
                    </div>
                </div>
                <!--收货地址列表-->
                <!--新增收货地址-->
                <font class="xinxi">请认真填写以下信息！</font>
                <ul class="tc-con2">
                    <li class="tc-li1">
                        <p class="l-p">所在地区<span>*</span></p>
                        <div class="xl-dz">
                            <div class="dz-left f-l">
                                <p>新疆</p>
                                <ul>
                                    <li class="current"><a href="#">新疆</a></li>
                                    <li><a href="#">甘肃</a></li>
                                    <li><a href="#">宁夏</a></li>
                                    <li><a href="#">青海</a></li>
                                    <li><a href="#">重庆</a></li>
                                    <li><a href="#">长寿</a></li>
                                </ul>
                            </div>
                            <div class="dz-right f-l">
                                <p>乌鲁木齐</p>
                                <ul>
                                    <li class="current"><a href="#">乌鲁木齐</a></li>
                                    <li><a href="#">昌吉</a></li>
                                    <li><a href="#">巴音</a></li>
                                    <li><a href="#">郭楞</a></li>
                                    <li><a href="#">伊犁</a></li>
                                    <li><a href="#">阿克苏</a></li>
                                    <li><a href="#">喀什</a></li>
                                    <li><a href="#">哈密</a></li>
                                    <li><a href="#">克拉玛依</a></li>
                                    <li><a href="#">博尔塔拉</a></li>
                                    <li><a href="#">吐鲁番</a></li>
                                    <li><a href="#">和田</a></li>
                                    <li><a href="#">石河子</a></li>
                                    <li><a href="#">克孜勒苏</a></li>
                                    <li><a href="#">阿拉尔</a></li>
                                    <li><a href="#">五家渠</a></li>
                                    <li><a href="#">图木舒克</a></li>
                                    <li><a href="#">库尔勒</a></li>
                                    <div style="clear:both;"></div>
                                </ul>
                            </div>
                            <div style="clear:both;"></div>
                        </div>
                        <div style="clear:both;"></div>
                    </li>
                    <li class="tc-li1">
                        <p class="l-p">详细地址<span>*</span></p>
                        <textarea class="textarea1" placeholder="请如实填写您的详细信息，如街道名称、门牌号、楼层号和房间号。"></textarea>
                        <div style="clear:both;"></div>
                    </li>
                    <li class="tc-li1">
                        <p class="l-p">邮政编码<span></span></p>
                        <input type="text" />
                        <div style="clear:both;"></div>
                    </li>
                    <li class="tc-li1">
                        <p class="l-p">收货人姓名<span>*</span></p>
                        <input type="text" />
                        <div style="clear:both;"></div>
                    </li>
                    <li class="tc-li1">
                        <p class="l-p">联系电话<span>*</span></p>
                        <input type="text" />
                        <div style="clear:both;"></div>
                    </li>
                </ul>
                <button class="btn-pst2">保存</button>
                <!--新增收货地址-->
            </div>

        </div>
        <div style="clear:both;"></div>
    </div>
    <!--个人资料-->
</div>
<%--头像插件--%>
<%--<div class="modal fade" id="avatar-modal" aria-hidden="true" aria-labelledby="avatar-modal-label" role="dialog"
     tabindex="-1">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <!--<form class="avatar-form" action="upload-logo.php" enctype="multipart/form-data" method="post">-->
            <form class="avatar-form">
                <div class="modal-header">
                    <button class="close" data-dismiss="modal" type="button">×</button>
                    <h4 class="modal-title" id="avatar-modal-label">上传图片</h4>
                </div>
                <div class="modal-body">
                    <div class="avatar-body">
                        <div class="avatar-upload">
                            <input class="avatar-src" name="avatar_src" type="hidden">
                            <input class="avatar-data" name="avatar_data" type="hidden">
                            <label for="avatarInput" style="line-height: 35px;">图片上传</label>
                            <button class="btn btn-info" type="button" style="height: 35px;"
                                    onClick="$('input[id=avatarInput]').click();">请选择图片
                            </button>
                            <span id="avatar-name"></span>
                            <input class="avatar-input hide" id="avatarInput" name="avatar_file" type="file"></div>
                        <div class="row">
                            <div class="col-md-9">
                                <div class="avatar-wrapper"></div>
                            </div>
                            <div class="col-md-3">
                                <div class="avatar-preview preview-lg" id="imageHead"></div>
                                <!--<div class="avatar-preview preview-md"></div>
                        <div class="avatar-preview preview-sm"></div>-->
                            </div>
                        </div>
                        <div class="row avatar-btns">
                            <div class="col-md-4">
                                <div class="btn-group">
                                    <button class="btn btn-info fa fa-undo" data-method="rotate" data-option="-90"
                                            type="button" title="Rotate -90 degrees"> 向左旋转
                                    </button>
                                </div>
                                <div class="btn-group">
                                    <button class="btn  btn-info fa fa-repeat" data-method="rotate" data-option="90"
                                            type="button" title="Rotate 90 degrees"> 向右旋转
                                    </button>
                                </div>
                            </div>
                            <div class="col-md-5" style="text-align: right;">
                                <button class="btn btn-info fa fa-arrows" data-method="setDragMode" data-option="move"
                                        type="button" title="移动">
                                    <span class="docs-tooltip" data-toggle="tooltip" title=""
                                          data-original-title="$().cropper(' setDragMode', 'move')">
                                    </span>
                                </button>
                                <button type="button" class="btn btn-info fa fa-search-plus" data-method="zoom"
                                        data-option="0.1" title="放大图片">
                                    <span class="docs-tooltip" data-toggle="tooltip" title=""
                                          data-original-title="$().cropper(' zoom', 0.1)">
                                    <!--<span class="fa fa-search-plus"></span>-->
                                    </span>
                                </button>
                                <button type="button" class="btn btn-info fa fa-search-minus" data-method="zoom"
                                        data-option="-0.1" title="缩小图片">
                                    <span class="docs-tooltip" data-toggle="tooltip" title=""
                                          data-original-title="$().cropper(' zoom', -0.1)">
                                    <!--<span class="fa fa-search-minus"></span>-->
                                    </span>
                                </button>
                                <button type="button" class="btn btn-info fa fa-refresh" data-method="reset"
                                        title="重置图片">
                                    <span class="docs-tooltip" data-toggle="tooltip" title=""
                                          data-original-title="$().cropper(' reset')" aria-describedby="tooltip866214"></span>
                                </button>
                            </div>
                            <div class="col-md-3">
                                <button id="button_save" class="btn btn-info btn-block avatar-save fa fa-save"
                                        type="button" data-dismiss="modal"> 保存修改
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>--%>
<!--引入底部导航start-->
<script type="text/javascript">
    $("body").append($("<section id='top_navbar'></section>").load("<%=root%>footer_navbar.do"));
</script>
<!--引入底部导航end-->
</body>
</html>
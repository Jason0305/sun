<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String root = request.getContextPath() + "/";%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>宠物商城-个人资料</title>
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
    <script type="text/javascript" src="<%=root%>static/js/login.js"></script>
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

<div class="container" style="padding:0 0 50px 0;">

    <div class="container-fluid">
        <div class="row">
            <div class="col-md-2">
                <ul id="main-nav" class="nav nav-tabs nav-stacked" style="">
                    <li class="active">
                        <a href="#">
                            <i class="glyphicon glyphicon-th-large"></i>
                            首页
                        </a>
                    </li>
                    <li>
                        <a href="#systemSetting" class="nav-header collapsed" data-toggle="collapse">
                            <i class="glyphicon glyphicon-cog"></i>
                            系统管理
                            <span class="pull-right glyphicon glyphicon-chevron-down"></span>
                        </a>
                        <ul id="systemSetting" class="nav nav-list collapse secondmenu" style="height: 0px;">
                            <li><a href="mytask"><i class="glyphicon glyphicon-user"></i>个人资料</a></li>
                            <li><a href="#"><i class="glyphicon glyphicon-th-list"></i>菜单管理</a></li>
                            <li><a href="#"><i class="glyphicon glyphicon-asterisk"></i>角色管理</a></li>
                            <li><a href="#"><i class="glyphicon glyphicon-edit"></i>修改密码</a></li>
                            <li><a href="#"><i class="glyphicon glyphicon-eye-open"></i>日志查看</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="./plans.html">
                            <i class="glyphicon glyphicon-credit-card"></i>
                            物料管理
                        </a>
                    </li>
                    <li>
                        <a href="./grid.html">
                            <i class="glyphicon glyphicon-globe"></i>
                            收货地址
                            <%--<span class="label label-warning pull-right">5</span>--%>
                        </a>
                    </li>
                    <li>
                        <a href="./charts.html">
                            <i class="glyphicon glyphicon-calendar"></i>
                            订单管理
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <i class="glyphicon glyphicon-fire"></i>
                            关于系统
                        </a>
                    </li>
                </ul>
            </div>

            <div class="col-md-10 text-center" style="min-height:800px;">
                    <!--个人资料-->
                <div class="rightsidebar_box rt text-center form-horizontal">

                    <!--个人信息具体内容 -->
                    <div class="rs_content">
                        <form id="user_info">
                            <!--头像-->
                            <div class="rs_content_headPortrait">
                                <span class="same">我的头像：</span>
                                <img src="static/images/personage/avatar.png" alt="" id="icon" width="50px" height="50px"/>
                                <input type="file" name="avatarFile"/>
                                <span class="change_headPortrait same_click" data-toggle="modal" data-target="#avatar-modal"
                                      style="display: none;">更改头像</span>
                            </div>
                            <!--用户名-->
                            <div class="rs_content_username">
                                <span class="same">用户名：</span>
                                <span id="username_sp" class="same rs_username">-- --</span>
                                <input name="username" class="ed_username" value="" style="display: none;"/>
                                <span class="change_username same_click">更改用户名</span>
                            </div>
                            <!--性别-->
                            <div class="rs_content_sex">
                                <span class="same">性别：</span>
                                <input id="gender_inp_male" name="gender" type="radio" value="1" checked="checked"/>男
                                <input id="gender_inp_female" name="gender" type="radio" value="0"/>女
                            </div>
                            <!--绑定电话-->
                            <div class="rs_content_tel">
                                <span class="same">绑定电话：</span>
                                <input id="phone_inp" name="phone" type="text" value=""/>
                            </div>
                            <!--绑定邮箱-->
                            <div class="rs_content_mail">
                                <span class="same">绑定邮箱：</span>
                                <input name="email" class="ed_email" value="" style="display: none;"/>
                                <span id="email_sp" class="rs_mail"></span>
                                <span class="same_click change_mail">更改邮箱</span>
                            </div>
                            <!--保存按钮-->
                            <div class="save" id="change_info">
                                保存更改
                            </div>
                        </form>
                    </div>
                </div>

                    <!--个人资料-->
                </div>
            </div>

        </div>
    </div>
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
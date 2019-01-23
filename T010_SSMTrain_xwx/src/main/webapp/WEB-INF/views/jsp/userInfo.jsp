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
    <link rel="stylesheet" type="text/css" href="<%=root%>static/css/style.css"/>
    <link rel="stylesheet" type="text/css" href="<%=root%>static/css/base2.css"/>
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
        <div class="personal-r f-r">
            <form id="infoForm" enctype="multipart/form-data">
                <div class="personal_content">
                    <div class="personal-r-tit">
                        <h3>个人资料</h3>
                    </div>
                    <div class="data-con">
                        <div class="dt1">
                            <p class="f-l">当前头像：</p>
                            <div class="avatar f-l">
                                <div class="tu f-l">
                                    <a href="#">
                                        <img src="<%=root%>static/images/img/data-tu.gif"/>
                                        <input type="file" name="avatarFile" id="" class="img1" disabled="disabled"/>
                                    </a>
                                </div>
                                <a href="JavaScript:;" class="sc f-l" shangchuang="">上传头像</a>
                                <div style="clear:both;"></div>
                            </div>
                            <div style="clear:both;"></div>
                        </div>
                        <div class="dt1">
                            <p class="dt-p f-l">用户名：</p>
                            <input type="text" id="username" name="username" disabled="disabled"/>
                            <div style="clear:both;"></div>
                        </div>
                        <div class="dt1">
                            <p class="dt-p f-l">电子邮箱：</p>
                            <input type="text" id="email" name="email" disabled="disabled"/>
                            <div style="clear:both;"></div>
                        </div>
                        <div class="dt1">
                            <p class="dt-p f-l">手机号码：</p>
                            <input type="text" id="phone" name="phone" disabled="disabled"/>
                            <div style="clear:both;"></div>
                        </div>
                        <div class="dt1 gender_span">
                            <p class="dt-p f-l">性别：</p>
                            <input type="radio" name="gender" id="gender_male" value="1" disabled/><label
                                for="gender_male">男</label>
                            <input type="radio" name="gender" id="gender_female" value="0" disabled/><label
                                for="gender_female">女</label>
                            <div style="clear:both;"></div>
                        </div>
                        <button type="button" id="updateInfoBtn" class="btn-pst">修改</button>
                    </div>
                </div>
            </form>
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
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String root = request.getContextPath();%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,shrink-to-fit=no">
    <link rel="stylesheet" type="text/css" href="<%=root%>/static/plug-in/bootstrap-3.4.0-dist/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="<%=root%>/static/plug-in/font-awesome-4.7.0/css/font-awesome.min.css"/>
    <link rel="shortcut icon" href="<%=root%>/static/images/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="<%=root%>/static/css/base.css" type="text/css">
    <script type="text/javascript" src="<%=root%>/static/js/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="<%=root%>/static/plug-in/bootstrap-3.4.0-dist/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=root%>/static/js/jquery.blockUI.js"></script>
    <script type="text/javascript" src="<%=root%>/static/js/jquery.cookie.js"></script>
    <script type="text/javascript" src="<%=root%>/static/js/base.js"></script>
    <script type="text/javascript" src="<%=root%>/static/js/login.js"></script>
    <script type="text/javascript">
        let root = "<%=root%>";
    </script>
</head>
<body>

<!--引入顶部导航栏-->
<script type="text/javascript">
    $("body").append($("<header id='header_navbar'></header>").load("<%=root%>/header_navbar.do"));
</script>
<!--引入顶部导航栏-->

<!--登录模块start-->
<section class="container login_content">
    <!--<div class="container"><img src="../images/login_bg_1.jpg" alt="登录首页背景图" style="width:600px;position: absolute;left:70px;top:150px;z-index: -4;"></div>-->
    <!--<h1>Hello,world!</h1>-->
    <!--<p>欢迎来到宠物商城</p>-->
    <!--<button class="btn btn-info" type="button">Message</button>-->
    <div class="container login_form  modal-content" style="float:right;">
        <form id="loginForm" role="form" class="">
            <span><h4>宠物商城</h4></span>
            <!--用户名输入start-->
            <div class="form-group has-success has-feedback col-sm-12">
                <label for="uname" class="control-label sr-only">用户名</label>
                <div class="input-group">
                    <span class="input-group-addon glyphicon glyphicon-user"></span>
                    <input type="text" id="uname" name="username" class="form-control"
                           aria-describedby="uname_tip" placeholder="username"/>
                    <span class="glyphicon glyphicon-ok form-control-feedback action_success sr-only"
                          aria-hidden="true"></span>
                    <span class="glyphicon glyphicon-remove form-control-feedback action_error"
                          aria-hidden="true"></span>
                    <!--<div class=" sr-only"><span>error</span></div>-->
                </div>
                <span id="uname_tip" class="help-block login_tip">(success) </span>
            </div>
            <!--用户名输入end-->

            <!--密码输入start-->
            <div class="form-group col-sm-12 has-feedback">
                <label for="pwd" class="control-label sr-only">密码</label>
                <div class="input-group">
                    <span class="input-group-addon glyphicon glyphicon-lock"></span>
                    <input type="password" id="pwd" name="password" class="form-control"
                           aria-describedby="pwd_tip" placeholder="Passowrd"/>
                    <span class="glyphicon glyphicon-ok form-control-feedback action_success" aria-hidden="true"></span>
                    <span class="glyphicon glyphicon-remove  form-control-feedback action_error sr-only"
                          aria-hidden="true"></span>
                    <span id="pwd_tip" class="sr-only login_tip">(success) </span>
                </div>
                <div class="help-block"><span>error</span></div>
            </div>
            <!--密码输入end-->

            <!--记住密码、忘记密码、免费注册-->
            <div class="form-group checkbox col-sm-12">
                <span>
                    <label class="checkbox-inline">
                        <input type="checkbox" id="autoLogin"> 记住密码
                    </label>
                </span>
                <span>
                    <a href="#" class="login_target" onclick="alert('该模块暂未完善！');">忘记密码</a>
                    <span>&nbsp;|&nbsp;</span><a href="reg.html" class="login_target">免费注册</a>
                </span>
            </div>
            <!--记住密码、忘记密码、免费注册-->

            <!--登录按钮-->
            <button type="button" class="btn btn-primary btn-lg btn-block" id="loginBtn">
                <i class="fa fa-spinner fa-pulse sr-only"></i>
                <span>登录</span>
            </button>
            <!--登录按钮-->
            <script type="text/javascript">

            </script>
            <!--快捷登录-->
            <div class="fast_login col-sm-12">
                <span>合作网站账户登录</span>
                <div class="fast_way">
                    <a class="qq_way"></a>
                    <a class="sina_way"></a>
                    <a class="weixin_way"></a>
                </div>
                <div class="more_way_wrap">
                    <a>更多登录方式&gt;&gt;</a>
                </div>
            </div>
            <!--快捷登录-->
        </form>
    </div>
</section>
<!--登录模块end-->


<!--引入底部导航start-->
<script type="text/javascript">
    $("body").append($("<section id='top_navbar'></section>").load("<%=root%>/footer_navbar.do"));
</script>
<!--引入底部导航end-->
</body>
</html>
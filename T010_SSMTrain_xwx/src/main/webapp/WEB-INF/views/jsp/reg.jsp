<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String root = request.getContextPath();
    System.err.println("root = " + root);%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Reg</title>
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <link rel="stylesheet" type="text/css" href="<%=root%>/plug-in/bootstrap-3.4.0-dist/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="<%=root%>/plug-in/font-awesome-4.7.0/css/font-awesome.min.css"/>
    <link rel="shortcut icon" href="<%=root%>/images/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="<%=root%>/css/base.css" type="text/css">
    <script type="text/javascript" src="<%=root%>/js/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="<%=root%>/plug-in/bootstrap-3.4.0-dist/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=root%>/js/jquery.blockUI.js"></script>
    <script type="text/javascript" src="<%=root%>/js/jquery.cookie.js"></script>
    <script type="text/javascript" src="<%=root%>/js/base.js"></script>
    <script type="text/javascript">
        let root = "<%=root%>";
    </script>
</head>
<body>

<!--引入顶部导航栏-->
<script type="text/javascript">
    $("body").append($("<header id='header_navbar'></header>").load(root + "/header_navbar.do"));
</script>
<!--引入顶部导航栏-->

<div id="regForm">
    <div class="reg_form">
        <form class="form-horizontal">
            <div class="form-group">
                <label for="uname" class="col-sm-2 control-label">用户名</label>
                <div class="col-sm-7">
                    <input type="email" class="form-control" id="uname" placeholder="Email">
                </div>
                <!--<span>asdasdfdsfdsf</span>-->
            </div>
            <div class="form-group">
                <label for="pwd" class="col-sm-2 control-label">输入密码</label>
                <div class="col-sm-7">
                    <input type="password" class="form-control" id="pwd" placeholder="Password">
                </div>
            </div>
            <div class="form-group">
                <label for="pwd_confirm" class="col-sm-2 control-label">确认密码</label>
                <div class="col-sm-7">
                    <input type="password" class="form-control" id="pwd_confirm" placeholder="Password">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">性别</label>
                <div class="input-group col-sm-6">
                    <label class="radio-inline">
                        <input type="radio" name="gender" id="gender_m" value="1"> 男
                    </label>
                    <label class="radio-inline">
                        <input type="radio" name="gender" id="gender_f" value="0"> 女
                    </label>
                </div>
            </div>
            <div class="form-group">
                <label for="phone" class="col-sm-2 control-label">手机号</label>
                <div class="col-sm-7">
                    <input type="password" class="form-control" id="phone" name="phone" placeholder="手机号">
                </div>
            </div>
            <div class="form-group">
                <label for="phone_security_code" class="col-sm-2">短信验证码</label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" id="phone_security_code" placeholder="请输入手机验证码">
                </div>
                <div class="col-sm-3">
                    <button type="button" class="btn btn-info col-sm-12">获取短信验证码</button>
                </div>
            </div>
            <div class="form-group">
                <label for="email" class="col-sm-2 control-label">邮箱</label>
                <div class="col-sm-7">
                    <input type="password" class="form-control" id="email" name="email" placeholder="Password">
                </div>
            </div>
            <div class="form-group">
                <label for="email_security_code" class="col-sm-2">邮箱验证码</label>
                <div class="col-sm-4">
                    <input type="button" type="text" class="form-control" id="email_security_code"
                           placeholder="请输入邮箱验证码">
                </div>
                <div class="col-sm-3">
                    <button type="button" class="btn btn-info col-sm-12">获取邮箱验证码</button>
                </div>
            </div>
            <div class="form-group">
                <label for="reg_verification_code" class="col-sm-2">图形验证码</label>
                <div class="col-sm-7">
                    <div class="col-sm-6">
                        <input type="button" type="text" class="form-control" id="reg_verification_code"
                               placeholder="请输入图形验证码">
                    </div>
                    <div class="col-sm-6">
                        <img src="<%=root%>/images/reg_verification_code.gif" alt=""/>
                        <!--<span>看不清？<a href="#">换张图</a></span>-->
                    </div>
                </div>
            </div>
            <div class="form-group agreement">
                <label for="agreement" class="col-sm-2 sr-only">用户协议</label>
                <div class="col-sm-offset-2 col-sm-7">
                    <label class="checkbox-inline">
                        <input type="checkbox" id="agreement" value="option1" name="agreement">
                        <p>我有阅读并同意<a>《宠物商城服务协议》</a></p>
                    </label>

                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-7">
                    <button type="button" class="btn btn-primary col-sm-12">Sign in</button>
                </div>
            </div>
        </form>
    </div>
</div>


<!--引入底部导航start-->
<script type="text/javascript">
    $("body").append($("<section id='top_navbar'></section>").load(root + "/footer_navbar.do"));
</script>
<!--引入底部导航end-->
</body>
</html>
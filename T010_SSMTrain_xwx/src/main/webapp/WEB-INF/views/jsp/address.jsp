<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String root = request.getContextPath() + "/";%>
<!DOCTYPE html>
<html lang="en">
<head>
    <script type="text/javascript">
        let root = "<%=root%>";
    </script>
    <meta charset="UTF-8">
    <title>宠物商城-地址管理</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,shrink-to-fit=no">
    <link rel="shortcut icon" href="<%=root%>static/images/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" type="text/css" href="<%=root%>static/plug-in/bootstrap-3.4.0-dist/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="<%=root%>static/plug-in/font-awesome-4.7.0/css/font-awesome.min.css"/>
    <%--<link rel="stylesheet" type="text/css" href="<%=root%>static/css/style.css"/>--%>
    <%--<link rel="stylesheet" type="text/css" href="<%=root%>static/css/base2.css"/>--%>
    <link rel="stylesheet" href="<%=root%>static/css/base.css" type="text/css">

    <script type="text/javascript" src="<%=root%>static/js/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="<%=root%>static/plug-in/bootstrap-3.4.0-dist/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=root%>static/js/jquery.blockUI.js"></script>
    <script type="text/javascript" src="<%=root%>static/js/jquery.cookie.js"></script>
    <script type="text/javascript" src="<%=root%>static/js/base.js"></script>
    <script type="text/javascript" src="<%=root%>static/js/jquery.SuperSlide.2.1.1.js"></script>
</head>
<body>

<!--引入顶部导航栏-->
<script type="text/javascript">
    $("body").append($("<header id='header_navbar'></header>").load("<%=root%>header_navbar.do"));
</script>
<!--引入顶部导航栏-->

<!--个人中心-->
<div class="container border border-bottom personal">
    <!--路径地址-->
    <ol class="breadcrumb">
        <li><a href="<%=root%>index.do">首页</a></li>
        <li><a href="#">个人中心</a></li>
        <li class="active">收货地址管理</li>
    </ol>
    <!--个人资料-->
    <div>
        <div class="panel panel-group col-md-3 personal_left">
            <div class="personal-l-tit panel-title panel-primary">个人中心</div>
            <div class="panel-body">
                <%--<p>...</p>--%>
                <div class="list-group panel-body">
                    <a class="list-group-item" href="<%=root%>user/info.do">个人资料<span>></span></a>
                    <a class="list-group-item" href="#">我的订单<span>></span></a>
                    <a class="list-group-item" href="#">购物车<span>></span></a>
                    <a class="list-group-item active" href="#">收货地址管理<span>></span></a>
                    <a class="list-group-item" href="#">我的收藏<span>></span></a>
                    <a class="list-group-item" href="#">交易记录<span>></span></a>
                    <a class="list-group-item" href="#">浏览记录<span>></span></a>
                </div>
            </div>
        </div>
        <div class="col-md-9 recvAddressList  personal_content">
            <%--<div class="well well-sm">
                <span class="">收货地址</span>
            </div>--%>
            <div class="panel panel-primary" style="min-height:500px;">
                <div class="panel-heading"><span class="text-white-50">收货地址</span>
                    <button type="button" class="btn btn-success pull-right label"
                            data-toggle="modal" data-target="#addressModify" data-title="新增">
                        新增
                    </button>
                </div>
                <table class="table">
                    <table class="table table-responsive table-striped">
                        <thead>
                        <tr class="">
                            <th>地址名称</th>
                            <th>收货人</th>
                            <th style="width:70px;">收件地址</th>
                            <th>手机号码</th>
                            <th>邮编</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody id="addressList">
                        <tr id="recvId_2965">
                            <td>公司</td>
                            <td>邬秀纯</td>
                            <td>null湖北省咸宁市崇阳县</td>
                            <td>13405580832</td>
                            <td>邬秀纯</td>
                            <td><span class="">修改</span>&nbsp;|&nbsp;<span class="">删除</span>&nbsp;|&nbsp;<span
                                    class="label label-warning">默认</span></td>
                        </tr>
                        </tbody>
                    </table>
                </table>
            </div>

            <!-- Modal -->
            <div class="modal fade" id="addressModify" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                    aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="name_addr">新增收货地址</h4>
                        </div>
                        <div class="modal-body">
                            <form class="form news_addr" id="addressNew">
                                <div class="form-group">
                                    <label for="uname" class="col-sm-3 control-label">收件人姓名：</label>
                                    <div class="input-group col-sm-8">
                                        <input type="text" id="uname" name="username" class="form-control"
                                               aria-describedby="uname_tip" placeholder="username"/>
                                        <span class="glyphicon glyphicon-ok form-control-feedback action_success"
                                              aria-hidden="true"></span>
                                    </div>
                                </div>
                                <div class="form-group" id="addNewAddressForm">
                                    <label for="uname" class="col-sm-3 control-label">省市区：</label>
                                    <div class="input-group col-sm-9">
                                        <select id="recvProvince" class="select" name="recvProvince">
                                            <option value="0">----- 请选择 -----</option>
                                        </select>
                                        <select id="recvCity" class="select" name="recvCity">
                                            <option value="0">----- 请选择 -----</option>
                                        </select>&nbsp;&nbsp;
                                        <select id="recvArea" class="select" name="recvArea">
                                            <option value="0">----- 请选择 -----</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="uname" class="col-sm-3 control-label">街道地址：</label>
                                    <div class="input-group col-sm-8">
                                        <input type="text" id="recvaddress" name="username" class="form-control"
                                               aria-describedby="uname_tip" placeholder="具体街道地址"
                                               size="70" maxlength="50"/>
                                        <span class="glyphicon glyphicon-ok form-control-feedback action_success"
                                              aria-hidden="true"></span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="uname" class="col-sm-3 control-label">邮政编码：</label>
                                    <div class="input-group col-sm-8">
                                        <input type="text" id="zipCode" name="recvAddress" class="form-control"
                                               aria-describedby="uname_tip" placeholder="具体街道地址"
                                               size="70" maxlength="50"/>
                                        <span class="glyphicon glyphicon-ok form-control-feedback action_success"
                                              aria-hidden="true"></span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="uname" class="col-sm-3 control-label">手机号码：</label>
                                    <div class="input-group col-sm-8">
                                        <input type="text" id="" name="phone" class="form-control"
                                               aria-describedby="uname_tip" placeholder="请填写11位手机号码"
                                               size="22" maxlength="11" value=""/>
                                        <span class="glyphicon glyphicon-ok form-control-feedback action_success"
                                              aria-hidden="true"></span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="uname" class="col-sm-3 control-label">地址标签：</label>
                                    <div class="input-group col-sm-3">
                                        <input type="text" id="recvTag" name="recvTag" class="form-control"
                                               aria-describedby="uname_tip" placeholder="请填写11位手机号码"
                                               size="22" maxlength="11" value=""/>
                                        <span class="glyphicon glyphicon-ok form-control-feedback action_success"
                                              aria-hidden="true"></span>
                                    </div>
                                    <div class="col-md-4 d-md-inline">
                                        <span class="label bg-primary"><span
                                                class=" glyphicon glyphicon-tags text-warning"></span> 家 </span>
                                        <span class="label bg-primary"><span class=" glyphicon glyphicon-tags"></span> 公司 </span>
                                        <span class="label bg-primary"><span class=" glyphicon glyphicon-tags"></span> 宿舍 </span>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-primary" id="saveBtn">保存</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!--个人中心-->

<!--引入底部导航start-->
<script type="text/javascript">
    $("body").append($("<section id='top_navbar'></section>").load("<%=root%>/footer_navbar.do"));
</script>
<!--引入底部导航end-->
</body>
</html>
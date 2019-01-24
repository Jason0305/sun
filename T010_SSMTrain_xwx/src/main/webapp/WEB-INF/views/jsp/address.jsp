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
    <link rel="stylesheet" type="text/css" href="<%=root%>static/css/style.css"/>
    <link rel="stylesheet" type="text/css" href="<%=root%>static/css/base2.css"/>
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
                <li><a href="<%=root%>user/info.do">个人资料<span>></span></a></li>
                <li><a href="<%=root%>user/order.do">我的订单<span>></span></a></li>
                <%--<li><a href="#">我的预约<span>></span></a></li>--%>
                <li><a href="<%=root%>shopcart/page.do">购物车<span>></span></a></li>
                <li class="current_active"><a href="#">收货地址管理<span>></span></a></li>
                <li><a href="#">我的收藏<span>></span></a></li>
                <li><a href="#">交易记录<span>></span></a></li>
                <li><a href="#">浏览记录<span>></span></a></li>
                <%--<li><a href="#">会员积分<span>></span></a></li>--%>
            </ul>
        </div>
        <div class="management f-r">
            <div class="contB ">
                <!--[[收货地址-->
                <div class="">
                    <div class="cont-tit">
                        <h2>收货地址</h2>
                    </div>
                    <div class="sh_address_box">
                        <div class="yy_address">
                            <table width="" cellpadding="0" cellspacing="0" border="0" class="tb_news">
                                <thead>
                                <tr>
                                    <th class="s_tag">地址名称</th>
                                    <th class="s_name">收货人</th>
                                    <th class="s_addr">收件地址</th>
                                    <th class="s_tel">手机号码</th>
                                    <th class="s_postal">邮编</th>
                                    <th class="s_opt">操作</th>
                                </tr>
                                </thead>
                                <tbody id="addressList">
                             <%--<tr>
                                    <td>刘冰</td>
                                    <td class="infro_td">河北省-秦皇岛市-海港区 东大直街88</td>
                                    <td>15245166888</td>
                                    <td>445454</td>
                                    <td>
                                        <a class="modify_ico" href="javascript:;" onclick="isModify()">修改</a>&nbsp;|&nbsp;
                                        <a class="delete_ico" href="javascript:;"
                                           onclick="return confirm('&quot;确认删除？&quot;');">删除</a>
                                    </td>
                                </tr>--%>
                                </tbody>
                            </table>
                        </div>
                        <!--[[新增按钮-->
                        <div class="address_add">
                            <a href="javascript:;"id="addNewBtn" class="btn btn-info">添加新地址</a>
                        </div>
                        <!--新增按钮]]-->
                        <!--[[新增收货人信息-->
                        <!--[[省份-->
                        <div class="news_addr" id="addressNew" style="display:none;">
                            <h2 class="name_addr">
                                <span class="addAddress" style="display: none;">新增收货地址</span>
                                <span class="modifyAddress" style="display: none;">修改收货地址</span>
                            </h2>
                            <!--省份]]-->
                            <table id="modifyAddress" class="o_layout" width="100%" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td class="o_label"><i>*</i><label>收件人姓名：</label></td>
                                    <td>
                                        <input type="text" placeholder="姓名，如张三、Lily" class="order_input" size="22"
                                               maxlength="14" value="">
                                    </td>
                                </tr>

                                <tr>
                                    <td class="o_label"><i>*</i><label>省市区：</label></td>
                                    <td>
                                        <%--onChange="changeComplexProvince(this.value, sub_array, 'seachcity', 'seachdistrict');"--%>
                                        <select id="recvProvince" class="sf_input" name="recvProvince">
                                            <option value="0">----- 请选择 -----</option>
                                        </select>&nbsp;&nbsp;
                                        <%--onChange="changeCity(this.value,'seachdistrict','seachdistrict');"--%>
                                        <select id="recvCity" class="sf_input" name="recvCity">
                                            <option value="0">----- 请选择 -----</option>
                                        </select>&nbsp;&nbsp;
                                        <div id="recvArea_div">
                                            <select id="recvArea" class="sf_input" name="recvArea">
                                                <option value="0">----- 请选择 -----</option>
                                            </select>
                                        </div>
                                        <input type="button" value="获取地区"
                                               onClick="alert($(this).prev('div').children('select').val())"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="o_label"><i>*</i><label>街道地址：</label></td>
                                    <td>
                                        <input type="text" placeholder="具体街道地址" class="order_input" value="" size="70"
                                               maxlength="50">
                                    </td>
                                </tr>
                                <tr>
                                    <td class="o_label"><i>*</i><label>邮政编码：</label></td>
                                    <td>
                                        <input type="text" placeholder="" class="order_input" size="22" maxlength="6"
                                               value="">
                                    </td>
                                </tr>
                                <tr>
                                    <td class="o_label"><i>*</i><label>手机号码：</label></td>
                                    <td>
                                        <input type="text" placeholder="请填写11位手机号码" class="order_input" size="22"
                                               maxlength="11" value="">
                                    </td>
                                </tr>
                                <tr>
                                    <td class="o_label"><i>*</i><label>固定电话：</label></td>
                                    <td>
                                        <input type="text" size="5" class="order_input" maxlength="4"> -
                                        <input type="text" size="10" class="order_input" maxlength="8"> -
                                        <input type="text" size="5" class="order_input" maxlength="8">
                                    </td>
                                </tr>
                                <tr>
                                    <td style="text-align:right;"></td>
                                    <td style="text-align:left;color:#999;">两者至少填一项</td>
                                </tr>
                                <tr class="address_name">
                                    <td class="o_label"><i>&nbsp;&nbsp;</i><label>地址名称：</label></td>
                                    <td>
                                        <input type="text" id="addressName" name="recvTag"/>
                                        <span>如：</span>
                                        <span class="sp badge btn recvTag">家</span>
                                        <span class="sp badge btn recvTag">公司</span>
                                        <span class="sp badge btn recvTag">宿舍</span>
                                    </td>
                                </tr>
                                <tr>
                                    <td>&nbsp;</td>
                                    <td class="pad_btn">
                                        <div class="act" style="font-size: 14px; padding: 5px;padding-left: 0px;">
                                            <input type="submit" value="保存收货地址" class="save_btn">
                                            <a style="" href="#" class="cancel_btn" onclick="$('#addressNew').hide()">取消</a>
                                        </div>
                                    </td>
                                </tr>
                            </table>
                        </div>
                        <!--新增收货人信息]]-->
                    </div>
                </div>
                <!--收货地址]]-->
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
<%--
  Created by IntelliJ IDEA.
  User: xuwanxing
  Date: 2019/1/21
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>address</title>
</head>
<body>
<div class="container">
    <div class="cont-tit">
        <h2>收货地址</h2>
    </div>
    <div class="sh_address_box">
        <div class="yy_address">
            <table width="850" cellpadding="0" cellspacing="0" border="0" class="tb_news">
                <thead>
                <tr>
                    <th class="s_name">收货人</th>
                    <th class="s_addr">收件地址</th>
                    <th class="s_tel">手机号码</th>
                    <th class="s_postal">邮编</th>
                    <th class="s_opt">操作</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>刘冰</td>
                    <td class="infro_td">河北省-秦皇岛市-海港区 东大直街88</td>
                    <td>15245166888</td>
                    <td>445454</td>
                    <td>
                        <a class="modify_ico" href="javascript:;" onclick="isModify()">修改</a>&nbsp;|&nbsp;
                        <a class="delete_ico" href="javascript:;"
                           onclick="return confirm('&quot;确认删除？&quot;');">删除</a>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
</div>
</body>
</html>

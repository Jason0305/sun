<%@page pageEncoding="UTF-8" %>
<html>
<head>
    <title>hello</title>
    <script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="../js/jquery.blockUI.js"></script>
    <script>
        onload = function () {
            isSubmit.onclick = function () {
                console.log("准备提交");
                $.ajax({
                    url: "../user/login.do",
                    // cache: true,
                    type: "post",
                    dataType: "json",
                    data: $(form).serialize(),
                    beforeSend: function (XMLHttpRequest) {
                        console.log("beforeSend()")
                    },
                    context: document.body,
                    success: function (data, textStatus) {
                        console.log("11111");
                        demo.value = "13"
                        // alert(data);
                        // alert(data.a[0].a);
                    },
                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                        console.log("未知错误情况！");
                    },
                    complete: function (XMLHttpRequest, textStatus) {
                        console.log("请求完成！\n\f");
                    },
                    statusCode: {
                        200: function () {
                            console.log("200,请求正常...")
                        },
                        404: function () {
                            alert("404，页面不存在...");
                        }
                    }
                });

            };

        }
    </script>
</head>
<body>
<form id="form">
    <table border="1px" cellspacing="0" align="center" style="border:solid 1px black;align-content: center">
        <caption><h2>Hello World!</h2></caption>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="username" id="username" placeholder="Please write your username!"/>
            </td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password" id="password" placeholder="Please write your username!"/></td>
        </tr>
        <tr>
            <td>确认密码</td>
            <td><input type="password" name="password" placeholder="Please ensure your username!"></td>
        </tr>
        <tr>
            <td colspan="2">
                <button type="reset">RESET</button>
                <button type="button" id="isSubmit">SUBMIT</button>
            </td>
        </tr>
    </table>
</form>
<a href="http://localhost:8080//do">忘记密码</a>
<a href="http://localhost:8080//do">注册</a>
<input style="width:100px;height:100px;background: orange" id="demo" value="123567889"></input>
<div style="width:100px;height:100px;background: orange" id="demo2">123567889</div>
</body>
</html>

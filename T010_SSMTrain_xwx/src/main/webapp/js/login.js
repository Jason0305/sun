// console.log("邮箱: " + FormReg.formCheck("2141243@qq.com", "邮箱", "email,phone,username",));
$(function () {
    $("#uname").focus(function () {
        // $(this).nextAll(":last").addClass("sr-only");
    }).blur(function () {
        // $(this).nextAll(":last").removeClass("sr-only");
        // $(this).parents(".form-group").addClass("has-success");
    });

    $("#uname1").focus(function () {
        $(this).nextAll("span:eq(1)").css("display", "none");
        $(this).nextAll("span:last").text("请输入您的用户名或注册邮箱！").css("color", "#666");
    }).blur(function () {
        const loginInput = this;
        const username = this.value;
        // const isCorrect = FormReg.formCheck(username, "用户名", "username",);
        if (username == null || username === "" || username === this.defaultValue) {
            $(this).addClass("style_border").removeClass("style_error");
            $(this).nextAll("span:last").text("用户名不能为空！").css("color", "red");
        } else if (!/^[\u4E00-\u9FA5\w_]{2,16}$/.test(username)) {
            $(this).css("border", "red");
            $(this).nextAll("span:last").text("用户名格式不正确，请重新检查！").css("color", "red");
        } else {
            $.ajax({
                url: "user/username_check.do",
                type: "get",
                data: "username=" + username,
                dataType: "json",
                before: function () {
                    $(loginInput).nextAll("span:last").text("正在查询");
                },
                success: function (data) {
                    if (data.status) {
                        $(this).css("border", "red");
                        $(loginInput).nextAll("span:last").text("");
                        $(loginInput).nextAll("span:eq(1)").css("display", "block");
                    } else {
                        $(this).css("border", "red");
                        $(loginInput).nextAll("span:last").text("用户名不存在，请重新确认！");
                    }
                }
            })
        }
    });


    /** 当密码输入框内容改变，校验合法性 */
    $("#pwd").focus(function () {
        $(this).nextAll("span:last").text("请输入至少6位以字母开头，数字或符号!").css("color", "#666");
    }).blur(function () {
        const value = this.value;
        if (value == null || value === '') {
            $(this).css("border", "red");
            $(this).nextAll("span:last").text("请输入至少6位以字母开头，数字或符号!").css("color", "red");
        } else if (value.length < 6) {
            $(this).nextAll("span:last").text("密码格式不正确，请重新检查！").css("color", "red");
        } else {
            $(this).nextAll("span:last").text("")
        }
    });

    /** 页面加载时将记住的密码信息填充到页面 */
    $(function () {
        //页面加载先前记录的用户信息并选择填充到页面
        if ($.cookie("isAutoLogin") === "true") {
            $("#autoLogin").attr({checked: "checked"});
            $("#loginForm input[name='username']").val($.cookie("username"));
            $("#loginForm input[name='password']").val($.cookie("password"));
        }
    });

    $(function () {
        /** 执行登录操作 */
        $("#loginBtn").click(function () {
            console.log("cookie.password:" + $.cookie("password"));
            $.ajax({
                url: root + "/user/handle_login.do",
                data: $("#loginForm").serialize(),
                type: "get",
                dataType: "json",
                beforeSend: function () {
                    $("#loginBtn").addClass("disabled").children("i").removeClass("sr-only").next("span").text("");
                },
                success: function (data) {
                    console.log("登录返回状态码:" + data.status);
                    if (data.status === 600) {
                        rememberUserInfo();
                        console.log("response.success!");
                        alert("登录成功");
                        setTimeout(location.href = root + "/index.do", 1000);
                    } else if (data.status === 601) {
                        alert("用户不存在！");
                    } else if (data.status === 602) {
                        alert("密码不正确，请重新检查！");
                    }
                },
                error: function () {
                    alert("未知异常！")
                },
                complete: function () {
                    $("#loginBtn").removeClass("disabled").children("i").addClass("sr-only").next().text("登录");
                }
            });
        });
    })

    /** 账号第三方登录功能不可用提示 */
    $(".fast_login a").click(function () {
        alert("该功能暂未开通，敬请期待！");
    }).attr("href", "javascript:;")

    /** 记住密码 */
    function rememberUserInfo() {
        if ($("#autoLogin").is(":checked")) {
            $.cookie("isAutoLogin", "true", {expires: 7});
            $.cookie("username", $("#loginForm input[name='username']").val(), {expires: 7});
            $.cookie("password", $("#loginForm input[name='password']").val(), {expires: 7});
        } else {
            $.cookie("isAutoLogin", "false");
            $.cookie("username", null);
            $.cookie("password", null);
        }
    }
});

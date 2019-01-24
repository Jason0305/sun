/*******************头部*********************/
$(function () {
    /***/
    $("[data-toggle='tooltip']").tooltip();
    $(document).off('click.bs.dropdown.data-api');
    dropdownOpen();//调用


    /**鼠标划过就展开子菜单，免得需要点击才能展开*/
    function dropdownOpen() {
        const $dropdownLi = $('li.dropdown');

        $dropdownLi.mouseover(function () {
            $(this).addClass('open');
        }).mouseout(function () {
            $(this).removeClass('open');
        });
    }

    //设为首页
    function setHome(obj, url) {
        try {
            obj.style.behavior = 'url(#default#homepage)';
            obj.setHomePage(url);
        } catch (e) {
            if (window.netscape) {
                try {
                    netscape.security.PrivilegeManager.enablePrivilege("UniversalXPConnect");
                } catch (e) {
                    alert("抱歉，此操作被浏览器拒绝！\n\n请在浏览器地址栏输入“about:config”并回车然后将[signed.applets.codebase_principal_support]设置为'true'");
                }
            } else {
                alert("抱歉，您所使用的浏览器无法完成此操作。\n\n您需要手动将【" + url + "】设置为首页。");
            }
        }
    }

    //收藏本站
    function addFavorite(title, url) {
        try {
            window.external.addFavorite(url, title);
        } catch (e) {
            try {
                window.sidebar.addPanel(title, url, "");
            } catch (e) {
                alert("抱歉，您所使用的浏览器无法完成此操作。\n\n加入收藏失败，请使用Ctrl+D进行添加");
            }
        }
    }

    //保存到桌面
    function toDesktop(sUrl, sName) {
        try {
            var WshShell = new ActiveXObject("WScript.Shell");
            var oUrlLink = WshShell.CreateShortcut(WshShell.SpecialFolders("Desktop") + "\\" + sName + ".url");
            oUrlLink.TargetPath = sUrl;
            oUrlLink.Save();
        } catch (e) {
            alert("当前IE安全级别不允许操作！");
        }
    }
});
/*******************头部*********************/


/*******************个人资料*********************/
$(function(){
    if (!/(user\/info\.do)$/.test(window.location.pathname)) return;
    /**加载个人信息*/
    const request = $.ajax({
        url: "get_info.do",
        method: "get",
        dataType: "json",
        success: function (json) {
            data = json.data
            let phone = data.phone;
            let email = data.email;
            $(".img1").prev("img").attr({src: root + data.avatar});
            $("#username").attr({placeHolder: data.username})
            $("#phone").attr({placeHolder: data.phone})
            $("#email").attr({placeHolder: data.email})
            $("input[name='gender'][value='" + data.gender + "']").attr({checked: "checked"});
        }
    })

    /*个人资料（上传头像）*/
    $("[shangchuang]").click(function (event) {
        $(".tanchuang").show();
    });
    $("[delete]").click(function (event) {
        $(".tanchuang").hide();
    });

    // 图像上传替换图片
    $(".img1").change(function () {
        if ($(this).val()) {
            var objUrl = gebjectURL(this.files[0]);
            console.log("objUrl = " + objUrl);
            $(this).prev("img").attr("src", objUrl)
        }
    })

    function gebjectURL(file) {
        var url = null;
        if (window.createObjectURL !== undefined) { // basic
            url = window.createObjectURL(file);
        } else if (window.URL !== undefined) { // mozilla(firefox)
            url = window.URL.createObjectURL(file);
        } else if (window.webkitURL !== undefined) { // webkit or chrome
            url = window.webkitURL.createObjectURL(file);
        }
        return url;
    }

    /**修改用户信息*/
    $("#updateInfoBtn").click(function () {
        if ($(this).text() === "修改") {
            $(this).text("保存").prevAll().children("input").removeAttr("disabled");
        } else {
            $(this).text("修改").prevAll().filter("input").attr({disabled: "disabled"});
            $.ajax({
                url: "update_info.do",
                method: "post",
                data: new FormData($("#infoForm")[0]),
                processData: false,
                contentType: false,
                dataType: "json",
                success: function (data) {
                    if (data.status === 600) {
                        alert("上传成功")
                    } else {
                        alert("上传失败!");
                    }
                }
            });
        }
    })

})
/*******************个人资料*********************/


/*******************登录************/
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
                url: "username_check.do",
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

    /** 执行登录操作 */
    $("#loginBtn").click(function () {
        console.log("cookie.password:" + $.cookie("password"));
        $.ajax({
            url: "handle_login.do",
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

    /** 账号第三方登录功能不可用提示 */
    $(".fast_login a").click(function () {
        alert("该功能暂未开通，敬请期待！");
    }).attr("href", "javascript:;")
});
/*******************登录*******************/


/*******************收货地址*******************/
$(function () {
    let addressListData;
    if (!/\S*(address\/)\S*$/.test(window.location.pathname)) return;
    function isModify() {
        $('#addressNew').show();
        $('.addAddress').hide();
        $('.modifyAddress').show();
    }

    function getDistricts(parent, menu) {
        menu.empty();
        var op = "<option value=0>----- 请选择 -----</option>";
        menu.append(op);
        var data = "parent=" + parent;
        $.ajax({
            "url": root + "district/list.do",
            "data": data,
            "type": "GET",
            "dataType": "json",
            "success": function (json) {
                // 响应结果中的data为地区的列表数组对象
                var districts = json.data;
                // 遍历地区的列表
                districts.forEach(function (district) {
                    menu.append($("<option></option>").attr({value: district.code}).text(district.name));
                })
                // for (var i = 0; i < districts.length; i++) {
                //     // 将地区的选项填充到省的下拉菜单中
                // }
            }
        });
    }

    // 页面加载完成时，即加载并显示省列表
    getDistricts("86", $("#recvProvince"));

    // 为省列表绑定change()函数，当选中的项发生变化时被触发
    $("#recvProvince").change(function () {
        // 清空城市列表
        $("#recvCity").empty();
        // 清空区县列表
        $("#recvArea").empty().append("<option value=0>----- 请选择 -----</option>");

        // 获取省列表中选中的项
        var provinceCode = $("#recvProvince").val();
        // 判断当前选中的省是否为“请选择”
        if (provinceCode == 0) {
            return;
        }
        // 加载并显示城市列表
        getDistricts(provinceCode, $("#recvCity"));
    });

    // 为城市列表绑定change()函数，当选中的项发生变化时被触发
    $("#recvCity").change(function () {
        // 清空区县列表
        $("#recvArea").empty();
        // 获取城市列表中选中的项
        var cityCode = $("#recvCity").val();
        // 判断当前选中的城市是否为“请选择”
        if (cityCode == 0) {
            return;
        }
        // 加载并显示区县列表
        getDistricts(cityCode, $("#recvArea"));
    });

    $(".recvTag").click(function () {
        $(this).prevAll("input").val(this.innerText)
    });

    showList();

    function fillAddressList(json) {
        $("#addressList").empty();
        json.data.forEach(function (address) {
            console.log(address.recvName + ", " + address.recvDistrict + ", " +
                address.recvAddress + ", " + address.isDefault);
            // language=HTML
            $("#addressList").append($("<tr></tr>").attr({id: ("recvId_" + address.id)})
                .append($("<td></td>").text(address.recvTag))
                .append($("<td></td>").text(address.recvName))
                .append($("<td></td>").text(address.recvDistrict + address.recvAddress))
                // .append($("<span></span>").text().attr({id:"district_"+}))
                // .append($("<span></span>"))
                // .append($("<span></span>"))
                // .append($("<span></span>")))
                .append($("<td></td>").text(address.recvPhone))
                .append($("<td></td>").text(address.recvName))
                .append($("<td><span class=''>修改</span>&nbsp;|&nbsp;" +
                    "<span class=''>删除</span>&nbsp;|&nbsp;" + ((address.isDefault === 1) ?
                        "<span class=''>设为默认</span>" : "<span class='badge'>默认</span>"))));
        })
    }

    function showList() {
        $.ajax({
            "url": root + "address/list.do",
            "type": "GET",
            "dataType": "json",
            "success": function (json) {
                addressListData = json;
                fillAddressList(json);
            },
            "error": function (xhr, textStatus, errorThrown) {
                // xhr：XMLHttpRequest类型的对象
                // - responseText：响应的文本
                // - readyState：状态，值为0~4
                // - status：响应码
                console.log("状态码：" + xhr.readyState);
                console.log("响应码：" + xhr.status);
                console.log("响应文本：" + xhr.responseText);
                console.log("textStatus=" + textStatus);
                console.log("errorThrown=" + errorThrown);
            }
        });
    }

    $("#addNewBtn").click(function() {
        $('#addressNew').show();
        $('.modifyAddress').hide();
        $('.addAddress').show();
    });

    $("#addressList").click(function (e) {
        if (e.target.tagName === "SPAN") {
            const span = $(e.target);
            const tr = span.parent().parent();
            switch (span.text()) {
                case "修改":
                    const addressId = +tr.attr("id").replace("recvId_", "");
                    let currentAddress;
                    addressListData.data.forEach(function (address) {
                        if (address.id === addressId) {
                            currentAddress = address
                            return false;
                        }
                    })
                    $("#modifyAddress input[name='username']").val(currentAddress.recvName)
                    // $("#modifyAddress input[name='phone']").children("input").val(currentAddress.recvName)
                    // $("#modifyAddress select[name='recvAddress']").children("input").val(tr.children("td:first").text())
                    // $("#modifyAddress input[name='recvAddress']").children("input").val(tr.children("td:first").text())
                    // $("#modifyAddress input[name='recvAddress']").children("input").val(tr.children("td:first").text())
                    $("#addressNew").show();
                    $(".addAddress").hide();
                    $(".modifyAddress").show();
                    break;
                case "删除":
                    confirm("确认此收货地址删除？") && tr.remove();
                    break;
                case "设为默认":
                    $.ajax({
                        url: root + "address/set_default.do",
                        data: "id=" + tr.attr("id"),
                        method: "post",
                        dataType: "json",
                        success: function (json) {
                            fillAddressList(json);
                        }
                    })
                    break;
                default:
                    break;
            }
        }
    })
});
/*******************收货地址************/

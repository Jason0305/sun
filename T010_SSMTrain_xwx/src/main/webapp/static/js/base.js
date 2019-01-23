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

    $.ajax({
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


    /**修改用户信息*/
    $("#updateInfoBtn").click(function () {
        if ($(this).text() === "修改") {
            $(this).text("保存").prevAll().children("input").removeAttr("disabled");
        } else {
            $(this).text("修改").prevAll().filter("input").attr({disabled:"disabled"});
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
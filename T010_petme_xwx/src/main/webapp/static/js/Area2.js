$(function () {

    function getDistricts(parent, menu) {
        menu.empty();

        var op = "<option value=0>----- 请选择 -----</option>";
        menu.append(op);

        var url = root + "district/list.do";
        var data = "parent=" + parent;
        $.ajax({
            "url": url,
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

    let addressListData;
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

    $("#addressList").click(function (e) {
        if (e.target.tagName === "SPAN") {
            const span = $(e.target);
            const tr = span.parent().parent();
            switch (span.text()) {
                case "修改":
                    const addressId = +tr.attr("id").replace("recvId_","");
                    let currentAddress;
                    addressListData.forEach(function(address){
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


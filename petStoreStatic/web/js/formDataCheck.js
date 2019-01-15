function FormReg() {

    //用户名正则，4到16位（字母，中文, 数字，下划线）
    FormReg.username = /^[\u4E00-\u9FA5\w_]{2,16}$/;
    //密码强度正则，最少6位，包括至少1个大写字母，1个小写字母，1个数字，1个特殊字符
    FormReg.password = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z_]{6,16}$/;
    //邮箱
    FormReg.email = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
    //手机或者固话
    FormReg.phone = /(^(0[0-9]{2,3}\-)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?$)|(^0?[1][358][0-9]{9}$)/;
    //邮编
    FormReg.postcode = /^\d{6}$/;
    //身份证
    FormReg.idCard = /^[1-9]\d{5}(18|19|([23]\d))\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$/;
    //url
    FormReg.url = /^((ht|f)tps?):\/\/([\w\-]+(\.[\w\-]+)*\/)*[\w\-]+(\.[\w\-]+)*\/?(\?([\w\-\.,@?^=%&:\/~\+#]*)+)?/;
    //ip
    FormReg.ip = /((25[0-5]|2[0-4]\d|((1\d{2})|([1-9]?\d)))\.){3}(25[0-5]|2[0-4]\d|((1\d{2})|([1-9]?\d)))/;
    //物理地址
    FormReg.mac = /^[A-F0-9]{2}(-[A-F0-9]{2}){5}$/;
    //两位小数
    FormReg.decimal = /^[0-9]+(.[0-9]{2})?$/;
    //数字
    FormReg.num = /^[0-9]*$/;
    //正整数
    FormReg.pos = /^\d+$/;
    //负整数正则
    FormReg.neg = /^-\d+$/;
    this.username2 = 2;

}

/**
 * 校验表单
 */
FormReg.formCheck = function (value, preText, rule) {
    let rs = rule.split(",");
    let errorInfo = null;
    rs.forEach(function (s) {
        if (s.indexOf("|") < 0 && s.indexOf("_") < 0) {
            //“|”(或):邮箱或者手机号，“_”(最):min_6/max_6指最小/最大6位
            switch (s) {
                //需要特殊说明文字的在此添加case
                case "required":
                    if (value != null && value.trim().length > 0) {
                        errorInfo = "正确";
                    } else {
                        errorInfo = preText + "不能为空";
                    }
                    break;
                //通用说明走else
                default:
                    errorInfo = FormReg.verifyByRegular(value, preText, s);
                    break;
            }
            if (errorInfo != null) {
                //如果已有错误信息，则不需要再次循环
                return;
            }
        } else {
            if (s.indexOf("|") >= 0) {
                //包含"或者关系",一般"|"和"_"不会共存，在此不做考虑
                if (s.indexOf("_") >= 0) {
                    errorInfo = preText + "规则配置错误";
                }
                let s1 = s.split("|");
                s1.forEach(function (s2) {
                    errorInfo = FormReg.verifyByRegular(value, preText, s2);
                    if (errorInfo == null) {
                        return;
                    }
                })
            } else if (s.indexOf("_") >= 0) {
                let s1 = s.split("_");
                if (s1[0] === "min") {
                    errorInfo = FormReg.minLen(preText, value, +s1[1]);
                } else if (s1[0] === "max") {
                    errorInfo = FormReg.maxLen(preText, value, +s1[1]);
                } else {
                    errorInfo = "暂不支持这种校验格式：" + s1[0];
                }
            }
            if (errorInfo != null) {
                //如果已有错误信息，则不需要再次循环
                return;
            }
        }
    });
    return errorInfo;
}

/**
 * 根据正则表达式判断是否成立
 *
 * @param preText 必传，字段名称
 * @param value   必传，字段值
 * @param rule    必传，校验类型
 * @return
 */
FormReg.verifyByRegular = function (value, preText, rule) {
    let errorInfo = null;
    let regex;
    alert(this.username2);
    switch (rule) {
        case "username":
            regex = FormReg.username;
            break;
        case "password":
            regex = FormReg.password;
            break;
        case "email":
            regex = FormReg.email;
            break;
        case "phone":
            regex = FormReg.phone;
            break;
        case "postcode":
            regex = FormReg.postcode;
            break;
        case "sfz":
            regex = FormReg.idCard;
            break;
        case "n":
            regex = FormReg.n;
            break;
        case "url":
            regex = FormReg.url;
            break;
        case "ip":
            regex = FormReg.ip;
            break;
        case "mac":
            regex = FormReg.mac;
            break;
        case "decimal":
            regex = FormReg.decimal;
            break;
        case "num":
            regex = FormReg.num;
            break;
        case "pos":
            regex = FormReg.pos;
            break;
        case "neg":
            regex = FormReg.neg;
        default:
            break;
    }
    if (regex === "") {
        errorInfo = "不支持";
    } else {
        alert(regex);
        if (regex.test(value)) {
            errorInfo = "正确";
        } else {
            errorInfo = preText + "格式不正确，请重新检查！";
        }
    }
    return errorInfo;
};

/**
 * 校验最少长度
 *
 * @param preText
 * @param value
 * @param min
 * @return
 */
FormReg.minLen = function (preText, value, min) {
    let errorInfo = null;
    if (value != null && value.trim.length >= min) {
    } else {
        errorInfo = preText + "最少长度为" + min + "位。";
    }
    return errorInfo;
}


FormReg.maxLen = function (preText, value, max) {
    let errorInfo = null;
    if (value != null && value.trim().length() <= max) {

    } else {
        errorInfo = preText + "最大长度为" + max + "位。";
    }
    return errorInfo;
}

alert(FormReg.formCheck("asdf", "用户名", "username"));
// alert((/^[\u4E00-\u9FA5\w_]{2,16}$/));
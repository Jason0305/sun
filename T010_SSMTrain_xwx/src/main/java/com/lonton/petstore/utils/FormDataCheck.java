package com.lonton.petstore.utils;

import java.util.regex.Pattern;

public class FormDataCheck {
    
    /**
     * 邮箱
     */
    private String email   = "^([\\w-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|" +
            "(([\\w-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
    //手机
    private String phone   = "^[1]+[3,5]+\\d{9}$";
    //电话
    private String tel     = "^(\\d{3,4}-)?\\d{6,8}$";
    //邮编
    private String yzbm    = "^\\d{6}$";
    //身份证
    private String sfz     = "(^\\d{18}$)|(^\\d{15}$)";
    //url
    private String url     = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";
    //ip
    private String ip      = "^((\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5]|[*])\\.){3}(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5]|[*])$";
    //物理地址
    private String mac     = "^[A-F0-9]{2}(-[A-F0-9]{2}){5}$";
    //两位小数
    private String decimal = "^[0-9]+(.[0-9]{2})?$";
    //数字
    private String num     = "^[0-9]*$";
    //正整数
    private String n       = "^\\+?[1-9][0-9]*$";
    
    /**
     * 校验表单
     */
    public String verify(String value, String preText, String rule) throws Exception {
        String[] rs = rule.split(",");
        String errorInfo = null;
        for (String s : rs) {
            if (s.indexOf("|") < 0 && s.indexOf("_") < 0) {
                //包含“|”是指或者的关系，比如输入框可以输入邮箱或者手机号，包含“_”,比如min_6指最小6位
                switch (s) {
                    //需要特殊说明文字的在此添加case
                    case "required":
                        if (value != null && value.trim().length() > 0) {
                        
                        } else {
                            errorInfo = preText + "不能为空";
                        }
                        break;
                    //通用说明走else
                    default:
                        errorInfo = verifyByRegular(value, preText, s);
                        break;
                }
                if (errorInfo != null) {
                    //如果已有错误信息，则不需要再次循环
                    break;
                }
            } else {
                if (s.indexOf("|") >= 0) {
                    //包含"或者关系",一般"|"和"_"不会共存，在此不做考虑
                    if (s.indexOf("_") >= 0) {
                        throw new Exception(preText + "规则配置错误");
                    }
                    String[] s1 = s.split("|");
                    for (String s2 : s1) {
                        errorInfo = verifyByRegular(preText, value, s2);
                        if (errorInfo == null) {
                            break;
                        }
                    }
                } else if (s.indexOf("_") >= 0) {
                    String[] s1 = s.split("_");
                    if (s1[0].equals("min")) {
                        errorInfo = minLen(preText, value, Integer.parseInt(s1[1]));
                    } else if (s1[0].equals("max")) {
                        errorInfo = maxLen(preText, value, Integer.parseInt(s1[1]));
                    } else {
                        throw new Exception("暂不支持这种校验格式：" + s1[0]);
                    }
                }
                if (errorInfo != null) {
                    //如果已有错误信息，则不需要再次循环
                    break;
                }
                
            }
        }
        return errorInfo;
    }
    
    /**
     * 根据正则表达式判断是否成立
     *
     * @param preText 必传，字段名称
     * @param value   必传，字段值
     * @param r       必传，校验类型
     * @return
     */
    private String verifyByRegular(String value, String preText, String r) throws Exception {
        String errorInfo = null;
        String regex = "";
        switch (r) {
            case "email":
                regex = email;
                break;
            case "phone":
                regex = phone;
                break;
            case "tel":
                regex = tel;
                break;
            case "yzbm":
                regex = yzbm;
                break;
            case "sfz":
                regex = sfz;
                break;
            case "n":
                regex = n;
                break;
            case "url":
                regex = url;
                break;
            case "ip":
                regex = ip;
                break;
            case "mac":
                regex = mac;
                break;
            case "decimal":
                regex = decimal;
                break;
            case "num":
                regex = num;
            default:
                break;
        }
        if (regex.equals("")) {
            throw new Exception("暂不支持这种校验格式：" + r);
        } else {
            boolean flg = Pattern.matches(regex, value);
            if (flg) {
            } else {
                errorInfo = preText + "格式不正确，请重新检查！";
            }
        }
        return errorInfo;
    }
    
    
    /**
     * 校验最少长度
     *
     * @param preText
     * @param value
     * @param min
     * @return
     */
    private String minLen(String preText, String value, int min) {
        String errorInfo = null;
        if (value != null && value.trim().length() >= min) {
        
        } else {
            errorInfo = preText + "最少长度为" + min + "位。";
        }
        return errorInfo;
    }
    
    
    private String maxLen(String preText, String value, int max) {
        String errorInfo = null;
        if (value != null && value.trim().length() <= max) {
        
        } else {
            errorInfo = preText + "最大长度为" + max + "位。";
        }
        return errorInfo;
    }
    
    
}

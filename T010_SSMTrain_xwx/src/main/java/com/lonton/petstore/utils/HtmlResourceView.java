package com.lonton.petstore.utils;

import org.springframework.web.servlet.view.InternalResourceView;

import java.io.File;
import java.util.Locale;

/**
 * 配置返回页面 .jsp
 * 如果返回页面是 .html ，就需要使用此类
 *
 * @author xuwanxing
 */
public class HtmlResourceView extends InternalResourceView {
    @Override
    public boolean checkResource(Locale locale) {
        File file = new File(this.getServletContext().getRealPath("/") + getUrl());
        return file.exists(); //判断页面是否存在
    }
}
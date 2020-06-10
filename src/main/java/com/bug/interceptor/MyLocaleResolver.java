package com.bug.interceptor;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/*
 *   Author = Liewona
 *   Date = 2020/6/7
 */
public class MyLocaleResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String l = request.getParameter("l");
        Locale locale = Locale.getDefault();
        if(! StringUtils.isEmpty(l)) {
            String[] s = l.split("_");
            locale = new Locale(s[0], s[1]);
        }
        System.out.println("resolveLocale");
        System.out.println(l);
        System.out.println(locale);
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}

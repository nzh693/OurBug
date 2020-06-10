package com.bug.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 *   Author = Liewona
 *   Date = 2020/6/9 14:48
 */
public class UserInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Object signer = request.getSession().getAttribute("signer");
        System.out.println("signer------------------111111");
        if(signer == null) {
            System.out.println("signer------------------1111ssssss11");
            response.sendRedirect("/login");
            return false;
        }
        System.out.println("signer------------------2222222222");
        return true;
    }
}

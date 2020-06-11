package com.bug.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bug.entity.Admin;
import com.bug.entity.Users;
import com.bug.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Liewona
 * @since 2020-06-09
 */
@Controller
@RequestMapping("/sign")
public class AdminController {

    @Autowired
    private IAdminService as;


    @PostMapping("/sign")
    public String sign(String username, String password, HttpServletResponse response, HttpServletRequest request) {
        System.out.println(username);
        System.out.println(password);
        System.out.println("AdminController ------------------sign");
        QueryWrapper<Admin> qw = new QueryWrapper<>();
        Map<String, String> conditions = new HashMap<>();
        conditions.put("account", username);
        conditions.put("password", password);
        qw.allEq(conditions);
        Admin u = as.getOne(qw);
        System.out.println(u);
        if(u != null) {
            request.getSession().setAttribute("signer", u);
            response.addCookie(new Cookie("username", username));
            response.addCookie(new Cookie("nickname", u.getName()));
            return "redirect:/";
        } else {
            return "forward:/users/sign";
        }
    }
}


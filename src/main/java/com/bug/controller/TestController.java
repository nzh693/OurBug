package com.bug.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 *   Author = Liewona
 *   Date = 2020/6/8 20:11
 */
@Controller
@RequestMapping("/api/v1")
public class TestController {

    @GetMapping("/test")
    @ResponseBody
    public String test() {
//        new MyTest().test();
        return "sususus";
    }
}

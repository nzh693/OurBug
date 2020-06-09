package com.bug.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 *   Author = Liewona
 *   Date = 2020/6/8 20:11
 */
@Api(value = "test", tags = "test", hidden = true)
@Controller
@RequestMapping("/api/v1")
public class TestController {

    @GetMapping("/test")
    @ResponseBody
    @ApiOperation(value = "hhh", notes = "111111111")
    public String test() {
//        new MyTest().test();
        return "sususus";
    }

    @GetMapping("/test2")
    @ResponseBody
    @ApiOperation(value = "hhh", notes = "22222222222222")
    public String test2() {
//        new MyTest().test();
        return "sususus";
    }
}

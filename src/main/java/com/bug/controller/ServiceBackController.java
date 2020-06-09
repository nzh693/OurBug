package com.bug.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Liewona
 * @since 2020-06-09
 */
@Controller
@RequestMapping("/api/v1/serviceBack")
public class ServiceBackController {

    @GetMapping("")
    public void getDisposeService() {

    }
}


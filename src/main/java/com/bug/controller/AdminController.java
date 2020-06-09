package com.bug.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Liewona
 * @since 2020-06-08
 */
@Api(tags = "admin")
@Controller
@RequestMapping("/api/v1")
public class AdminController {

    @ApiOperation(value = "yyy", notes = "22323")
    @PostMapping("/ccc")
    public void tet() {

    }
}


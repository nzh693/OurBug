package com.bug.controller;


import com.bug.entity.Users;
import com.bug.service.IUsersService;
import com.bug.vo.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Liewona
 * @since 2020-06-09
 */
@RestController
@RequestMapping("/users")
@CrossOrigin
@Api(tags = "Users业务接口")
public class UsersController {
    @Autowired
    private IUsersService usersService;

    /**
     * 获取所有的客户经理 - 即limited为1的user
     */
    @ApiOperation(value = "获取所有客户经理",notes = "获取所有客户经理 - limited为1")
    @GetMapping("/getAllUserLimited1")
    public ResponseResult<List<Users>> getAllUserLimited1(){
        List<Users> users = usersService.getAllUserLimited1();
        ResponseResult<List<Users>> responseResult = new ResponseResult<>(users);
        return responseResult;
    }
}


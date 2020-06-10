package com.bug.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bug.entity.SignUser;
import com.bug.entity.Users;
import com.bug.service.IUsersService;
import com.bug.vo.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
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
    @ResponseBody
    public ResponseResult<List<Users>> getAllUserLimited1(){
        List<Users> users = usersService.getAllUserLimited1();
        ResponseResult<List<Users>> responseResult = new ResponseResult<>(users);
        return responseResult;
    }

    @PostMapping("/sign")
    public String sign(String username, String password, HttpServletResponse response, HttpServletRequest request) {

        System.out.println("UserController----------sign");
        QueryWrapper<Users> qw = new QueryWrapper<>();
        Map<String, String> conditions = new HashMap<>();
        conditions.put("account", username);
        conditions.put("password", password);
        qw.allEq(conditions);
        Users u = usersService.getOne(qw);
        if(u != null) {
            request.getSession().setAttribute("signer", u);
            response.addCookie(new Cookie("username", username));
            response.addCookie(new Cookie("nickname", u.getNickname()));
            return "index";
        } else {
            return "login";
        }
    }
}


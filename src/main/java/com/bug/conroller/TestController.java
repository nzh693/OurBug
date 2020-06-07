package com.bug.conroller;

import com.bug.service.IUserService;
import com.bug.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private IUserService userService;

    @RequestMapping("test")
    public String test(){
        userService.getAllStudents();
        return "hello bug";
    }
}

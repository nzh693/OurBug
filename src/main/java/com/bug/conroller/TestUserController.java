package com.bug.conroller;

import com.bug.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestUserController {

    @Autowired
    private UserServiceImp serviceImp;


    @RequestMapping(path = "/getAllStudents")
    public String getAllStudents(Integer id){
        serviceImp.getAllStudents(123456);
        return "get studentS";
    }

    @RequestMapping(path = "/delStudentByName")
    public String delStudentByName(String name){
        serviceImp.delStudentByName("nzh");
        int a=10,b=0;
        int c=a/b;
        return "delete One";
    }




}

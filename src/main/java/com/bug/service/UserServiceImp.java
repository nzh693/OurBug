package com.bug.service;


import org.springframework.stereotype.Service;


@Service
public class UserServiceImp {


    public String getAllStudents(Integer id){
        System.out.println("获取所有的学生对象");
        return "get studentS";
    }

    public String delStudentByName(String name){
        System.out.println("按姓名删除学生信息");
        int a=10,b=0;
        int c=a/b;
        return "delete One";
    }
}

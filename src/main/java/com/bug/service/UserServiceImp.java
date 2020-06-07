package com.bug.service;


import org.springframework.stereotype.Service;


@Service
public class UserServiceImp implements IUserService {




    @Override
    public String getAllStudents() {
        System.out.println("test");
        return "test";
    }
}

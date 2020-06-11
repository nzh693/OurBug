package com.bug.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bug.entity.ContactRecord;
import com.bug.entity.Customer;
import com.bug.entity.Linkman;
import com.bug.service.ICustomerService;
import com.bug.service.ILinkmanService;
import com.bug.utils.ResultByList;
import javafx.scene.input.DataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import springfox.documentation.spring.web.json.Json;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
@CrossOrigin
@RequestMapping("api/v1")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;
    /**
     * 客户状态正常：可编辑
     *
     * @param customer 客户
     * @return  返回编辑结果：成功或失败
     */
    @RequestMapping(path = "/customer", method = RequestMethod.PUT)
    public String editCustomer(Customer customer){
        ResultByList result=new ResultByList();
        List<String> list=new ArrayList<>();
        String str="编辑失败";
        boolean re=customerService.updateById(customer);
        if (re){
            str="编辑成功";
        }
        list.add(str);
        result.setCode(0);
        result.setCount(1L);
        result.setData(list);
        return JSON.toJSONString(result);
    }



    @RequestMapping(path = "/customers",method = RequestMethod.GET)
    public ResultByList getAllCustomers(){
        ResultByList result=new ResultByList();
        List<Customer> list=customerService.list();
        result.setCode(0);
        result.setMsg("返回所有的用户");
        result.setCount((long) list.size());
        result.setData(list);
        return result;
    }



}


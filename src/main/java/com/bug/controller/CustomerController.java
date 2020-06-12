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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import springfox.documentation.spring.web.json.Json;

import javax.xml.transform.Source;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
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
    @RequestMapping(path = "/editCustomer")
    public String editCustomer(Customer customer){
        ResultByList result=new ResultByList();
        List<String> list=new ArrayList<>();
        String str="编辑失败";
        System.out.println("customer"+customer);
        boolean re=customerService.saveOrUpdate(customer);
        if (re){
            str="编辑成功";
        }
        list.add(str);
        result.setCode(0);
        result.setCount(1L);
        result.setData(list);
        return JSON.toJSONString(result);
    }



    @RequestMapping(path = "/customers")
    public ResultByList getAllCustomers(){
        ResultByList result=new ResultByList();
        List<Customer> list=customerService.list();
        result.setCode(0);
        result.setMsg("返回所有的用户");
        result.setCount((long) list.size());
        result.setData(list);
        return result;
    }

    /**
     * 批量删除获取客户的历时订单
     * @param str
     * @return
     */
    @RequestMapping(path = "delManyCustomers")
    @Transactional
    public ResultByList delManyCustomers(@RequestParam(value = "strs") String[] str){
        ResultByList result = new ResultByList();
        List<String> list = Arrays.asList(str);
        boolean re = customerService.removeByIds(list);
        if (re){
            result.setCode(0);
            result.setMsg("删除成功");
            result.setCount(0L);
        }else {
            result.setCode(1);
            result.setMsg("删除失败");
            result.setCount(0L);
        }
        return result;
    }



}


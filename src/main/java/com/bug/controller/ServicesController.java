package com.bug.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bug.entity.Services;
import com.bug.service.IServicesService;
import com.bug.utils.ResultByInteger;
import com.bug.utils.ResultByList;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Date;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Liewona
 * @since 2020-06-09
 */
@Controller
@RequestMapping("/api/v1")
@CrossOrigin
public class ServicesController {

    @Autowired
    private IServicesService services;

    @PostMapping("service")
    public @ResponseBody
    ResultByInteger insertServices(@RequestBody Services s) {
        ResultByInteger code = new ResultByInteger();

//        s.setCreateTime(new Date());
        boolean isOk = services.save(s);
        if(isOk) {
            code.setCode(0);
        } else {
            code.setCode(-1);
        }
        return code;
    }

    @GetMapping("services")
    public @ResponseBody
    ResultByList getServices(
            @ApiParam(value = "要查询的页码",required = true)
            @RequestParam(defaultValue = "1") Integer page, //page请求的页码,默认为1
            @ApiParam(value = "每页的行数",required = true)
            @RequestParam(defaultValue = "10") Integer pageLimit//limit每页的行数，默认为10
    ) {
        ResultByList rst = new ResultByList();
//        Services s = new Services();
//        s.setType(1);
//        s.setTime(LocalDateTime.now());
//        s.setUserid(123);
//        s.setTime(LocalDateTime.now());
//        services.save(s);

        try {


            QueryWrapper<Services> qw = new QueryWrapper<>();
//            qw.eq("state", s.getState());
            Page<Services> pageCustomer = services.page(new Page<Services>(page,pageLimit), qw);
            rst.setData(pageCustomer.getRecords());
            rst.setCount(pageCustomer.getTotal());
            rst.setMsg("查询成功");
            rst.setCode(0);
        } catch (Exception e) {
            rst.setMsg("查询失败：" + e.toString());
            rst.setCode(-1);
        }
        return rst;
    }

    @GetMapping("service")
    public @ResponseBody ResultByList getServiceByField(
            @ApiParam(value = "要查询的页码",required = true)
            @RequestParam(defaultValue = "1")
                    Integer page, //page请求的页码,默认为1
            @ApiParam(value = "每页的行数",required = true)
            @RequestParam(defaultValue = "10")
                    Integer pageLimit,//limit每页的行数，默认为10
            Services s) {


        ResultByList rst = new ResultByList();

        try {
            if(s.getId() != null) {
                Services byId = services.getById(s);
                rst.setData(Collections.singletonList(byId));
                rst.setCount(0L);
            } else if(s.getState() != null) {
                QueryWrapper<Services> qw = new QueryWrapper<>();
                qw.eq("state", s.getState());
                Page<Services> pageCustomer = services.page(new Page<Services>(page,pageLimit), qw);
                rst.setData(pageCustomer.getRecords());
                rst.setCount(pageCustomer.getTotal());
            }
            rst.setMsg("查询成功");
            rst.setCode(0);
        } catch (Exception e) {
            rst.setMsg("查询失败：" + e.toString());
            rst.setCode(-1);
        }

        return rst;
    }

    @PutMapping("service")
    @ResponseBody
    public ResultByInteger updateServices(@RequestBody Services s) {
        ResultByInteger code = new ResultByInteger();
        boolean isOk;
        if(s.getDealUserid() != null && s.getAllocationTime() == null) {
            s.setAllocationTime(LocalDateTime.now());
            s.setState(1);
        }
        System.out.println("-----------");
        System.out.println(s);
        System.out.println("-----------");

        isOk = services.updateById(s);
        if(isOk) {
            code.setCode(0);
        } else {
            code.setCode(-1);
        }
        return code;
    }



    @ModelAttribute
    public void setUser(HttpServletRequest request, HttpServletResponse response, Model model) {
        Object o = request.getSession().getAttribute("signer");
        model.addAttribute("user", o);
//        System.out.println(request.getCookies());
        System.out.println(request.getRequestURL());

        System.out.println(request.getParameter("id"));
        System.out.println(request.getParameter("createTime"));
        System.out.println(request.getParameterMap());

    }

}


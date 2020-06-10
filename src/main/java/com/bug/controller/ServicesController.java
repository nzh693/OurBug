package com.bug.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bug.entity.Services;
import com.bug.service.IServicesService;
import com.bug.utils.ResultByInteger;
import com.bug.utils.ResultByList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Liewona
 * @since 2020-06-09
 */
@Api(tags = "服务记录管理")
@Controller
@RequestMapping("/api/v1")
@CrossOrigin
public class ServicesController {

    @Autowired
    private IServicesService services;


    /**
     * 查询服务
     * @param page 页码
     * @param pageLimit 每页大小
     * @return 返回查询列表
     */
    @ApiOperation(value = "查询所有的服务,分页")
    @GetMapping("services")
    public @ResponseBody ResultByList getServices(
            @ApiParam(value = "要查询的页码",required = true)
            @RequestParam(defaultValue = "1") Integer page, //page请求的页码,默认为1
            @ApiParam(value = "每页的行数",required = true)
            @RequestParam(defaultValue = "10") Integer pageLimit//limit每页的行数，默认为10
    ) {
        ResultByList rst = new ResultByList();
        try {
            QueryWrapper<Services> qw = new QueryWrapper<>();
            Page<Services> pageCustomer = services.page(new Page<Services>(page,pageLimit), qw);
            rst.setData(pageCustomer.getRecords());
            rst.setCount(pageCustomer.getTotal());
            rst.setMsg("查询成功");
            rst.setCode(0);
        } catch (Exception e) {
            rst.setMsg("查询失败：" + e.toString());
            rst.setCode(1);
        }
        return rst;
    }


    /**
     * 查询所有的服务记录
     */
    @ApiOperation("获取所有的服务记录，用于统计报表")
    @GetMapping("as")
    public void getAll() {
        ResultByList rst = new ResultByList();
        List<Services> list = services.list();
        rst.setData(list);
        rst.setCount((long) list.size());
        rst.setMsg("查询成功");
        rst.setCode(0);
    }

    /**
     * 根据条件查询的的服务记录（状态或id），返回一个列表
     * @param page 页码
     * @param pageLimit 每页行数
     * @param s 将传入的参数自动注入到s中
     * @return
     */
    @ApiOperation(value = "根据条件查询的的服务记录（状态或id），返回一个列表")
    @GetMapping("service")
    public @ResponseBody ResultByList getServiceByField(
            @ApiParam(value = "要查询的页码")
            @RequestParam(defaultValue = "1")
                    Integer page, //page请求的页码,默认为1
            @ApiParam(value = "每页的行数")
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
            rst.setCode(1);
        }

        return rst;
    }

    /**
     * 新建服务记录，
     * @param s 将请求参数自动注入到s中
     * @return
     */
    @ApiOperation("插入服务记录")
    @PostMapping("service")
    public @ResponseBody
    ResultByInteger insertServices(@RequestBody Services s) {
        ResultByInteger code = new ResultByInteger();

//        s.setCreateTime(new Date());
        boolean isOk = services.save(s);
        if(isOk) {
            code.setCode(0);
        } else {
            code.setCode(1);
        }
        return code;
    }
    @ApiOperation("更新服务记录")
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
            code.setCode(1);
        }
        return code;
    }


    /**
     * 在调用controller方法之前检查用户，并设置用户
     * @param request HttpServletRequest
     * @param model 数据Model
     */
    @ModelAttribute
    public void setUser(HttpServletRequest request, Model model) {
        Object o = request.getSession().getAttribute("signer");
        model.addAttribute("user", o);
//        System.out.println(request.getCookies());
        System.out.println(request.getRequestURL());

        System.out.println(request.getParameter("id"));
        System.out.println(request.getParameter("createTime"));
        System.out.println(request.getParameterMap());

    }

}


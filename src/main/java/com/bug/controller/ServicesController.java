package com.bug.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bug.entity.Services;
import com.bug.entity.Users;
import com.bug.service.IServicesService;
import com.bug.utils.ResultByInteger;
import com.bug.utils.ResultByList;
import com.bug.vo.ServiceTableResult;
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
 * 前端控制器
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
     * 查询所有的服务记录
     */
    @ApiOperation("获取所有的服务记录，用于统计报表")
    @GetMapping("/services")
    public @ResponseBody
    ResultByList getAll() {
        ResultByList rst = new ResultByList();
        List<Services> list = services.list();
        rst.setData(list);
        rst.setCount((long) list.size());
        rst.setMsg("查询成功");
        rst.setCode(0);
        return rst;
    }

    /**
     * 根据条件查询的的服务记录（状态或id），返回一个列表
     *
     * @param page      页码
     * @param limit 每页行数
     * @param s         将传入的参数自动注入到s中
     * @return
     */
    @ApiOperation(value = "根据条件查询的的服务记录（状态或id），返回一个列表")
    @GetMapping("/service")
    public @ResponseBody
    ResultByList getServiceByField(
            @ApiParam(value = "要查询的页码")
            @RequestParam(defaultValue = "1")
                    Integer page, //page请求的页码,默认为1
            @ApiParam(value = "每页的行数")
            @RequestParam(defaultValue = "10")
                    Integer limit,//limit每页的行数，默认为10
            Services s) {

        System.out.println("-------------------");

        System.out.println(s);

        ResultByList rst = new ResultByList();
        ServiceTableResult str = new ServiceTableResult();

        try {

            if (s != null && s.getId() != null) {
                Services byId = services.getById(s);
                rst.setData(Collections.singletonList(byId));
                rst.setCount(0L);
                System.out.println("----------111---------");
            } else if (s != null && s.getState() != null) {
                QueryWrapper<Services> qw = new QueryWrapper<>();
                qw.eq("state", s.getState());
                Page<Services> pageCustomer = services.page(new Page<Services>(page, limit), qw);
                rst.setData(pageCustomer.getRecords());
                rst.setCount(pageCustomer.getTotal());
                System.out.println("---------222----------");
            } else {

                List<ServiceTableResult> allContent = services.getAllContent((page - 1) * limit, page * limit);
                System.out.println(allContent.size());
                System.out.println("---------3333----------");
                rst.setData(allContent);
                rst.setCount((long) services.getTotal());
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
     *
     * @param s 将请求参数自动注入到s中
     * @return
     */
    @ApiOperation("插入服务记录")
    @PostMapping("/service")
    public @ResponseBody
    ResultByInteger insertServices(@RequestBody Services s, Model model) {
        ResultByInteger code = new ResultByInteger();
        Users u;
        Object signer = model.getAttribute("signer");
        if(signer instanceof Users) {
            u = (Users) signer;
            s.setUserid(u.getId());
        } else if (s.getUserid() == null) {
            s.setUserid(123);
        }
        s.setCreateTime(LocalDateTime.now());
//        s.setCreateTime(new Date());
        boolean isOk = services.save(s);
        if (isOk) {
            code.setCode(0);
        } else {
            code.setCode(1);
        }
        return code;
    }


    @ApiOperation("更新服务记录")
    @PutMapping("/service")
    @ResponseBody
    public ResultByInteger updateServices(@RequestBody Services s) {
        System.out.println("---223--------");
        System.out.println(s);
        ResultByInteger code = new ResultByInteger();
        try {
            boolean isOk;
            Services byId = services.getById(s.getId());
            assert byId != null;
            if (byId.getState() == 0 && s.getDealUserid() != null && s.getAllocationTime() == null) {
                s.setAllocationTime(LocalDateTime.now());
                s.setState(1);
            }
            System.out.println("-----------");
            System.out.println(s);
            System.out.println("-----------");
            isOk = services.updateById(s);
            if (isOk) {
                code.setCode(0);
            } else {
                code.setCode(1);
            }
        } catch (Exception e) {

            code.setCode(1);
        }
        return code;
    }


    /**
     * 在调用controller方法之前检查用户，并设置用户
     *
     * @param request HttpServletRequest
     * @param model   数据Model
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


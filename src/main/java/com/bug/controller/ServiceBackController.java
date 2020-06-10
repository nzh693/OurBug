package com.bug.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bug.entity.ServiceBack;
import com.bug.entity.Services;
import com.bug.service.IServiceBackService;
import com.bug.service.IServicesService;
import com.bug.service.impl.ServicesServiceImpl;
import com.bug.utils.ResultByInteger;
import com.bug.utils.ResultByList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Random;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Liewona
 * @since 2020-06-09
 */

@Api(tags = "服务反馈管理")
@Controller
@CrossOrigin
@RequestMapping("/api/v1")
public class ServiceBackController {

    @Autowired
    private IServiceBackService sback;

    @Autowired
    private IServicesService ss;

    /**
     * 查询所有的服务记录
     */
    @ApiOperation("获取所有的服务记录，用于统计报表")
    @GetMapping("/asb")
    @ResponseBody
    public ResultByList getAll() {
        ResultByList rst = new ResultByList();
        List<ServiceBack> list = sback.list();
        rst.setData(list);
        rst.setCount((long) list.size());
        rst.setMsg("查询成功");
        rst.setCode(0);
        return rst;
    }


    /**
     * 查询服务反馈
     * @param page 页码
     * @param pageLimit 每页大小
     * @return 返回查询列表
     */
    @ApiOperation(value = "查询所有的服务反馈记录。可以分页")
    @GetMapping("serviceback")
    public @ResponseBody ResultByList getServices(
            @ApiParam(value = "要查询的页码",required = true)
            @RequestParam(defaultValue = "1") Integer page, //page请求的页码,默认为1
            @ApiParam(value = "每页的行数",required = true)
            @RequestParam(defaultValue = "10") Integer pageLimit//limit每页的行数，默认为10
    ) {
        ResultByList rst = new ResultByList();
        try {
            QueryWrapper<ServiceBack> qw = new QueryWrapper<>();
            Page<ServiceBack> pageCustomer = sback.page(new Page<>(page,pageLimit), qw);
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


    @ApiOperation(value = "服务反馈记录更新，并更新服务记录状态")
    @Transactional
    @PutMapping("serviceback")
    public @ResponseBody ResultByInteger insertServiceBack(@RequestBody ServiceBack sb) {
        Services byId = ss.getById(sb.getServiceid());
        if(sb.getSatisfaction() < 3) {
            byId.setState(1);
        } else {
            byId.setState(3);
            sback.save(sb);
        }
        sb.setState(1);
        ss.updateById(byId);
        ResultByInteger rst = new ResultByInteger();
        rst.setCode(0);

        return rst;
    }


    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public String setData() {
        ServiceBack sb = new ServiceBack();
        sb.setComment("爱上了xionggggggg");
        sb.setServiceid(2);
        Random rd = new Random();
        for(int i = 0; i < 10; i++) {
            sb.setState(rd.nextInt() % 2);
            sb.setSatisfaction(rd.nextInt() % 5 + 1);
            sback.save(sb);
            System.out.println(i);
        }
        return "success";
    }

    public void searchByCondition() {

    }

}


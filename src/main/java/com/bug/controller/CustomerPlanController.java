package com.bug.controller;


import com.bug.entity.CustomerPlan;
import com.bug.service.ICustomerPlanService;
import com.bug.service.ICustomerService;
import com.bug.vo.ChanceAndPlanVo;
import com.bug.vo.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
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
@RequestMapping("/customerPlan")
@CrossOrigin
@Api(tags = "销售机会业务接口")
public class CustomerPlanController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ICustomerPlanService customerPlanService;

    /**
     * 获取当前登录用户被指派的计划
     */
    @ApiOperation(value = "获取当前登录用户被指派的计划",notes = "获取当前登录用户被指派的计划")
    @GetMapping("/getCustomerPlans")
    public ResponseResult<List<CustomerPlan>> getCustomerPlans(@RequestParam(value = "page",defaultValue = "1") Integer page, @RequestParam(value = "limit",defaultValue = "10") Integer limit,@RequestParam(value = "customerName",required=false) String customerName ,HttpServletRequest request){
        // 获取当前登录的账号
//        String account = (String) request.getSession().getAttribute("account");
        String account = "123456";
        // 只需要获取当前的账号
        ResponseResult<List<CustomerPlan>> responseResult = customerPlanService.getChanceAndPlanVo(page,limit,account,customerName);
        return responseResult;
    }

    @ApiOperation(value = "制定计划",notes = "制定开发计划")
    @ApiImplicitParam(name = "customerPlan",value = "开发计划")
    @PostMapping("/makePlan")
    public ResponseResult<List<CustomerPlan>> makePlan(@RequestBody CustomerPlan customerPlan,HttpServletRequest request){
        customerPlan.setUserid(1);
        customerPlanService.makePlan(customerPlan);
        return new ResponseResult<>(0,"制定计划成功！",null);
    }

    @ApiOperation(value = "获取计划详情",notes = "获取计划详情通过机会id")
    @ApiImplicitParam(name = "chanceid",value = "机会id")
    @GetMapping("/getPlanByChanceId")
    public ResponseResult<CustomerPlan> getPlanByChanceId(@RequestParam("chanceid") Integer chanceid){
        CustomerPlan customerPlan = customerPlanService.getPlanByChanceId(chanceid);
        ResponseResult<CustomerPlan> responseResult = new ResponseResult<>(0,"成功",0,customerPlan);
        return responseResult;
    }

    @ApiOperation(value = "开发结果",notes = "开发结果")
    @ApiImplicitParam(name = "customerPlan",value = "开发计划")
    @PutMapping("/developmentResult")
    public ResponseResult<String> developmentResult(@RequestBody CustomerPlan customerPlan){
        customerPlanService.developmentResult(customerPlan);
        ResponseResult<String> responseResult = new ResponseResult<>(0,"成功！",null);
        return responseResult;
    }


}


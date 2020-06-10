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
    @ApiOperation(value = "获取当前登录用户被指派的计划",notes = "新增一个销售机会")
    @GetMapping("/getCustomerPlans")
    public ResponseResult<List<ChanceAndPlanVo>> getCustomerPlans(HttpServletRequest request){
        // 获取当前登录的账号
//        String account = (String) request.getSession().getAttribute("account");
        String account = "123456";
        // 只需要获取当前的账号
        ResponseResult<List<ChanceAndPlanVo>> responseResult = customerPlanService.getChanceAndPlanVo(account);
        return responseResult;
    }

    @ApiOperation(value = "制定计划",notes = "制定开发计划")
    @ApiImplicitParam(name = "customerPlan",value = "开发计划")
    @PutMapping("/makePlan")
    public void makePlan(@RequestBody CustomerPlan customerPlan){
        customerPlanService.makePlan(customerPlan);
    }

}


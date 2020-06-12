package com.bug.service;

import com.bug.entity.CustomerPlan;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bug.vo.ChanceAndPlanVo;
import com.bug.vo.ResponseResult;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Liewona
 * @since 2020-06-09
 */
public interface ICustomerPlanService extends IService<CustomerPlan> {

    void makePlan(CustomerPlan customerPlan);

    ResponseResult<List<CustomerPlan>> getChanceAndPlanVo(Integer page, Integer limit, String account,String customerName);

    Integer getCountByUserId(Integer id);

    ResponseResult<List<CustomerPlan>> getCustomerPlan(Integer page, Integer limit, Integer id,String customer);

    CustomerPlan getPlanByChanceId(Integer chanceid);

    void developmentResult(CustomerPlan customerPlan);
}

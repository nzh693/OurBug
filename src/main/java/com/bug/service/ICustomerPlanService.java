package com.bug.service;

import com.bug.entity.CustomerPlan;
import com.baomidou.mybatisplus.extension.service.IService;
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

    ResponseResult<List<CustomerPlan>> getCustomerPlans(String account);
}

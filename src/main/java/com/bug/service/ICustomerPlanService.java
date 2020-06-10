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

    /**
     * 根据账户获取ChanceAndPlanVo
     * @param account 账号
     */
    ResponseResult<List<ChanceAndPlanVo>> getChanceAndPlanVo(String account);

    void makePlan(CustomerPlan customerPlan);
}

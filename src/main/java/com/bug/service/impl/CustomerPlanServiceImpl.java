package com.bug.service.impl;

import com.bug.entity.CustomerPlan;
import com.bug.entity.Users;
import com.bug.mapper.CustomerPlanMapper;
import com.bug.service.ICustomerPlanService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bug.service.IUsersService;
import com.bug.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Liewona
 * @since 2020-06-09
 */
@Service
public class CustomerPlanServiceImpl extends ServiceImpl<CustomerPlanMapper, CustomerPlan> implements ICustomerPlanService {

    @Autowired
    private IUsersService usersService;

    @Override
    public ResponseResult<List<CustomerPlan>> getCustomerPlans(String account) {
        // 获取当前登录的用户
        Users user = usersService.getUserByAccount(account,1);
        if(user != null){

        }

        return null;
    }
}

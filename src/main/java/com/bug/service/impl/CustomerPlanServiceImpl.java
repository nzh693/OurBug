package com.bug.service.impl;

import com.bug.entity.CustomerPlan;
import com.bug.entity.SaleChance;
import com.bug.entity.Users;
import com.bug.mapper.CustomerPlanMapper;
import com.bug.service.ICustomerPlanService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bug.service.ISaleChanceService;
import com.bug.service.IUsersService;
import com.bug.vo.ChanceAndPlanVo;
import com.bug.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    @Autowired
    private ISaleChanceService saleChanceService;

    @Override
    public ResponseResult<List<ChanceAndPlanVo>> getChanceAndPlanVo(String account) {
        // 查询这个客户经理是否存在
        Users user = usersService.getUserByAccount(account, 1);
        if(user != null){
            // 客户经理id
            Integer id = user.getId();
            // 根据客户经理id获取 - 指派给他的机会
            List<ChanceAndPlanVo> chanceAndPlanVos = saleChanceService.getSaleChanceAndPlanVosByUserId(id);
            System.out.println("asdasdasd");
        }
        return null;
    }
}

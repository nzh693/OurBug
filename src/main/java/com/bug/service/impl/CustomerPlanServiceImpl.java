package com.bug.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
@Transactional
public class CustomerPlanServiceImpl extends ServiceImpl<CustomerPlanMapper, CustomerPlan> implements ICustomerPlanService {

    @Autowired
    private IUsersService usersService;
    @Autowired
    private ISaleChanceService saleChanceService;
    @Autowired
    private ICustomerPlanService customerPlanService;

    @Override
    public ResponseResult<List<CustomerPlan>> getChanceAndPlanVo(Integer page, Integer limit,String account) {
        // 查询这个客户经理是否存在
        Users user = usersService.getUserByAccount(account, 1);
        if(user != null){
            // 客户经理id
            Integer id = user.getId();
            // 根据客户经理id获取 - 指派给他的机会
            ResponseResult<List<CustomerPlan>> responseResult = customerPlanService.getCustomerPlan(page,limit,id);
            return responseResult;
        }
        return null;
    }

    @Override
    public Integer getCountByUserId(Integer id) {
        return baseMapper.getCountByUserId(id);
    }

    @Override
    public ResponseResult<List<CustomerPlan>>  getCustomerPlan(Integer page, Integer limit, Integer id) {
        Page<CustomerPlan> customerPlanPage = new Page<>(page,limit);
        QueryWrapper<CustomerPlan> wrapper = new QueryWrapper<>();
        wrapper.eq("userid",id);
        Page<CustomerPlan> customerPlanPage1 = baseMapper.selectPage(customerPlanPage, wrapper);
        List<CustomerPlan> records = customerPlanPage1.getRecords();
        int total = (int) customerPlanPage1.getTotal();
        ResponseResult<List<CustomerPlan>> responseResult = new ResponseResult<>(0,"成功",total,records);
        return responseResult;
    }

    @Override
    public CustomerPlan getPlanByChanceId(Integer chanceid) {
        QueryWrapper<CustomerPlan> wrapper = new QueryWrapper<>();
        wrapper.eq("chanceid",chanceid);
        CustomerPlan customerPlan = baseMapper.selectOne(wrapper);
        return customerPlan;
    }

    @Override
    public void developmentResult(CustomerPlan customerPlan) {
        makePlan(customerPlan);
        SaleChance saleChance = saleChanceService.getById(customerPlan.getChanceid());
        saleChance.setState(customerPlan.getState());
        saleChanceService.updateById(saleChance);
    }

    @Override
    public void makePlan(CustomerPlan customerPlan) {
        if(customerPlan.getChanceid() != null && customerPlan.getUserid() != null){
            customerPlan.setMakeState(1);
            QueryWrapper<CustomerPlan> wrapper = new QueryWrapper<>();
            wrapper.eq("chanceid",customerPlan.getChanceid());
            wrapper.eq("userid",customerPlan.getUserid());
            baseMapper.update(customerPlan,wrapper);
        }
    }
}

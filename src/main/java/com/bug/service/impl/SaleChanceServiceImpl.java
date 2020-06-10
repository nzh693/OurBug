package com.bug.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bug.entity.Customer;
import com.bug.entity.CustomerPlan;
import com.bug.entity.SaleChance;
import com.bug.entity.Users;
import com.bug.mapper.SaleChanceMapper;
import com.bug.service.ICustomerPlanService;
import com.bug.service.ICustomerService;
import com.bug.service.ISaleChanceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bug.service.IUsersService;
import com.bug.vo.ChanceAndPlanVo;
import com.bug.vo.ChanceAndUserVo;
import com.bug.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;
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
@Transactional
public class SaleChanceServiceImpl extends ServiceImpl<SaleChanceMapper, SaleChance> implements ISaleChanceService {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IUsersService usersService;
    @Autowired
    private ICustomerPlanService customerPlanService;
    @Autowired
    private SaleChanceMapper saleChanceMapper;

    @Override
    public void saveSaleChance(SaleChance saleChance) {
        // 保存Customer
        Customer customer = new Customer(saleChance.getCustomerName(),saleChance.getSex(),saleChance.getAddr(),saleChance.getTelephone(),saleChance.getLevel(),saleChance.getState());
        customerService.save(customer);
        System.out.println(customer.getId());
        saleChance.setCustomerId(customer.getId());
        baseMapper.insert(saleChance);
    }

    @Override
    public ResponseResult<List<SaleChance>> getSaleChanceByPage(Integer page, Integer limit, String customerName, Integer state) {
        Page<SaleChance> pageSaleChance = new Page<>(page,limit);
        QueryWrapper<SaleChance> wrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(customerName)){
            wrapper.like("customer_name",customerName);
        }
        if(state != null && state != 0){
            wrapper.eq("state",state);
        }
        Page<SaleChance> saleChancePage = baseMapper.selectPage(pageSaleChance, wrapper);
        List<SaleChance> saleChances = saleChancePage.getRecords();
        ResponseResult<List<SaleChance>> responseResult = new ResponseResult<>(0,"查询成功",saleChances.size(),saleChances);
        return responseResult;
    }


    @Override
    public ResponseResult<ChanceAndUserVo> getSaleChanceAndUser(Integer id) {
        SaleChance saleChance = baseMapper.selectById(id);
        QueryWrapper<Users> wrapper = new QueryWrapper<>();
        wrapper.eq("limited",1);  // 只要客户经理
        List<Users> users = usersService.list(wrapper);
        ChanceAndUserVo chanceAndUserVo = new ChanceAndUserVo(saleChance,users);
        ResponseResult<ChanceAndUserVo> responseResult = new ResponseResult<>(chanceAndUserVo);
        return responseResult;
    }

    @Override
    public void deleteSaleChance(Integer id) {
        SaleChance saleChance = baseMapper.selectById(id);
        if(saleChance != null && saleChance.getState() == 1){
            // 不存在则删除
            baseMapper.deleteById(id);
        }
    }

    @Override
    public SaleChance assignedChance(Integer saleChanceId, Integer userId, String username) {
        SaleChance saleChance = baseMapper.selectById(saleChanceId);
        saleChance.setState(2); // 已分配
        saleChance.setUserid(userId);
        saleChance.setUsername(username);
        saleChance.setAssginTime(new Date());
        baseMapper.updateById(saleChance);
        // 创建开发计划
        CustomerPlan customerPlan = new CustomerPlan();
        customerPlan.setChanceid(saleChanceId);  // 销售机会id
        customerPlan.setUserId(userId);  // 客户经理id
        customerPlan.setState(0);   // 未制定计划
        customerPlan.setProgress(0);  // 进度为0
        customerPlanService.save(customerPlan);
        return saleChance;
    }

    @Override
    public List<SaleChance> getSaleChanceByUserId(Integer id) {
        QueryWrapper<SaleChance> wrapper = new QueryWrapper<>();
        wrapper.eq("userid",id);
        List<SaleChance> saleChances = baseMapper.selectList(wrapper);
        return saleChances;
    }

    @Override
    public List<ChanceAndPlanVo> getSaleChanceAndPlanVosByUserId(Integer id) {
        List<ChanceAndPlanVo> chanceAndPlanVos = saleChanceMapper.getSaleChanceAndPlanVosByUserId(id);
        return chanceAndPlanVos;
    }


}

package com.bug.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bug.entity.Customer;
import com.bug.entity.SaleChance;
import com.bug.entity.Users;
import com.bug.mapper.SaleChanceMapper;
import com.bug.service.ICustomerService;
import com.bug.service.ISaleChanceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bug.service.IUsersService;
import com.bug.vo.ChanceAndUserVo;
import com.bug.vo.ResponseResult;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

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
        wrapper.eq("limit",1);  // 只要客户经理
        List<Users> users = usersService.list(wrapper);
        ChanceAndUserVo chanceAndUserVo = new ChanceAndUserVo(saleChance,users);
        ResponseResult<ChanceAndUserVo> responseResult = new ResponseResult<>(chanceAndUserVo);
        return responseResult;
    }
}

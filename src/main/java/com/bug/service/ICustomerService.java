package com.bug.service;

import com.bug.entity.Customer;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bug.entity.Linkman;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Liewona
 * @since 2020-06-09
 */
public interface ICustomerService extends IService<Customer> {

    /**
     * 按照客户id查询客户
     * @param customer
     * @return 客户
     */
    public Customer getCustomerById(Customer customer);





}

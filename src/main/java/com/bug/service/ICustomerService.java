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
     * 修改客户的状态字段为0；表示已经流失
     * @param cid
     * @return
     */
    public boolean updateState(int cid);





}

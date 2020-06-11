package com.bug.service.impl;

import com.bug.entity.Customer;
import com.bug.entity.Linkman;
import com.bug.mapper.CustomerMapper;
import com.bug.mapper.LinkmanMapper;
import com.bug.service.ICustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.CoderMalfunctionError;
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
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements ICustomerService {

    @Override
    public boolean updateState(int cid) {
        return  getBaseMapper().updatetReasonByID(cid);
    }
}

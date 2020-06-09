package com.bug.service.impl;

import com.bug.entity.Services;
import com.bug.mapper.ServiceMapper;
import com.bug.service.IServicesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Liewona
 * @since 2020-06-08
 */
@Service
public class ServicesServiceImpl extends ServiceImpl<ServiceMapper, Services> implements IServicesService {

}

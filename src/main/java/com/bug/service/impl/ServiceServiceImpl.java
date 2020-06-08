package com.bug.service.impl;

import com.bug.entity.Service;
import com.bug.mapper.ServiceMapper;
import com.bug.service.IServiceService;
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
public class ServiceServiceImpl extends ServiceImpl<ServiceMapper, Service> implements IServiceService {

}

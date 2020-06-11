package com.bug.service;

import com.bug.entity.Services;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bug.vo.ServiceTableResult;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Liewona
 * @since 2020-06-09
 */
public interface IServicesService extends IService<Services> {

    List<ServiceTableResult> getAllContent();
}

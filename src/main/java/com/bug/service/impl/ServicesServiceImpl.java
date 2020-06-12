package com.bug.service.impl;

import com.bug.entity.Services;
import com.bug.mapper.ServicesMapper;
import com.bug.service.IServicesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bug.vo.ServiceTableResult;
import org.springframework.stereotype.Service;

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
public class ServicesServiceImpl extends ServiceImpl<ServicesMapper, Services> implements IServicesService {

    @Override
    public List<ServiceTableResult> getAllContent(Integer start,  Integer end) {
        System.out.println("---------getAllContent()");
        System.out.println(start);
        System.out.println(end);
        List l = getBaseMapper().getAllContent(start, end);
        System.out.println(l);
        return getBaseMapper().getAllContent(start, end);
    }

    @Override
    public Integer getTotal() {
        return getBaseMapper().getTotal();
    }


}

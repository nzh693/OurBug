package com.bug.mapper;

import com.bug.entity.Services;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bug.vo.ServiceTableResult;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Liewona
 * @since 2020-06-09
 */
public interface ServicesMapper extends BaseMapper<Services> {

    List<ServiceTableResult> getAllContent(Integer start, Integer end);


    Integer getTotal();

}

package com.bug.mapper;

import com.bug.entity.Services;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bug.vo.ServiceTableResult;
import org.apache.ibatis.annotations.Param;

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

    List<ServiceTableResult> getAllContent(@Param("start") Integer start, @Param("end") Integer end);


    Integer getTotal();

}

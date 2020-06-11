package com.bug.mapper;

import com.bug.entity.CustomerPlan;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Liewona
 * @since 2020-06-09
 */
public interface CustomerPlanMapper extends BaseMapper<CustomerPlan> {

    Integer getCountByUserId(@Param("id") Integer id);
}

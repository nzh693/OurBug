package com.bug.mapper;

import com.bug.entity.SaleChance;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bug.vo.ChanceAndPlanVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Liewona
 * @since 2020-06-09
 */
public interface SaleChanceMapper extends BaseMapper<SaleChance> {

    List<ChanceAndPlanVo> getSaleChanceAndPlanVosByUserId(Integer id);
}

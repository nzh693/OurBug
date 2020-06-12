package com.bug.mapper;

import com.bug.entity.SaleChance;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bug.vo.ChanceAndPlanVo;
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
public interface SaleChanceMapper extends BaseMapper<SaleChance> {

    List<ChanceAndPlanVo> getSaleChanceAndPlanVosByUserId(@Param("page") Integer page, @Param("limit") Integer limit, @Param("id") Integer id);

//    List<ChanceAndPlanVo> getSaleChanceAndPlanVosByUserId(Integer page, Integer limit, Integer id);
}

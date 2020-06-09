package com.bug.service;

import com.bug.entity.SaleChance;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bug.vo.ChanceAndUserVo;
import com.bug.vo.ResponseResult;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Liewona
 * @since 2020-06-09
 */
public interface ISaleChanceService extends IService<SaleChance> {

    void saveSaleChance(SaleChance saleChance);

    /**
     * 分页查询销售机会
     * @param page 当前页
     * @param limit 每页多少条数据
     * @param customerName 客户姓名
     * @param state 状态 0-全部 1-未分配 2-已分配 3-开发成功 4-开发失败
     * @return 数据集合
     */
    ResponseResult<List<SaleChance>> getSaleChanceByPage(Integer page, Integer limit, String customerName, Integer state);

    /**
     * 获取销售机会和所有客户经理
     * @param id 销售机会id
     */
    ResponseResult<ChanceAndUserVo> getSaleChanceAndUser(Integer id);
}

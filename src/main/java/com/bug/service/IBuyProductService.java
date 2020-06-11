package com.bug.service;

import com.bug.entity.BuyProduct;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bug.entity.WarnLost;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Liewona
 * @since 2020-06-09
 */
public interface IBuyProductService extends IService<BuyProduct> {

    /**
     * 在历史订单表查询6个月没有消费的订单，筛选生成流程预警
     * @return 流失预警
     */
    public List<WarnLost> createWarnLost();

    /**
     * 生成比较的时间字符串
     * @param size
     * @return
     */
    public String Maketime(int size);

    /**
     * 按页面要求返回预警记录
     * @param page 页码
     * @param size 页大小
     * @param warnLosts 所有数据
     * @return
     */
    public List<WarnLost> getPageWarLost(int page,int size,List<WarnLost> warnLosts);

}

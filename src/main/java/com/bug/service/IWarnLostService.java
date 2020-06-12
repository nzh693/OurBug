package com.bug.service;

import com.bug.entity.WarnLost;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Liewona
 * @since 2020-06-11
 */
public interface IWarnLostService extends IService<WarnLost> {

    /**
     * 那页面获取预警信息
     * @param page
     * @param size
     * @return
     */
    public List<WarnLost> getWarnByPage(int page,int size);

    /**
     * 为预警记录添加新的措施
     * @param wid    预警记录id
     * @param newStr 新措施
     * @return
     */
    public Boolean UpdateMeasure(int wid,String newStr);

    /**
     * 确认客户流失，在客户表修改客户的状态，记录表修改状态
     * @param wid
     * @return
     */
    public Boolean confirmLost(int wid);

    /**
     * 确认客户流失，在客户表修改客户的状态，记录表修改状态
     * @param wid
     * @return
     */
    public Boolean setResaon(int wid,String reason);
}

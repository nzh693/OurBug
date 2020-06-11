package com.bug.service.impl;

import com.bug.entity.WarnLost;
import com.bug.mapper.WarnLostMapper;
import com.bug.service.ICustomerService;
import com.bug.service.IWarnLostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bug.utils.ResultByList;
import jdk.nashorn.internal.runtime.RewriteException;
import org.junit.runner.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Liewona
 * @since 2020-06-11
 */
@Service
public class WarnLostServiceImpl extends ServiceImpl<WarnLostMapper, WarnLost> implements IWarnLostService {


    @Autowired
    private ICustomerService customerService;

    /**
     *
     * @param page
     * @param size
     * @return
     */
    @Override
    public List<WarnLost> getWarnByPage(int page, int size) {
        List<WarnLost> warnLosts=list();
        int total=warnLosts.size();
        int sIndex,eIndex;
        if (page*size>total){//请求页数超出范围
            int tindex=--page*size;
            if (tindex<total){//未超出尾页数据
                sIndex=tindex;
                return warnLosts.subList(sIndex,total-1);
            }
            return null;//超出尾页
        }else {
            sIndex=(page-1)*size;
            eIndex=sIndex+size;
            warnLosts=warnLosts.subList(sIndex,eIndex);
        }
        return warnLosts;
    }

    /**
     *
     * @param wid    预警记录id
     * @param newStr 新措施
     * @return
     */
    @Transactional
    @Override
    public Boolean UpdateMeasure(int wid, String newStr) {
        String oldStr = getBaseMapper().selectMeasureByID(wid);
        newStr=oldStr+newStr;
        return getBaseMapper().updatetMeasureByID(wid, newStr);
    }

    @Override
    @Transactional
    public Boolean confirmLost(int wid, String reason) {
        getBaseMapper().updatetReasonByID(wid,reason);
        int cid=getBaseMapper().selectCustomerIdByWarnId(wid);
        return customerService.updateState(cid);
    }
}

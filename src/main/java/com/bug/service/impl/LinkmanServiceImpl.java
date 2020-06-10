package com.bug.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bug.entity.Linkman;
import com.bug.mapper.LinkmanMapper;
import com.bug.service.ILinkmanService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import sun.awt.SunHints;

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
public class LinkmanServiceImpl extends ServiceImpl<LinkmanMapper, Linkman> implements ILinkmanService {

    Logger logger= LoggerFactory.getLogger(LinkmanServiceImpl.class);

    @Override
    public List<Linkman> getLinkmanByPage(int cid, int page, int size) {
        List<Linkman> linkman = getBaseMapper().queryLinkmans(cid);
        int total=linkman.size();
        int sIndex,eIndex;
        if (page*size>total){//请求页数超出范围
            int tindex=--page*size;
            logger.info("临时下标"+String.valueOf(tindex));
            if (tindex<total){//未超出尾页数据
                sIndex=tindex;
                return linkman.subList(sIndex,total-1);
            }
            return null;//超出尾页
        }else {
            sIndex=(page-1)*size;
            eIndex=sIndex+size;
            linkman=linkman.subList(sIndex,eIndex);
        }

        return linkman;
    }
}

package com.bug.service;

import com.bug.entity.Linkman;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Liewona
 * @since 2020-06-09
 */
public interface ILinkmanService extends IService<Linkman> {


    public List<Linkman> getLinkmanByPage(int cid,int page,int size);



}

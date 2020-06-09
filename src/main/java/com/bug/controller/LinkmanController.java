package com.bug.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bug.entity.Linkman;
import com.bug.service.ILinkmanService;
import com.bug.utils.ResultByList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Liewona
 * @since 2020-06-09
 */
@Controller
@RequestMapping("api/v1/linkman")
public class LinkmanController {

    @Autowired
    private ILinkmanService linkmanService;

    /**
     * 返回一个客户的所有联系人
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(path = "getLinkMans")
    public String getAllLinkmans(Integer cid, Integer page
            , Integer limit){
        ResultByList result=new ResultByList();

        List<Linkman> linkmanByPage = linkmanService.getLinkmanByPage(cid, page, limit);
        if(linkmanByPage!=null){
            result.setCode(0);
            result.setData(linkmanByPage);//填充分页数据
            result.setCount(Long.valueOf(linkmanByPage.size()));
        }else {
            List<String> data=new ArrayList<String>();
            data.add("没有数据了");
            result.setCode(1);
            result.setData(data);//填充分页数据
            result.setCount(0L);//test
        }
        return JSON.toJSONString(result);
    }





}


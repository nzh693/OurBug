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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.print.DocFlavor;
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
    @RequestMapping(path = "getLinkMans",method = RequestMethod.GET)
    public String getAllLinkmans(Integer cid,@RequestParam(value ="page" ,defaultValue = "1") Integer page
            ,@RequestParam(value = "limit",defaultValue = "8") Integer limit){
        ResultByList result=new ResultByList();
        List<Linkman> linkmanByPage = linkmanService.getLinkmanByPage(cid, page, limit);
        if(linkmanByPage!=null){//数据范围内，最后一页未处理
            result.setCode(0);
            result.setData(linkmanByPage);//填充分页数据
            result.setCount(Long.valueOf(linkmanByPage.size()));
        }else {//请求页码超出范围
            result.setCode(1);
            result.setMsg("没有数据了");//填充分页数据
            result.setCount(0L);
        }
        return JSON.toJSONString(result);
    }

    @ResponseBody
    @RequestMapping(path = "linkmans",method = RequestMethod.GET)
    public ResultByList getAllLinkmans(@RequestParam(value ="page" ,defaultValue = "1") Integer page
            ,@RequestParam(value = "limit",defaultValue = "10") Integer limit){
        ResultByList result=new ResultByList();
        QueryWrapper<Linkman> qw = new QueryWrapper();
        Page<Linkman> pageCustomer = linkmanService.page(new Page<Linkman>(page,limit), qw);
//        List<Linkman> linkmanByPage = linkmanService.list();
        result.setCode(0);
        result.setData(pageCustomer.getRecords());//填充分页数据
        result.setCount(pageCustomer.getTotal());
        return result;
    }



    /**
     * 提交修改联系人的表单
     * @param linkman
     * @return
     */
    @ResponseBody
    @RequestMapping(path = "editLinkMan",method = RequestMethod.POST)
    public String editcustomer(Linkman linkman){
        ResultByList result=new ResultByList();
        boolean re = linkmanService.saveOrUpdate(linkman);
        if (re){
            result.setCode(0);
            result.setMsg("修改成功");
            result.setCount(0L);
        }else {
            result.setCode(1);
            result.setMsg("修改失败");
            result.setCount(0L);
        }
        return JSON.toJSONString(result);
    }

    /**
     * 删除客户的一个联系人
     * @param lid
     * @return
     */
    @ResponseBody
    @RequestMapping(path = "deleteLinkeman",method = RequestMethod.DELETE)
    public String deleteLinkeman(@RequestParam(value = "lid") int lid){

        ResultByList result=new ResultByList();
        boolean re = linkmanService.removeById(Long.valueOf(lid));
        if (re){
            result.setCode(0);
            result.setMsg("删除成功");
            result.setCount(1L);
        }else {
            result.setCode(1);
            result.setMsg("删除失败");
            result.setCount(0L);
        }
        return JSON.toJSONString(result);
    }

    /**
     * 为客户添加一个联系人
     * @param linkman
     * @return
     */
    @ResponseBody
    @RequestMapping(path = "addLinkeman",method = RequestMethod.POST)
    public String addLinkeman( Linkman linkman){
        ResultByList result=new ResultByList();

        Linkman linkman1=new Linkman();
        linkman1.setName("wbl");
        linkman1.setComment("a ");
        boolean re = linkmanService.saveOrUpdate(linkman1);
        if (re){
            result.setCode(0);
            result.setMsg("添加成功");
            result.setCount(0L);
        }else {
            result.setCode(1);
            result.setMsg("添加失败");
            result.setCount(0L);
        }
        return JSON.toJSONString(result);
    }











}


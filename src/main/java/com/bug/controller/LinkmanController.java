package com.bug.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bug.entity.Linkman;
import com.bug.service.ILinkmanService;
import com.bug.utils.ResultByList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
@CrossOrigin
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
    @RequestMapping(path = "getLinkmans")
    public ResultByList getLinkmans(@RequestParam(value ="cid" ,defaultValue = "0")Integer cid,@RequestParam(value ="page" ,defaultValue = "1") Integer page
            ,@RequestParam(value = "limit",defaultValue = "8") Integer limit){
        ResultByList result=new ResultByList();
        List<Linkman> linkmanByPage;
        if (cid==0){
             linkmanByPage= linkmanService.list();
        }else {
             linkmanByPage= linkmanService.getLinkmanByPage(cid, page, limit);
        }
        if(linkmanByPage!=null){
            result.setCode(0);
            result.setData(linkmanByPage);//填充分页数据
            result.setCount(Long.valueOf(linkmanByPage.size()));
        }else {//请求页码超出范围
            result.setCode(1);
            result.setMsg("没有数据了");//填充分页数据
            result.setCount(0L);
        }
        return result;
    }

    @ResponseBody
    @RequestMapping(path = "getAllLinkmansByPage")
    public ResultByList getAllLinkmansByPage(@RequestParam(value ="page" ,defaultValue = "1") Integer page
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
     * 删除客户的一个联系人
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(path = "deleteLinkeman")
    public ResultByList deleteLinkeman(@RequestParam(value = "id") int id){
        ResultByList result=new ResultByList();
        System.out.println(id);
        boolean re = linkmanService.removeById(Long.valueOf(id));
        if (re){
            result.setCode(0);
            result.setMsg("删除成功");
            result.setCount(1L);
        }else {
            result.setCode(1);
            result.setMsg("删除失败");
            result.setCount(0L);
        }
        return result;
    }

    /**
     * 为客户添加一个联系人
     * @param linkman
     * @return
     */
    @ResponseBody
    @RequestMapping(path = "addLinkeman")
    public String addLinkeman( Linkman linkman){
        ResultByList result=new ResultByList();
        boolean re = linkmanService.save(linkman);
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


    /**
     * 为客户添加一个联系人
     * @param linkman
     * @return
     */
    @ResponseBody
    @RequestMapping(path = "editLinkMan")
    public String editLinkMan( Linkman linkman){
        ResultByList result=new ResultByList();
        System.out.println("修改联系人"+linkman);
        boolean re = linkmanService.updateById(linkman);
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


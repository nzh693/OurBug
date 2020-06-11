package com.bug.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bug.entity.BuyProduct;
import com.bug.entity.ContactRecord;
import com.bug.service.IBuyProductService;
import com.bug.utils.ResultByList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Liewona
 * @since 2020-06-09
 */
@RestController
@RequestMapping("api/v1/buyProduct")
public class BuyProductController {


    @Autowired
    private IBuyProductService buyProductService;

    /**
     * 获取客户的所有的历时订单
     * @param cid
     * @return
     */
    @RequestMapping(path = "getAllHistoryOrders",method = RequestMethod.GET)
    public ResultByList getAllHistoryOrders(@RequestParam(value = "cid") int cid){
        ResultByList result = new ResultByList();
        QueryWrapper<BuyProduct> qw=new QueryWrapper<>();
        qw.eq("customerid",cid);
        List<BuyProduct> list = buyProductService.list(qw);
        if (list==null||list.size()==0){
            result.setCode(0);
            result.setMsg("获取用户所有历时订单成功");
            result.setData(list);
            result.setCount(Long.valueOf(list.size()));
        }else {
            result.setCode(1);
            result.setMsg("获取用户所有历时订单失败");
            result.setCount(0L);
        }
        return result;
    }


    /**
     * 删除获取客户的历时订单
     * @param bid
     * @return
     */
    @RequestMapping(path = "delHistoryOrders",method = RequestMethod.DELETE)
    public ResultByList delHistoryOrders(@RequestParam(value = "bid") int bid){
        ResultByList result = new ResultByList();
        boolean re = buyProductService.removeById(Long.valueOf(bid + ""));
        if (re){
            result.setCode(0);
            result.setMsg("删除成功");
            result.setCount(0L);
        }else {
            result.setCode(1);
            result.setMsg("删除失败");
            result.setCount(0L);
        }
        return result;
    }


    /**
     * 系统被动触发：扫描6个月没有下单的客户，并筛选出没有
     * @return
     */
    @RequestMapping(path = "startScanRecord")
    public ResultByList startScanRecord(){
        ResultByList result = new ResultByList();
        QueryWrapper<ContactRecord> qw=new QueryWrapper<>();
        return result;
    }

    /**
     * 每个天凌晨3点系统自动触发： 从历史订单中扫描6个月没有下单的客户，并筛选出生成流失预警
     * @return
     */
    @Scheduled(cron = "0/5 * * * * *")
    @RequestMapping(path = "autoStartScanRecord")
    public ResultByList autoStartScanRecord(){
        ResultByList result = new ResultByList();
        QueryWrapper<ContactRecord> qw=new QueryWrapper<>();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println("test "+df.format(new Date()));// new Date()为获取当前系统时间

        return result;
    }






}


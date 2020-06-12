package com.bug.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bug.entity.BuyProduct;
import com.bug.entity.ContactRecord;
import com.bug.entity.WarnLost;
import com.bug.service.IBuyProductService;
import com.bug.utils.ResultByList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
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
@CrossOrigin
@RequestMapping("api/v1/buyProduct")
public class BuyProductController {


    @Autowired
    private IBuyProductService buyProductService;

    /**
     * 获取客户的所有的历时订单
     * @param cid
     * @return
     */
    @RequestMapping(path = "getAllHistoryOrders")
    public ResultByList getAllHistoryOrders(@RequestParam(value = "cid",defaultValue = "1") int cid){
        ResultByList result = new ResultByList();
        QueryWrapper<BuyProduct> qw=new QueryWrapper<>();
        qw.eq("customerid",cid);
        List<BuyProduct> list=null;
        if (cid==1){
            list= buyProductService.list();
        }else {
            list= buyProductService.list(qw);
        }
        if (list==null||list.size()==0){
            result.setCode(1);
            result.setMsg("获取用户所有历时订单失败");
            result.setCount(0L);
        }else {
            result.setCode(0);
            result.setMsg("获取用户所有历时订单成功");
            result.setData(list);
            result.setCount(Long.valueOf(list.size()));
        }
        return result;
    }


    /**
     * 删除获取客户的历时订单
     * @param bid
     * @return
     */
    @RequestMapping(path = "delHistoryOrders")
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
     * 批量删除获取客户的历时订单
     * @param str
     * @return
     */
    @RequestMapping(path = "delManyHistoryOrders")
    @Transactional
    public ResultByList delManyHistoryOrders(@RequestParam(value = "strs") String[] str){
        ResultByList result = new ResultByList();
        List<String> list = Arrays.asList(str);
        boolean re = buyProductService.removeByIds(list);
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
     * 系统被动触发：扫描6个月没有下单的客户，更新记录表，并筛选出首页数据返回
     * @return
     */
    
    @RequestMapping(path = "startScanRecord")
    public ResultByList startScanRecord(@RequestParam(value = "page",defaultValue = "1") int page,
                                        @RequestParam(value = "limit",defaultValue = "10") int limit){
        ResultByList re = new ResultByList();
        List<WarnLost> warnLost = buyProductService.createWarnLost();
        if (warnLost==null){
            re.setCode(1);
            re.setMsg("生成预警信息失败");
            re.setCount(0L);
        }else {
            if (limit<warnLost.size()){//生成记录太少
                warnLost=warnLost.subList(0,limit);
            }
            re.setCode(0);
            re.setMsg("生成预警信息成功");
            re.setCount(Long.valueOf(warnLost.size()));
            re.setData(warnLost);
        }
        return re;
    }

    /**
     * 每月1号凌晨3点系统自动触发： 从历史订单中扫描6个月没有下单的客户，并筛选出生成流失预警
     * @return
     */
    @Scheduled(cron = "0 0 3 1 * *")
    @RequestMapping(path = "autoStartScanRecord")
    public ResultByList autoStartScanRecord(){
        ResultByList result = new ResultByList();
        List<WarnLost> warnLost = buyProductService.createWarnLost();
        if (warnLost==null){
            result.setCode(1);
            result.setMsg("生成预警信息失败");
            result.setCount(0L);
        }else {
            result.setCode(0);
            result.setMsg("生成预警信息成功");
            result.setCount(Long.valueOf(warnLost.size()));
            result.setData(warnLost);
        }
        return result;
    }














}


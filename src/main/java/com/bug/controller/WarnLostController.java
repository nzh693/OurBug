package com.bug.controller;

import com.bug.entity.WarnLost;
import com.bug.service.IWarnLostService;
import com.bug.utils.ResultByList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Liewona
 * @since 2020-06-11
 */
@RestController
@CrossOrigin
@RequestMapping("api/v1/warnLost")
public class WarnLostController {


    @Autowired
    private IWarnLostService warnLostService;

    /**
     * 按页面获取预警信息
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping(path = "getWarnByPage")
    public ResultByList getWarnByPage(@RequestParam(value = "page",defaultValue = "1") int page,
                                        @RequestParam(value = "limit",defaultValue = "10") int limit){
        ResultByList re = new ResultByList();
        List<WarnLost> warnLost =warnLostService.getWarnByPage(page,limit);
        if (warnLost==null){
            re.setCode(1);
            re.setMsg("获取本页预警信息失败");
            re.setCount(0L);
        }else {
            if (limit<warnLost.size()){//生成记录不足一页.
                warnLost=warnLost.subList(0,limit);
            }
            re.setCode(0);
            re.setMsg("获取本页预警信息成功");
            re.setCount(Long.valueOf(warnLost.size()));
            re.setData(warnLost);
        }
        return re;
    }

    /**
     * 新增措施
     * @param wid  预警记录id
     * @param newStr  新的措施
     * @return
     */
    @RequestMapping(path = "updateMeasure")
    public ResultByList updateMeasure(@RequestParam(value = "wid") int wid,
            @RequestParam(value = "newStr",defaultValue = "未填写") String newStr){
        ResultByList result = new ResultByList();
        boolean re= warnLostService.UpdateMeasure(wid,newStr);
        System.out.println("新增措施"+wid+newStr);
        if (re){
            result.setCode(0);
            result.setMsg("添加措施成功");
            result.setCount(0L);
        }else {
            result.setCode(1);
            result.setMsg("添加措施失败");
            result.setCount(0L);
        }
        return result;
    }

    /**
     * 确认流失，修改状态
     * @param wid  预警记录id
     * @return
     */
    @RequestMapping(value = "confirmLost")
    public ResultByList confirmLost(int wid){
        ResultByList result = new ResultByList();
        Boolean re = warnLostService.confirmLost(wid);
        if(re){
            result.setCode(0);
            result.setMsg("确认流失成功");
            result.setCount(0L);
        }else {
            result.setCode(0);
            result.setMsg("确认流失失败");
            result.setCount(0L);
        }
        return result;
    }


    /**
     * 修改流失原因
     * @param id  预警记录id
     * @param reason 流失原因
     * @return
     */
    @RequestMapping(value = "setReason")
    public ResultByList setReason(int id, String reason){
        ResultByList result = new ResultByList();
        Boolean re = warnLostService.setResaon(id, reason);
        if(re){
            result.setCode(0);
            result.setMsg("确认流失成功");
            result.setCount(0L);
        }else {
            result.setCode(0);
            result.setMsg("确认流失失败");
            result.setCount(0L);
        }
        return result;
    }



}


package com.bug.controller;

import com.alibaba.fastjson.JSONObject;
import com.bug.entity.ContactRecord;
import com.bug.entity.Event;
import com.bug.service.IContactRecordService;
import com.bug.service.IEventService;
import com.bug.utils.ResultByList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Liewona
 * @since 2020-06-10
 */
@RestController
@RequestMapping("api/v1/contactRecord")
public class ContactRecordController {

    @Autowired
    private IContactRecordService contactRecordService;
    @Autowired
    private IEventService eventService;

    /**
     *
     * 添加客户记录
     * @param
     * @param str           描述：              属性：                个数
     *                      服务id              sid                   =1
     *                      ContactRecord对象   contactRecord          =1
     *                      event对象           event                 >=0
     * @return
     */
    @Transactional
    @RequestMapping(path = "addRecord")
    public ResultByList  addRecord( @RequestBody String str){
        ResultByList result = new ResultByList();
        JSONObject jsonObject = JSONObject.parseObject(str);
        int sid=Integer.valueOf(jsonObject.getString("sid"));
        ContactRecord contactRecord = JSONObject.parseObject(jsonObject.get("contactRecord").toString(), ContactRecord.class);
        Event event = JSONObject.parseObject(jsonObject.get("event").toString(), Event.class);
        contactRecordService.save(contactRecord);
        eventService.save(event);
        result.setMsg("添加成功");
        result.setCount(0L);
        return result;
    }

    /**
     * 修改客户来往记录
     * 日期格式为年月日 / -
     * @param
     * @return
     */

    @Transactional
    @RequestMapping(path = "editRecord")
    public ResultByList editRecord(@RequestBody String strs){
        ResultByList result=new ResultByList();
        Map<String, Object> map = contactRecordService.convertParamter(strs);
        contactRecordService.updateById((ContactRecord)map.get("contactRecord"));
        eventService.updateById((Event) map.get("event"));
        result.setMsg("编辑成功");
        result.setCode(1);
        result.setCount(0L);
        return result;
    }





}


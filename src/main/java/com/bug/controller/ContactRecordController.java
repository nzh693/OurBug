package com.bug.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bug.entity.ContactRecord;
import com.bug.entity.Event;
import com.bug.service.IContactRecordService;
import com.bug.service.IEventService;
import com.bug.utils.ResultByList;
import com.bug.vo.RecordAndEvent;
import com.sun.tracing.dtrace.Attributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Liewona
 * @since 2020-06-10
 */
@RestController
@CrossOrigin
@RequestMapping("api/v1/contactRecord")
public class ContactRecordController {

    @Autowired
    private IContactRecordService contactRecordService;
    @Autowired
    private IEventService eventService;

    /**
     * 添加客户记录
     *
     * @param
     * @param str 描述：              属性：                个数
     *            服务id              sid                   =1
     *            ContactRecord对象   contactRecord          =1
     *            event对象           event                 >=0
     * @return
     */
    @Transactional
    @RequestMapping(path = "addRecord")
    public ResultByList addRecord(@RequestBody String str) {
        ResultByList result = new ResultByList();
        JSONObject jsonObject = JSONObject.parseObject(str);
        int sid = Integer.valueOf(jsonObject.getString("sid"));
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
     *
     * @param
     * @return
     */

    @Transactional
    @RequestMapping(path = "editRecord")
    public ResultByList editRecord(@RequestParam(value = "id", defaultValue = "0") String id, @RequestParam(value = "customerid", defaultValue = "1") String customerid,
                                   @RequestParam(value = "time", defaultValue = "2020-08-09") String time, @RequestParam(value = "schema", defaultValue = "schema") String schema,
                                   @RequestParam(value = "place", defaultValue = "place") String place, @RequestParam(value = "detail", defaultValue = "detail") String detail,
                                   @RequestParam(value = "comment", defaultValue = "comment") String comment) {
        ResultByList result = new ResultByList();
        String strs = id + id + schema + place + detail + comment + time;
        System.out.println("时间："+time);
        time=time.substring(0,10);
        System.out.println("time："+time);
        Map<String, Object> map = contactRecordService.convertParamter(id,customerid,time,place,detail,comment,schema);
        ContactRecord contactRecord= (ContactRecord) map.get("contactRecord");
        Event event= (Event) map.get("event");
        Integer cid = contactRecord.getId();
        System.out.println("cid"+cid);
        event.setId(cid);
        contactRecordService.updateById(contactRecord);
        eventService.updateById(event);
        result.setMsg("编辑成功");
        result.setCode(1);
        result.setCount(0L);
        return result;
    }


    /**
     * 获取所有记录
     *
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(path = "getAllRecords")
    public ResultByList getAllRecords() {
        ResultByList result = new ResultByList();
        List<ContactRecord> records = contactRecordService.list();
        List<RecordAndEvent> raes=new ArrayList<>();
        List<Event> events=eventService.list();
        QueryWrapper<Object> qw = new QueryWrapper<>();
        int i=0;
        for (Event e:events){
            for(ContactRecord record:records){
                if (e.getRecordId()==record.getId()){
                    RecordAndEvent rae = new RecordAndEvent();
                    rae.setId(record.getId());
                    rae.setCustomerid(record.getCustomerid());
                    rae.setTime(e.getTime().toString());
                    rae.setSchema(e.getSumary());
                    rae.setDetail(e.getDetail());
                    rae.setPlace(e.getPlace());
                    rae.setComment(e.getComment());
                    raes.add(rae);
                }
            }
            i++;
        }
        qw.eq("record_id","");
        eventService.list();
        result.setCode(0);
        result.setMsg("获取所有");
        result.setCount(Long.valueOf(raes.size()));
        result.setData(raes);
        return result;
    }

}


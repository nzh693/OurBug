package com.bug.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.bug.entity.BuyProduct;
import com.bug.entity.ContactRecord;
import com.bug.entity.Event;
import com.bug.mapper.ContactRecordMapper;
import com.bug.service.IContactRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Liewona
 * @since 2020-06-10
 */
@Service
public class ContactRecordServiceImpl extends ServiceImpl<ContactRecordMapper, ContactRecord> implements IContactRecordService {



    @Override
    public Map<String, Object> convertParamter(String id, String customerid, String time, String place, String detail, String comment,String schema) {
        Map<String, Object> map = new HashMap<>();
        ContactRecord contactRecord = new ContactRecord();
        Event event = new Event();
        contactRecord.setComment(comment);
        contactRecord.setCustomerid(Integer.valueOf(customerid));
        contactRecord.setTime(time);
        contactRecord.setId(Integer.valueOf(id));
        event.setComment(comment);
        event.setSumary(schema);
        event.setDetail(detail);
        event.setPlace(place);
        event.setId(Integer.valueOf(id));
        event.setRecordId(Integer.valueOf(id));
        String[] strTimes=time.split("-");//  需要转义的特殊符号【* ^ : | . \】
        event.setTime(LocalDateTime.of(Integer.valueOf(strTimes[0]),Integer.valueOf(strTimes[1]),
                Integer.valueOf(strTimes[2]),0,
                0,0));
        map.put("event",event);
        map.put("contactRecord",contactRecord);
        System.out.println("记录 "+contactRecord);
        System.out.println("实践 "+event);
        return map;
    }
}

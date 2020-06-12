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
    private final static String DATE_FORMAT="yyyy-MM-dd HH:mm:ss";//时间格式
    private Logger logger= LoggerFactory.getLogger(ContactRecordServiceImpl.class);
    private static SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);

    @Override
    public Map<String, Object> convertParamter(String strs) {
        Map<String, Object> map = new HashMap<>();
        JSONObject jo = JSONObject.parseObject(strs);
        ContactRecord contactRecord = new ContactRecord();
        Event event = new Event();
        contactRecord.setComment(jo.getString("comment"));
        contactRecord.setCustomerid(Integer.valueOf(jo.getString("customerid") ));
        contactRecord.setTime(jo.getString("time"));
        contactRecord.setId(Integer.valueOf(jo.getString("id")));
        event.setComment(jo.getString("comment"));
        event.setSumary(jo.getString("schema"));
        event.setDetail(jo.getString("detail"));
        event.setPlace(jo.getString("place"));
        event.setId(Integer.valueOf(jo.getString("id")));
        event.setRecordId(Integer.valueOf(jo.getString("id")));
        String[] strTimes=jo.getString("time").split("-");//  需要转义的特殊符号【* ^ : | . \】
        event.setTime(LocalDateTime.of(Integer.valueOf(strTimes[0]),Integer.valueOf(strTimes[1]),
                Integer.valueOf(strTimes[2]),0,
                0,0));
        map.put("event",event);
        map.put("contactRecord",contactRecord);
        return map;
    }
}

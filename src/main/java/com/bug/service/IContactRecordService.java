package com.bug.service;

import com.bug.entity.ContactRecord;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.print.DocFlavor;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Liewona
 * @since 2020-06-10
 */
public interface IContactRecordService extends IService<ContactRecord> {

    /**
     * 将json字符串封装成ContactRecord对象和Event对象。
     * @param strs
     * @return
     */
    public Map<String,Object> convertParamter(String id, String customerid ,String time,String place,String detail,String comment,String schema);



}

package com.bug.service.impl;

import com.bug.entity.ContactRecord;
import com.bug.mapper.ContactRecordMapper;
import com.bug.service.IContactRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Liewona
 * @since 2020-06-08
 */
@Service
public class ContactRecordServiceImpl extends ServiceImpl<ContactRecordMapper, ContactRecord> implements IContactRecordService {

}

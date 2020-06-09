package com.bug.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

import java.util.Date;

/**
 * @ClassName MyMetaObjectHandler
 * @Description MyBatisPlus字段填充
 * @Author 柳成荫
 * @Date 2020/6/9
 */
public class MyMetaObjectHandler implements MetaObjectHandler{
    @Override
    public void insertFill(MetaObject metaObject) {
        /**
         * 参数一：修改的字段
         * 参数二：修改的值
         * 参数三：源对象
         */
        this.setFieldValByName("createTime",new Date(),metaObject);
//        this.setFieldValByName("updateTime",new Date(),metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
//        this.setFieldValByName("updateTime",new Date(),metaObject);
    }
}

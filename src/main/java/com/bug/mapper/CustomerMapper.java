package com.bug.mapper;

import com.bug.entity.Customer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Liewona
 * @since 2020-06-10
 */
public interface CustomerMapper extends BaseMapper<Customer> {


    @Update("update customer set state=0 where id=#{cid}")
    public boolean updatetReasonByID(@Param("cid") int cid);

}

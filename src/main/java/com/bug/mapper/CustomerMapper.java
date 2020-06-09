package com.bug.mapper;

import com.bug.entity.Customer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Liewona
 * @since 2020-06-09
 */
public interface CustomerMapper extends BaseMapper<Customer> {



    @Update("")
    public void updateCostomer(Customer customer);

    @Insert("")
    public void addCostomer(Customer customer);

    @Select("select * from customer c where  c.id=cid")
    public Customer queryCostomerById(int cid);

    @Delete("")
    public void deleteById(int cid);



}

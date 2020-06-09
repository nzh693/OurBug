package com.bug.mapper;

import com.bug.entity.Linkman;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Liewona
 * @since 2020-06-09
 */
public interface LinkmanMapper extends BaseMapper<Linkman> {


    @Select("select * from linkman l where l.customerid=#{cid} ")
    public List<Linkman> queryLinkmans(@Param("cid") int cid);

}

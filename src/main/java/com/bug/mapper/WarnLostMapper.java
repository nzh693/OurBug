package com.bug.mapper;

import com.bug.entity.WarnLost;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Liewona
 * @since 2020-06-11
 */
public interface WarnLostMapper extends BaseMapper<WarnLost> {



    @Select("select measure from warn_lost where id=#{wid}")
    public String selectMeasureByID(int wid);

    @Update("update warn_lost w set w.measure=#{measure} where w.id=#{wid}")
    public boolean updatetMeasureByID(@Param("wid") int wid, @Param("measure") String measure);

    @Update("update warn_lost w set w.lost_reason=#{reason},w.state=0  where w.id=#{wid}")
    public boolean updatetReasonByID(@Param("wid") int wid, @Param("reason") String reason);


    @Select("select customerid from warn_lost where id=#{wid}")
    public Integer selectCustomerIdByWarnId(int wid);

}

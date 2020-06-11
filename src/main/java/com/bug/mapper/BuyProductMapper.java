package com.bug.mapper;

import com.bug.entity.BuyProduct;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bug.entity.WarnLost;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Liewona
 * @since 2020-06-09
 */
public interface BuyProductMapper extends BaseMapper<BuyProduct> {

   @Select("SELECT customerid from buy_product where time <= #{time} GROUP BY customerid")
   public List<Integer> selectNoBuy(String time);


   @Delete("delete from warn_lost ")
   public void deleteAllWarnInfo();

}

package com.bug.mapper;

import com.bug.entity.BuyProduct;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bug.entity.WarnLost;
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

   @Select("select * from buy_product t where  t.time>=#{time}")
   public List<BuyProduct> selectNoBuy(String time);

}

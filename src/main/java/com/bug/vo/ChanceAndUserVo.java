package com.bug.vo;

import com.bug.entity.SaleChance;
import com.bug.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName ChanceAndUserVo
 * @Description
 * @Author 柳成荫
 * @Date 2020/6/9
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChanceAndUserVo {
    private SaleChance saleChance;
    private List<Users> users;
}

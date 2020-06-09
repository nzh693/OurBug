package com.bug.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bug.entity.SaleChance;
import com.bug.service.ISaleChanceService;
import com.bug.vo.SaleChanceVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * @ClassName SaleChanceController
 * @Description 销售机会Controller
 * @Author 柳成荫
 * @Date 2020/6/9
 */
@RestController
@RequestMapping("/api/v1/saleChance")
@CrossOrigin
@Slf4j
@Api(tags = "销售机会业务接口")
public class SaleChanceController {
    @Autowired
    private ISaleChanceService saleChanceService;

    /**
     * 分页查询销售机会
     * @param page 当前页
     * @param limit 每页多少条数据
     * @return 数据集合
     */
    @GetMapping("/")
    @ApiOperation(value = "查询所有销售机会",notes = "分页查询所有销售机会")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page",value = "当前页",required = true,dataType = "Integer"),
            @ApiImplicitParam(name = "limit",value = "每页多少条数据",required = true,dataType = "Integer")
    })
    public List<SaleChanceVo> getSaleChanceByPage(@RequestParam Integer page, @RequestParam Integer limit){
        log.info("当前页：" + page + ",每页" + limit + "条数据");
//        List<SaleChanceVo> SaleChanceVos = saleChanceService.findSaleChanceByPage(page);

//        Page<SaleChance> pageSaleChance = new Page<>(page,limit);
//        saleChanceService.page(pageSaleChance,null);
//        pageSaleChance.getTotal();  // 总记录数
//        List<SaleChance> saleChances = pageSaleChance.getRecords();// 每页数据集合
//        return saleChances;
          return null;
    }
}


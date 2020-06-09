package com.bug.controller;


import com.bug.entity.SaleChance;
import com.bug.service.ISaleChanceService;
import com.bug.vo.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
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
     * @param customerName 客户姓名
     * @param state 状态 0-全部 1-未分配 2-已分配 3-开发成功 4-开发失败
     * @return 数据集合
     */
    @GetMapping("/")
    @ApiOperation(value = "查询所有销售机会",notes = "分页查询所有销售机会")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page",value = "当前页",dataType = "Integer"),
            @ApiImplicitParam(name = "limit",value = "每页多少条数据",dataType = "Integer"),
            @ApiImplicitParam(name = "customerName",value = "客户姓名",dataType = "String"),
            @ApiImplicitParam(name = "state",value = "状态",dataType = "Integer")
    })
    public ResponseResult<List<SaleChance>> getSaleChanceByPage(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit,
                                                  @RequestParam(value = "customerName",required=false) String customerName,
                                                  @RequestParam(value = "state",required=false) Integer state){
        log.info("当前页：" + page + ",每页" + limit + "条数据");
        ResponseResult<List<SaleChance>> responseResult = saleChanceService.getSaleChanceByPage(page,limit,customerName,state);
        return responseResult;
    }

    @ApiOperation(value = "新增销售机会",notes = "新增一个销售机会")
    @ApiImplicitParam(name = "saleChance",value = "销售机会")
    @PostMapping("/addSaleChance")
    public SaleChance addSaleChance(@RequestBody SaleChance saleChance){
        log.info("新增销售机会！");
        //TODO： 获取登录的用户，这里固定写死
        saleChance.setCreateUserid(1);
        saleChance.setCreateUsername("刘备");
        saleChance.setState(1);   // 默认
        saleChance.setCreateTime(new Date()); // 创建时间
        saleChanceService.saveSaleChance(saleChance);
        return saleChance;
    }

}


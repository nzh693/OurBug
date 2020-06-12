package com.bug.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bug.entity.Customer;
import com.bug.entity.SaleChance;
import com.bug.service.ICustomerService;
import com.bug.service.ISaleChanceService;
import com.bug.vo.ChanceAndUserVo;
import com.bug.vo.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName SaleChanceController
 * @Description 销售机会Controller
 * @Author 柳成荫
 * @Date 2020/6/9
 */
@RestController
@RequestMapping("/saleChance")
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
    public ResponseResult<List<SaleChance>> getSaleChanceByPage(@RequestParam(value = "page",defaultValue = "1") Integer page, @RequestParam(value = "limit",defaultValue = "5") Integer limit,
                                                  @RequestParam(value = "customerName",required=false) String customerName,
                                                  @RequestParam(value = "state",required=false) Integer state){
        log.info("当前页：" + page + ",每页" + limit + "条数据");
        ResponseResult<List<SaleChance>> responseResult = saleChanceService.getSaleChanceByPage(page,limit,customerName,state);
        return responseResult;
    }

    /**
     * 新增销售机会
     * @param saleChance 销售机会
     */
    @ApiOperation(value = "新增销售机会",notes = "新增一个销售机会")
    @ApiImplicitParam(name = "saleChance",value = "销售机会")
    @PostMapping("/addSaleChance")
    public ResponseResult<String> addSaleChance(@RequestBody SaleChance saleChance, HttpServletRequest request){
//        request.getSession().setAttribute("xjs","熊劲松");
//        String xjs = (String) request.getSession().get+Attribute("xjs");
        log.info("新增销售机会！");
        //TODO： 获取登录的用户，这里固定写死
        saleChance.setCreateUserid(1);
        saleChance.setCreateUsername("刘备");
        saleChance.setState(1);   // 默认
        saleChance.setCreateTime(new Date()); // 创建时间
        saleChanceService.saveSaleChance(saleChance);
        ResponseResult<String> responseResult = new ResponseResult<>(0,"新增销售机会成功！",null);
        return responseResult;
    }


    /**
     * 获取销售机会和所有客户经理
     * @param id 销售机会id
     */
    @ApiOperation(value = "获取销售机会信息",notes = "获取销售机会和所有客户经理")
    @ApiImplicitParam(name = "id",value = "销售机会id")
    @GetMapping("/getSaleChanceAndUser")
    public ResponseResult<ChanceAndUserVo> getSaleChanceAndUser(@RequestParam("id") Integer id){
        ResponseResult<ChanceAndUserVo> responseResult = saleChanceService.getSaleChanceAndUser(id);
        return responseResult;
    }

    /**
     * 修改 - 销售机会
     * @param saleChance 销售机会
     */
    @ApiOperation(value = "修改销售机会",notes = "修改销售机会")
    @ApiImplicitParam(name = "saleChance",value = "销售机会")
    @PutMapping("/updateSaleChance")
    public ResponseResult<String> updateSaleChance(@RequestBody SaleChance saleChance){
        System.out.println("熊劲松天下第一");
        ResponseResult<String> responseResult = null;
        if(saleChance.getId() == null){  // id不存在不是修改
            responseResult = new ResponseResult<>(1,"机会不存在，修改失败！",null);
        }else{
            saleChanceService.updateById(saleChance);
            responseResult = new ResponseResult<>(0,"修改成功！",null);
        }
        return responseResult;
    }

    /**
     * 指派销售机会
     * @param saleChanceId
     * @param userId
     * @param username
     * @return
     */
    @ApiOperation(value = "指派销售机会",notes = "指派销售机会")
    @ApiImplicitParam(name = "chanceAndAssignVo",value = "销售机会与指派Vo封装")
    @PostMapping("/assignedChance")
    public ResponseResult<String> assignedChance(@RequestParam("saleChanceId") Integer saleChanceId,@RequestParam("userId") Integer userId,@RequestParam("username") String username){
       SaleChance saleChance = saleChanceService.assignedChance(saleChanceId,userId,username);
       ResponseResult<String> responseResult = null;
       if(saleChance != null){
           responseResult = new ResponseResult<>(0,"指派销售机会成功！",null);
       }else{
           responseResult = new ResponseResult<>(1,"未知错误，指派失败！",null);
       }
       return responseResult;
    }

    /**
     * 删除销售机会
     * @param id 销售机会id
     */
    @ApiOperation(value = "删除销售机会",notes = "删除销售机会")
    @ApiImplicitParam(name = "saleChance",value = "销售机会id")
    @DeleteMapping("/deleteSaleChance")
    public ResponseResult<String> deleteSaleChance(@RequestParam("id") Integer id){
        saleChanceService.deleteSaleChance(id);
        ResponseResult<String> responseResult = new ResponseResult<>(0,"删除机会成功！",null);
        return responseResult;
    }

    @Autowired
    private ICustomerService customerService;


    /**
     * 添加数据专用 - 慎用
     * @param page
     * @param limit
     */
    @ApiOperation(value = "添加数据专用 - 慎用",notes = "添加数据专用 - 慎用")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page",value = "当前页",dataType = "Integer"),
            @ApiImplicitParam(name = "limit",value = "每页多少条数据",dataType = "Integer")
    })
    @PostMapping("/addData")
    public void addData(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit){
        Page<Customer> customerPage = new Page<>(page,limit);
        Page<Customer> page1 = customerService.page(customerPage);
        List<Customer> records = page1.getRecords();
        List<SaleChance> collect = records.stream().map(customer -> {
            SaleChance saleChance = new SaleChance();
            saleChance.setCustomerId(customer.getId());
            saleChance.setCustomerName(customer.getName());
            saleChance.setLevel(customer.getLevel());
            saleChance.setAddr(customer.getAddr());
            saleChance.setSex(customer.getSex());
            saleChance.setTelephone(customer.getTelephone());
            saleChance.setChanceFrom("连锁介绍");
            saleChance.setSuccessRate(78);
            saleChance.setSummary("根据各客户之间的社会关系，通过客户之间的连锁介绍来寻找更多的新客户。");
            saleChance.setDescription("他们可以帮你介绍客户，使你获得更多的准意向客户。此外，也不能否认有些客户确实有二次置业或多次置业的能力。");
            saleChance.setState(1);
            saleChance.setCreateUserid(10);
            saleChance.setCreateUsername("黄月英");
            saleChance.setCreateTime(new Date());
            return saleChance;
        }).collect(Collectors.toList());
        saleChanceService.saveBatch(collect);
    }

}


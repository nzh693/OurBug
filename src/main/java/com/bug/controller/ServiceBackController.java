package com.bug.controller;


import com.bug.entity.ServiceBack;
import com.bug.entity.Services;
import com.bug.service.IServiceBackService;
import com.bug.service.IServicesService;
import com.bug.service.impl.ServicesServiceImpl;
import com.bug.utils.ResultByInteger;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Liewona
 * @since 2020-06-09
 */

@Api(tags = "服务反馈管理")
@Controller
@RequestMapping("/api/v1/")
public class ServiceBackController {

    @Autowired
    private IServiceBackService sback;

    @Autowired
    private IServicesService ss;

    @ApiOperation(value = "服务反馈记录更新，并更新服务记录状态")
    @Transactional
    @PutMapping("serviceback")
    public @ResponseBody ResultByInteger insertServiceBack(@RequestBody ServiceBack sb) {
        Services byId = ss.getById(sb.getServiceid());
        if(sb.getSatisfaction() < 3) {
            byId.setState(1);
        } else {
            byId.setState(3);
            sback.save(sb);
        }
        ss.updateById(byId);
        ResultByInteger rst = new ResultByInteger();
        rst.setCode(0);

        return rst;
    }

    public void searchByCondition() {

    }

}


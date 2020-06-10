package com.bug.service;

import com.bug.entity.Users;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Liewona
 * @since 2020-06-09
 */
public interface IUsersService extends IService<Users> {

    /**
     * 获取所有的客户经理 - 即limited为1的user
     */
    List<Users> getAllUserLimited1();

    /**
     * 根据账号获取User
     * @param account 账号
     * @param limited 职位
0     */
    Users getUserByAccount(String account, int limited);
}
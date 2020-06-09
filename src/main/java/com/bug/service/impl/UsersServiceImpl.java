package com.bug.service.impl;

import com.bug.entity.Users;
import com.bug.mapper.UsersMapper;
import com.bug.service.IUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Liewona
 * @since 2020-06-09
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {

}

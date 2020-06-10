package com.bug.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bug.entity.Users;
import com.bug.mapper.UsersMapper;
import com.bug.service.IUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Users> getAllUserLimited1() {
        QueryWrapper<Users> wrapper = new QueryWrapper<>();
        wrapper.eq("limited",1);
        List<Users> users = baseMapper.selectList(wrapper);
        return users;
    }

    @Override
    public Users getUserByAccount(String account, int limited) {
        QueryWrapper<Users> wrapper = new QueryWrapper<>();
        wrapper.eq("account",account).eq("limited",limited);
        List<Users> users = baseMapper.selectList(wrapper);
        if(users == null || users.size() == 0){
            return null;
        }else {
            return users.get(0);
        }
    }
}

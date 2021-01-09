package com.yueqian.epidemic.service.impl;

import com.yueqian.epidemic.beans.UserInfo;
import com.yueqian.epidemic.mapper.UserMapper;
import com.yueqian.epidemic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional//声明在类上 表示类内所有方法都启用事务管理
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public UserInfo findByAccount(String Account) {
        return userMapper.findByAccount(Account);
    }
}

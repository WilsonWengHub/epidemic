package com.yueqian.epidemic.service;

import com.yueqian.epidemic.beans.UserInfo;

public interface UserService {
    UserInfo findByAccount(String Account);
}

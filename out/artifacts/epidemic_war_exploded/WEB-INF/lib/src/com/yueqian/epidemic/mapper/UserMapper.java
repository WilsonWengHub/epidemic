package com.yueqian.epidemic.mapper;

import com.yueqian.epidemic.beans.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select*from users where account = #{account}")
    UserInfo findByAccount(String Account);
}

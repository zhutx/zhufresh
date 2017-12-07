package com.moredian.zhufresh.mapper;

import com.moredian.zhufresh.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    int insert(User user);

}

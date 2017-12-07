package com.moredian.zhufresh.manager.impl;

import com.moredian.bee.common.exception.BizAssert;
import com.moredian.bee.common.utils.BeanUtils;
import com.moredian.bee.common.utils.ExceptionUtils;
import com.moredian.bee.tube.annotation.SI;
import com.moredian.idgenerator.service.IdgeneratorService;
import com.moredian.zhufresh.domain.User;
import com.moredian.zhufresh.enums.UserStatus;
import com.moredian.zhufresh.enums.ZhufreshErrorCode;
import com.moredian.zhufresh.manager.UserManager;
import com.moredian.zhufresh.mapper.UserMapper;
import com.moredian.zhufresh.request.LoginRequest;
import com.moredian.zhufresh.request.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManagerImpl implements UserManager {

    @Autowired
    private UserMapper userMapper;
    @SI
    private IdgeneratorService idgeneratorService;

    private Long genPrimaryKey(String name) {
        return idgeneratorService.getNextIdByTypeName(name).getData();
    }

    private User requestToDomain(RegisterRequest request) {
        User user = BeanUtils.copyProperties(User.class, request);
        user.setUserId(genPrimaryKey(User.class.getName()));
        user.setUsername(user.getMobile());
        user.setStatus(UserStatus.ENABLE.getValue());
        return user;
    }

    @Override
    public Long register(RegisterRequest request) {
        BizAssert.notNull(request.getMobile(), "mobile is required");
        BizAssert.notNull(request.getPassword(), "passwd is required");

        User user = requestToDomain(request);
        userMapper.insert(user);

        return user.getUserId();
    }

    @Override
    public User login(LoginRequest request) {
        BizAssert.notNull(request.getMobile(), "mobile is required");
        BizAssert.notBlank(request.getPassword(), "password is required");

        User user = userMapper.loadByMobileLogin(request.getMobile(), request.getPassword());
        if (user == null) ExceptionUtils.throwException(ZhufreshErrorCode.ACCOUNT_FAIL, ZhufreshErrorCode.ACCOUNT_FAIL.getMessage());

        if (UserStatus.DISABLE.getValue() == user.getStatus()) ExceptionUtils.throwException(ZhufreshErrorCode.ACCOUNT_DISABLE, ZhufreshErrorCode.ACCOUNT_DISABLE.getMessage());

        return user;
    }

    @Override
    public User getUser(Long userId) {
        BizAssert.notNull(userId);
        return userMapper.load(userId);
    }
}

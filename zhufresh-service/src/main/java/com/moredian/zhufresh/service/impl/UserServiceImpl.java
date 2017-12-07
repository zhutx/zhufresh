package com.moredian.zhufresh.service.impl;

import com.moredian.bee.common.rpc.ServiceResponse;
import com.moredian.bee.common.utils.BeanUtils;
import com.moredian.bee.tube.annotation.SI;
import com.moredian.zhufresh.domain.User;
import com.moredian.zhufresh.manager.UserManager;
import com.moredian.zhufresh.model.UserInfo;
import com.moredian.zhufresh.request.LoginRequest;
import com.moredian.zhufresh.request.RegisterRequest;
import com.moredian.zhufresh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

@SI
public class UserServiceImpl implements UserService {

    @Autowired
    private UserManager userManager;

    @Override
    public ServiceResponse<Long> register(RegisterRequest request) {
        Long result = userManager.register(request);
        return new ServiceResponse<>(true, null, result);
    }

    private UserInfo userToUserInfo(User user) {
        if (user == null) return null;
        return BeanUtils.copyProperties(UserInfo.class, user);
    }

    @Override
    public ServiceResponse<UserInfo> login(LoginRequest request) {
        User user = userManager.login(request);
        return new ServiceResponse<>(true, null, userToUserInfo(user));
    }
}

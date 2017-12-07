package com.moredian.zhufresh.service;

import com.moredian.bee.common.rpc.ServiceResponse;
import com.moredian.zhufresh.model.UserInfo;
import com.moredian.zhufresh.request.LoginRequest;
import com.moredian.zhufresh.request.RegisterRequest;

/**
 * 用户服务
 * @author zhutx
 *
 */
public interface UserService {

    ServiceResponse<Long> register(RegisterRequest request);

    ServiceResponse<UserInfo> login(LoginRequest request);

    UserInfo getUser(Long userId);

}

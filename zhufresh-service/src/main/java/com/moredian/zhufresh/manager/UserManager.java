package com.moredian.zhufresh.manager;

import com.moredian.zhufresh.domain.User;
import com.moredian.zhufresh.request.LoginRequest;
import com.moredian.zhufresh.request.RegisterRequest;

public interface UserManager {

    Long register(RegisterRequest request);

    User login(LoginRequest request);

}

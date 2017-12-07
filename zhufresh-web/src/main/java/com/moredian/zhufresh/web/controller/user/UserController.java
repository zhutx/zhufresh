package com.moredian.zhufresh.web.controller.user;

import com.moredian.bee.common.utils.BeanUtils;
import com.moredian.bee.common.utils.Validator;
import com.moredian.bee.common.web.BaseResponse;
import com.moredian.bee.tube.annotation.SI;
import com.moredian.zhufresh.request.LoginRequest;
import com.moredian.zhufresh.request.RegisterRequest;
import com.moredian.zhufresh.service.UserService;
import com.moredian.zhufresh.web.BaseController;
import com.moredian.zhufresh.web.controller.user.request.LoginModel;
import com.moredian.zhufresh.web.controller.user.request.RegisterModel;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping(value="/user")
public class UserController extends BaseController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @SI
    private UserService userService;

    @RequestMapping(value="/checkCode", method= RequestMethod.GET)
    @ResponseBody
    public BaseResponse list(@RequestParam(value = "mobile") String mobile) {
        if (!Validator.isMobile(mobile)) return new BaseResponse("1", "手机号有误");
        String checkCode = RandomStringUtils.randomNumeric(4);
        stringRedisTemplate.opsForValue().set(mobile, checkCode, 20, TimeUnit.MINUTES);

        BaseResponse<String> br = new BaseResponse<>();
        br.setData(checkCode);
        return br;
    }

    private RegisterRequest buildRequest(RegisterModel model) {
        return BeanUtils.copyProperties(RegisterRequest.class, model);
    }

    @RequestMapping(value="/register", method= RequestMethod.POST)
    @ResponseBody
    public BaseResponse register(@RequestBody RegisterModel model) {
        if (!Validator.isMobile(model.getMobile())) return new BaseResponse("1", "手机号有误");
        if (StringUtils.isBlank(model.getCheckCode())) return new BaseResponse("1", "请输入验证码");
        String checkCode = stringRedisTemplate.opsForValue().get(model.getMobile());
        if (!model.getCheckCode().equals(checkCode)) return new BaseResponse("1", "验证码错误");
        userService.register(buildRequest(model)).pickDataThrowException();
        stringRedisTemplate.expire(model.getMobile(), 1, TimeUnit.MINUTES);

        return new BaseResponse();
    }

    private LoginRequest buildRequest(LoginModel model) {
        return BeanUtils.copyProperties(LoginRequest.class, model);
    }

    @RequestMapping(value="/login", method= RequestMethod.POST)
    @ResponseBody
    public BaseResponse login(@RequestBody LoginModel model) {

        userService.login(buildRequest(model)).pickDataThrowException();

        return new BaseResponse();
    }

}

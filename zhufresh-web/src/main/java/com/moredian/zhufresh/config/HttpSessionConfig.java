package com.moredian.zhufresh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.CookieHttpSessionStrategy;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;

@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 3600 * 24 * 3)
public class HttpSessionConfig {
    /**
     * 以独立的header属性x-auth-token，返回sessionid的值。对接硬件设备可以采用这种方式。
     */
    /*
    @Bean
    public HttpSessionStrategy httpSessionStrategy() {
        return new HeaderHttpSessionStrategy();
    }
    */

    /**
     * 用cookie返回sessionid值。对接网页，可以使用这种方式。
     * @return
     */
    @Bean
    public HttpSessionStrategy httpSessionStrategy() {
        return new CookieHttpSessionStrategy();
    }

}

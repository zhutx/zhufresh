package com.moredian.zhufresh.utils;

import javax.servlet.http.HttpSession;

public class AuthorizeUtil {

    public static final String KEY_UID = "uid";

    private static ThreadLocal<HttpSession> sessionThreadLocal = new ThreadLocal<HttpSession>() {

        @Override
        protected HttpSession initialValue() {
            return null;
        }

    };


    public static void remove() {
        sessionThreadLocal.remove();
    }


    public static void setSession(HttpSession session) {
        sessionThreadLocal.set(session);
    }


    public static HttpSession getSession() {
        return sessionThreadLocal.get();
    }
    
    public static Long getUserId() {
        return Long.parseLong((String)getSession().getAttribute("uid"));
    }
    
}

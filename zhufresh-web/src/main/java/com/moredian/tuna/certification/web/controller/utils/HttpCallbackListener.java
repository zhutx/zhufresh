package com.moredian.tuna.certification.web.controller.utils;

public interface HttpCallbackListener {
	void onFinish(String response);
    void onError(Exception e);
}

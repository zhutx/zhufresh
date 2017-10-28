package com.moredian.tuna.certification.utils;

public interface HttpCallbackListener {
	void onFinish(String response);
    void onError(Exception e);
}

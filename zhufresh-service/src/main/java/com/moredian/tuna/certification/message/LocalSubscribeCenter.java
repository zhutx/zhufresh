package com.moredian.tuna.certification.message;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import com.moredian.bee.common.utils.JsonUtils;
import com.moredian.bee.rmq.annotation.Subscribe;
import com.moredian.fishnet.common.model.msg.AuthRecordMsg;
import com.moredian.tuna.certification.config.CacheManager;
import com.moredian.tuna.certification.utils.AsyncHttpUtil;
import com.moredian.tuna.certification.utils.HttpCallbackListener;

@Component
public class LocalSubscribeCenter {
	
	private static final Logger logger = LoggerFactory.getLogger(LocalSubscribeCenter.class);
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	private static <T> Map<String, Object> beanToMap(T bean) {  
	    Map<String, Object> map = new HashMap<>();  
	    if (bean != null) {  
	        BeanMap beanMap = BeanMap.create(bean);  
	        for (Object key : beanMap.keySet()) {  
	            map.put(key+"", beanMap.get(key));  
	        }             
	    }  
	    return map;  
	}  
	
	private void sendAuthRecord(String url, AuthRecordMsg msg) {
		AsyncHttpUtil.doPost(url, beanToMap(msg), new HttpCallbackListener() {
			@Override
			public void onFinish(String response) {
				logger.info(response);
			}
			
			@Override
			public void onError(Exception e) {
				logger.info(e.getMessage());
			}
		});
	}
	
	@Subscribe
	public void subscribe(AuthRecordMsg msg) {
		logger.info("收到消息[认证]: " + JsonUtils.toJson(msg));
		
		HashOperations<String, String, String> hashOps = stringRedisTemplate.opsForHash();
		
        if(hashOps.hasKey(CacheManager.KEY_AUTH_RECEIVE_URL, String.valueOf(msg.getProvinceCode()))) {
        	String url = hashOps.get(CacheManager.KEY_AUTH_RECEIVE_URL, String.valueOf(msg.getProvinceCode()));
        	this.sendAuthRecord(url, msg);
        }
        
        if(hashOps.hasKey(CacheManager.KEY_AUTH_RECEIVE_URL, String.valueOf(msg.getCityCode()))) {
        	String url = hashOps.get(CacheManager.KEY_AUTH_RECEIVE_URL, String.valueOf(msg.getCityCode()));
        	this.sendAuthRecord(url, msg);
        }
        
        if(hashOps.hasKey(CacheManager.KEY_AUTH_RECEIVE_URL, String.valueOf(msg.getDistrictCode()))) {
        	String url = hashOps.get(CacheManager.KEY_AUTH_RECEIVE_URL, String.valueOf(msg.getDistrictCode()));
        	this.sendAuthRecord(url, msg);
        }
        
        if(hashOps.hasKey(CacheManager.KEY_AUTH_RECEIVE_URL, String.valueOf(msg.getTownCode()))) {
        	String url = hashOps.get(CacheManager.KEY_AUTH_RECEIVE_URL, String.valueOf(msg.getTownCode()));
        	this.sendAuthRecord(url, msg);
        }
		
		
	}

}

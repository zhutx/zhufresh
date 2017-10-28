package com.moredian.tuna.certification.config;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.moredian.tuna.certification.domain.PrivateCloud;
import com.moredian.tuna.certification.manager.PrivateCloudManager;

@Component
public class CacheManager {
	
	private static final Logger logger = LoggerFactory.getLogger(CacheManager.class);
	
	public static final String KEY_AUTH_RECEIVE_URL = "alarm.auth_receive_url";
	
	private static String AUTH_RECEIVE_URL = "%s/alarm/receiveAuth";
	
	@Autowired
	private PrivateCloudManager privateCloudManager;
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	/**
	 * 缓存私有云的认证接收URL
	 */
	private void cacheAlarmReceiveUrl() {
		
		List<PrivateCloud> privateClouds = privateCloudManager.findAllPrivateCloud();
		stringRedisTemplate.delete(KEY_AUTH_RECEIVE_URL);
		for(PrivateCloud privateCloud : privateClouds) {
			stringRedisTemplate.opsForHash().put(KEY_AUTH_RECEIVE_URL, String.valueOf(privateCloud.getAreaCode()), String.format(AUTH_RECEIVE_URL, privateCloud.getAlarmWebUrl()));
		}
		
		logger.info("-------接收认证数据的私有云网关列表-------");
		for (Map.Entry<Object, Object> entry : stringRedisTemplate.opsForHash().entries(KEY_AUTH_RECEIVE_URL).entrySet()) {
			logger.info(entry.getKey() + " -> " + entry.getValue());
        }
		
	}
	
	@Scheduled(fixedRate=60*60*1000)
    public void oneHourTask() {
		this.cacheAlarmReceiveUrl();
    }

}

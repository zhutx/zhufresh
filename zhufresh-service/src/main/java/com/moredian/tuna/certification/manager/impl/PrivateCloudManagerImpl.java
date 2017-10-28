package com.moredian.tuna.certification.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moredian.tuna.certification.domain.PrivateCloud;
import com.moredian.tuna.certification.manager.PrivateCloudManager;
import com.moredian.tuna.certification.mapper.PrivateCloudMapper;

@Service
public class PrivateCloudManagerImpl implements PrivateCloudManager {
	
	@Autowired
	private PrivateCloudMapper privateCloudMapper;

	@Override
	public List<PrivateCloud> findAllPrivateCloud() {
		return privateCloudMapper.findAll();
	}

}

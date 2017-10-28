package com.moredian.tuna.certification.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moredian.tuna.certification.domain.AuthTop;
import com.moredian.tuna.certification.manager.PlaceManager;
import com.moredian.tuna.certification.mapper.AuthTopMapper;

@Service
public class PlaceManagerImpl implements PlaceManager {
	
	@Autowired
	private AuthTopMapper authTopMapper;

	@Override
	public List<AuthTop> findAuthTop(Integer areaCode, String topDirection) {
		return authTopMapper.findAuthTop(areaCode, topDirection);
	}

	@Override
	public List<AuthTop> findAuthFailTop(Integer areaCode, String topDirection) {
		return authTopMapper.findAuthFailTop(areaCode, topDirection);
	}


}

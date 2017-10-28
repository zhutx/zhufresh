package com.moredian.tuna.certification.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moredian.tuna.certification.manager.MonitorRelationManager;
import com.moredian.tuna.certification.mapper.MonitorRelationMapper;

@Service
public class MonitorRelationManagerImpl implements MonitorRelationManager {
	
	@Autowired
	private MonitorRelationMapper monitorRelationMapper;

}

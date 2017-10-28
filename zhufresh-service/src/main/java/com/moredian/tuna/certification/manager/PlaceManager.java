package com.moredian.tuna.certification.manager;

import java.util.List;

import com.moredian.tuna.certification.domain.AuthTop;

public interface PlaceManager {
	
	List<AuthTop> findAuthTop(Integer areaCode, String topDirection);
	
	List<AuthTop> findAuthFailTop(Integer areaCode, String topDirection);
	
}

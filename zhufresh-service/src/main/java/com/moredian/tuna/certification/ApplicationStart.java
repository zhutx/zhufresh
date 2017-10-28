package com.moredian.tuna.certification;

import org.springframework.scheduling.annotation.EnableScheduling;

import com.moredian.bee.boot.BeeStarter;
import com.moredian.bee.config.annotation.Application;

@Application("certification")
@EnableScheduling  
public class ApplicationStart extends BeeStarter{

	public static void main(String[] args) {
		
		run(ApplicationStart.class, args);
	}
}

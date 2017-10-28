package com.moredian.tuna.certification;

import com.moredian.bee.boot.BeeStarter;
import com.moredian.bee.config.annotation.Application;

@Application("certification-web")
public class ApplicationStart extends BeeStarter{

	public static void main(String[] args) {
		run(ApplicationStart.class, args);
	}
	
}

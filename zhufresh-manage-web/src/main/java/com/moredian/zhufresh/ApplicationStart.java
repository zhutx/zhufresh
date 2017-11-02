package com.moredian.zhufresh;

import com.moredian.bee.boot.BeeStarter;
import com.moredian.bee.config.annotation.Application;

@Application("zhufresh-web")
public class ApplicationStart extends BeeStarter{

	public static void main(String[] args) {
		run(ApplicationStart.class, args);
	}
	
}

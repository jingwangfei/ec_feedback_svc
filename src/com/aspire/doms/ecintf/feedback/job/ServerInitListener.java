package com.aspire.doms.ecintf.feedback.job;

import com.aspire.config.ConfigParameters;
import com.aspire.ec.scheduler.listener.ContextListener;

/**
 * 在应用启动时执行初始化工作，包括：
 * 	加载config.properties
 * 	初始化DAO
 * 
 * @author liuhongtian
 * 
 */
public class ServerInitListener implements ContextListener {

	@Override
	public void onShutdown() {
		
	}

	@Override
	public boolean onStartup() throws Exception {
		
		ConfigParameters.instance();
		
		return true;
	}
}

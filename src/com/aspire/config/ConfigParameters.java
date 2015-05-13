package com.aspire.config;

import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * config.properties里的配置参数
 * 
 * @author liuhongtian
 * 
 */
public class ConfigParameters extends Properties {

	private static final long serialVersionUID = 7159324916694657645L;

	private static final Logger log = Logger.getLogger(ConfigParameters.class);
	
	private static ConfigParameters instance;

	protected ConfigParameters() {
		super();
	}

	/**
	 * 获取单例，或创建单例并加载config.properties到内存
	 * 
	 * @return
	 */
	public static ConfigParameters instance() {
		if (instance == null) {
			synchronized(ConfigParameters.class) {
				if (instance == null) {
					instance = new ConfigParameters();
					try {
						InputStream is = instance.getClass().getClassLoader()
								.getResourceAsStream("config.properties");
						instance.load(is);
					} catch (Exception e) {
						log.error("fail to load config.properties!", e);
						System.exit(1);
					}
				}
			}
		}

		log.info("load config.properties");
		return instance;
	}

	/**
	 * 刷新config.properties中的设置到内存
	 * 
	 * @return
	 */
	public static ConfigParameters refresh() {
		if (instance == null) {
			synchronized(ConfigParameters.class) {
				if (instance == null) {
					instance = new ConfigParameters();
				}
			}
		} else {
			instance.clear();
		}

		try {
			InputStream is = instance.getClass().getClassLoader()
					.getResourceAsStream("config.properties");
			instance.load(is);
		} catch (Exception e) {
			log.error("fail to load config.properties!", e);
			System.exit(1);
		}

		return instance;
	}

}

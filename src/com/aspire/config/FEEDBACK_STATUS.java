package com.aspire.config;

/**
 * 接口反馈状态
 * 
 * @author liuhongtian
 *
 */
public enum FEEDBACK_STATUS {
	DEPENDING("0"),		//待反馈
	PROCESSING("-1"),	//反馈处理中
	SUCCESSED("1"),		//反馈成功
	FAILED("2");		//反馈失败
	
	public String value;
	
	FEEDBACK_STATUS(String value) {
		this.value = value;
	}
	
}

package com.aspire.doms.ecintf.feedback.common;

import java.util.List;

/**
 * @author liuhongtian
 *
 */
public interface IRequester {
	
	/**
	 * 获取待处理的数据列表
	 * 
	 * @param maxSentCount 最大发送次数
	 * @return
	 */
	public List<?> loadRecords(int maxSentCount);

	/**
	 * 向BBOSS反馈前的预处理（可以为空）
	 * 
	 * @param svc 待处理的VO对象
	 */
	public void preOperate(Object svc);
	
	/**
	 * 向BBOSS发起反馈请求，发出的请求如果没收到响应，返回false。
	 * 
	 * @param svc 待处理的VO对象
	 * @return
	 */
	public boolean feedback(Object svc);
	
	/**
	 * 得到BBOSS确认后的后续处理（可以为空）
	 * 
	 * @param svc 待处理的VO对象
	 */
	public void postOperate(Object svc);
	
}

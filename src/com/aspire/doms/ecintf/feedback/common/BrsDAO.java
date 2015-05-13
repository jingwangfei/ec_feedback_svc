package com.aspire.doms.ecintf.feedback.common;

import java.math.BigDecimal;

/**
 * 配置DAO
 * 
 * @author liuhongtian
 * 
 */
public interface BrsDAO {

	/**
	 * 获取指定序列的下一个值
	 * 
	 * @param sn
	 *            指定的序列名
	 * @return
	 */
	public BigDecimal nextSequence(String sn);
}

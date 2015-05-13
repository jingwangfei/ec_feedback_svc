package com.aspire.doms.ecintf.feedback.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import com.aspire.doms.ecintf.feedback.common.BrsDAO;
import com.aspire.doms.ecintf.feedback.vo.ec.EcRequest;

/**
 * BRS
 * 
 * @author liuhongtian
 * 
 */
public class BossIntfService {

	private static final Logger log = Logger.getLogger(BossIntfService.class);
	private BrsDAO brsDao;

	public BossIntfService() {

	}

	public BossIntfService(BrsDAO brsDao) {
		this.brsDao = brsDao;
	}

	public BrsDAO getBrsDao() {
		return brsDao;
	}

	public void setBrsDao(BrsDAO brsDao) {
		this.brsDao = brsDao;
	}

	public String getProcessTime() {
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
		String now = sf.format(new Date());
		return now;
	}

	/**
	 * 格式化字符串，用于生成ProcID、TransIDO （长度为固定30位）
	 * 
	 * @param src
	 *            未经格式化的源字符串，长度超过16-prefix的长度（最多4位）时，从头部截断
	 * @param prefix
	 *            前缀，必须添加在输出结果的最前方，最长4位，多于4位的，从尾部截断
	 * @return 格式化后的字符串
	 */
	private String format(String src, String prefix) {
		StringBuffer buff = new StringBuffer();

		if (prefix == null) {
			prefix = new String("");
		}

		int pLen = prefix.length();
		if (pLen > 4) {
			prefix = prefix.substring(0, 4);
			pLen = 4;
		}

		int len = src.length();

		if (len > 16 - pLen) {
			src = src.substring(len - 16 + pLen);
		}

		len = src.length();

		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
		String now = sf.format(new Date());

		buff.append(prefix);
		buff.append(now);
		buff.append("0000000000000000".substring(len + pLen));
		buff.append(src);

		return buff.toString();
	}

	/**
	 * 获取TransIDO
	 * 
	 * @return
	 */
	//TODO ... 修改前缀
	public String getTransIdO() {
		log.debug("getTransId");
		String transId = brsDao.nextSequence("SEQ_TRANS_ID_O").toString();
		return format(transId, "TRNO");
	}

	/**
	 * 获取ProcID
	 * 
	 * @return
	 */
	public String getProcId() {
		log.debug("getProcId");
		String procId = brsDao.nextSequence("SEQ_PROC_ID").toString();
		return format(procId, "PROC");
	}
 
	/**
	 * 向请求报文对象中增加ProcID、TransIDO、TransIDOTime
	 * 
	 * @param reqObj
	 */
	public void format(EcRequest reqObj) {

		if (reqObj == null) {
			return;
		}

		if (reqObj.getProcID() == null
				|| reqObj.getProcID().trim().length() == 0) {
			reqObj.setProcID(getProcId());
		}
		if (reqObj.getTransIDO() == null
				|| reqObj.getTransIDO().trim().length() == 0) {
			reqObj.setTransIDO(getTransIdO());
		}
		if (reqObj.getTransIDOTime() == null
				|| reqObj.getTransIDOTime().trim().length() == 0) {
			reqObj.setTransIDOTime(getProcessTime());
		}
	}

}

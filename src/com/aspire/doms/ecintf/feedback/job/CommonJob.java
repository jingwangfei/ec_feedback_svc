package com.aspire.doms.ecintf.feedback.job;

import java.util.List;

import org.apache.log4j.Logger;

import com.aspire.config.Consts;
import com.aspire.doms.ecintf.feedback.common.IRequester;
import com.aspire.ec.scheduler.ECJob;

/**
 * 基础任务类，用于根据指定的参数执行对应的业务操作。
 * 
 * @author jingtao
 * 
 */
public class CommonJob extends ECJob {

	protected static final Logger logger = Logger.getLogger(CommonJob.class);

	private static final String REQ_PKG = "com.aspire.doms.ecintf.feedback.request.";

	@Override
	public void run() throws Exception {
		logger.info("start scheduling job: " + this.getJobName());

		String intfId = this.getParamByName("BIPCODE") + this.getParamByName("ACTIVITYCODE");
		long startTime = System.currentTimeMillis();
		
		int maxSentCount = Consts.DEFAULT_MAX_SENT_COUNT;

		String maxSentCountStr = this.getParamByName("MAX_SENT_COUNT");
		if (maxSentCountStr != null && maxSentCountStr.trim().length() != 0) {
			maxSentCount = new Integer(maxSentCountStr).intValue();
		}

		String className = REQ_PKG + intfId;

		Class<?> reqClass = null;
		try {
			reqClass = Class.forName(className);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			logger.error("loading Request class Error", e);
			return;
		}

		IRequester requester = null;
		try {
			requester = (IRequester) reqClass.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("CommonJob create Requester instance Error", e);
			return;
		}

		List<?> records = requester.loadRecords(maxSentCount);
		if (records != null) {
			for (Object svc : records) {
				execute(requester, svc);
			}
		}

		logger.info("end scheduleing job: " + this.getJobName() + ", consuming time: " + (System.currentTimeMillis() - startTime));
	}

	private void execute(IRequester requester, Object svc) {
		requester.preOperate(svc);
		requester.feedback(svc); // 发送报文并接收确认响应，如果没收到响应，返回false，并将LHTStatus设置为false
		requester.postOperate(svc);
	}

}

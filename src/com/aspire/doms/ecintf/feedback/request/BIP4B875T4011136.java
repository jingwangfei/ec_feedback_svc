package com.aspire.doms.ecintf.feedback.request;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBException;

import org.xml.sax.SAXException;

import com.aspire.config.FEEDBACK_STATUS;
import com.aspire.doms.ecintf.feedback.common.BaseRequester;
import com.aspire.doms.ecintf.feedback.dao.BrsDAOImpl;
import com.aspire.doms.ecintf.feedback.utils.BossIntfService;
import com.aspire.doms.ecintf.feedback.utils.MsgSender;
import com.aspire.doms.ecintf.feedback.vo.ec.EcRequest;
import com.aspire.doms.ecintf.feedback.vo.ec.EcResponse;

/**
 * 成员变更
 * 
 * @author jingtao
 * 
 */
public class BIP4B875T4011136 extends BaseRequester {

	@Override
	public boolean feedback(Object svc) {
		long startTime = System.currentTimeMillis();
		logger.info("start feedbacking BIP4B875T4011136.");
		
		com.aspire.doms.ecintf.feedback.vo.BIP4B875T4011136.UserResult r = (com.aspire.doms.ecintf.feedback.vo.BIP4B875T4011136.UserResult) svc;
		boolean result = false;

		EcRequest req = new EcRequest();
		req.setBIPCode("BIP4B875");
		req.setActivityCode("T4011136");
		com.aspire.doms.ecintf.feedback.vo.ec.Routing routing = new com.aspire.doms.ecintf.feedback.vo.ec.Routing();
		routing.setRouteType("00");
		routing.setRouteValue("998");
		req.setRouting(routing);
		new BossIntfService(new BrsDAOImpl()).format(req);
		if (xml != null) {
			req.setSvcCont(xml
					.parsePojo(
							r,
							com.aspire.doms.ecintf.feedback.vo.BIP4B875T4011136.UserResult.class));
		} else {
			req.setSvcCont("");
		}
		try {
			MsgSender sender;
			sender = new MsgSender();
			Map<String, String> params = new HashMap<String, String>();
			params.put("ecid", r.getEc_id());
			EcResponse rsp = sender.send(req, params);
			if (rsp.getResponse().getRspType().equals("0")) {
				result = true;
			}
		} catch (JAXBException e) {
			logger.error(e.getMessage(), e);
		} catch (SAXException e) {
			logger.error(e.getMessage(), e);
		} catch (UnsupportedEncodingException e) {
			logger.error(e.getMessage(), e);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}

		// 处理结果
		if (result) {
			r.setLHTStatus(FEEDBACK_STATUS.SUCCESSED.value);
		} else {
			r.setLHTStatus(FEEDBACK_STATUS.FAILED.value);
		}
		
		logger.info("end feedbacking BIP4B875T4011136: feedback_status: " + r.getLHTStatus() + ", consuming time: " + (System.currentTimeMillis() - startTime));
		return result;
	}

	@Override
	public void postOperate(Object svc) {
		long startTime = System.currentTimeMillis();
		logger.info("start postOperating BIP4B875T4011136.");
		
		com.aspire.doms.ecintf.feedback.vo.BIP4B875T4011136.UserResult u = (com.aspire.doms.ecintf.feedback.vo.BIP4B875T4011136.UserResult) svc;
		try {
			dao.update(id, new Integer(u.getLHTStatus()).intValue(), u.getId(), null);
		} catch (NumberFormatException e) {
			logger.error(e.getMessage(), e);
		}  catch (SQLException e) {
			logger.error(e.getMessage(), e);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
		logger.info("end postOperating BIP4B875T4011136, consuming time: " + (System.currentTimeMillis() - startTime));
	}

}

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
 * 流量叠加包
 * 
 * @author liuhongtian
 * 
 */
public class BIP4B877T4011138 extends BaseRequester {

	@Override
	public boolean feedback(Object svc) {
		long startTime = System.currentTimeMillis();
		logger.info("start feedbacking BIP4B877T4011138 feedback.");
		
		com.aspire.doms.ecintf.feedback.vo.BIP4B877T4011138.AdditionResult a = (com.aspire.doms.ecintf.feedback.vo.BIP4B877T4011138.AdditionResult) svc;
		boolean result = false;

		EcRequest req = new EcRequest();
		req.setBIPCode("BIP4B877");
		req.setActivityCode("T4011138");
		com.aspire.doms.ecintf.feedback.vo.ec.Routing routing = new com.aspire.doms.ecintf.feedback.vo.ec.Routing();
		routing.setRouteType("00");
		routing.setRouteValue("998");
		req.setRouting(routing);
		new BossIntfService(new BrsDAOImpl()).format(req);
		if (xml != null) {
			req.setSvcCont(xml
					.parsePojo(
							a,
							com.aspire.doms.ecintf.feedback.vo.BIP4B877T4011138.AdditionResult.class));
		} else {
			req.setSvcCont("");
		}
		try {
			MsgSender sender;
			sender = new MsgSender();
			Map<String, String> params = new HashMap<String, String>();
			params.put("ecid", a.getEc_id());
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
			a.setLHTStatus(FEEDBACK_STATUS.SUCCESSED.value);
		} else {
			a.setLHTStatus(FEEDBACK_STATUS.FAILED.value);
		}
		logger.info("end feedbacking BIP4B877T4011138: feedback_status: " + a.getLHTStatus() + ", consuming time: " + (System.currentTimeMillis() - startTime));
		return result;
	}

	@Override
	public void postOperate(Object svc) {
		long startTime = System.currentTimeMillis();
		logger.info("start postOperating BIP4B877T4011138.");
		com.aspire.doms.ecintf.feedback.vo.BIP4B877T4011138.AdditionResult a = (com.aspire.doms.ecintf.feedback.vo.BIP4B877T4011138.AdditionResult) svc;
		try {
			dao.update(id, new Integer(a.getLHTStatus()).intValue(), a.getId(), null);
		} catch (NumberFormatException e) {
			logger.error(e.getMessage(), e);
		}  catch (SQLException e) {
			logger.error(e.getMessage(), e);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
		logger.info("end postOperating BIP4B877T4011138, consuming time: " + (System.currentTimeMillis() - startTime));
	}

}

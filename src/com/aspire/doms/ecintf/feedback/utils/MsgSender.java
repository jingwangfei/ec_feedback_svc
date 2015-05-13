package com.aspire.doms.ecintf.feedback.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Properties;
import java.util.Map.Entry;

import javax.xml.bind.JAXBException;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import com.aspire.doms.ecintf.feedback.vo.ec.EcRequest;
import com.aspire.doms.ecintf.feedback.vo.ec.EcResponse;

/**
 * 向指定的ec_serv_intf接口发送BossRequest消息的代理类
 * 
 * @author liuhongtian
 *
 */
public class MsgSender {
	private Logger logger = Logger.getLogger(MsgSender.class);
	
	Properties props;
	
	private String routerUrl;
	private XmlHandleService xmlSvc;
	
	public MsgSender() throws JAXBException, SAXException {
		
		xmlSvc = new XmlHandleService("com.aspire.doms.ecintf.feedback.vo.ec", "ec.xsd");
		props = new Properties();
		try {
			InputStream is = this.getClass().getClassLoader()
					.getResourceAsStream("ec_serv_intf.properties");
			props.load(is);
			
			routerUrl = props.getProperty("ec_serv_intf.url");
		} catch (Exception e) {
			logger.error("create MsgSender instance error.", e);
		}
	}
	
	/**
	 * 设置boss_router接口地址，以覆盖配置文件中的设置（或者在不提供配置文件时，手工进行设置）
	 * 
	 * @param routerUrl
	 */
	public void setRouterUrl(String routerUrl) {
		this.routerUrl = routerUrl;
	}
	
	/**
	 * 向boss_router发送消息，其中，bIPCode、activityCode、Routing、SvcCont四个属性必须设置。
	 * 
	 * @param req
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	public EcResponse send(EcRequest req) throws UnsupportedEncodingException, IOException {
		
		URL url = new URL(routerUrl);
		HttpURLConnection uc = (HttpURLConnection) url.openConnection();
		uc.setRequestMethod("POST");
		uc.setDoOutput(true);
		uc.setRequestProperty("Content-Type",
				"application/x-www-form-urlencoded; charset=utf-8");

		OutputStreamWriter out = new OutputStreamWriter(
				uc.getOutputStream(), "UTF-8");
		String queryStr = xmlSvc.parsePojo(req, EcRequest.class);

		logger.debug("send xml data: " + queryStr);
		queryStr = URLEncoder.encode(queryStr, "UTF-8");

		out.write("xmldata=");
		
		out.write(queryStr);
		out.flush();
		out.close();

		InputStreamReader in = new InputStreamReader(
				uc.getInputStream(), "UTF-8");
		StringBuffer ecRspSb = new StringBuffer("");
		char[] buffer = new char[1024];
		int len = 0;
		while ((len = in.read(buffer)) > 0) {
			ecRspSb.append(buffer, 0, len);
		}
		in.close();

		String ecRspStr = ecRspSb.toString();
		ecRspStr = URLDecoder.decode(ecRspStr, "UTF-8");

		EcResponse rsp = xmlSvc.parseXmlStr(ecRspStr,
				EcResponse.class);
		
		return rsp;
	}

	/**
	 * 向boss_router发送消息，其中，bIPCode、activityCode、Routing、SvcCont四个属性必须设置。
	 * 
	 * @param req
	 * @param extParams
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	public EcResponse send(EcRequest req, Map<String,String> extParams) throws UnsupportedEncodingException, IOException {

		URL url = new URL(routerUrl);
		HttpURLConnection uc = (HttpURLConnection) url.openConnection();
		uc.setRequestMethod("POST");
		uc.setDoOutput(true);
		uc.setRequestProperty("Content-Type",
				"application/x-www-form-urlencoded; charset=utf-8");

		OutputStreamWriter out = new OutputStreamWriter(
				uc.getOutputStream(), "UTF-8");
		String queryStr = xmlSvc.parsePojo(req, EcRequest.class);
		logger.debug("send xml data: " + queryStr);

		queryStr = URLEncoder.encode(queryStr, "UTF-8");

		out.write("xmldata=");

		out.write(queryStr);
		
		// 添加附加参数
		if(extParams != null && (!extParams.isEmpty())) {
			for(Entry<String, String> kv: extParams.entrySet()) {
				out.write("&");
				out.write(kv.getKey());
				out.write("=");
				out.write(URLEncoder.encode(kv.getValue(), "UTF-8"));
				logger.debug("send ext data: " + kv.getKey() + ": " + URLEncoder.encode(kv.getValue(), "UTF-8"));
			}
		}
		
		out.flush();
		out.close();

		InputStreamReader in = new InputStreamReader(
				uc.getInputStream(), "UTF-8");
		StringBuffer ecRspSb = new StringBuffer("");
		char[] buffer = new char[1024];
		int len = 0;
		while ((len = in.read(buffer)) > 0) {
			ecRspSb.append(buffer, 0, len);
		}
		in.close();

		String ecRspStr = ecRspSb.toString();
		ecRspStr = URLDecoder.decode(ecRspStr, "UTF-8");

		EcResponse rsp = xmlSvc.parseXmlStr(ecRspStr,
				EcResponse.class);
		
		return rsp;
	}

}

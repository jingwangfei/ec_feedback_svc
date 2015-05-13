package com.aspire.doms.ecintf.feedback.common;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import com.aspire.doms.ecintf.feedback.utils.XmlHandleService;

public abstract class BaseRequester implements IRequester {

	protected Logger logger;

	protected String id;

	protected XmlHandleService xml;

	protected IDAO dao;

	protected BaseRequester() {
		logger = Logger.getLogger(this.getClass());
		String cName = this.getClass().getSimpleName();
		String pkg = "com.aspire.doms.ecintf.feedback.vo." + cName;
		String xsd = cName + ".xsd";
		String daoName = "com.aspire.doms.ecintf.feedback.dao."
				+ this.getClass().getSimpleName() + "DAO";
		init(pkg, xsd, daoName);
	}

	protected BaseRequester(String pkg, String xsd, String daoName) {
		init(pkg, xsd, daoName);
	}

	private void init(String pkg, String xsd, String daoName) {
		logger = Logger.getLogger(this.getClass());

		id = this.getClass().getSimpleName() + "|"
				+ Thread.currentThread().getName();

		try {
			xml = new XmlHandleService(pkg, xsd);
		} catch (JAXBException e) {
			logger.error(e.getMessage(), e);
		} catch (SAXException e) {
			logger.error(e.getMessage(), e);
		}

		try {
			dao = (IDAO) Class.forName(daoName).newInstance();
		} catch (InstantiationException e) {
			logger.error(e.getMessage(), e);
		} catch (IllegalAccessException e) {
			logger.error(e.getMessage(), e);
		} catch (ClassNotFoundException e) {
			logger.error(e.getMessage(), e);
		}

	}

	public List<?> loadRecords(int maxSentCount) {
		long startTime = System.currentTimeMillis();
		logger.info("start loadding " + this.getClass().getSimpleName() + " Records.");
	
		List<?> res = null;
		try {
			dao.lock(id, maxSentCount);
			res = dao.load(id);
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage(), e);
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
		logger.info("end loadding " + this.getClass().getSimpleName() + " Records: " + res.size() + ", consuming time: " + (System.currentTimeMillis() - startTime));
		return res;
	}
	
	@Override
	public void preOperate(Object svc) {
		
	}
}

package com.aspire.doms.ecintf.feedback.common;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public abstract class BaseDAO implements IDAO {

	protected Logger logger;

	public BaseDAO() {
		logger = Logger.getLogger(this.getClass());
	}
	
	@Override
	public void exUpdate(String id) throws FileNotFoundException, SQLException, IOException {
		
	}
}

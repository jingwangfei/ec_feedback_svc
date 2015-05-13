package com.aspire.doms.ecintf.feedback.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.log4j.Logger;

import com.aspire.doms.ecintf.feedback.common.BrsDAO;
import com.aspire.ec.scheduler.db.C3p0ConnFactory;

public class BrsDAOImpl implements BrsDAO {

	private static final Logger log = Logger.getLogger(BrsDAOImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.aspire.bossrouter.dao.ConfigDAO#nextSequence(java.lang.String)
	 */
	@Override
	public synchronized BigDecimal nextSequence(String sn) {
		Connection conn = null;
		BigDecimal v = null;
		try {
			conn = C3p0ConnFactory.getConn("brsdb.properties");
		
			String sql = "select " + sn + ".nextval from dual";
			log.debug("SQL: " + sql);

			v = (BigDecimal) new QueryRunner().query(conn, sql, new ScalarHandler());
		} catch (FileNotFoundException e) {
			log.error(e);
			e.printStackTrace();
		} catch (SQLException e) {
			log.error(e);
			e.printStackTrace();
		} catch (IOException e) {
			log.error(e);
			e.printStackTrace();
		}
		
		C3p0ConnFactory.attemptClose(conn);
		return v;
	}	 
	
}

package com.aspire.doms.ecintf.feedback.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import com.aspire.config.ConfigParameters;
import com.aspire.doms.ecintf.feedback.common.BaseDAO;
import com.aspire.doms.ecintf.feedback.common.IDAO;
import com.aspire.ec.scheduler.db.C3p0ConnFactory;

/**
 * 流量叠加包
 */
public class BIP4B877T4011138DAO extends BaseDAO implements IDAO {

	@Override
	public void lock(String locker, int maxSentCount)
			throws FileNotFoundException, SQLException, IOException {
		logger.debug("starting lock BIP4B877T4011138 instance.");

		QueryRunner run = new QueryRunner();
		
		Connection conn = C3p0ConnFactory.getConn("logdb.properties");
		Object[] params = { locker, maxSentCount };
		
		int upRowNum = run.update(
				conn,
				ConfigParameters.instance().getProperty(
						"sql.LOCK_BIP4B877T4011138"), params); // 锁定待处理的记录
		
		logger.debug("end locking BIP4B877T4011138 instance: " + upRowNum);
		C3p0ConnFactory.attemptClose(conn);
	}

	@Override
	public void update(String locker, int status, String cardPwd, String noUse)
			throws FileNotFoundException, SQLException, IOException {
		logger.debug("update BIP4B877T4011138 instance: id = " + cardPwd);

		QueryRunner run = new QueryRunner();
		
		Connection conn = C3p0ConnFactory.getConn("logdb.properties");
		Object[] params = { status, cardPwd, locker };
		
		run.update(
				conn,
				ConfigParameters.instance().getProperty(
						"sql.UPDATE_BIP4B877T4011138"), params); // 更新记录
		
		C3p0ConnFactory.attemptClose(conn);
	}

	@Override
	public List<?> load(String locker) throws FileNotFoundException,
			SQLException, IOException {
		logger.debug("start loadding BIP4B877T4011138 list.");
		List<com.aspire.doms.ecintf.feedback.vo.BIP4B877T4011138.AdditionResult> records = null;
		
		final QueryRunner run = new QueryRunner();
		final Connection conn = C3p0ConnFactory.getConn("logdb.properties");
		
		String sql = ConfigParameters.instance().getProperty("sql.LOAD_BIP4B877T4011138"); // 加载记录
		final String sql_detail =  ConfigParameters.instance().getProperty("sql.LOAD_BIP4B877T4011138_detail"); // 详情 
		
		final ResultSetHandler rsh_detail = new ResultSetHandler() {
			
			@Override
			public Object handle(ResultSet rs) throws SQLException {
				List<com.aspire.doms.ecintf.feedback.vo.BIP4B877T4011138.FailInfo> list = new ArrayList<com.aspire.doms.ecintf.feedback.vo.BIP4B877T4011138.FailInfo>();
				while (rs.next()) {
					com.aspire.doms.ecintf.feedback.vo.BIP4B877T4011138.FailInfo f = new com.aspire.doms.ecintf.feedback.vo.BIP4B877T4011138.FailInfo();
					f.setMobNum(rs.getString(1));
					f.setRsp(rs.getString(2));
					f.setRspDesc(rs.getString(3));
					f.setOper_seq(rs.getString(4));
					list.add(f);
				}
				return list;
			}
		};
		
		ResultSetHandler rsh = new ResultSetHandler() {
			@SuppressWarnings("unchecked")
			@Override
			public Object handle(ResultSet rs) throws SQLException {
				List<com.aspire.doms.ecintf.feedback.vo.BIP4B877T4011138.AdditionResult> list = new ArrayList<com.aspire.doms.ecintf.feedback.vo.BIP4B877T4011138.AdditionResult>();
				com.aspire.doms.ecintf.feedback.vo.BIP4B877T4011138.AdditionResult a = null;
				while (rs.next()) {
					a = new com.aspire.doms.ecintf.feedback.vo.BIP4B877T4011138.AdditionResult();
					String taskId = rs.getBigDecimal(1).toString();
					a.setId(taskId);
					a.setEc_id(rs.getString(2)); // ec_id
					List<com.aspire.doms.ecintf.feedback.vo.BIP4B877T4011138.FailInfo> f_List = (List<com.aspire.doms.ecintf.feedback.vo.BIP4B877T4011138.FailInfo>) run
														.query(conn, sql_detail, new Object[] {taskId}, rsh_detail);
					
					a.setFailNum(f_List.size() + "");
					logger.debug("loadding BIP4B877T4011138 list: task_id = " + taskId + ", failNum = " + f_List.size());
					for (com.aspire.doms.ecintf.feedback.vo.BIP4B877T4011138.FailInfo f : f_List) {
						a.getFailInfo().add(f);
					}
					a.setOperSeq(f_List.get(0).getOper_seq());
					a.setSuccNum("0");
					list.add(a);
				}
				return list;
			}
		};

		@SuppressWarnings("unchecked")
		List<com.aspire.doms.ecintf.feedback.vo.BIP4B877T4011138.AdditionResult> res = (List<com.aspire.doms.ecintf.feedback.vo.BIP4B877T4011138.AdditionResult>) run
				.query(conn, sql, new Object[] { locker }, rsh);
		
		if (res != null) {
			records = res;
		} else {
			records = new ArrayList<com.aspire.doms.ecintf.feedback.vo.BIP4B877T4011138.AdditionResult>();
		}

		C3p0ConnFactory.attemptClose(conn);
		logger.debug("end loadding BIP4B877T4011138 list: " + records.size());
		return records;
	}
	
}

package com.aspire.doms.ecintf.feedback.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import com.aspire.config.ConfigParameters;
import com.aspire.doms.ecintf.feedback.common.BaseDAO;
import com.aspire.doms.ecintf.feedback.common.IDAO;
import com.aspire.doms.ecintf.feedback.utils.MsgSender;
import com.aspire.doms.ecintf.feedback.utils.XmlHandleService;
import com.aspire.doms.ecintf.feedback.vo.BIP4B877T4011138.AdditionResult;
import com.aspire.doms.ecintf.feedback.vo.ec.EcRequest;
import com.aspire.doms.ecintf.feedback.vo.ec.EcResponse;
import com.aspire.doms.ecintf.feedback.vo.ec.Routing;
import com.aspire.ec.scheduler.db.C3p0ConnFactory;

/**
 * 成员变更
 */
@SuppressWarnings("unchecked")
public class BIP4B875T4011136DAO extends BaseDAO {

	@Override
	public void lock(String locker, int maxSentCount) throws FileNotFoundException, SQLException, IOException {
		logger.debug("starting locking BIP4B875T4011136 instance.");
		
		QueryRunner run = new QueryRunner();
		Object[] params = { locker, maxSentCount };
		Connection conn = C3p0ConnFactory.getConn("logdb.properties");

		int upRowNum = run.update(conn, ConfigParameters.instance().getProperty("sql.LOCK_BIP4B875T4011136"), params); // 锁定待处理的记录
		
		logger.debug("end locking BIP4B875T4011136 instance: " + upRowNum);
		C3p0ConnFactory.attemptClose(conn);
	}

	@Override
	public void update(String locker, int status, String cardPwd, String noUse) throws FileNotFoundException, SQLException, IOException {
		logger.debug("update BIP4B875T4011136 instance: task_id = " + cardPwd );

		QueryRunner run = new QueryRunner();
		Connection conn = C3p0ConnFactory.getConn("logdb.properties");
		Object[] params = { status, cardPwd, locker };

		run.update(conn, ConfigParameters.instance().getProperty("sql.UPDATE_BIP4B875T4011136"), params); // 更新记录

		C3p0ConnFactory.attemptClose(conn);
	}

	@Override
	public List<?> load(String locker) throws FileNotFoundException, SQLException, IOException {
		logger.debug("start loadding BIP4B875T4011136 list.");
		List<com.aspire.doms.ecintf.feedback.vo.BIP4B875T4011136.UserResult> records = null;
		
		final QueryRunner run = new QueryRunner();
		final Connection conn = C3p0ConnFactory.getConn("logdb.properties");
		
		String sql_load = ConfigParameters.instance().getProperty("sql.LOAD_BIP4B875T4011136"); // 加载记录
		final String sql_load_detail = ConfigParameters.instance().getProperty("sql.LOAD_BIP4B875T4011136_detail"); // 详情
		
		final ResultSetHandler rsh_detail = new ResultSetHandler() {
			
			@Override
			public Object handle(ResultSet rs) throws SQLException {
				List<com.aspire.doms.ecintf.feedback.vo.BIP4B875T4011136.FailInfo> list = new ArrayList<com.aspire.doms.ecintf.feedback.vo.BIP4B875T4011136.FailInfo>();
				while (rs.next()) {
					com.aspire.doms.ecintf.feedback.vo.BIP4B875T4011136.FailInfo f = new com.aspire.doms.ecintf.feedback.vo.BIP4B875T4011136.FailInfo();
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
			@Override
			public Object handle(ResultSet rs) throws SQLException {
				List<com.aspire.doms.ecintf.feedback.vo.BIP4B875T4011136.UserResult> list = new ArrayList<com.aspire.doms.ecintf.feedback.vo.BIP4B875T4011136.UserResult>();
				com.aspire.doms.ecintf.feedback.vo.BIP4B875T4011136.UserResult u = null;
				while (rs.next()) {
					u = new com.aspire.doms.ecintf.feedback.vo.BIP4B875T4011136.UserResult();
					String taskId = rs.getBigDecimal(1).toString();
					u.setId(taskId);
					u.setEc_id(rs.getString(2)); // ec_id
					List<com.aspire.doms.ecintf.feedback.vo.BIP4B875T4011136.FailInfo> f_List = (List<com.aspire.doms.ecintf.feedback.vo.BIP4B875T4011136.FailInfo>) run
												.query(conn, sql_load_detail,
														new Object[] {taskId},
														rsh_detail);
					u.setFailNum(f_List.size() + "");
					logger.debug("loadding BIP4B875T4011136 list: task_id = " + taskId + ", failNum = " + f_List.size());
					for (com.aspire.doms.ecintf.feedback.vo.BIP4B875T4011136.FailInfo f : f_List) {
						u.getFailInfo().add(f);
					}
					u.setOperSeq(f_List.get(0).getOper_seq());
					u.setSuccNum("0");
					list.add(u);
				}
				return list;
			}
		};
		
		List<com.aspire.doms.ecintf.feedback.vo.BIP4B875T4011136.UserResult> res = (List<com.aspire.doms.ecintf.feedback.vo.BIP4B875T4011136.UserResult>) run
				.query(conn, sql_load, new Object[] { locker }, rsh);

		if (res != null) {
			records = res;
		} else {
			records = new ArrayList<com.aspire.doms.ecintf.feedback.vo.BIP4B875T4011136.UserResult>();
		}

		C3p0ConnFactory.attemptClose(conn);
		logger.debug("end loadding BIP4B875T4011136 list: " + records.size());
		return records;
	}

	public static void main(String args[]) throws Exception {

		IDAO dao = new BIP4B875T4011136DAO();
		dao.getClass();

		// 创建Ecrequest
		EcRequest ecRequest = new EcRequest();
		ecRequest.setActivityCode("T4011136");
		ecRequest.setBIPCode("BIP4B875");
		ecRequest.setProcID("BBSS1427088761363");
		Routing routing = new Routing();
		routing.setRouteType("00");
		routing.setRouteValue("998");
		ecRequest.setRouting(routing);

		// 设置svcCoent内容
		com.aspire.doms.ecintf.feedback.vo.BIP4B877T4011138.FailInfo e = new com.aspire.doms.ecintf.feedback.vo.BIP4B877T4011138.FailInfo();
		e.setMobNum("15101144130");
		e.setRsp("01");
		e.setRspDesc("错误");

		com.aspire.doms.ecintf.feedback.vo.BIP4B877T4011138.SuccInfo s = new com.aspire.doms.ecintf.feedback.vo.BIP4B877T4011138.SuccInfo();
		s.setSuccTel("18734570233");

		AdditionResult a = new AdditionResult();
		a.setFailNum("1");
		a.setSuccNum("1");
		a.getFailInfo().add(e);
		a.getSuccInfo().add(s);
		a.setOperSeq("7934229");
		
		XmlHandleService xs = new XmlHandleService("com.aspire.doms.ecintf.feedback.vo.BIP4B877T4011138", "BIP4B877T4011138.xsd");
		ecRequest.setSvcCont(xs.parsePojo(a, com.aspire.doms.ecintf.feedback.vo.BIP4B877T4011138.AdditionResult.class));
		
		ecRequest.setTransIDO("BBSST401113620150323000115");
		ecRequest.setTransIDOTime("20150323133241");
		
		// 发送
		MsgSender msgSender = new MsgSender();
		try {
			Map<String, String> params = new HashMap<String, String>();
			params.put("ecid", "280009999280013598");
			EcResponse response = msgSender.send(ecRequest, params);
			
			System.out.println(response.getTransIDH());
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
}

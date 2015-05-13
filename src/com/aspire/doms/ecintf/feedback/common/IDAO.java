package com.aspire.doms.ecintf.feedback.common;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IDAO {

	public void lock(String locker, int maxSentCount)
			throws FileNotFoundException, SQLException, IOException;

	/**
	 * @param locker
	 * @param status
	 * @param id
	 * @param version 对于某些接口，version为null
	 * @throws FileNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	public void update(String locker, int status, String id, String version)
			throws FileNotFoundException, SQLException, IOException;

	public List<?> load(String locker) throws FileNotFoundException,
			SQLException, IOException;

	public void exUpdate(String id) throws FileNotFoundException, SQLException,
			IOException;
}

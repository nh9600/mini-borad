package com.board.mini.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBExecutor {

	private PreparedStatement ps;
	private ResultSet rs;

	public PreparedStatement prepared(Connection con, String sql) throws SQLException {
		ps = con.prepareStatement(sql);
		return ps;
	}

	public ResultSet executeQuery() throws SQLException {
		rs = ps.executeQuery();
		return rs;
	}

	public void closeAll() {
		try {
		if (rs != null) {
			rs.close();
		}
		if (ps != null) {
			ps.close();
		}
		}catch(SQLException sqle) {
			sqle.printStackTrace();
		}
	}
}

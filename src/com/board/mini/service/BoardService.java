package com.board.mini.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.board.mini.common.DBCon;
import com.board.mini.common.DBExecutor;

public class BoardService {

	public List<Map<String,String>> getBoardList(){
		Connection con = DBCon.getCon();
		DBExecutor dbe = new DBExecutor();
		String sql = "select * from board_info";
		try {
			PreparedStatement ps = dbe.prepared(con, sql);
			ResultSet rs = dbe.executeQuery();
			List<Map<String,String>> boardList = new ArrayList<>();
			while(rs.next()) {
				Map<String,String> bi = new HashMap<>();
				bi.put("biNum", rs.getString("bi_num"));
				bi.put("biTitle", rs.getString("bi_title"));
				bi.put("biContent", rs.getString("bi_content"));
				bi.put("uiNum", rs.getString("ui_num"));
				bi.put("credat", rs.getString("credat"));
				bi.put("cretim", rs.getString("cretim"));
				bi.put("moddat", rs.getString("moddat"));
				bi.put("modtim", rs.getString("modtim"));
				bi.put("active", rs.getString("active"));
				boardList.add(bi);
			}
			return boardList;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbe.closeAll();
			DBCon.closeCon();
		}
		return null;
	}
	
	public int insertBoard(Map<String,String> board) {
		Connection con = DBCon.getCon();
		DBExecutor dbe = new DBExecutor();
		String sql = "insert into board_info(bi_num, bi_title, bi_content, ui_num, credat, cretim, moddat, modtim)";
		sql += " values(seq_bi_num.nextval, ?,?,?,to_char(sysdate,'YYYYMMDD'), to_char(sysdate,'HH24MISS'),to_char(sysdate,'YYYYMMDD'), to_char(sysdate,'HH24MISS'))";
		try {
			PreparedStatement ps = dbe.prepared(con, sql);
			ps.setString(1, board.get("biTitle"));
			ps.setString(2, board.get("biContent"));
			ps.setString(3, board.get("uiNum"));
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbe.closeAll();
			DBCon.closeCon();
		}
		return 0;
	}
}
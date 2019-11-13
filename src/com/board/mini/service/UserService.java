package com.board.mini.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;

import com.board.mini.common.DBCon;
import com.board.mini.common.DBExecutor;

public class UserService {
	public Map<String,Object> doLogin(String id,String pwd){
		Connection con = DBCon.getCon();//1.제일 먼저
		DBExecutor dbe= new DBExecutor();
		String sql="select * from user_info where ui_id=? and ui_pwd=?";
		try {
			PreparedStatement ps = dbe.prepared(con, sql);//Map=키는 스트링 밸류는 오브젝트(아무거나 다 넣을 수 있는 것)
			ps.setString(1, id);
			ps.setString(2, pwd);
			ResultSet rs = dbe.executeQuery();
			if(rs.next()) {//아이디와 비밀번호를 옳바르게 작성했을때 
				Map<String,Object> user = new HashMap<>();
				user.put("uiNum",rs.getInt("ui_Num"));//getInt 리턴타입 인트
				user.put("uiName",rs.getString("ui_Name"));//getString 리턴타입 스트링
				user.put("uiId",rs.getString("ui_id"));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {//무조건 실행된 다음 리턴, 반드시 실행돼야하면 finally에 적는게 좋음
			dbe.closeAll();
			DBCon.closeCon();//3
		}
		return null;
	}
	
	public Map<String,Object> doSignup(String uiName,String uiId,String uiPwd){
		DBExecutor dbe = new DBExecutor();
		try {
			Connection con = DBCon.getCon();
			String sql = "insert into user_info(ui_num,ui_name,ui_id,ui_pwd,credat,cretim,moddat,modtim)";
			sql+="values(seq_ui_num.nextval,?,?,?,to_char(sysdate,'yyyymmdd'), to_char(sysdate,'hh24miss'),to_char(sysdate,'yyyymmdd'), to_char(sysdate,'hh24miss'))";
			PreparedStatement ps = dbe.prepared(con, sql);
			ps.setString(1,uiName);
			ps.setString(2,uiId);
			ps.setString(3,uiPwd);
			if(ps.executeUpdate()==1) {
				Map<String,Object> rMap = new HashMap<String,Object>();
				rMap.put("msg",uiName+"님 회원가입이 성공하였습니다.");
				rMap.put("url","/views/user/login");
				return rMap;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbe.closeAll();
			DBCon.closeCon();
			}
		return null;
		}		
	}





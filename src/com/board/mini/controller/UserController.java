package com.board.mini.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.mini.service.UserService;

public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}// /user/*

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uiName=request.getParameter("uiName");//id(이건 자바스크립트에서 사용하려고 쓰는 것)가 아니라 name을 바라봄
		String uiId=request.getParameter("uiId");
		String uiPwd=request.getParameter("uiPwd");
		UserService us = new UserService();
		String uri = request.getRequestURI();
		uri=uri.substring(6);
		String url="/views/user/login";
		String msg="아이디나 비밀번호를 확인해주세요.";//메세지
		if("login".equals(uri)) {//로그인이 제대로 됐으면 
			Map<String,Object>user=us.doLogin(uiId,uiPwd);
			if(user!=null) {//null이 아니라면
				HttpSession hs = request.getSession();
				hs.setAttribute("user",user);//키,밸류
				url="/views/index";
				msg=user.get("uiName")+"님 환영합니다.";
			}

		}else if("signup".contentEquals(uri)) {
			Map<String, Object> rMap = us.doSignup(uiName, uiId, uiPwd);
			if(rMap!=null) {
				url = (String)rMap.get("url");
				msg = (String)rMap.get("msg");
			}else {
				url="/views/user/signup";
				msg="뭔가 잘못돼서 회원가입 안됨~";
			}
		}
		request.setAttribute("msg",msg);
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	
}
}

package com.board.mini.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//중개자 역할만 하기때문에 소스를 먹을 수 없음
//요청주소를 받고 응답을 해줘야하기때문에 
public class URIcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;     
	private static final String PREFIX="/WEB-INF";//접두사(앞에 붙는)
	private static final String SUFFIX=".jsp";//정리사(뒤에 붙는) 나중에 스프링할때 수월하게 하기위해 사용
	
	private static String getForwardURI(HttpServletRequest request) {
		return PREFIX + request.getRequestURI() + SUFFIX;
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  RequestDispatcher rd = request.getRequestDispatcher(getForwardURI(request));//위에 것 읽음
	  rd.forward(request,response);
	}//doGet = 겟으로 들어왔다.겟방식일때 무조건 이것만 실행
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  doGet(request,response);
	}
}

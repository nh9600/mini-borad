package com.board.mini.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		System.out.println(uri.substring(6));
		
	
}
}

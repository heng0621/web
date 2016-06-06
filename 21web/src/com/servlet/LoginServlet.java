package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AdminDao;
import com.entity.Admin;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		AdminDao admindao = new AdminDao();
		Admin admin = admindao.findByadminname(username);
		
		if (admin != null && password.equals(admin.getPassword())) {
			
			response.sendRedirect("/home.do");

		} else {

			response.sendRedirect("/index?code=1001");
		}
	}
}

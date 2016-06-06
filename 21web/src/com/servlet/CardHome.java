package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CardDAO;

public class CardHome extends HttpServlet {


	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		CardDAO cardDao = new CardDAO();
		req.setAttribute("cardList", cardDao.findAllCard());
		req.getRequestDispatcher("/WEB-INF/views/cardlist.jsp").forward(req, resp);
		
	}

}

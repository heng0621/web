package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BookDAO;
import com.entity.Book;

public class HomeServlet extends HttpServlet{

	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BookDAO bookDao = new BookDAO();
		List<Book> bookList = bookDao.findAllBook();
		
		request.setAttribute("bookList", bookList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/booklist.jsp");
		rd.forward(request, response);
	}
}

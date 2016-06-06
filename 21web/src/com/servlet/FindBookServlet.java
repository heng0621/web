package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BookDAO;
import com.entity.Book;

public class FindBookServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String wd="";
		
		if (req.getParameter("wd") != null) {
			wd = new String(req.getParameter("wd").getBytes("ISO-8859-1"), "utf-8");
		}
		
		
		BookDAO bookDao = new BookDAO();
		List<Book> bookList = bookDao.findBooks(wd);
		req.setAttribute("bookList", bookList);
		req.getRequestDispatcher("/WEB-INF/views/booklist.jsp").forward(req, resp);
		
	}
}

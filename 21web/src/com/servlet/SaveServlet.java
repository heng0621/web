package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BookDAO;
import com.entity.Book;

public class SaveServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ��ȡ������
		String code = req.getParameter("code");
		String title = req.getParameter("title");
		String author = req.getParameter("author");
		String publishing = req.getParameter("publishing");
		String total = req.getParameter("total");
		
		//��������ӵ����ݿ���
		Book book =new Book();
		book.setCode(code);
		book.setTitle(title);
		book.setAuthor(author);
		book.setPublishing(publishing);
		book.setTotal(Integer.valueOf(total));
		book.setCount(Integer.valueOf(total));
		
		//�ض���home
		
		BookDAO bookDao= new BookDAO();
		bookDao.save(book);
		
		resp.sendRedirect("/home");

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/WEB-INF/views/bookadd.jsp").forward(req, resp);
	}
}

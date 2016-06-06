package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BookDAO;
import com.entity.Book;


public class UpdateServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ��ȡ������
				String id = req.getParameter("id");
				String code = req.getParameter("code");
				String title = req.getParameter("title");
				String author = req.getParameter("author");
				String publishing = req.getParameter("publishing");
				String total = req.getParameter("total");
				String count = req.getParameter("count");
				
				//��������ӵ����ݿ���
				Book book =new Book();
				book.setId(Integer.valueOf(id));
				book.setCode(code);
				book.setTitle(title);
				book.setAuthor(author);
				book.setPublishing(publishing);
				book.setTotal(Integer.valueOf(total));
				book.setCount(Integer.valueOf(count));
				
				//�ض���home
				
				BookDAO bookDao= new BookDAO();
				bookDao.update(book);;
				
				resp.sendRedirect("/home");
	}
	

}

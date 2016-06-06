package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BookDAO;
import com.entity.Book;

public class EditServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		
		if(id !=null && id.matches("\\d+")){
			
			BookDAO bookDao = new BookDAO();
			Book book = bookDao.findBookById(Integer.valueOf(id));
			if(book ==null){
				resp.sendError(404, "查找资源不存在……");
			}else{
				
				req.setAttribute("book", book);
				RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/bookedit.jsp");
				rd.forward(req, resp);
			}
		}else{
			resp.sendRedirect("/home");
		}
	}
}

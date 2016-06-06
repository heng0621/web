package com.dao;

import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.entity.Book;
import com.uitl.DBHelper;

public class BookDAO {

	public List<Book> findAllBook() {

		String sql = "select * from book ";
		return DBHelper.query(sql, new BeanListHandler<Book>(Book.class));

	}

	public void save(Book book){
		
		String sql = "insert into book(code, title, author, publishing, total, count) values(?,?,?,?,?,?)";
		DBHelper.update(sql, book.getCode(),book.getTitle(),book.getAuthor(),book.getPublishing(),book.getTotal(),book.getCount());
	}
	
	public void deleteBook(Integer id){
		String sql = "delete from book where id = ?";
		DBHelper.update(sql, id);
	}
	
	public Book findBookById(Integer id){
		String sql = "select * from book where id = ?";
		return DBHelper.query(sql, new BeanHandler<Book>(Book.class), id);
		
	}
	
	public void update(Book book){
		
		String sql = "update book set code=?,title=?,author=?,publishing=? ,total=? ,count=? where id =?";
		DBHelper.update(sql, book.getCode(),book.getTitle(),book.getAuthor(),book.getPublishing(),book.getTotal(),book.getCount(),book.getId());
	}
	
	public List<Book> findBooks(String str) {
		String sql = "select * from book where title like '%" + str + "%' or author like '%" + str
				+ "%' or code like '%" + str + "%'";
		return DBHelper.query(sql, new BeanListHandler<Book>(Book.class));
	}


}

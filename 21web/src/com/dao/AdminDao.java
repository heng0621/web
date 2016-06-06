package com.dao;

import org.apache.commons.dbutils.handlers.BeanHandler;

import com.entity.Admin;
import com.uitl.DBHelper;

public class AdminDao {

	
	public Admin findByadminname(String name){
		
		String sql = "select * from admin where username=?";

		return DBHelper.query(sql, new BeanHandler<Admin>(Admin.class), name);
		
	}
}

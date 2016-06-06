package com.uitl;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

public class DBHelper {

	// 数据库的增删改
	public static void update(String sql, Object... params) {

		Connection conn = ConnectionDB.getConnection();
		QueryRunner qr = new QueryRunner();

		try {
			qr.update(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			closeConn(conn);
		}
	}

	// 数据库的查询
	
	public static <T> T query(String sql, ResultSetHandler<T> rsh,Object... params){
		
		Connection conn = ConnectionDB.getConnection();
		QueryRunner qr = new QueryRunner();
		
		try {
			return qr.query(conn, sql, rsh, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	private static void closeConn(Connection conn) {

		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}

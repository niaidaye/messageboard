package cn.jbit.dao.impl;

import java.sql.*;


/**
 * 数据库操作基类。
 * @author 北大青鸟
 *
 */
public class BaseDao {
	public final static String DRIVER = "oracle.jdbc.driver.OracleDriver"; // 数据库驱动

	public final static String URL = "jdbc:oracle:thin:@10.0.0.41:1521:sjbitdb"; // url

	public final static String DBNAME = "admin"; // 数据库用户名

	public final static String DBPASS = "bdqn"; // 数据库密码

	/**
	 * 得到数据库连接
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @return 数据库连接
	 */
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		try {
			Class.forName(DRIVER); // 注册驱动
			conn = DriverManager.getConnection(URL, DBNAME, DBPASS); // 获得数据库连接
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn; // 返回连接
	}

	/**
	 * 释放资源
	 * 
	 * @param conn 数据库连接
	 * @param stmt Statement对象
	 * @param rs 结果集
	 */
	public void closeAll(Connection conn, Statement stmt, ResultSet rs) {

		/* 如果rs不空，关闭rs */
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		/* 如果pstmt不空，关闭pstmt */
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		/* 如果conn不空，关闭conn */
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * 执行SQL语句，可以执行查询
	 * 
	 * @param sql 预编译的 SQL 语句
	 * @param param 预编译的 SQL 语句中的‘？’参数的字符串数组
	 * @return 影响的条数
	 */
	public ResultSet executeQuerySQL(String preparedSql, String[] param) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// int num = 0;

		/* 处理SQL,执行SQL */
		try {
			conn = getConnection(); // 得到数据库连接
			pstmt = conn.prepareStatement(preparedSql); // 得到PreparedStatement对象
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					pstmt.setString(i + 1, param[i]); // 为预编译sql设置参数
				}
			}
			rs = pstmt.executeQuery(); // 执行SQL语句
		} catch (ClassNotFoundException e) {
			e.printStackTrace(); // 处理ClassNotFoundException异常
		} catch (SQLException e) {
			e.printStackTrace(); // 处理SQLException异常
		}
		return rs;
	}

	/**
	 * 执行SQL语句，可以进行增、删、改的操作，不能执行查询
	 * 
	 * @param sql 预编译的 SQL 语句
	 * @param param 预编译的 SQL 语句中的‘？’参数的字符串数组
	 * @return 影响的条数
	 */
	public int executeSQL(String preparedSql, Object[] param) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int num = 0;

		/* 处理SQL,执行SQL */
		try {
			conn = getConnection(); // 得到数据库连接
			pstmt = conn.prepareStatement(preparedSql); // 得到PreparedStatement对象
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					pstmt.setObject(i + 1, param[i]); // 为预编译sql设置参数
				}
			}
			// System.out.println(preparedSql);
			num = pstmt.executeUpdate(); // 执行SQL语句
		} catch (ClassNotFoundException e) {
			e.printStackTrace(); // 处理ClassNotFoundException异常
		} catch (SQLException e) {
			e.printStackTrace(); // 处理SQLException异常
		} finally {
			this.closeAll(conn, pstmt, null);
		}
		return num;
	}
}

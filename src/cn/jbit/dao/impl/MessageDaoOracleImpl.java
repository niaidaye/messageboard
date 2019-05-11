package cn.jbit.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import cn.jbit.dao.MessageDao;
import cn.jbit.entity.Message;

/**
 * MessageDao实现类。
 * @author 北大青鸟
 *
 */
public class MessageDaoOracleImpl extends BaseDao implements MessageDao{

	/* (non-Javadoc)
	 * @see cn.jbit.dao.impl.MessageDao#getAllMessage()
	 */
	public ArrayList<Message> getAllMessage(){
		Connection conn = null;//数据库连接对象
		Statement stmt = null;//命令对象
		ResultSet rs = null;//结果集
		String sql = "select * from message order by createtime desc";//SQL语句
		ArrayList<Message> list = new ArrayList<Message>();//用于保存查询得到的留言信息
		
		//从数据库获取数据并处理异常
		try {
			conn = this.getConnection();
			stmt = conn.createStatement();;
			rs = stmt.executeQuery(sql);
			//如果结果集不为空，循环从结果集取出数据加入集合
			while(rs.next()){
				Message message = new Message();
				message.setId(rs.getInt("id"));
				message.setTitle(rs.getString("title"));
				message.setUserName(rs.getString("username"));
				message.setContents(rs.getString("contents"));				
				message.setCreateTime(rs.getDate("createtime"));
				list.add(message);
			}
		} catch (Exception e) {
			e.printStackTrace();//异常处理
		} finally {
			this.closeAll(conn, stmt, rs);
		}
		return list;//返回所有留言信息
	}
	
	/* (non-Javadoc)
	 * @see cn.jbit.dao.impl.MessageDao#addMessage(cn.jbit.entity.Message)
	 */
	public int addMessage(Message message){
		Connection conn= null;//连接对象
		PreparedStatement pstmt = null;//命令对象
		int count = 0;//添加记录条数
		String sql = "insert into message values (messageSeq.nextVal,?,?,?,sysdate)";//SQL语句
		//执行添加操作并捕获异常
		try {
			conn = this.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, message.getTitle());
			pstmt.setString(2,message.getUserName());
			pstmt.setString(3, message.getContents());			
			count = pstmt.executeUpdate();//得到执行结果
		} catch (Exception e) {
			e.printStackTrace();//异常处理
		} finally {
			this.closeAll(conn, pstmt, null);
		}
		return count;//返回结果
	}
	
}

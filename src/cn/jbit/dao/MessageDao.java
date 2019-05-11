package cn.jbit.dao;

import java.util.ArrayList;

import cn.jbit.entity.Message;
/**
 * 留言DAO接口。
 * @author 北大青鸟
 *
 */
public interface MessageDao {

	/**
	 * 获取所有留言信息列表。
	 * @return 所有留言信息
	 */
	public ArrayList<Message> getAllMessage();

	/**
	 * 添加留言。
	 * @param message 留言
	 * @return 添加记录条数
	 */
	public int addMessage(Message message);

}
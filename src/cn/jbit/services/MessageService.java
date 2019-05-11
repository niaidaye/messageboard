package cn.jbit.services;

import java.util.List;
import java.util.Scanner;

import cn.jbit.dao.MessageDao;
import cn.jbit.dao.impl.MessageDaoOracleImpl;
import cn.jbit.entity.Message;

/**
 * 留言业务类。
 * @author 北大青鸟
 */
public class MessageService {
	/**
	 * 用户输入留言信息，添加留言。
	 */
	public void addMessage() {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入留言人姓名：");
		String username = input.next();
		System.out.println("请输入留言标题：");
		String title = input.next();
		System.out.println("请输入留言内容：");
		String contents = input.next();
		Message message = new Message();
		message.setUserName(username);
		message.setTitle(title);
		message.setContents(contents);
		MessageDao messageDao = new MessageDaoOracleImpl();
		int count = messageDao.addMessage(message);
		if (count > 0)
			System.out.println("留言成功！");
		else
			System.out.println("留言失败！");
	}
	/**
	 * 在控制台显示所有留言。
	 */
	public void showMessage() {
		MessageDao messageDao = new MessageDaoOracleImpl();
		List<Message> messageList = messageDao.getAllMessage();

		for (int i = 0; i < messageList.size(); i++) {
			Message message = (Message) messageList.get(i);
			System.out.println("留言人：" + message.getUserName() + "\t留言时间："
					+ message.getCreateTime());
			System.out.println("留言标题：" + message.getTitle());
			System.out.println("留言内容：" + message.getContents());
			System.out.println();
		}
	}
	/**
	 * 显示主菜单。
	 */
	public void showMenu() {
		System.out.println("--------主菜单-------");
		System.out.println("     1、显示留言");
		System.out.println("     2、添加留言");
		System.out.println("     3、退出系统");
	}

}

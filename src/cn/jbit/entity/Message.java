package cn.jbit.entity;

import java.util.Date;
/**
 * 留言实体类。
 * @author 北大青鸟
 *
 */
public class Message {

	private int id; // 留言id
	private String userName;// 留言人姓名
	private String title;// 留言标题
	private String contents;// 留言内容
	private String ip;// IP地址
	private Date createTime;// 创建时间

	/**
	 * 无参构造方法。
	 */
	public Message() {
	}

	/**
	 * 有参构造方法。
	 * 
	 * @param id  留言id
	 * @param userName  留言人姓名
	 * @param title 留言标题
	 * @param contents  留言内容
	 * @param ip IP地址
	 * @param createTime 创建时间
	 */
	public Message(String userName, String title, String contents,
			String ip, Date createTime) {
		this.userName = userName;
		this.title = title;
		this.contents = contents;
		this.ip = ip;
		this.createTime = createTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}

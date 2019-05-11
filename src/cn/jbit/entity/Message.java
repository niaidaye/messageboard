package cn.jbit.entity;

import java.util.Date;
/**
 * ����ʵ���ࡣ
 * @author ��������
 *
 */
public class Message {

	private int id; // ����id
	private String userName;// ����������
	private String title;// ���Ա���
	private String contents;// ��������
	private String ip;// IP��ַ
	private Date createTime;// ����ʱ��

	/**
	 * �޲ι��췽����
	 */
	public Message() {
	}

	/**
	 * �вι��췽����
	 * 
	 * @param id  ����id
	 * @param userName  ����������
	 * @param title ���Ա���
	 * @param contents  ��������
	 * @param ip IP��ַ
	 * @param createTime ����ʱ��
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

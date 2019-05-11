package cn.jbit.test;

import java.util.Scanner;

import cn.jbit.services.MessageService;
/**
 * Main类。
 * @author 北大青鸟
 */
public class Main {	
	public static void main(String[] args) {
		MessageService  messageService =new MessageService();
		System.out.println("----欢迎登录留言板系统---");
		while (true) {
			messageService.showMenu();
			System.out.println("请选择");
			Scanner input = new Scanner(System.in);
			int option = input.nextInt();
			switch (option) {
			case 1:
				messageService.showMessage();
				break;
			case 2:
				messageService.addMessage();
				break;
			default:
				System.out.println("谢谢使用，再见！");return;
			}
		}
	}
}

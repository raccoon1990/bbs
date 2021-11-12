package mms.member.ui;

import java.util.Scanner;

import mms.member.action.MemberAddAction;
import mms.member.controller.MemberController;
import mms.member.db.JdbcUtil;

public class MemberUI {

	public static void main(String[] args) {

		boolean isStop = false;
		MemberController controller = new MemberController();
		Scanner sc = new Scanner(System.in);
		
		do {
			
			System.out.println("1.회원등록");
			System.out.println("2.회원목록보기");
			System.out.println("3.회원정보수정");
			System.out.println("4.회원정보삭제");
			System.out.println("5.프로그램종료");
			System.out.print("메뉴번호 : ");
			int menu = Integer.parseInt(sc.nextLine());
			
			switch(menu) {
			
			case 1: 
				controller.processRequest(new MemberAddAction(), sc);
				break;
			case 2: break;
			case 3: break;
			case 4: break;
			case 5: isStop = true; break;
			default: System.out.println("옳지않은 메뉴 번호 입력\n");
			}
			
		} while (!isStop);
		System.out.println("프로그램 종료");
		
	}

}

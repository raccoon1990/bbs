package mms.member.ui;

import java.util.Scanner;

import mms.member.action.MemberAddAction;
import mms.member.action.MemberListAction;
import mms.member.action.MemberModifyAction;
import mms.member.action.MemberRemoveAction;
import mms.member.controller.MemberController;

public class MemberUI {
	public static void main(String[] args) {
		boolean isStop = false;
		MemberController memberController = new MemberController();
		Scanner sc = new Scanner(System.in);
		String menu = "=====회원관리 프로그램=====\n" + "1. 회원등록\n" + 
					  "2.회원목록보기\n" + "3.회원정보수정\n" + "4.회원정보삭제\n" + "5.프로그램종료";
		do {
			System.out.println(menu);
			System.out.print("메뉴 번호 : ");
			int select = sc.nextInt();
			switch (select) {
			case 1:
				memberController.processRequest(new MemberAddAction(), sc);
				break;
			case 2:
				memberController.processRequest(new MemberListAction(), sc);
				break;
			case 3:
				memberController.processRequest(new MemberModifyAction(), sc);
				break;
			case 4:
				memberController.processRequest(new MemberRemoveAction(), sc);
				break;
			case 5:
				isStop = true;
			}
		} while (!isStop);
	}
}
package mms.member.action;

import java.util.Scanner;

import mms.member.svc.MemberRemoveService;
import mms.member.util.ConsoleUtil;

public class MemberRemoveAction implements Action {
	private ConsoleUtil cu;
	private MemberRemoveService rs;

	public MemberRemoveAction() {
		cu = new ConsoleUtil();
		rs = new MemberRemoveService();
	}

	@Override
	public void execute(Scanner sc) throws Exception {
		System.out.println("삭제할 회원 이름을 입력하세요");
		String name = sc.next();
		if(rs.removeMember(name))
			cu.printRemoveSuccessMessage(name);
		else {
			cu.printRemoveFailMessage(name);
		}
	}
}

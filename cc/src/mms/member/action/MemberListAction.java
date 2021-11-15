package mms.member.action;

import java.util.ArrayList;
import java.util.Scanner;

import mms.member.svc.MemberListService;
import mms.member.util.ConsoleUtil;
import mms.member.vo.Member;

public class MemberListAction implements Action {
	private ConsoleUtil cu;

	private MemberListService ls;
	
	public MemberListAction() {
		cu = new ConsoleUtil();
		ls = new MemberListService();
	}

	@Override
	public void execute(Scanner sc) throws Exception {
		ArrayList<Member> memberList = ls.getMemberList();
		cu.printMemberList(memberList);
		
		
	}
}

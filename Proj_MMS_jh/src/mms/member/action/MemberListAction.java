package mms.member.action;

import java.util.ArrayList;
import java.util.Scanner;

import mms.member.svc.MemberListService;
import mms.member.util.ConsoleUtil;
import mms.member.vo.Member;

public class MemberListAction implements Action  {

	@Override
	public void execute(Scanner sc) throws Exception {
		
		ArrayList<Member> members = new ArrayList<Member>();
		ConsoleUtil cu = new ConsoleUtil();
		MemberListService mls = new MemberListService();
		
		members = mls.getMemberList();
		
		if(members.size() != 0) {
			cu.printMemberList(members);
		}
		else {
			cu.printSelectZeroMessage();
		}
	}
}

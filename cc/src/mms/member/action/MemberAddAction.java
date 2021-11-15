package mms.member.action;

import java.util.Scanner;

import mms.member.svc.MemberAddService;
import mms.member.util.ConsoleUtil;
import mms.member.vo.Member;

public class MemberAddAction implements Action {
	private ConsoleUtil cu;
	private MemberAddService as;
	
	public MemberAddAction() {
		cu = new ConsoleUtil();
		as = new MemberAddService();
	}
	@Override
	public void execute(Scanner sc) throws Exception {
		Member mb = cu.getNewMember(sc);
		boolean addComplete = as.addMember(mb);
		if (addComplete) {
			cu.printAddSuccessMessage(mb);
		} else {
			cu.printAddFailMessage(mb);
		}
	}
}

package mms.member.action;

import java.util.Scanner;

import mms.member.svc.MemberModifyService;
import mms.member.util.ConsoleUtil;
import mms.member.vo.Member;

public class MemberModifyAction implements Action {
	private ConsoleUtil cu;
	private MemberModifyService ms;

	public MemberModifyAction() {
		cu = new ConsoleUtil();
		ms = new MemberModifyService();
	}

	@Override
	public void execute(Scanner sc) throws Exception {
		String msgKind = "수정할 회원 이름 입력하세요";
		String name = cu.getName(msgKind, sc);
		Member mb = ms.getOldMember(name);
		mb = cu.getUpdateMember(sc, mb);
		boolean mm = ms.modifyMember(mb);
		if (mm) {
			cu.printAddSuccessMessage(mb);
		} else {
			cu.printAddFailMessage(mb);
		}
	}

}

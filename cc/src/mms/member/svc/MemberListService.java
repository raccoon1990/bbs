package mms.member.svc;

import java.util.ArrayList;

import mms.member.dao.MemberDAO;
import mms.member.db.JdbcUtil;
import mms.member.vo.Member;

public class MemberListService {
	MemberDAO dao = new MemberDAO(JdbcUtil.getConnection());

	public ArrayList<Member> getMemberList() {
		ArrayList<Member> memberList = dao.selectMemberList();
		return memberList;
	}
}

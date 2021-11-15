package mms.member.svc;

import mms.member.dao.MemberDAO;
import mms.member.db.JdbcUtil;
import mms.member.vo.Member;

public class MemberModifyService {
	MemberDAO dao = new MemberDAO(JdbcUtil.getConnection());

	public Member getOldMember(String name) {
		Member oldMember = dao.selectOldMember(name);
		return oldMember;
	}

	public boolean modifyMember(Member updateMember) {
		int upComplete = dao.updateMember(updateMember);
		if (upComplete > 0) {
			JdbcUtil.commit(JdbcUtil.getConnection());
			return true;
		} else {
			return false;
		}

	}
}

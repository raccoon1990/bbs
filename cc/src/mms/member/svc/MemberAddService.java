package mms.member.svc;

import mms.member.dao.MemberDAO;
import mms.member.db.JdbcUtil;
import mms.member.vo.Member;

public class MemberAddService {
	MemberDAO dao = new MemberDAO(JdbcUtil.getConnection());

	public boolean addMember(Member newMember) throws Exception {
		int result = dao.insertNewMember(newMember);
		if (result > 0) {
			JdbcUtil.commit(JdbcUtil.getConnection());
			return true;
		} else {
			return false;
		}
	}
}

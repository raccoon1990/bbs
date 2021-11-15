package mms.member.svc;

import java.sql.Connection;

import mms.member.dao.MemberDAO;
import mms.member.db.JdbcUtil;
import mms.member.vo.Member;

public class MemberModifyService {

	Connection conn = null;

	public Member getOldMember(String name) {

		Member oldMember = null;

		conn = JdbcUtil.getConnection();
		MemberDAO dao = new MemberDAO(conn);
		oldMember = dao.selectOldMember(name);

		return oldMember;
	}

	public boolean modifyMember(Member updateMember) {

		conn = JdbcUtil.getConnection();
		MemberDAO dao = new MemberDAO(conn);
		int count = dao.updateMember(updateMember);

		if (count > 0) {
			return true;
		}
		return false;
	}

}

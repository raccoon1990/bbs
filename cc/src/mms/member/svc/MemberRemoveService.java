package mms.member.svc;

import mms.member.dao.MemberDAO;
import mms.member.db.JdbcUtil;

public class MemberRemoveService {
	MemberDAO dao = new MemberDAO(JdbcUtil.getConnection());

	public boolean removeMember(String name) {
		int	rmComplete = dao.deleteMember(name);
		if (rmComplete > 0) {
			JdbcUtil.commit(JdbcUtil.getConnection());
			return true;
		} else {
			return false;
		}
	}
}
package mms.member.util;

import java.util.ArrayList;
import java.util.Scanner;

import mms.member.vo.Member;

public class ConsoleUtil {

	public Member getNewMember(Scanner sc) {
		System.out.println("등록할 회원 정보를 입력하세요");
		Member mb = new Member();
		System.out.print("이름 : ");
		mb.setName(sc.next());
		System.out.print("주소 : ");
		mb.setAddr(sc.next());
		System.out.print("국가 : ");
		mb.setNation(sc.next());
		System.out.print("이메일 : ");
		mb.setEmail(sc.next());
		System.out.print("나이 : ");
		mb.setAge(sc.nextInt());
		return mb;
	}

	public void printAddSuccessMessage(Member newMember) {
		System.out.println(newMember.getName() + " 회원 정보 추가 성공");
	}

	public void printAddFailMessage(Member newMember) {
		System.out.println(newMember.getName() + " 회원 정보 추가 실패");
	}

	public void printMemberList(ArrayList<Member> memberList) {
		if (memberList.size() > 0)
			for (Member m : memberList) {
				System.out.println(m.toString());
			}
		// size() : 컬렉션에 저장되어 있는 요소의 개수를 리턴하는 메소드
		else {
			System.out.println("등록된 회원 정보를 찾을 수 없습니다.");
		}
	}

	public String getName(String msgKind, Scanner sc) {
		System.out.println(msgKind);
		String name = sc.next();
		return name;
	}

	public Member getUpdateMember(Scanner sc, Member mb) {
		if (mb == null) {
			System.out.println("회원정보가 없습니다.");
			return mb;
		} else {
			System.out.print("이전 국가 : " + mb.getNation() + " ");
			System.out.print("수정할 국가 : ");
			mb.setNation(sc.next());
			System.out.print("이전 이메일 : " + mb.getEmail() + " ");
			System.out.print("수정할 이메일 : ");
			mb.setEmail(sc.next());
			System.out.print("이전 나이 : " + mb.getAge() + " ");
			System.out.print("수정할 나이 : ");
			mb.setAge(sc.nextInt());
			return mb;
		}
	}

	public void printModifySuccessMessage(Member updateMember) {
		System.out.println(updateMember.getName() + " 회원 정보 수정 성공.");
	}

	public void printModifyFailMessage(Member updateMember) {
		System.out.println(updateMember.getName() + " 회원 정보 수정 실패.");
	}

	public void printRemoveSuccessMessage(String name) {
		System.out.println(name + " 회원의 정보 삭제 성공.");
	}

	public void printRemoveFailMessage(String name) {
		System.out.println(name + " 회원의 정보 삭제 실패.");
	}

}
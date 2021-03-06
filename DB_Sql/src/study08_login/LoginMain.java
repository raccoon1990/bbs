package study08_login;

import java.util.Scanner;

public class LoginMain {

	public static void main(String[] args) {

		boolean isStop = false;
		Scanner scan = new Scanner(System.in);
		User user = null;

		do {
			System.out.println("로그인 화면입니다.");
			System.out.println("아이디와 비밀번호를 입력하세요.");
			System.out.print("아이디 : ");
			String id = scan.nextLine();

			System.out.print("비밀번호 : ");

			String passwd = scan.nextLine();

			LoginSVC lsvc = new LoginSVC();
			lsvc.connect();
			user = lsvc.login(id, passwd);

			if (user == null) {
				System.out.println("아이디나 비밀번호가 일치하지 않습니다.");
			} else {
				System.out.println("로그인한 사용자 정보");				
				System.out.println("아이디: " + id + ", 비밀번호: " + passwd + ", 이름 " + user.getName() + ", 나이: " + user.getAge() + ", 성별: " + user.getAddr() + ", 이메일: " + user.getEmail());
				isStop = true;

			}
		} while (!isStop);

	}

}

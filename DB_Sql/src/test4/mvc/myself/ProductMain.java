package test4.mvc.myself;

import java.util.Scanner;

public class ProductMain {

	public static void main(String[] args) {
		
		//DBConnect dc = DBConnect.getInstance();
		Scanner scan = new Scanner(System.in);
		boolean isStop = false;
		
		do {
		System.out.println("1.제품등록 2.제품검색 3.전체검색 4.수정 5.삭제 6.종료");
		int menu = Integer.parseInt(scan.nextLine());
		Service sc = new ServiceClass(new DaoClass());
		
		if(menu == 1) {
			sc.addProduct();
		}
		else if(menu == 2) {
			
		}
		else if(menu == 3) {
			
		}
		else if(menu == 4) {
			
		}
		else if(menu == 5) {
			
		}
		else if(menu == 6) {
			isStop = true;
		}
		else {
			
		}
		
		
		} while(!isStop);
		
		System.out.println("프로그램 종료");

	}

}

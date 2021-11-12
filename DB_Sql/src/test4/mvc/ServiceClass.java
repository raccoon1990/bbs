package test4.mvc;

import java.util.Scanner;
import java.util.Vector;

import test4.mvc.dao.Dao;
import test4.mvc.dto.Product;
import test4.mvc.service.Service;

public class ServiceClass implements Service {

	Dao dao;
	Scanner scan = new Scanner(System.in);

	public ServiceClass(Dao dao) {
		this.dao = dao;
	}

	@Override
	public void addProduct() {

		System.out.print("제품이름: ");
		String name = scan.nextLine();

		System.out.print("제품가격: ");
		int price = Integer.parseInt(scan.nextLine());

		Product p = new Product(name, price);
		dao.insert(p);

	}

	@Override
	public void delProduct() {

		System.out.print("삭제할 제품번호: ");
		int no = Integer.parseInt(scan.nextLine());
		dao.delete(no);

	}

	public void editProduct() {
		System.out.print("수정할 제품번호: ");
		int no = Integer.parseInt(scan.nextLine());
		getProduct();

		System.out.print("새 제품이름: ");
		String name = scan.nextLine();

		System.out.print("새 제품가격: ");
		int price = Integer.parseInt(scan.nextLine());

		Product p = new Product(name, price);
		dao.update(no, p);
	};

	@Override
	public Product getProduct() {

		System.out.print("검색할 제품번호: ");
		int no = Integer.parseInt(scan.nextLine());
		return dao.select(no);
	}

	@Override
	public Vector<Product> getProducts() {

		return dao.selectAll();
	}
}

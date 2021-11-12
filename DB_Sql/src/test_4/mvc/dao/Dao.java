package test_4.mvc.dao;

import java.util.Vector;

import test_4.mvc.dto.Product;

public interface Dao {

	//추상 메소드
		void insert(Product p);
		Product select(int num);
		Vector<Product> selectAll();
		void delete(int num);
		void update(int num,Product p);
}

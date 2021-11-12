package test4.mvc.myself;

import java.util.Vector;

public interface Dao {

	void insert(Product p);
	Product select(int num);
	Vector<Product> selectAll();
	void delete(int num);
	void update(int num, Product p);

}

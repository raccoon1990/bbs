package test_4.mvc.service;

import java.util.Vector;

import test_4.mvc.dto.Product;

public interface Service {

	 void addProduct();//insert
     Product getProduct();//select one
     Vector<Product> getProducts();//select all
     void delProduct();//delete
     void editProduct();//update
}

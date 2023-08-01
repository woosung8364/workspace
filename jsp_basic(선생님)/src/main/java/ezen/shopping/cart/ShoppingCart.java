package ezen.shopping.cart;

import java.util.LinkedList;
import java.util.List;

public class ShoppingCart {
	
	private List<Product> products;
	
	public ShoppingCart() {
		products = new LinkedList<Product>();		
	}
	
	public void addProduct(Product product) {
		products.add(product);
	}
	
	public List<Product> findAll(){
		return products;
	}

}







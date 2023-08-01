package ezen.shopping.cart;

public class Product {
	
	private String name;
	private int count;
	// 기타 필요한 속성들.....
	
	public Product() {}
	
	public Product(String name, int count) {
		this.name = name;
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", count=" + count + "]";
	}
	
}

package ezen.oop;


public class BoxExample {

	public static void main(String[] args) {
		
		Box<String> box = new Box<String>();
		box.setItem("qwerasdf");
		
		String item = box.getItem();
		System.out.println(item);
		
		
	}

}

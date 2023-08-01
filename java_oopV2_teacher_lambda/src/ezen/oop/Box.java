package ezen.oop;

/**
 * 제너릭타입(클래스) 정의
 * @author 김기정
 * @param <T>
 */
public class Box<T> {
	private T item;
	public Box(){}
	
	public Box(T item){
		this.item = item;
	}

	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	}

}





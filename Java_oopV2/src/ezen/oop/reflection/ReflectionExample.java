package ezen.oop.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionExample {

	public static void main(String[] args) throws ClassNotFoundException {

//		String message = "리플렉션이 뭐야?";
		Integer message = new Integer(50);
		

		
//		Class 인스턴스를 취득하는 방법
//		Class cls = message.getClass();
//		Class cls = Class.forName("java.lang.Integer");
		Class cls = Integer.class;
		
//		클래스 정보(메타) 분석
		System.out.println(cls.getName());
		System.out.println(cls.getSimpleName()); 
		Package pack = cls.getPackage();
		System.out.println(pack.getName());
	
//		부모클래스를 확인하는 방법
		System.out.println(cls.getSuperclass());

		//		클래스의 생성자 확인하는 방법
		Constructor[] cons = cls.getConstructors();
		for (Constructor constructor : cons) {
			System.out.println(constructor);
		}
		
//		클래스의 메소드를 확인하는 방법
		Method[] method = cls.getMethods();
		for (Method method2 : method) {
//			System.out.println(method2.getName());
			System.out.println(method2);

			//		블래스의 필드를 확인하는 방법	
		Field[] fields = cls.getFields();
		for (Method method3 : method) {
			System.out.println(method3);
		}
		}
		
		
	}

}

package ezen.oop.lambda;

public class SomeDo implements Calculable {
	
	
	@Override
	public void calculate(int x, int y) {
		// TODO Auto-generated method stub
		
	}
	
	public void action(Calculable calculable) {
		// 데이터 처리부
		int x = 10;
		int y = 4;
		calculable.calculate(x, y);
	}
	
	
	public void action2(Calculable2 calculable) {
		// 데이터 처리부
		int x = 10;
		int y = 4;
		int result=calculable.calculate(x, y);
		System.out.println("결과값:"  + result);
	}
	
	public void action3(Calculable2 calculable) {
		// 데이터 처리부
		int x = 10;
		int y = 4;
		int result=calculable.calculate(x);
		System.out.println("결과값:"  + result);
	}


	
}

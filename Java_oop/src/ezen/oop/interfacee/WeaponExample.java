package ezen.oop.interfacee;

public class WeaponExample {

	public static void main(String[] args) {
//		인터페이스는 추상클래스처럼 객체 생성은 X , 하지만 데이터 타입으로는 사용 가능.

//		Weapon weapon = new Gun();
//		weapon.attack();
//		
//		weapon = new Sword();
//		weapon.attack();
//		
//		weapon = new Club();
//		weapon.attack();
	
		Unit unit = new Unit("marin", new Gun());
		unit.offence();
		unit.offence();
		unit.offence();
		
		unit.setWeapon(new Sword());
		unit.offence();
		unit.offence();
		unit.offence();
		
		unit.setWeapon(new Club());
		unit.offence();
		unit.offence();
		unit.offence();
	}

}

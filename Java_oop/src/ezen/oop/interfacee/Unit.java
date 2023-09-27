package ezen.oop.interfacee;

public class Unit {

	private String name; 
	private Weapon weapon;
	
	
	public Unit () {}
	public Unit (String name, Weapon weapon) {
		this.name = name;
		this.weapon = weapon;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
	public Weapon getWeapon() {
		return weapon;
	}
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	@Override
	public String toString() {
		return "Unit [name=" + name + "]";
	}

	public void offence () {
		weapon.attack();
	}
	
	
}

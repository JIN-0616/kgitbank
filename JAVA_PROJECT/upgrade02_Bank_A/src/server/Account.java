package server;

public class Account {
	String id;
	String pass;
	
	int balance;
	
	public Account(String id) {
		this.id = id;
		pass ="1111";
		balance= 1000;
	}
	
	public boolean validate(String p) {
		return p.equals(pass);
	}
	
	public void modifyPass(String pass) {
		this.pass = pass;
	}
	
	public boolean addBalance(int ammo) {
		if(ammo>0) {
			balance += ammo;
			return true;
		}else {
			return false;
		}
	}
	
	public boolean subBalance(int ammo) {
		if(ammo>0 && ammo <= balance) {
			balance -= ammo;
			return true;
		}else {
			return false;
		}
	}
}

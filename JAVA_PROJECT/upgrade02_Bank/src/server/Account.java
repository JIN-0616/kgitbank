package server;

import java.io.Serializable;

public class Account implements Serializable{
	String id;
	String pass;
	
	int balance;
	
	public Account(String id) {
		this.id = id;
		balance= 1000;
	}
	
	public boolean validate(String p) { 	// 비밀번호 체크
		return p.equals(pass);
	}
	
	public void modifyPass(String pass) {	// 비밀번호 변경
		this.pass = pass;
	}
	
	public boolean addBalance(int ammo) {	// 돈 더하기
		if(ammo>0) {
			balance += ammo;
			return true;
		}else {
			return false;
		}
	}	
	public boolean subBalance(int ammo) {	// 돈 빼기
		if(ammo>0 && ammo <= balance) {
			balance -= ammo;
			return true;
		}else {
			return false;
		}
	}
}

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
	
	public boolean validate(String p) { 	// ��й�ȣ üũ
		return p.equals(pass);
	}
	
	public void modifyPass(String pass) {	// ��й�ȣ ����
		this.pass = pass;
	}
	
	public boolean addBalance(int ammo) {	// �� ���ϱ�
		if(ammo>0) {
			balance += ammo;
			return true;
		}else {
			return false;
		}
	}	
	public boolean subBalance(int ammo) {	// �� ����
		if(ammo>0 && ammo <= balance) {
			balance -= ammo;
			return true;
		}else {
			return false;
		}
	}
}

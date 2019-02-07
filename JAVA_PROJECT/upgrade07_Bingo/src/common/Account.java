package common;

import java.io.Serializable;

public class Account implements Serializable{		
	public String nick;
	public String pass;
	public int win;
	public int lose;
	public int roomNum;
	
	public String getPass() {
		return pass;
	}
	public Account(String nick, String pass) {
		this.nick=nick;
		this.pass=pass;
		win = lose = 0;
	}
	
	// ���۷����� �����ؼ� �������� ���ı�� ����
	
	@Override
	public String toString() {
		return nick +" : "+win+"�� "+lose+"��";
	}
	
	
	
}

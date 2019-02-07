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
	
	// 컴퍼레이터 생성해서 접속유저 정렬기능 생성
	
	@Override
	public String toString() {
		return nick +" : "+win+"승 "+lose+"패";
	}
	
	
	
}

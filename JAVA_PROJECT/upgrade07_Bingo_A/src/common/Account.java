package common;

import java.io.Serializable;

public class Account implements Serializable{
	public String nick;
	public String pass;
	public int win;
	public int lose;
	
	public String getPass() {
		return pass;
	}


	public Account(String nick, String pass) {
		this.nick = nick;
		this.pass = pass;
		win = lose = 0;
	}
	
	public String toString() {
		return "¡²"+nick+"¡³ " +win +"½Â " +lose+"ÆÐ";
	}
}





















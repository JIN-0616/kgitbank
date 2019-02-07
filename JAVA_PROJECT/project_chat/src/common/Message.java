package common;

import java.io.Serializable;

public class Message implements Serializable{
	String talker;
	String ment;
	long time;	
	
	public long getTime() {
		return time;
	}
	
	public Message(String talker, String ment) {
		this.talker = talker;
		this.ment = ment;
		this.time = System.currentTimeMillis();
	}
	
	public String toString() {
		return "¡²"+talker +"¡³" + ment;
	}
}

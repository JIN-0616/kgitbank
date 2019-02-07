package common;

import java.io.Serializable;

public class Message implements Serializable{
	String talker;
	String ment;
	long time;		// System.currentTimeMilliis()·Î ±â·Ï
	
	public Message(String talker, String ment) {
		this.talker = talker;
		this.ment = ment;
		this.time = System.currentTimeMillis();
	}
	public long getTime() {
		return time;
	}
	
	public String toString() {
		return " [ "+talker+" ] "+ment;
	}
}

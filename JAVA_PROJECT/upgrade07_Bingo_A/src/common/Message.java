package common;

import java.io.Serializable;

public class Message implements Serializable{
	String talker;
	String ment;
	long time;	// System.currentTimeMillis();  로 기록을 시켜두고..
	
	public Message(String talker, String ment) {
		this.talker = talker;
		this.ment = ment;
		this.time = System.currentTimeMillis();
	}
	
	public String toString() {
		return "〔"+talker +"〕" + ment;
	}
}

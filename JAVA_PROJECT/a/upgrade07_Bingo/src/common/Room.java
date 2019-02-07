package common;

import java.io.Serializable;
import java.util.List;
import java.util.Vector;

public class Room implements Serializable {
	static String[] titles;
	static {
		titles = new String[] { "페어플레이합시다.", "매너게임","일단 들어오세요.","스피드 한게임"};
	}

	public String title;	// 방제목
	
	public List<Account> joiner;
	
	public Room(Account owner, String title) {
		joiner = new Vector<>();
		joiner.add(owner);
		this.title = title;
	}
	
	public Room(Account owner) {
		this(owner, titles[(int)(Math.random()*titles.length)]);
	}
	
	public boolean enter(Account acc) {
		if(joiner.size()<2) {
			joiner.add(acc);
			return true;
		}else {
			return false;
		}
	}
	
	public boolean leave(Account acc) {
		return joiner.remove(acc);
	}
	
	public boolean isEmpty() {
		return joiner.size()==0;
	}
	
	public String toString() {
		Account creater = joiner.get(0);
		return  title +" 【" + creater.nick +" - "+ joiner.size() +"/2】";
	}
	
	
	
}

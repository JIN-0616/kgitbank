package common;

import java.io.Serializable;
import java.util.List;
import java.util.Vector;

public class Room implements Serializable {
	public String title;	
	public int idx;
	public List<Account> joiner;
	
	public Room(Account owner, String title) {
		joiner = new Vector<>();
		joiner.add(owner);
		this.title = title;
		
	}
	public Room(Account owner) {
		this(owner, owner.nick);
	}
	
	public Room(Account owner, Account talker) {
		this(owner, owner.nick+", "+talker.nick );				
	}
	
	public boolean leaved(Account acc) {
		return joiner.remove(acc);		
	}
	
	public boolean isEmpty() {
		return joiner.size()==0;
	}
	
	public String toString() {
		Account creater = joiner.get(0);
		return  title +" ¡¼" + creater.nick +" - "+ joiner.size() +"¡½";
	}
	
	
	
}

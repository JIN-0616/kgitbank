package common;

import java.io.Serializable;
import java.util.List;
import java.util.Vector;

public class Room implements Serializable {
	static String[] titles;
	static {
		titles = new String[] { "����÷����սô�.", "�ųʰ���","�ϴ� ��������.","���ǵ� �Ѱ���"};
	}

	public String title;	// ������
	
	public List<Account> joiner;
	
	public Room(Account owner) {
		this(owner, titles[(int)(Math.random()*titles.length)]);
	}
	
	public Room(Account owner, String title) {
		joiner = new Vector<>();	//��Ƽ������ ȯ����
		joiner.add(owner);
		this.title = title;
	}
	
	public boolean enter(Account acc) {
		if(joiner.size()<2) {
			joiner.add(acc);
			return true;
		}else {
			return false;
		}
		
	}
	
	public boolean leaved(Account acc) {
		return joiner.remove(acc);		
	}
	
	public boolean isEmpty() {
		return joiner.size()==0;
	}
	
	public String toString() {
		Account creater = joiner.get(0); 
		return "��" + title +" | ����:" + creater.nick +" | �����ο�:"+ joiner.size() +"/ 2�� ";
	}
	
	
	
}

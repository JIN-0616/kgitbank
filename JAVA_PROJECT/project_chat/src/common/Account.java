package common;

import java.io.Serializable;
import java.net.SocketAddress;
import java.util.List;

public class Account implements Serializable{
	String id;
	String nick;
	String pass;
	SocketAddress sock;	
	String passwordQuest;
	
	public List<Account> friendList;
	public List<Integer> roomNum;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public SocketAddress getSock() {
		return sock;
	}

	public void setSock(SocketAddress sock) {
		this.sock = sock;
	}

	public String getPasswordQuest() {
		return passwordQuest;
	}

	public void setPasswordQuest(String passwordQuest) {
		this.passwordQuest = passwordQuest;
	}

	public List<Account> getFriendList() {
		return friendList;
	}

	public void setFriendList(List<Account> friendList) {
		this.friendList = friendList;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	
	public String friendAdd(Account a) {
		friendList.add(a);
		return a.nick+ "등록 완료";
	}
	
	public String friendSub(Account a) {
		if (friendList.contains(a)) {
			friendList.remove(a);
			return a.nick+"등록 해제";
		} else {
			return a.nick+"은 등록되어있지 않습니다.";
		}
	}
	
	public String getPass() {
		return pass;
	}

	public Account(String id, String pass) {
		this.id = id;
		this.pass = pass;

	}
	public Account(String id, String pass, String quest) {
		this(id,pass);
		this.passwordQuest = quest;

	}
	
	public String toString() {
		return "〔"+nick+"〕";
	}
}





















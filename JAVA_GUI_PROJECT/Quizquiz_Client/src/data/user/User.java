package data.user;

import java.io.Serializable;
import java.util.List;

import data.gameRoom.GameRoom;

public class User implements Serializable {
	public static int inWaitingRoom = 100;
	public static int inGameRoom = 200;

	public String id;
	public String password;
	
	public String nickname;
	
	public int score;
	
	public List<User> friends;
	
	public boolean isOwner;
	public int location;
	
	public GameRoom gameRoom;
	public boolean myTurn;
	
	
	public User() {
		
	}
	
	public User(String id, String password) {
		this.id = id;
		this.password = password;
		isOwner = false;
	}
	public User(String id, String password, String nickname) {
		this.id = id;
		this.password = password;
		this.nickname = nickname;
		isOwner = false;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof User)) {
			return false;
		}
		
		User otherUser = (User) obj;
		
		if (this.id.equals(otherUser.id)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		if (this == null || this.id == null) {
			return -1;
		} else {
			return this.id.hashCode();			
		}
	}
	
	
	
}

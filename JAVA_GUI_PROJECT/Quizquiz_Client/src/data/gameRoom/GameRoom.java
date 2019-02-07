package data.gameRoom;

import java.io.Serializable;
import java.util.Hashtable;
import java.util.Map;

import data.user.User;

public class GameRoom implements Serializable {
	public String title;

	public static int number;
	public int maxPlayers;
	public int roomNumber;

	public boolean isFull;
	public boolean isStarted;

	public Map<User,Integer> joinedUsers;

	public GameRoom(int maxPlayers) {
		this.maxPlayers = maxPlayers;
		joinedUsers = new Hashtable<User,Integer>();
		isFull = false;
		isStarted = false;
		roomNumber = number;
		number++;
	}

	@Override
	public int hashCode() {		
		return this.roomNumber;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof GameRoom)) {
			return false;
		}
		
		GameRoom otherGameRoom = (GameRoom) obj;
		if (this.roomNumber == otherGameRoom.roomNumber) {
			return true;
		} else {
			return false;
		}
	}

}

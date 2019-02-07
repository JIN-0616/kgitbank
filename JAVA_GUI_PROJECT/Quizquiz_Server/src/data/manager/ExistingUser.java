package data.manager;

import java.io.*;
import java.util.*;

import data.user.User;

public class ExistingUser {
	private static ExistingUser existingUser;
	
	public static File savedUser;
	public static ObjectInputStream fileInput;
	public static ObjectOutputStream fileOutput;
	
	public static Set<User> existingUsers;
	
	static {
		existingUser = new ExistingUser();
		
		savedUser = new File("signed_up_users.txt");
		
	}
	
	private ExistingUser() {
		
	}
	
	synchronized public static ExistingUser getInstance() {
		return existingUser;
	}
	
	public static boolean uploadUsers() {
		try {
			fileInput = new ObjectInputStream(new FileInputStream(savedUser));
			existingUsers = (HashSet)fileInput.readObject();				
			System.out.println("[SERVER] user list uploaded success");
			fileInput.close();
			return true;
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("[SERVER] user list uploading failed");
			existingUsers = new HashSet<User>();
			User u = new User("1234", "1234","1234");
			User u2 = new User("aaa", "aaa", "aaa");
			User u3 = new User("bbb", "bbb", "bbb");
			
			existingUsers.add(u);
			existingUsers.add(u2);
			existingUsers.add(u3);
		//	e.printStackTrace();
			return false;
		}
	}
	
	public static boolean saveUsers() {
		try {
			fileOutput = new ObjectOutputStream(new FileOutputStream(savedUser));
			fileOutput.writeObject(existingUsers);
			System.out.println("[SERVER] user list saved success");
			fileOutput.close();
			return true;
		} catch (IOException e) {
			System.out.println("[SERVER] user list saved failed");
			e.printStackTrace();
			return false;
		}
	}
}

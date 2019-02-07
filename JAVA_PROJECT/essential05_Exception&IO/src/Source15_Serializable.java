import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class Item implements Serializable{
	String name;
	Item(String name){
		this.name = name;
	}
}

class User implements Serializable {
	String nick;
	int exp;
	int money;
	List<Item> li;

	User(String nick) {
		this.nick = nick;
		exp = 0;
		money = 500;
		li = new ArrayList<>();
	}

	void goHunt() {
		exp += (int) (Math.random() * 20);
		money += (1 + (int) (Math.random() * 10)) * 100; // 100~1000원?
		li.add(new Item("물약"));
	}
	// public String toString() .. User 상태 출력으로 바꿔주시고

	@Override
	public String toString() {
		return "이름 : " + nick + "\n경험치 : " + exp + "\n금액 : " + money + "\n";
	}
}

public class Source15_Serializable {
	public static void main(String[] args) {
		User u = new User("v해적왕v");
		System.out.println(u.toString());
		for (int cnt = 1; cnt <= 5; cnt++) {
			u.goHunt();
		}
		System.out.println(u.toString());

		// ------출력
		/*
		FileOutputStream out = null;
		BufferedOutputStream bout = null;
		ObjectOutputStream oout = null;

		try {
			File n = new File(u.nick);
			out = new FileOutputStream(n);
			bout = new BufferedOutputStream(out);
			oout = new ObjectOutputStream(bout);
			oout.writeObject(u);
			oout.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
		// 이 User를 ObjectOutput으로 출력
		// NotSerializableException 이 발생하면서 출력 실패가 뜰꺼임 (확인만)
		
		try(ObjectOutputStream oos 
				= new ObjectOutputStream(new FileOutputStream(u.nick))) {
			System.out.print("output try..");
			oos.writeObject(u);
			System.out.println("success!");
		} catch (IOException e) {
			System.out.println("failed.."+e.toString());
		}
		/* ############## 직렬화 / 역직렬화 -- Serializable ##############
		 * 모든 객체가 Object InOut 되는건 아니다.
		 * 					(TreeSet에 객체 저장할때와 같이...)
		 * byte(숫자)화 시킬수 있는 객체들에 한해서만 가능하다. (직렬화 가능한 객체)
		 * 
		 *  Comparable 붙여서 설계했던것 같이 별도로 작업이 필요한건 아니고,
		 *  implements Serializable 를 설정해두면 된다.
		 *  
		 *  단, 출력하고자 하는 객체가 Serializable 이어도 그 안에 설정된 데이터들이
		 *   Serializable이 아니면 실패가 뜬다. (다른객체를 물려서 사용할때도 같은경우)
		 *   List는 Serializable 이지만 String 이 아닌 Item객체의 경우에는 Serializable아니라서..
		 *  모든 구성요소를 Serializable 인 상황에서 가능한 이유
		 */
		
		
		// ------입력
		/*
		FileInputStream in = null;
		BufferedInputStream bin = null;
		ObjectInputStream oin = null;
		User nu = null;

		try {
			in = new FileInputStream(new File("해적왕.sav"));
			bin = new BufferedInputStream(in);
			oin = new ObjectInputStream(bin);
			nu = (User) oin.readObject();
			oin.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("load file data = \n" + nu.toString());
		*/
	}
}

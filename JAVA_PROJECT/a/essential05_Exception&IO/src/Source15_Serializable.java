import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class Item implements Serializable{
	String name;
	Item(String name) {
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
		money += (1 + (int) (Math.random() * 10)) * 100;
		li.add(new Item("����"));
	}
	// public String toString() ,, User ���� ������� �ٲ��ֽð�..

	@Override
	public String toString() {
		return nick + " [" + exp + " xp, ��" + money + "]";
	}
}

public class Source15_Serializable {
	public static void main(String[] args) {
		User u = new User("v������v");
		System.out.println(u.toString());
		for (int cnt = 1; cnt <= 5; cnt++) {
			u.goHunt();
		}
		System.out.println(u.toString());
		// �� User�� ObejctOutput���� ���!
		// NotSerializableException �� �߻��ϸ鼭 ��� ���а� �㲨��.
		try (ObjectOutputStream oos 
				= new ObjectOutputStream(new FileOutputStream(u.nick));) {
			System.out.print("output try..");
			oos.writeObject(u);
			System.out.println("success!");
		} catch (IOException e) {
			System.out.println("failed..  " + e.toString());
		}
		/*
		 * ��� ��ü�� Object InOut �Ǵ°� �ƴϴ�.
		 * 					(TreeSet�� ��ü �����Ҷ� ����..)
		 * byte(����)ȭ ��ų�� �ִ� ��ü�鿡 ���ؼ��� �����ϴ�. (����ȭ ������ ��ü)
		 * Comparable �ٿ��� �����ߴ��� ���� ������ �۾��� �ʿ��Ѱ� �ƴϰ�,
		 *   implements Serializable �� �����صθ� �ȴ�.   
		 *  ����ϰ��� �ϴ� ��ü�� Serializable �̿��� �� �ȿ� ������ ��ü���� Serializable ��
		 *  �ƴϸ� ���� �� ���.  
		 */
		
	}
}

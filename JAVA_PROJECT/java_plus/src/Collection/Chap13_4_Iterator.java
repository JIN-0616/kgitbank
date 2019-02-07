package Collection;
/*
	5. Iterator
	- Iterator�� �����ΰ��� "�ݺ��ϴ�" ��� �ǹ�,
	 Iterator ������ �Ϸ��� ��ҵ� �Ǵ� �����ΰ� ���� ���ִ� �͵���
	 ������� �����ϸ鼭 �ݺ����� �۾��� �ϰų�, ��ü�� �˻��ϴ� ó����
	 �����ϱ� ���� ����
	 
	- Iterator(�ݺ���)�� ��Ȱ : ��Ҹ� ������� �˻��ذ��� �������̽�(API)�� �����ϴ� ��Ȱ.
						(hasNext�޼ҵ�� ���� ��Ұ� �����ϴ��� ���θ� Ȯ���ϴ� ������ �����ϱ� ���� �߻� �޼ҵ��̸�,
						 next�� ���� ��Ҹ� ���� ���ִ� ������ �����ϱ� ���� �߻� �޼ҵ��̴�.)
						 
	- Iterator : ��� �÷��� ���� ��ҿ� �����ϴ� �������̽�
				List�� ���� ���ټ��� ����, ������ ����
				
	- ListIterator lit = list.listIterator(); //������ ����	
*/
import java.util.*;
public class Chap13_4_Iterator {
	public static void main(String[] args) {
		ArrayList li = new ArrayList();
		li.add("1");
		li.add("3");
		li.add("7");
		li.add("9");
		li.add("2");
		
		Iterator it = li.iterator();	//List��ü�κ��� iterator�� ������
		
		while(it.hasNext()) { // ���� ������ �����Ѵٸ�
			System.out.println(it.next());
			//���� ������ �����´�			
		}
		System.out.println("----------------------------");
		//it = li.iterator(); //ó������ �ٽ��ϱ� ���ؼ��� ���� �ҷ��;� �Ѵ�
		//System.out.println(it.next());
		
		ListIterator lit = li.listIterator(); // ���� ����
		while(lit.hasNext()) { // ���� ������ �����Ѵٸ�
			System.out.println(lit.next());
			// ���� ������ �����´�
		}
		while(lit.hasPrevious()) { //�ڿ� ������ �����Ѵٸ�
			System.out.println(lit.previous());
		}
	}
}

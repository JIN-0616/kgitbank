package Collection;
/*
	<List>
	������ �ִ� ������ ����(�ߺ��� ������)
	
	1. Vector
	
	-����ȭ ó���� ���������� �̷������
	
	-���� ��� �� �����忡�� � �۾��� �ϰ� ������ �ٸ� �����忡���� ������ �� ������ �ѹ��� �ϳ��� �����常 ����� �� �ֵ��� ���������� ó���ǰ� �ִ�.
	
	-���� �����忡���� ���ʿ��� ó�� �ڵ常 ������ �Ǳ� ������ ArrayList�� LinkedList�� ���� ���� ���ϸ� �������� �ȴ�.
	
	-����ȭ�� ����Ѵٸ� Vector�� ��� ���ٴ�  Collection.synchronizedCollection(Collection c) ��
	 sysnchronizedList, Map ���� ����ϴ� ���� ����.  
	
	2. ArrayList
	
	-���������� ���� ����ȭ ó���� ���� �ʴ´�.
	
	-����ȭ ó���� ���ؼ� Collection.synchronizedCollection�� ����ؾ� �Ѵ�.
	
	-�������� �߰�/���� �۾��� �߻����� ��, ���������� �迭 ���簡 �Ͼ��.(�����Ͱ� ���� ���� ���� ���ϰ� ����)
	
	-������ ���� ����� index�� ���� ������ �־ ���� �����͸� �˻��ϴµ� �����ϴ�.
*/
import java.util.*;

public class Chap13_1_List {
	public static void main(String[] args) {
		ArrayList l_1 = new ArrayList<>();
		List l_2 = new ArrayList<>();
		//List L_3 = new List() { };
		l_1.add(new Integer(5)); // Object ������ ó��
		l_1.add(new Integer(7)); 
		l_1.add(new Integer(4)); 
		l_1.add(new Integer(5)); 
		l_1.add(new Integer(3)); 
		l_1.add(new Integer(7)); 
		l_1.add(new Integer(2)); 
		
		ArrayList l_4 = new ArrayList(l_1.subList(1, 4)); //�Ϻθ� �����Ͽ� ����
		l_4.add(new Integer(0));
		l_1.set(2, new Integer(11));
		System.out.println(l_1.get(4)); // 3
		System.out.println(l_1);  // [5, 7, 11, 5, 3, 7, 2]
		System.out.println(l_4); // [7, 4, 5, 0]
		
		Collections.sort(l_1);				//���� Collections.sort()
		Collections.sort(l_4);  			//����---> ���� �ڷ����� �������� ����
		
		System.out.println(l_1); // [2, 3, 5, 5, 7, 7, 11]
		System.out.println(l_4); // [0, 4, 5, 7]

		l_1.remove(2);
		l_1.retainAll(l_4);		 // 1_4�� �ִ� �׸� �����ϰ� ������ ����
		System.out.println(l_1); // [5, 7, 7]   
		System.out.println(l_4); // [0, 4, 5, 7]
		
		for (int i = (l_4.size()-1); i >=0; i--) { //�ڿ��� ���� ���� ���ؼ�
			//l_4.size => ����Ʈ�� ��ü ����
			if(l_1.contains(l_4.get(i))) { // l_1.contains(���)--��Ұ� ����Ʈ�� �����ϴ°�
				l_4.remove(i);
			}
		}
		print(l_1,l_4); //[5, 7, 7] [0, 4]
	}
	static void print(ArrayList l_1, ArrayList l_2) {
		System.out.println(l_1);
		System.out.println(l_2);
	}
}

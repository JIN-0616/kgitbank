package Collection;
/*
	3. LinkedList
	
	-���������� ���� ����ȭ ó���� ���� �ʴ´�.
	
	-����ȭ ó���� ���ؼ� Collection.synchronizedCollection�� ����ؾ� �Ѵ�.
	
	-c�� ���Ḯ��Ʈ��� �����ϸ� �ȴ�.
	
	-�������� �߰�/���� �� , ����� ��ũ ���� �Ѱ��ָ� �Ǳ� ������, ���� ���� �����͵� ������ ó���� �����ϴ�.
	
	-������ ���� ����� index�� ���� ������ ���� �ʾƼ� ���� �����͸� �˻��� ��� ������ ������ �˻��� �ؾ��Ѵ�.
	(header���� �����ؼ� ��ũ�� ���󰡸� �˻�, ���� ���� ����)
	
	ArrayList : ������ ����
	
	LinkedList : ������� ����, �˻�
	
*/
import java.util.*;
public class Chap13_2_LinkedList {
	
	static void remove1(String name, List ls) { // ������ ����
		long tt = System.currentTimeMillis();
		for (int i = ls.size()-1; i >= 0; i--) {
			ls.remove(i);
		}
		System.out.println(name+" ��������: "+(System.currentTimeMillis()-tt));
	}
	
	static void remove2(String name, List ls) { // �� ������ ����
		long tt = System.currentTimeMillis();
		for (int i = 100; i >= 0; i--) {
			ls.remove(i);
		}
		System.out.println(name+" ���������: "+(System.currentTimeMillis()-tt));

	}
	
	static void add1(String name, List ls) { // ������ �Է�
		long tt =System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			ls.add(new Integer(i));
		}
		System.out.println(name +" �����Է� : "+(System.currentTimeMillis()-tt));
	}
	
	static void add2(String name, List ls) { // �� ������ �Է�
		long tt =System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			ls.add(500, new Integer(i));
		}
		System.out.println(name +" ������Է� : "+(System.currentTimeMillis()-tt));
	}
	
	public static void main(String[] args) {
		ArrayList ar = new ArrayList<>();
		LinkedList li = new LinkedList<>();
		
		add1("array",ar);
		add1("linked",li);
		
		add2("array",ar);
		add2("linked",li);
		
		remove2("array",ar);
		remove2("linked",li);
		
		remove1("array",ar);
		remove1("linked",li);
	}
}
/*

array �����Է� : 10
linked �����Է� : 0
array ������Է� : 120
linked ������Է� : 14
array ���������: 0
linked ���������: 0
array ��������: 6
linked ��������: 0

*/
/*
 * About. Object in java.lang Package
 * 	
 *  �ڹٿ��� �����ڰ� ����Ҽ� �ִ� ��ü���� ���� ��Ű�� ó���� ���ִ�.
 *  java.lang ��Ű�� �Ҽ��� ��ü���� import ó���� ���� �ʾƵ� ����� �� �ִ�. 
 * 	(������ �ڵ� �߰��� ���� �ʾƵ� �ڵ� ���Եȴ�.)
 * 
 * �� ��ü ��ü�� ũ�� �ǹ̰� �������� �ִ�. �����ؼ� ����ϴ� ��쵵 ���� ����.
 * � �뵵�� ��ü�ΰ�..?
 */

import java.lang.Object;	// Object��� �ܾ ctrl+click

public class Source02_Object {
	// main .. ctrl+space  enter 
	public static void main(String[] args) {
		Object obj = new Object();	
		
		String s = obj.toString();
		System.out.println("s = " + s);
		int c = obj.hashCode();
		// sysout  .. ctrl+space
		System.out.println("c = " + c);
		
		Object obj2 = new Object();
		boolean b = obj.equals(obj2);	// obj == obj2
		System.out.println("b = "+ b);
		obj2 = obj;
		boolean b2 = obj.equals(obj2);
		System.out.println("b2 = "+ b2);
		
		
	}
}
package sample;

import java.io.Console;
import java.util.Scanner;

public class LineBingoMain {
	public static void main(String[] args) {
		System.out.println("[SYSTEM] LINE BINGO START");
		/*
		 * LineBingo ��ü ������ ���� 
		 * ����ڷκ��� �Է¹޾ư��鼭 �� ��ü�� �����ؾߵǴµ�,
		 */
	//	System.console().readLine(); //	��Ŭ���������� �̷����� �Է�ó���� �ȵ�.
		
		// Console c = System.console();
		// c.readLine();	
		
		// Eclipse������ testing ������ �Է�ó���� �˾ƾ� �ȴ�.
		Scanner cin = new Scanner(System.in);	// ��ü �����ѹ����ѵΰ�,
		
		String in1 = cin.nextLine();	// ��ü.nextLine();
		System.out.println(in1);
		String in2 = cin.nextLine();	// ������ ������ų�ʿ�� ����, ���ѹ� �����ؼ� ����ϸ� �ȴ�.
		System.out.println(in1);		// readLine() ��ɰ� ���������� String���� �����ϱ�, Integer.valueOf(); ó��
		
		// ����ڿ� ����, toHiddenString / ������ ���κ��� toHiddenString
		
		// ���߿� �ϳ��� revealed �Ϸ�Ǹ� �Ѵ� toString
		
		
		
		
	}
}

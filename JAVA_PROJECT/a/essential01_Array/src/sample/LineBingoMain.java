package sample;

import java.io.Console;
import java.util.Scanner;

public class LineBingoMain {
	public static void main(String[] args) {
		System.out.println("[SYSTEM] LINE BINGO START");
		/*
		 * LineBingo 객체 여러개 만들어서 
		 * 사용자로부터 입력받아가면서 이 객체를 제어해야되는데,
		 */
	//	System.console().readLine(); //	이클립스에서는 이런식의 입력처리가 안됨.
		
		// Console c = System.console();
		// c.readLine();	
		
		// Eclipse에서도 testing 가능한 입력처리를 알아야 된다.
		Scanner cin = new Scanner(System.in);	// 객체 생성한번시켜두고,
		
		String in1 = cin.nextLine();	// 객체.nextLine();
		System.out.println(in1);
		String in2 = cin.nextLine();	// 여러번 생성시킬필요는 없고, 딱한번 생성해서 사용하면 된다.
		System.out.println(in1);		// readLine() 기능과 마찬가지로 String으로 나오니까, Integer.valueOf(); 처리
		
		// 사용자용 빙고도, toHiddenString / 상대방의 라인빙고도 toHiddenString
		
		// 둘중에 하나라도 revealed 완료되면 둘다 toString
		
		
		
		
	}
}

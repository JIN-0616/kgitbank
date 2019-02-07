package model;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class HangManMain {
	public static void main(String[] args) {
		String[] jewals = "DIAMOND,RUBY,EMERALD,PEARL,SAPPHIRE".split(",");
		//주제 정해서, 문자열 만들어서 이걸 가지고 반복을 돌면서
		//HangmanWord 객체 배열을 만드시고, 그중에서 랜덤으로
		//하나의 HangmanWord 객체를 뽑아서 게임이 시작되게 설정
		
		//행맨의 상태 출력
		//입력
		//mark하고 결과 알려주고
		//revealed 될때까지 혹은 life가 있을때까지 반복
		
		/*
		 * 문자를 입력받는 방법은 없고, String으로 받는데,
		 * 이 문자열이 정규식으로 대문자 1개인가 matches 체크해서
		 * 아니면 처리를 하지 말고, 맞을때만 처리해주고,
		 * 맞다면 입력받은 문자열에서 charAt(0); 하면 문자 입력이다.
		 */
		HangmanWord[] hg = new HangmanWord[jewals.length];
		for (int i = 0; i < jewals.length; i++) {
			hg[i] = new HangmanWord(jewals[i]);			
		}
		int a = (int)(Math.random()*(jewals.length-1));
		HangmanWord g = hg[a];
		
		Scanner c = new Scanner(System.in);
		
		LinkedHashSet<Character> set = new LinkedHashSet<Character>();
		LinkedHashSet<Character> mainset = new LinkedHashSet<Character>();
		for (char i = 'A'; i <= 'Z'; i++) {
			mainset.add(i);
		}
		
		System.out.println("HangmanGame Started");
//		StringBuilder re = new StringBuilder();;
				
		while(!g.isRevealed() && g.life!= 0) {
			System.out.println(g.toString());
			System.out.print("대문자 1글자 입력 : ");
			String in = c.nextLine();

			// 다른 기능 - 남은 문자를 공통적으로 표기함 
			if (in.matches("[A-Z]")) {
				boolean r = set.add(in.charAt(0));
				if(r) {					
					System.out.println(g.mark(in.charAt(0)));
				}
				System.out.print("	남은 문자 = ");
				mainset.removeAll(set);					
				System.out.println(mainset);
			}else {
				System.out.println("대문자 1글자 입력 : ");
			}
			
//			if (in.matches("[A-Z]")) {
//				boolean r = set.add(Character.valueOf(in.charAt(0)));
//				if(r) {					
//					System.out.println(g.mark(in.charAt(0)));
//				}else if(!r){
//					System.out.print("이미 입력한 글자 = ");
//					System.out.print(set.toString()+"\n");										
//				}
//			}else {
//				System.out.println("대문자 1글자 입력 : ");
//			}
			
//			if (in.matches("[A-Z]")) {
//				if(re.indexOf(in) == -1) {
//					re.append(in);
//					System.out.println(g.mark(in.charAt(0)));
//				}else if(re.indexOf(in) != -1){
//					System.out.print("이미 입력한 글자 = ");
//					System.out.print(new String(re+"\n"));
//										
//				}
//			}else {
//				System.out.println("대문자 1글자 입력 : ");
//			}
		}
		if(g.isRevealed()) {
			System.out.println();
			System.out.println("You Win!");
		}else if(g.life==0) {
			System.out.println();
			System.out.println("You Are DEAD");
		}
		System.out.println();
		System.out.println("HangmanGame Terminated");
		
		c.close(); // 원래는 클로스를 해줘야 하지만 주의할것
				   // 닫고나면 다시 생성해도 안되는 경우가 있음
		
		/*
		//teacher A
		String[] jewals = "DIAMOND,RUBY,EMERALD,PEARL,SAPPHIRE".split(",");
		HangmanWord[] words = new HangmanWord(jewals.length);
		for (int i = 0; i < jewals.length; i++) {
			words[i] = new HangmanWord(jewals[i]);		
		}
		
		HangmanWord w = words[(int)(Math.random()*words.length)];
		
		Scanner sin = new Scanner(System.in);
		while(w.life > 0) {
			System.out.println(w.toString() + " > ");
			String in = sin.nextLine();
			if(!in.matches("[A-Z]{1}")) {
				System.out.println("Invailed Characteres. Only 1 UpperCase Character.");
				continue;
			}
			char c = n.CharAt(0);
			boolean b = w.mark(c);
			System.out.println("mark result is "+b);
			
			if(w.isRevealed()) {
				break;
			}
			
		}
		*/
		
		
		
		
		
	}
}

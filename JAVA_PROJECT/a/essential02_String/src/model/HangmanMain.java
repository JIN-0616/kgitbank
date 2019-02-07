package model;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class HangmanMain {
	public static void main(String[] args) {
		int n;
		String[] jewels = "DIAMOND,RUBY,EMERALD,SAPHIRE".split(",");
		HangmanWord[] words = new HangmanWord[jewels.length];
		for(int i=0; i<jewels.length; i++) {
			words[i] =  new HangmanWord(jewels[i]);
		}
		
		HangmanWord w = words[(int)(Math.random()*words.length)];
		
		LinkedHashSet<Character> filter = new LinkedHashSet<Character>(); 
		
		Scanner cin = new Scanner(System.in);
		
		while(w.life > 0) {
			System.out.print(w.toString() +" > ");
			String in = cin.nextLine();
			if(!in.matches("[A-Z]{1}")) {
				System.out.println("Only 1 UpperCase Character plz.");
				continue;
			}
			char c = in.charAt(0);
			boolean r =filter.add(c);	// new Character(c)  , Character.valueOf(c);
			if(r) {
				boolean b = w.mark(c);
				System.out.println("mark result is " + b);
				
				if(w.isRevealed()) {
					break;
				}
			}else {
				System.out.println(c +" is alreay input / "+  filter.toString());
			}
		}
		// 주제를 정해서, 문자열 만들어서 이걸 가지고 반복을 돌면서
		// HangmanWord 객체 배열를 만드시고, 그중에서 랜덤으로
		// 하나의 HangmanWord 객체를 뽑아서 게임이 시작되게 설정
		
		// 행맨의 상태 출력
		// 입력
		// mark 하고 결과 알려주고
		// revealed 될때까지 혹은 life가 있을때까지 반복
		
		/*
		 * 문자를 입력받는 방법은 없고, String으로 받는데,
		 * 이 문자열이 정규식으로 대문자 1개 인가 matches 체크해서
		 * 아니면 처리를 하지 말고, 맞을때만 처리해주고,
		 * 맞다면 입력받은 문자열에서 charAt(0); 하면 문자 입력이다.
		 * 
		 */
	}
}

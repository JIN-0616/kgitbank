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
		// ������ ���ؼ�, ���ڿ� ���� �̰� ������ �ݺ��� ���鼭
		// HangmanWord ��ü �迭�� ����ð�, ���߿��� ��������
		// �ϳ��� HangmanWord ��ü�� �̾Ƽ� ������ ���۵ǰ� ����
		
		// ����� ���� ���
		// �Է�
		// mark �ϰ� ��� �˷��ְ�
		// revealed �ɶ����� Ȥ�� life�� ���������� �ݺ�
		
		/*
		 * ���ڸ� �Է¹޴� ����� ����, String���� �޴µ�,
		 * �� ���ڿ��� ���Խ����� �빮�� 1�� �ΰ� matches üũ�ؼ�
		 * �ƴϸ� ó���� ���� ����, �������� ó�����ְ�,
		 * �´ٸ� �Է¹��� ���ڿ����� charAt(0); �ϸ� ���� �Է��̴�.
		 * 
		 */
	}
}

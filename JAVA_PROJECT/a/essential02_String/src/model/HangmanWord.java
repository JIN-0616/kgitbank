package model;

public class HangmanWord {
	int life;
	
	String answer;	// char[] 
	StringBuilder builder;	// char[] (boolean[]) 로 처리해도 
	
	public HangmanWord(String a) {
		this.answer = a;
		life = 5;
		builder = new StringBuilder(answer);
		for(int i=0; i<builder.length(); i++) {
			builder.setCharAt(i, '?');
		}
	}
	
	public boolean mark(char c) {
		// answer 에 c 문자의 위치를 찾아서 bulider 같은 칸에 해당문자를 설정
		char[] ar = answer.toCharArray();
		boolean find = false;
		for(int i=0; i<ar.length; i++) {
			if(ar[i] == c) {
				builder.setCharAt(i, c);
				find = true;
			}
		}
		/*
		for(int i=0; i<answer.length(); i++) {
			if(answer.charAt(i)==c) {
				builder.setCharAt(i, c);
				find = true;
			}
		}*/
		if(find) {
			return true;
		}else {
			life--;
			return false;
		}
	}
	
	
	public String toString() {
		StringBuilder heart = new StringBuilder();
		for(int cnt=1; cnt<=life; cnt++) {
			heart.append("♥");
		}
		
		
		return builder.toString() + " (life:" + life+")";
	}
	
	public boolean isRevealed() {
		
		// builder.equals(answer)
		return builder.toString().equals(answer);
		
	}
	
	
}

package model;

public class HangmanWord {
	int life;
	
	String answer;	// char[] 
	StringBuilder builder;	// char[] (boolean[]) �� ó���ص� 
	
	public HangmanWord(String a) {
		this.answer = a;
		life = 5;
		builder = new StringBuilder(answer);
		for(int i=0; i<builder.length(); i++) {
			builder.setCharAt(i, '?');
		}
	}
	
	public boolean mark(char c) {
		// answer �� c ������ ��ġ�� ã�Ƽ� bulider ���� ĭ�� �ش繮�ڸ� ����
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
			heart.append("��");
		}
		
		
		return builder.toString() + " (life:" + life+")";
	}
	
	public boolean isRevealed() {
		
		// builder.equals(answer)
		return builder.toString().equals(answer);
		
	}
	
	
}

package model;

public class Idiom {
	static char[] ar;
	static {
		ar = new char[] {'��','��','��','ȭ','ȣ','��','õ','��','��','��','��','��','��' };
	}
	
	String answer;
	String hint;
	
	public Idiom(String answer, String hint) {
		this.answer = answer;
		this.hint = hint;
	}
	
	
	public String mixChars() {
		// 6�� ¥�� ���ڿ��� ����� �Ǵµ�,
		// ���� answer ���ڿ��� 4���ڴ� �ݵ�� ����, 
		// ������ 2���ڴ� static���� ������ ar���� 2�� �̾Ƽ� ���ڿ��� �����޶�.
		char[] s = new char[6];
		for(int i=0; i<answer.length(); i++) {
			s[i] = answer.charAt(i);	// 0,1,2,3
		}
		s[4] = ar[(int)(Math.random()*ar.length)];
		s[5] = ar[(int)(Math.random()*ar.length)];
		for(int cnt=1; cnt<=10; cnt++) {
			int i = (int)(Math.random()*s.length);
			int j = (int)(Math.random()*s.length);
			char c = s[i];
			s[i] = s[j];
			s[j] = c;
		}
		return new String(s);
	}
	
	public boolean mark(String input) {
		input.toCharArray();
		answer.toCharArray();
		
		return answer.equals(input);
	}
	
	public String toString() {
		// answer�� ù���ڿ� hint�� ���ļ� ���ڿ���		
		return hint+ " (" + answer.charAt(0) +"***)";
						// answer.substring(0, 1);
	}
	
	
	
	
	
	
	
}

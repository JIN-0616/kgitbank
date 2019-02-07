package model;

public class Idiom {
	static char[] ar;
	static {
		ar = new char[] {'가','금','원','화','호','세','천','지','수','월','명','몽','유' };
	}
	
	String answer;
	String hint;
	
	public Idiom(String answer, String hint) {
		this.answer = answer;
		this.hint = hint;
	}
	
	
	public String mixChars() {
		// 6자 짜리 문자열을 만들면 되는데,
		// 원래 answer 문자열의 4글자는 반드시 포함, 
		// 나머지 2글자는 static으로 설정된 ar에서 2개 뽑아서 문자열을 만들어달라.
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
		// answer의 첫글자와 hint를 합쳐서 문자열로		
		return hint+ " (" + answer.charAt(0) +"***)";
						// answer.substring(0, 1);
	}
	
	
	
	
	
	
	
}

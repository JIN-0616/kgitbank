
public class Exercise01_String {
	public static void main(String[] args) {
		String word = "타산지석"; // 난형난제
		/*
		 * word가 가지고 있는 char 들의 위치를 섞어서 새로운 문자열로 만들어달라
		 * 
		 */
		char[] ar = word.toCharArray();
		for (int cnt = 0; cnt < 10; cnt++) {
			int i = (int)(Math.random()*ar.length);
			int j = (int)(Math.random()*ar.length);
			char c = ar[i];
			ar[i] = ar[j];
			ar[j] = c;
		}
		String cword = new String(ar);
		System.out.println(cword);
		
		/* 안되네.. 뻗어버림
		char[] c = word.toCharArray();
		for (int i = 0; i < c.length; i++) {
			System.out.println(c[i]);
		}
		char[] cr = new char[c.length];
		boolean find = false;
		int idx = 0;
		for (int i = 0; i < cr.length; i++) {
			int rand = (int)(Math.random()*c.length);
			System.out.println(rand);
		}
		while(idx <c.length) {
			int rand = (int)(Math.random()*c.length);
			for (int i = 0; i < c.length; i++) {
				if(cr[i] == c[rand]) {
					find = true;
					break;				
				}
			}
			if(!find)
				cr[idx++] = c[rand];
		}
				
		String cword = "";
		cword = new String(cr);
		System.out.println(cword);
		*/
	}
}

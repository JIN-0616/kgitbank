
public class Exercise01_String {
	public static void main(String[] args) {
		String word= "난형난제";	// "난형난제"
		/*
		 *  word가 가지고 있는 char 들의 위치를 섞어서 바꿔서 새로운 문자열로 만들어달라.
		 * 
		 */
		char[] ar = word.toCharArray();
		for(int cnt=1; cnt<=10; cnt++) {
			int i = (int)(Math.random()*ar.length);
			int j = (int)(Math.random()*ar.length);
			char c = ar[i];
			ar[i] = ar[j];
			ar[j] = c;
		}
		String cword =new String(ar);
		System.out.println(cword);
		
	}
}

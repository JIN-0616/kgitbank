
public class Exercise01_String {
	public static void main(String[] args) {
		String word= "��������";	// "��������"
		/*
		 *  word�� ������ �ִ� char ���� ��ġ�� ��� �ٲ㼭 ���ο� ���ڿ��� �����޶�.
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

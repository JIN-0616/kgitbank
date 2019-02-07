import java.util.Scanner;

/*
 * �� é�Ϳ��� ���캼 ��ü�� ���ڿ��� ���õ� ��ü���̴�.
 * ���� ù��° �˾ƺ� ��ü��  String �̴�. 
 *  
 * 	���ڿ��� new ���� �����Ǵ� Ư���� ������ ��ü�� (�⺻�������� ����), 
 * 	���� String ��ü�� ���ڿ��� ���ο� char[] ���·� ������ �ϰ� �ִ�.  
 *  
 */
public class Source01_String {
	public static void main(String[] args) {
		// String ��ü�� ������ �����..
		char[] c = new char[] {'��','��','��','��'};
		System.out.println(c);	// char[] �迭�� ��½� ���ڰ����� ��µȴ�.
		
		String s = new String(c);	// ��ü char[] �� �� ����ؼ� �����,
		System.out.println(s);
		String s1 = new String(c, 2, 2);	// char[] , �迭�� ���۰�, ����
		System.out.println(s1);
		// String �������� ���ڿ� ��ü���� ���� �ִ�.
		String s2 = new String(c, 0, 4);	// ������ �����ϸ� ���α׷� ������ ���� 
		System.out.println(s2);
		System.out.println(s == s2);	// ���� ��ü�� �ƴ�.
		
		// new ���̵� String ��ü�� ��������µ�, 
		
		
		
		String c1 = "���α׷�";
		
		String r = s.intern();
		System.out.println("s code = " + System.identityHashCode(s));
		System.out.println("r code = " + System.identityHashCode(r));
		System.out.println(r == s);
		
		
		// �� String��ü �������ִ� char[]�� ���� ������ ��� �ִ� String ��ü�� ã���ִ� ��.
		// ������ ����� ��. 
		// ""�� ��� ���ڿ��� �����ϰ� �Ǹ� �˾Ƽ� String ��ü�� ������ �ǰ� ���ְ�,
		// ������� ��ü���� String ������ ����ȴ�.
		
		String c2 = "���α׷�";
		System.out.println("c1= "+ c1+ "/ c2= " + c2 );
		System.out.println(c1 == c2);	// true ? 
		// �ֵ���ǥ�� �̿��ؼ� ǥ���Ͽ� �ڵ� �����ǰ� �Ǵ� ���ڿ� ��ü����, 
		// ���� JVM�� ���ؼ� String pool ���� ������ �ǰ�, ���߿� �̹� �ѹ��̶� ������� ��ü���� �ٽ� ������ ���ϰ� 
		// �ش� ��ü���� �ٽ� ��Ȱ��ȴ�. (���� ��ü�� ���ȴ�)  

		/*
		 * System.identityHashCode();  JVM�� ���ؼ� �ο��� ���� ��ü���� ���� ��� 
		 */
		System.out.println( System.identityHashCode(s)  );
		System.out.println( System.identityHashCode(s2)  );
		System.out.println( System.identityHashCode(c1)  );
		System.out.println( System.identityHashCode(c2)  );
		
		System.out.println(s == c1);
		
		// String ��ü�� , ���� �������� char[] �� ���� ���ڵ�� ������ ���ִٰ� �ϴ���,
		// == ���� ��ü�İ� �����, false�� ��� �ִ�. (Ư����쿡�� true��� ����.)
		
		Scanner cin = new Scanner(System.in);	// ctrl+shift+o : import java.util.Scanner
		String input = cin.nextLine();	// ������Է°��� ���� String ��ü�� ��������.
		
		System.out.println(input == "1q2w3e" );	// "" �̷��� ǥ���ϴ°� JVM�� String��ü�� �����ؼ� ������.
												// ��ü�񱳰� �Ͼ�� ������ false��.
		
		// ���� ��ü������ �ñ��Ѱ� �ƴ϶�, char[] ���� ��ü�� ���İ� ����� ������,
			// equals �� ������ �صξ��� ������ , �̱���� �̿��ؼ� Ȯ���ϸ� �ȴ�.
		System.out.println(input.equals("1q2w3e") );
		System.out.println("1q2w3e".equals(input) );
		
		String[] ar = new String[5];
		for(int i=0; i<ar.length; i++) {
			System.out.println(ar[i] == null);
		}
		
		// String ��ü�� ����� ���� ���캸��.
		
	}
}







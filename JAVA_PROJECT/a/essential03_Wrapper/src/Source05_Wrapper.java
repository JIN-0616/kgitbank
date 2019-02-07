
public class Source05_Wrapper {
	public static void main(String[] args) {
		// Boolean
		String s1 = Boolean.toString(true);	// String.valueOf(true) 
		// Byte , Short .. 
		
		// Integer
		String s2 = Integer.toHexString(255);	// 16�����ڿ��� ������ش�.
		System.out.println(s2);
		String s3 = Integer.toBinaryString(10);	// 2�� ���ڿ�
		String s4 = Integer.toOctalString(16);			// 8�� ���ڿ�
		String s5 = Integer.toString(16);	// 10�� ���ڿ�
		int[] d = new int[] {2,8,10,16 };
		for(int i=0; i<d.length; i++) {
			System.out.println( "16 �� " + d[i] +"�� ���ڿ� ? "+ Integer.toString(16, d[i])  );
		}
		int n = Integer.parseInt("1a",16);
		System.out.println(n);
		// Long
		
		// Float, Double
		double r = 10.0/0.0;
		System.out.println(r);
		System.out.println(Double.isInfinite(r));
		double rr = Math.sqrt(-1);
		System.out.println(Double.isNaN(rr));
		
		// Character
		String str ="Jdk 1.8.181";
		char[] ar = str.toCharArray();
		for(int i=0; i<ar.length; i++) {
			char t = ar[i];
			System.out.println(t + " isWhitespace " + Character.isWhitespace(t));
			System.out.println(t + " toLowerCase " + Character.toLowerCase(t));
			System.out.println(t + " toUpperCase " + Character.toUpperCase(t));
			System.out.println(t + " isDigit " + Character.isDigit(t));
		}
		
		// ������ ���캼 ��ü�� �����ؼ�, ��� ����� ���� �ܿ��ʿ�� ����.
		// ��ɵ鿡 ���� �� ������ API ������ Ȯ���ؾ� �Ѵ�.
		// java.oracle.com   Essential links �� Java APIs   >> Java SE 8
		
	}
}



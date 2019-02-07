import javax.swing.plaf.synth.SynthSplitPaneUI;

public class Source05_Wrapper {
	public static void main(String[] args) {
		// Boolean
		String s1 = Boolean.toString(true); // String.valueOf(ture);
		// Byte , Short ...
		
		// Integer
		 	// - Integer -> String
		String s2 = Integer.toHexString(255); // int -> 16진 문자 string 변환
		System.out.println(s2); 
		String s3 = Integer.toBinaryString(10); // int -> 2진 문자 string 변환
		System.out.println(s3);
		String s4 = Integer.toOctalString(16); // int -> 8진 문자 string 변환
		System.out.println(s4);
		
		int[] d = new int[] {2, 8, 10, 16};
		for (int i = 0; i < d.length; i++) {
			System.out.println("16 의 "+d[i]+"진 문자열 "+ Integer.toString(16, d[i]));
		}
		 	// - String -> Int
		int n = Integer.parseInt("1a", 16); //
		System.out.println(n);
		
		// Long
		 
		// Float, Double
		double r = 10.0/0.0;
		System.out.println(r); // Infinity
		System.out.println(Double.isFinite(r));
		System.out.println(Double.isInfinite(r));
		double rr = 0.0/0.0;
		System.out.println(rr); // NaN
		double rrr = Math.sqrt(-1);
		System.out.println(rrr); //NaN
		System.out.println(Double.isNaN(rrr));
		/*
		컴퓨터 연산에서 NaN(Not a Number)은 연산 과정에서 잘못된 입력을 받았음을 나타내는 기호이다.
		특히 부동 소수점 연산에서 사용한다. 예를 들어서, 대부분의 부동 소수점 장치는 음수에 대해서
		제곱근을 구하려는 연산에 대해서 이것은 불가능(invalid)하다는 메시지와 함께 NaN 값을 반환한다.
		*/
		
		
		// Character
		String str = "Jdk 1.8.181";
		char[] ar = str.toCharArray();
		for (int i = 0; i < ar.length; i++) {
			char t = ar[i];
			System.out.println(t + " : "+ Character.isWhitespace(t)); // 공백인지? boolean
			System.out.println(t + " : "+ Character.toUpperCase(t)); // 대문자로(알파벳만)
			System.out.println(t + " : "+ Character.toLowerCase(t)); // 소문자로(알파벳만)
			System.out.println(t + " : "+ Character.isDigit(t)); // 수치문자인지 boolean
		}
		
		// 앞으로 살펴볼 객체들 포함해서, 모든 기능을 전부 외울 필요는 없다.
		// 기능들에 대해 더 보려면 API 문서를 확인해야 된다.
		// java.oracle.com - Essential link - Java APIs - ver찾아서 검색
	}
}

import java.util.Scanner;

/*
 * 이 챕터에서 살펴볼 객체는 문자열에 관련된 객체들이다.
 * 그중 첫번째 알아볼 객체는  String 이다. 
 *  
 * 	문자열은 new 없이 생성되는 특이한 형태의 객체로 (기본데이터형 같이), 
 * 	실제 String 객체는 문자열을 내부에 char[] 형태로 관리를 하고 있다.  
 *  
 */
public class Source01_String {
	public static void main(String[] args) {
		// String 객체를 만들어내는 방법들..
		char[] c = new char[] {'프','로','그','램'};
		System.out.println(c);	// char[] 배열은 출력시 문자값들이 출력된다.
		
		String s = new String(c);	// 전체 char[] 을 다 사용해서 만들고,
		System.out.println(s);
		String s1 = new String(c, 2, 2);	// char[] , 배열의 시작값, 개수
		System.out.println(s1);
		// String 변수에는 문자열 객체값이 들어가져 있다.
		String s2 = new String(c, 0, 4);	// 개수가 부족하면 프로그램 비정상 종료 
		System.out.println(s2);
		System.out.println(s == s2);	// 같은 객체는 아님.
		
		// new 없이도 String 객체는 만들어지는데, 
		
		
		
		String c1 = "프로그램";
		
		String r = s.intern();
		System.out.println("s code = " + System.identityHashCode(s));
		System.out.println("r code = " + System.identityHashCode(r));
		System.out.println(r == s);
		
		
		// 이 String객체 가지고있는 char[]과 같은 구성을 띄고 있는 String 객체를 찾아주는 것.
		// 없으면 등록이 됨. 
		// ""로 묶어서 문자열을 설정하게 되면 알아서 String 객체가 생성이 되게 되있고,
		// 만들어진 객체값이 String 변수에 저장된다.
		
		String c2 = "프로그램";
		System.out.println("c1= "+ c1+ "/ c2= " + c2 );
		System.out.println(c1 == c2);	// true ? 
		// 쌍따옴표를 이용해서 표기하여 자동 생성되게 되는 문자열 객체들은, 
		// 따로 JVM에 의해서 String pool 에서 관리가 되고, 나중에 이미 한번이라도 만들어진 객체들은 다시 생성을 안하고 
		// 해당 객체값이 다시 재활용된다. (같은 객체가 사용된다)  

		/*
		 * System.identityHashCode();  JVM에 의해서 부여된 실제 객체값을 얻어내는 방법 
		 */
		System.out.println( System.identityHashCode(s)  );
		System.out.println( System.identityHashCode(s2)  );
		System.out.println( System.identityHashCode(c1)  );
		System.out.println( System.identityHashCode(c2)  );
		
		System.out.println(s == c1);
		
		// String 객체는 , 실제 관리중인 char[] 에 같은 문자들로 구성이 되있다고 하더라도,
		// == 같은 객체냐고 물어보면, false가 뜰수 있다. (특정경우에만 true라고 나옴.)
		
		Scanner cin = new Scanner(System.in);	// ctrl+shift+o : import java.util.Scanner
		String input = cin.nextLine();	// 사용자입력값을 토대로 String 객체를 생성해줌.
		
		System.out.println(input == "1q2w3e" );	// "" 이렇게 표기하는건 JVM이 String객체를 생성해서 관리함.
												// 객체비교가 일어나기 때문에 false임.
		
		// 같은 객체인지가 궁금한게 아니라, char[] 구성 자체가 같냐고 물어보고 싶으면,
			// equals 로 구현을 해두었기 때문에 , 이기능을 이용해서 확인하면 된다.
		System.out.println(input.equals("1q2w3e") );
		System.out.println("1q2w3e".equals(input) );
		
		String[] ar = new String[5];
		for(int i=0; i<ar.length; i++) {
			System.out.println(ar[i] == null);
		}
		
		// String 객체의 기능을 좀더 살펴보자.
		
	}
}







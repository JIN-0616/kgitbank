/*
 * 
 */
public class Source06_StringBuilder {
	public static void main(String[] args) {
		/*
		 * StringBuilder 객체
		 * :사용하고자 하는 문자열을 효율적으로 만들어내고자 할때 사용하는 객체
		 * 
		 *  기본적으로 객체안에 구현된 기능은 String 과 거의 흡사함
		 *  추가적인 기능들이 있다.
		 *  
		 *  다른 점이 있다면 
		 *  내부에 가지고 있는 char[] 배열에 문자를 변경할수 있게 지원하며,
		 *  									길이도 알아서 조절이 된다.
		 *  
		 */
		
		/*
		 * 객체 생성은 기본(매개변수)없이도 도고, int도 되고, String도 됨
		 */
		StringBuilder sb = new StringBuilder("String"); 
		System.out.println(sb.length()); 	// int : 만들어내고 있는 문자열의 길이
		System.out.println(sb.capacity());  // int : 문자열을 만들기 위해서 생성한 char[]크기 (default=16)
											// StringBuilder (int) 		- 초기 char[] 생성크기 지정
											// StringBuilder (String)   - 문자열크기 +기본16크기 char 생성 및 String저장
		
		System.out.println(sb.append("String")); //내부에 차례대로 저장 +6
		System.out.println(sb.toString());		 // 만들고 있는 문자열을 String 화 시켜준다.
		sb.append("Builder");
		sb.append(true); 						 // 데이터를 문자열화 해서 char[] 배열의 맨뒤에 붙여나감
		
		System.out.println(sb.toString());
		System.out.println(sb.length());
		System.out.println(sb.capacity());
		
		//===============================================================
		String str = "";
		System.out.println(System.identityHashCode(str));
		str += "String";
		System.out.println(System.identityHashCode(str));
		str += "Builder is ";
		System.out.println(System.identityHashCode(str));
		str += true; 										//데이터지만 문자열화 시켜서 붙임
		System.out.println(System.identityHashCode(str)); 	// 객체값이 계속 바뀜
		System.out.println(str);
		
		// String객체는 한번 설정되면 변경이 불가능함, 내부적으로 계속 새로 생성되는 것
		
		// Immutable Class - String
		
		// String에는 없는 독특한 기능이 있다.
	}
}

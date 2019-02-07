/*
 * 
 */
public class Source06_StringBuilder {
	public static void main(String[] args) {
		/*
		 * StringBuilder 객체 
		 * 	사용하고자 하는 문자열을 효율적으로 만들어내고자 할때 사용하는 객체
		 * 
		 * 	기본적으로 객체안에 구현된 기능은 String 이랑 거의 흡사함.
		 * 	추가적인 기능들이 있다.
		 *  
		 *  다른점이 있다면 내부가지고 char[] 배열에 문자를 변경할수 있게 해두었고,
		 *	길이도 알아서 조절이 된다. 
		 * 
		 */
		/*
		 * 객체 생성은 기본(매개변수)없이도 되고, int도 되고, String도 됨.
		 */
		StringBuilder sb = new StringBuilder();	// 
		System.out.println(sb.length());	// int : 만들어내고 있는 문자열의 길이
		System.out.println(sb.capacity());	// int : 문자열을 만들기 위해서 생성한 char[] 배열 크기
		
		sb.append("String");
		System.out.println(sb.toString());	// 만들고 있는 문자열을 String 화 시켜준다.
		
		System.out.println(sb.length());	// int : 만들어내고 있는 문자열의 길이
		System.out.println(sb.capacity());	// int : 문자열을 만들기 위해서 생성한 char[] 배열 크기
		sb.append("Builder is ");
		sb.append(true);	// 데이터를 문자열화 해서 char[] 배열의 맨뒤에 붙여나감
		
		System.out.println(sb.toString());	// 만들고 있는 문자열을 String 화 시켜준다.
		System.out.println(sb.length());	// int : 만들어내고 있는 문자열의 길이
		System.out.println(sb.capacity());	// int : 문자열을 만들기 위해서 생성한 char[] 배열 크기
		
		//====================================================================
		String str = "";	
		System.out.println(System.identityHashCode(str));
		str += "String";	// str + "String"
		System.out.println(System.identityHashCode(str));
		str += "Builder is ";
		System.out.println(System.identityHashCode(str));
		str += true;
		System.out.println(System.identityHashCode(str));
		System.out.println(str);
		// String에는 없는 독특한 기능이 있다.
		
		
	}
}








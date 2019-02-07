
public class Source07_StringBuilder {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("JavaProgramming");
		// 지금 String 객체를 넘기면서 생성하면, toCharArray() 자신의 배열에 카피를 해둠.
		
		// 자신에게 설정된 char[] 을 제어할수 있게 해두었다.
		char c = sb.charAt(4);	// String도 처리를 해주던 기능이고,
		System.out.println(c);
		
		sb.delete(3, 6);	// 3<= 6 char 들을 없앤다.
		System.out.println(sb.toString()  + "/"+sb.length() );
		sb.deleteCharAt(0);
		System.out.println(sb.toString()  + "/"+sb.length());
		sb.insert(5, "BAAAM!");
		System.out.println(sb.toString()  + "/"+sb.length());
		
		sb.replace(0, 4, "?");
		System.out.println(sb.toString() + "/"+sb.length());
		sb.setCharAt(5, '尹');
		System.out.println(sb.toString() + "/"+sb.length());
		
		StringBuilder sbb = sb.reverse();
		System.out.println(sb.toString() + "/"+sb.length());
		System.out.println(sbb == sb);
		// 이 객체의 특이한 점? 
		// 조작을 하는 기능들의 대부분이 리턴이 StringBuilder 자신의 객체값인 this를 리턴시킨다.
		sb.reverse().insert(3, "123456").reverse();
		System.out.println(sb.toString());
		
		// StringBuffer 라는 객체도 있다. 이건 StringBuilder 하고 기능은 똑같다.
		// 자바 초창기 버전부터 존재하던 객체이고 이걸 개량시켜서 만들어둔게 StringBuilder 
		// 개량된 점은 Thread 를 다룰때 알게 된다.
		
		
	}
}




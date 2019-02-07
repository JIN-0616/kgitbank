
public class Source07_StringBuilder {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("JavaPrograming");
		// 지금 String객체를 넘기면서 생성하면, toCharArray() 자신의 배열에 카피를 해둠
		
		// 자신에게 설정된 char[] 을 제어할수 있게 해두었다.
		
		char c = sb.charAt(4);	// String도 처리를 해주던 기능
		System.out.println(c);
		
		sb.delete(3,6);					 	// delete(시작<= <끝) char 들을 제거하고 char[]를 자동정렬
		System.out.println(sb.toString()+"/"+sb.length());
		sb.deleteCharAt(0);
		System.out.println(sb.toString()+"/"+sb.length());
		
		sb.insert(5, "BAAAM!");				// insert(넣을위치idx, 넣을 내용)
		System.out.println(sb.toString()+"/"+sb.length());
		
		sb.replace(0,4,"?"); 				// replace(시작<=  <끝 , 바꿔넣을내용)
		System.out.println(sb.toString()+"/"+sb.length());
		sb.setCharAt(5, '＆');				// setCharAt(위치, char) 단일idx위치 내용 변경
		System.out.println(sb.toString()+"/"+sb.length());
		
		StringBuilder sbb = sb.reverse();	// reverse() 순서를 뒤집어서 동일객체 반환
		System.out.println(sb.toString()+"/"+sb.length());
		System.out.println(sbb == sb);
		/*
		 *     @Override
    			public StringBuilder reverse() {
        		super.reverse();
        		return this;
    			}
		 */
		
		// 이 객체의 특이한 점 ?
		// - 조작을 하는 기능들의 대부분의 리턴이 StringBuilder 자신의 객체값인 this를 리턴시킨다
		
		sb.reverse().insert(3,"12345").reverse(); // 따라서 이런 명령이 가능
		
		System.out.println(sb.toString()+"/"+sb.length());
		
		// StringBuffer  - jdk 1.0부터 사용
		// StringBuilder - jdk 1.5부터 사용
		
		// 현재 java 8 - 1.8.1.181
		// JDK 1.5 이후 String객체는 컴파일시 자동으로 StringBuilder로 변환되서 사용됨
		// 따라서 성능상의 차이는 많이 없다
		
		// StringBuffer 라는 객체도 있다. 이건 StringBuffer 하고 기능은 똑같다
		// 자바 초창기 버전부터 존재하던 객체이고 이걸 계량시켜서 만들어둔게 StringBuffer
		// 계량된 점은 멀티쓰레드 관련 사항, 멀티쓰레드 동기화를 지원하지 않는다.
		
		/*
		 * 1. 멀티 스레드 환경에서 문자열의 변환이 많을때 사용하면 좋을 클래스는? 
				답 : StringBuffer
				
		   2. 단일 스레드 환경에서 문자열의 변환이 많을 때 사용하면 좋을 클래스는?
				답 : StringBuilder
				
		   3. 문자열의 변환은 없고 읽기를 많이 할 경우 사용하면 좋을 클래스는?
				답 : String
				
 		   4. String, StringBuffer, StringBuilder 에서 객체의 생성이 시간과 메모리
 		      자원을 가장 많이 필요로 하는 클래스는?
				답 : StringBuffer
		 */
		//핵맨게임
	}
}

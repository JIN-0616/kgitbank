/*
 * 자바에서 Exception 객체들을 여러개를 설계해두었다.
 *  앞서 살펴본 RuntimeException 객체부터 해서, 
 *  IndexOutOfBoundsException, NullPointerException 객체 까지 수도 없이 많다.
 *  
 *  프로그램을 더이상 돌릴필요가 없다고 생각하는 상황을 객체로 정의 내려둔거기 때문에,
 *  그 상황에 따른 객체들을 세분화시켜 설계하다보니, 종류가 다양해진 것이다.
 */

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class Source02_Exception {
	public static void main(String[] args) {
		String str = "자바의 문자열";
		// str.substring(5, 2);
		// System.out.println(str.length());
		List<String> li = new ArrayList<>();	
		// li.add(3, "월요일");
		// 익셉션 객체를 이용해서 에러를 터뜨리게 해두면, 설계자 입장에서 무의미한처리를 안해도 되고, 
		// 객체를 쓰는 개발자 입장에서 조심해서 사용하기 때문에 좀더 안전한 프로그램을 만들어내려고 노력을
		// 하게 유도 할수 있다.
		
		/*
		 *  이 익셉션 객체는, 크게 두가지로 분류가 되는데,
		 *  
		 *  하나는 방치해도 되는 익셉션, (익셉션처리가 필수가 아님)
		 *  	JVM에 크게 악영향이 없고, if로 프로그램적으로 다 막아낼수 있는 것들이 많음.
		 *  
		 *  다른 하나는 방치해서는 안되는 익셉션 (익셉션처리가 필수임)
		 *  	실제 가동이 되바야만 아는 예외들로, 프로그램적으로 막아내는게 불가능하고
		 *  	실행이 어디서 되냐에 따라서 발생할수도 있고, 아닐수도 있는 예외들로
		 *  	이런 예외는 JVM쪽으로 들어가는걸 막아야만 하는 것들. 
		 *   	
		 *  
		 *  입출력에 관련된 객체들도 타 객체들이랑 마찬가지로, Exception 이 발생하긴 하지만,
		 *  여긴 거의 처리가 필수인 익셉션들 위주로 발생해서 처리법에 대해 알아야 한다.
		 */
		// Socket 객체는 통신에 사용되는 객체인데,
		// 꽤 많은 형태의 익셉션들이 발생되게 설계되있다.
		// UnknownHostException,  IOException , IllegalArgumentException , 이렇게 3개
		// 이중에서, 앞에2개가 필수 처리 익셉션, 뒤에 하나는 필수처리는 아님.
		// 앞에 두개의 익셉션은 처리를 하지 않으면 객체 사용이 불가능하다.
				
		try {
			new Socket("192.168.10.27", 135);	//
			System.out.println("객체 생성 성공");
		} catch(UnknownHostException e) {	// java.net
			System.out.println("UnknownHostException");
		} catch(IOException e) {	// java.io
			System.out.println("IOException");
		} catch(IllegalArgumentException e) {
			System.out.println("IllegalArgumentException");
		}
		
		System.out.println("메인 종료");
		
	}
}








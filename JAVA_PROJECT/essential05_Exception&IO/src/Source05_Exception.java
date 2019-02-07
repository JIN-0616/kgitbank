import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * 
 */
public class Source05_Exception {
	public static void main(String[] args) {
		/*
		 * catch로 익셉션 잡아서 어떤처리를 할꺼냐...?
		 * 
		 * 1. 에러메시지 찍어주고 프로그램 종료를 시키던지,
		 * 
		 * 2. 그 상황일때는 다른식으로 작동할수 있게 유도한다던지
		 * 
		 */
		
		/*
		 * 네트워크 프로그램을 만든다고 가정했을때, 연결이 안되면
		 *  더이상의 작업이 무의미하다.
		 */
		Socket s = null;
		try {
			s = new Socket("192.168.10.27",5040);
			System.out.println("try success");
		} catch (UnknownHostException e) {
			System.out.println(e.getMessage()); //익셉션 발생의 원인이 설정이 되있는데 그걸 확인해본다던지,
			System.exit(0);		//프로그램 강제종료
		} catch (IOException e) {
			System.out.println(e.toString()); //toString()으로 확인해본다던지,
			System.exit(0);		//프로그램 강제종료
		} 
		
		System.out.println(s.isConnected());
		//java.net.ConnectException: Connection timed out: connect
		//========================================================================
		//파일 세이브로드시 일어날수 있는 경우 (대체방안 작성)

		Triangle t = null;
		try {
			t = new Triangle(1, 2, 1);
			System.out.println("try success");
		} catch (NonTriangleException e) {
			System.out.println("try fail");
			t = new Triangle(1, 1, 1);
		} finally {
			System.out.println("finally object = " + t);
		}
		// try~catch 작업하면서 finally block 설정도 가능한데,
		// finally 처리한 부분은 try success 하던, fail을 하던 
		// 무조건 작동해야되는 작업을 설정할때 사용
	}
}

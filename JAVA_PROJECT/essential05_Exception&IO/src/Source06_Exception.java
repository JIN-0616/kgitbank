import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class Source06_Exception {
	public static void main(String[] args) {
		/*
		 * 객체 사용이 완료되고 나면, 안정성을 위해 특정작업을 꼭 처리하는 걸 권장하는 것들이 있다.
		 */

		Scanner cin = new Scanner(System.in);
		System.out.println(cin instanceof Closeable); // Closeable check 방법

		try { // try는 catch를 안하더라도 꼭 필요하다
			System.out.print("System> ");
			String line = cin.nextLine();
			String[] ar = line.split(" ");
			int s = 0;
			for (String a : ar) {
				s += Integer.parseInt(a);
			}
			System.out.println("SUM = " + s);
		} finally { // 꼭 필요한 작업같은 경우
			cin.close();
			System.out.println("Scanner closed");
		}
		// ==================================================
		// interface Closeable 을 받아서 입출력객체의 대부분이 만들어짐

		// close() 작업이 가능한 Closeable 객체에 한해서
		// 예전에는 finally로 항상 close 처리가 일어나게 했었는데
		// try( ) 안에 생성시켜서 사용한 객체들은 자동으로, close() 콜이 된다.

		//######################################################################
		
		// ** try ~ catch ~ finally 관련 tip **
		
		// try + ( )추가하고 자동close할 객체를 ()안에 선언+생성, 2개이상도 가능
		
		// stream 관련 객체들 --close해줘야 할 객체들에 한함
		
		//######################################################################

		// try with resource statement ( catch, finally 생략가능한 구문)
		
		try (CustomScanner cs1 = new CustomScanner();) {
			cs1.nextLine();
			if (Math.random() > 0.5) {
				throw new RuntimeException();
			}
		}
	}
}
//---------------------------------------------------------------------------------
class CustomScanner implements AutoCloseable {
	public String nextLine() {
		return "....";
	}
	@Override
	public void close() {
		System.out.println("CustoomScanner.close()");
	}
}
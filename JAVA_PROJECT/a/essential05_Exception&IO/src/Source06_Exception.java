import java.io.Closeable;
import java.io.IOException;
import java.util.Scanner;

public class Source06_Exception {
	public static void main(String[] args) {
		/*
		 * 객체 사용이 완료되고 나면, 안정성을 위해 특정작업을 꼭 처리하는 걸 권장하는
		 * 것들이 있다.
		 *   
		 */
		Scanner cin = new Scanner(System.in);
		System.out.println(cin instanceof Closeable);
		try {
			System.out.print("SYSTEM> ");
			String line = cin.nextLine();
			String[] ar = line.split(" ");
			int s=0;
			for(String a : ar) {
				s += Integer.parseInt(a);	// 
			}
			System.out.println("SUM = "+ s);
		}finally {
			cin.close();
			System.out.println("Scanner closed");
		}
		//==============================================================
		// close() 작업이 가능한 Closeable 객체에 한해서  
		// 예전에는 finally 로 항상 close 처리가 일어나게 했었는데,
		// try( ) 생성시켜서 사용한 객체들은 자동으로, close()까지 자동콜이 된다.

		// try with resource statement 
		try(CustomScanner cs = new CustomScanner();)	{
			cs.nextLine();
			cs.nextLine();
			if(Math.random()>0.0) {
				throw new RuntimeException();
			}
		}
	}
}
//=======================================================================


class CustomScanner implements AutoCloseable {
	public String nextLine() {
		return "....";
	}
	public void close()  {
		System.out.println("CustomScanner.close()");
	}
}




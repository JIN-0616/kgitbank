import java.io.Closeable;
import java.io.IOException;
import java.util.Scanner;

public class Source06_Exception {
	public static void main(String[] args) {
		/*
		 * ��ü ����� �Ϸ�ǰ� ����, �������� ���� Ư���۾��� �� ó���ϴ� �� �����ϴ�
		 * �͵��� �ִ�.
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
		// close() �۾��� ������ Closeable ��ü�� ���ؼ�  
		// �������� finally �� �׻� close ó���� �Ͼ�� �߾��µ�,
		// try( ) �������Ѽ� ����� ��ü���� �ڵ�����, close()���� �ڵ����� �ȴ�.

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




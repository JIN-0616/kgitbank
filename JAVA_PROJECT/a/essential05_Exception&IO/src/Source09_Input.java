/*
 * �̹����� ���Ϸκ��� �����͸� �о���̴� �۾��� �Ϸ��� �Ѵ�.
 */
import java.io.*;
public class Source09_Input {
	public static void main(String[] args) {
		
		try {
			FileInputStream fis = new FileInputStream("output.data");	// ������ ���� ���(����)�� ���� �Ҷ�
			// ������ ���ٰų�, ���͸��ų�, ������ ���ٸ�.
			System.out.println("try success");
			for(int cnt=1; cnt<=30; cnt++) {
				int a = fis.available();	// �� �о�� �ִ� �� 
				System.out.print("available = " + a);
				int r = fis.read();	// �̰���, �о ��
					// (������ 1byte, available ���� 0�϶��� -1 ) 
				System.out.println(" / read = " + r + "/ " + Integer.toHexString(r));
			}
			fis.close();
			// fis.read();
			FileInputStream fiss = new FileInputStream("output.data");
			// ����Ҷ��� test�� �������� byte[] �� ����� �ȴ�.
			for(int cnt=1; cnt<=12; cnt++) {
				byte[] b = new byte[3];
				System.out.print("avaiable = " + fiss.available());
				int r = fiss.read(b);	// byte[] �迭�� read ��Ű��
				System.out.println(" / read = " + r);
			}
			// �����б��� �⺻������ ���캸�Ҵ�.
			
			
		}catch(IOException e) {
			System.out.println("catch..!!! " +e.getMessage());
		}
	}
}

import java.io.FileOutputStream;
import java.io.IOException;

public class Exercise01_NoDataInOut {
	public static void main(String[] args) {
		System.out.println( 3 | -1 | 3 | 5);
		System.out.println( 13 | 1 | 2 | 25);
		System.out.println( 3 | -1 | -1 | -1);
		int r = (int)(Math.random()*456120);
		System.out.println("r = "+ r);
		// ���ڸ� ���� ��� ��Ű��, �ٽ� �ҷ��鿩�� ��.
		// DataInOut�� �Ⱦ���..?
		try {
			FileOutputStream fos = new FileOutputStream("number.dat");
			while(r>0) {
				fos.write(r%10);
				r /= 10;
			}
			fos.close();
			System.out.println("data output complete!");
		}catch(IOException e) {
			System.out.println("output failed");
		}
	}
}

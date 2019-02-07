import java.io.FileOutputStream;
import java.io.IOException;

public class Exercise01_NoDataInOut {
	public static void main(String[] args) {
		System.out.println( 3 | -1 | 3 | 5);
		System.out.println( 13 | 1 | 2 | 25);
		System.out.println( 3 | -1 | -1 | -1);
		int r = (int)(Math.random()*456120);
		System.out.println("r = "+ r);
		// 숫자를 파일 기록 시키고, 다시 불러들여야 됨.
		// DataInOut을 안쓰면..?
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

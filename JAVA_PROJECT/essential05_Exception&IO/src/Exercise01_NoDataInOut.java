import java.io.FileOutputStream;
import java.io.IOException;

public class Exercise01_NoDataInOut {
	public static void main(String[] args) {
		int r = (int)(Math.random()*456120);
		System.out.println("r = "+r);
		// 숫자를 파일 기록시키고, 다시 불러들여야 됨
		// DataInOut을 안쓰면..?
		try {
			FileOutputStream fos = new FileOutputStream("123.data");
			
			while(r>0) {
				fos.write(r%10);
				r /= 10;
			}
			fos.close();
			System.out.println("data output complete");
		} catch (IOException e) {
			System.out.println("output fail");
		}
		/* cf)
		 * 비트연산 & and, | or, ^ xor
		 * 
		 * 비트의 유효성검사
		 * 
		 * int의 경우
		 * 비트당 8*0=0 8*1=8 8*2=16 8*3=24 오른쪽부터 역순으로 
		 */
		
		//수동으로 하는 방법
		//결론 : 귀찮음
	}
}

/*
 *  이번에는 파일로부터 데이터를 읽어들이는 작업을 하려고 한다.
 */
import java.io.*;
public class Source09_Input {
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("output.data"); 
			// 읽을수 없는 대상(파일)을 지정할때 에러발생
			// 파일이 없을수도 있고, 디렉터리거나, 권한이 없다면 예외발생
			System.out.println("try success");
			for (int cnt = 1; cnt <= 30; cnt++) {
				int a = fis.available(); // 실제로 읽어낼수 있는 바이트크기 int값 리턴
										 // 더 읽어낼수 있는 (남아있는 byte크기)
				System.out.print("available "+a);
				int r = fis.read(); // 해당파일을 1바이트씩 읽어내기 int리턴
									// 이 값이 읽어낸 값
									// (파일의 1byte), available=0일때는 -1 리턴
				System.out.println(" / read = "+r);
			}
			/*
			available 25 / read = 0
			available 24 / read = 69
			available 23 / read = 153
			available 22 / read = 69
			available 21 / read = 64
			available 20 / read = 9
			available 19 / read = 33
			available 18 / read = 250
			available 17 / read = 252
			available 16 / read = 139
			available 15 / read = 0
			available 14 / read = 122
			available 13 / read = 1
			available 12 / read = 0
			available 11 / read = 9
			available 10 / read = 237
			available 9 / read = 153
			available 8 / read = 141
			available 7 / read = 234
			available 6 / read = 184
			available 5 / read = 184
			available 4 / read = 235
			available 3 / read = 143
			available 2 / read = 153
			available 1 / read = 30
			available 0 / read = -1
			available 0 / read = -1
			available 0 / read = -1
			available 0 / read = -1
			available 0 / read = -1
			 */
			fis.close();
			// fis.read(); // error
			FileInputStream fiss = new FileInputStream("output.data");
			// 출력할때는 test를 못했지만 byte[] 로 출력이 된다.
			for (int cnt = 0; cnt <= 11; cnt++) {
				byte[] b = new byte[3];
				System.out.print("available = "+fiss.available());
				int r = fiss.read(b);	
				//byte[] 배열로 read 시키면 얼마만큼 사용했는지 사용값 리턴
				System.out.println(" / read = "+r);
			}
			// 파일읽기의 기본원리를 살펴보았다.
			
			/*
			available = 25 / read = 3
			available = 22 / read = 3
			available = 19 / read = 3
			available = 16 / read = 3
			available = 13 / read = 3
			available = 10 / read = 3
			available = 7 / read = 3
			available = 4 / read = 3
			available = 1 / read = 1
			available = 0 / read = -1
			available = 0 / read = -1
			available = 0 / read = -1
			*/
			
		} catch (IOException e) {
			System.out.println("Catch..."+e.toString());
		}
		
	}
}

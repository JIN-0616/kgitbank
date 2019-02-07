/*
 * 이번에는 파일로부터 데이터를 읽어들이는 작업을 하려고 한다.
 */
import java.io.*;
public class Source09_Input {
	public static void main(String[] args) {
		
		try {
			FileInputStream fis = new FileInputStream("output.data");	// 읽을수 없는 대상(파일)을 지정 할때
			// 파일이 없다거나, 디렉터리거나, 권한이 없다면.
			System.out.println("try success");
			for(int cnt=1; cnt<=30; cnt++) {
				int a = fis.available();	// 더 읽어낼수 있는 양 
				System.out.print("available = " + a);
				int r = fis.read();	// 이값이, 읽어낸 값
					// (파일의 1byte, available 값이 0일때는 -1 ) 
				System.out.println(" / read = " + r + "/ " + Integer.toHexString(r));
			}
			fis.close();
			// fis.read();
			FileInputStream fiss = new FileInputStream("output.data");
			// 출력할때는 test를 못했지만 byte[] 로 출력이 된다.
			for(int cnt=1; cnt<=12; cnt++) {
				byte[] b = new byte[3];
				System.out.print("avaiable = " + fiss.available());
				int r = fiss.read(b);	// byte[] 배열로 read 시키면
				System.out.println(" / read = " + r);
			}
			// 파일읽기의 기본원리를 살펴보았다.
			
			
		}catch(IOException e) {
			System.out.println("catch..!!! " +e.getMessage());
		}
	}
}

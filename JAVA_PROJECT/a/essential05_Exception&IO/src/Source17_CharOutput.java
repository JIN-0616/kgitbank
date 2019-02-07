import java.io.FileOutputStream;
import java.io.IOException;

/*
 * DataOutput(Input) , ObjectOutput(Input) 은 
 * 	데이터를 유지시켜 나중에 다시 읽어낼 목적으로 입출력시 사용하는 객체다.
 * 
 *  출력의 목적이 로그파일같이 사람이 알아보게 문자인 경우가 있다. 
 * 
 */
public class Source17_CharOutput {
	public static void main(String[] args) {
		
		try(FileOutputStream fos = new FileOutputStream("output.log");) {
			System.out.println("[SYSTEM] READY");
			
			fos.write(  Integer.parseInt("B9", 16) );
			System.out.println(Integer.parseInt("B9", 16));
			fos.write(  Integer.parseInt("AE", 16) );
			System.out.println(Integer.parseInt("AE", 16));
			fos.write(13);
			fos.write(10);
			String d ="문자열 출력";
			byte[] b = d.getBytes();
			fos.write(b);
			
			System.out.println("[SYSTEM] DONE");
		}catch(IOException e) {
			System.out.println("exception !! " + e.toString());
		}
		
	}
}

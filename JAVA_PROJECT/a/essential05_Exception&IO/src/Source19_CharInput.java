import java.io.*;

public class Source19_CharInput {
	public static void main(String[] args) {
		// 파일의 적혀져있는 값들이 문자값인 경우는, 
		// 읽어서 문자로 만들어 확보하는것도 가능하다.
		
		File t = new File("arrayData.log");
		
		try (FileInputStream is = new FileInputStream(t);) {
			// Output 할때 문자의 byte값을 일일이 출력해도 문자로 확인 가능 하듯...
			byte[] ar = new byte[16];
			String s = "";
			while(is.available()>0) {
				int len = is.read(ar);	// byte[] 로 적당히 읽어서
				s += new String(ar, 0, len);	// 그걸로 문자열 조합해서
				System.out.println(is.available()+"..left");
			}
			System.out.println(s);	// 확인해볼수 있다. 
			// 중간에 깨지는 문자가 들어가져 있는건, 
			// 문자의 일부 byte만 읽혀지는 상황이 있어서 그렇다.
			
			// InputStreamReader를 사용하게 되면, 문자를 좀더 편하게 확보할수 있다. 
			
			
			
			
			
		}catch(IOException e) {
			System.out.println("input failed..");
		}
		
		
		
		
		
		
	}
}

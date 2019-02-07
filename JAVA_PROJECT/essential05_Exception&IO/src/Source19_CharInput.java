import java.io.*;

public class Source19_CharInput {
	public static void main(String[] args) {
		// 파일의 적혀져있는 값들이 문자값인 경우는,
		// 읽어서 문자로 만들어 확보하는것도 가능하다.
		
		// (Source17 Output <-> Source19 Input)
		
		File t = new File("arraydata.log");
		
		try (FileInputStream is = new FileInputStream(t)) {
			// Output 할때 문자의 byte값을 일일히 출력해도 문자로 확인 가능 하듯..
			
			// ==>  파일 바이트 찍어서 문자열로 읽어내기 (문자열만)
			byte[] ar = new byte[10];
			String s = "";
			while(is.available()>0) {
				int len = is.read(ar);	// byte[] 로 적당히 읽어서
				//s += new String(ar); ->이렇게 찍어내면 마지막부분이 깨짐
				
							//바이트배열사용크기 0~len까지
				s += new String(ar, 0, len); 	// 그걸로 문자열 조합해서
				System.out.println(is.available());
			}
			System.out.println(s);	//확인해볼수 있다.
			// 중간에 깨지는 문자가 들어가져 있는건,
			// 문자의 일부 byte만 읽혀지는 상황이 있어서 그렇다.
			
			// 내용이 깨질수도 있는데 byte[]함수의 크기값에 영향을 받음
			// -> 한 문자의 크기가 제각각 다름 (byte)
			
			// InputStreamReader를 사용하게되면, 이런 상황이 일어나지 않고 
			// 문자를 좀더 쉽게 확보 가능
			
		} catch (IOException e) {
			System.out.println("input fail...");
		}
	}
}

import java.io.*;

public class Source20_CharInput {
	public static void main(String[] args) {
		
		// InputStreamReader ?
		
		File t = new File("arrayData.log");
		try(
			InputStreamReader isr = new InputStreamReader(new FileInputStream(t));	
				) {
			String sum ="";
			
			// 완성문자 1개씩을 읽어냄 (읽어내는 크기가 다를수있음)
			// ==>byte크기가 유동적임, 대신 하나의 문자값이 나눠지지 않음
			for (int cnt = 1; cnt <= 10; cnt++) {
				int n = isr.read();
				System.out.println(n+" / " + (char)n);
				sum += (char)n;
			}
			char[] c = new char[10]; //available이 없으므로 이런방식으로밖에
			while(true) {
				int n = isr.read(c);
				if(n == -1)
					break;
				sum += new String(c, 0, n);
			}
			System.out.println(sum);
		} catch (IOException e) {
			System.out.println("[시스템] input fail...");
		}
		
		// Objectinput -> 객체단위
		// InputStreamReader -> 문자값단위(완성문자) -> char[]만들어짐 -> String 변환
	}
}

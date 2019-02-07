import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class Source21_CharInput {
	public static void main(String[] args) {
		/*
		 * 문자가 적혀져 있는 파일을 읽어내는데,  라인단위로 읽어내는게 필요할때가 있다.
		 * (로그 분석, 등등..)
		 * 
		 *  BufferedReader ?
		 */
		File t = new File("arrayData.log");
		try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(t)));) {
			// BufferedReader br = new BufferedReader(new FileReader(t));
			String str ="";
			while(true) {
				String tmp = br.readLine();	// 13,10 앞까지의 char 을 모아서 String 으로 만들어준다.
				// 더이상 읽을 byte가 없어서 문자열이 안만들어지면, null 을 반환.
				System.out.println("→ " + tmp);
				if(tmp == null)
					break;
				str += tmp;
			}
			System.out.println(str);
			
		}catch(IOException e) {
			System.out.println("[SYSTEM] IO ERROR");
		}
		
		
	}
}

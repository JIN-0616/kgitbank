import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Source22_PrintWriter {
	public static void main(String[] args) {
		/*
		 * PrintWriter 객체...?
		 * 		BufferedWriter의 Upgrade 버전
		 */
		try {
			OutputStreamWriter osw = new FileWriter("last-log.txt");
			// === > 기존 BufferedWriter 대신 바로			
			PrintWriter pw = new PrintWriter(osw); //자동 문자열 convert 출력
			pw.print("문자열 출력");
			pw.println("해보자!!");
			pw.println(Math.PI);
			pw.println(true);
			pw.println(44651);
					
			pw.close(); // close나 flush 하지 않으면 출력안됨
			System.out.println("# IO SUCCESS #");
		} catch (IOException e) {
			System.out.println("# IO ERROR #");
		}
	}
}

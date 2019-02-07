import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Source22_PrintWriter {
	public static void main(String[] args) {
		/*
		 *	PrintWriter 객체..? 
		 *		BufferedWriter의 Upgrade 버전 
		 */
		try {
			OutputStreamWriter osw = new FileWriter("last-log.txt");
			// ===> BufferedWriter 대신 , 
			PrintWriter pw = new PrintWriter(osw);
			pw.print("문자열 출력");
			pw.println("해보자!!");
			pw.println(Math.PI);
			pw.println(true);
			pw.println(44651);
			pw.close();
			System.out.println("# io success #");
		}catch(IOException e) {
			System.out.println("# io error#");
		}
	}
}


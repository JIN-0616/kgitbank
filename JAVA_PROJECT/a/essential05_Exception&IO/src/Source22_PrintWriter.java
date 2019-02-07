import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Source22_PrintWriter {
	public static void main(String[] args) {
		/*
		 *	PrintWriter ��ü..? 
		 *		BufferedWriter�� Upgrade ���� 
		 */
		try {
			OutputStreamWriter osw = new FileWriter("last-log.txt");
			// ===> BufferedWriter ��� , 
			PrintWriter pw = new PrintWriter(osw);
			pw.print("���ڿ� ���");
			pw.println("�غ���!!");
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


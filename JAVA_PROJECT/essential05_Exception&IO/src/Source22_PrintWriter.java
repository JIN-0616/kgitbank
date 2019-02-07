import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Source22_PrintWriter {
	public static void main(String[] args) {
		/*
		 * PrintWriter ��ü...?
		 * 		BufferedWriter�� Upgrade ����
		 */
		try {
			OutputStreamWriter osw = new FileWriter("last-log.txt");
			// === > ���� BufferedWriter ��� �ٷ�			
			PrintWriter pw = new PrintWriter(osw); //�ڵ� ���ڿ� convert ���
			pw.print("���ڿ� ���");
			pw.println("�غ���!!");
			pw.println(Math.PI);
			pw.println(true);
			pw.println(44651);
					
			pw.close(); // close�� flush ���� ������ ��¾ȵ�
			System.out.println("# IO SUCCESS #");
		} catch (IOException e) {
			System.out.println("# IO ERROR #");
		}
	}
}

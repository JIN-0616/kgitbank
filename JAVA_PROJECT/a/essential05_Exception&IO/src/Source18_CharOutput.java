import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Source18_CharOutput {
	public static void main(String[] args) {
		/*
		 * ������ ����� ���� �ְ� ����byte�� ����ؼ� ����ϴ°� ���ŷӱ� ������,
		 * OutputStreamWriter , InputStreamReader ��� ��ü�� �����ξ���.
		 * 
		 * OutputStreamWriter ���� BufferedWriter 
		 */
		try  {
			/*
			FileOutputStream fos = new FileOutputStream("output.log");
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			
			���ϰ��� ���, �ٷ� OutputStreamWriter �� ���� ������ ��ü�� ������� �ִ�.
			*/
			OutputStreamWriter osw = new FileWriter("ouput.log");
			
			BufferedWriter bw = new BufferedWriter(osw, 1);
			bw.write("�׷쵥���� v1.0\r\n");
			bw.write("======================================");
			bw.newLine();
			bw.write("# ��¤���� #");
			bw.newLine();
			bw.write("�� ���� ");
			bw.flush();
			bw.write("���� ����");
			bw.newLine();
			bw.newLine();
			bw.write("# �� #");
			/*
			osw.write('��');
			char[] data = new char[] {'��', '��', '��', '��','!','!'};
			osw.write(data);
			osw.write(13);
			osw.write(10);
			osw.write("[SYSTEM] ���ڿ� ���");
			osw.append('.');
			osw.append("....");
			*/
			bw.close();
			System.out.println("[SYSTEM] DONE");
		} catch (IOException e) {
			System.out.println("exception !! " + e.toString());
		}

	}
}

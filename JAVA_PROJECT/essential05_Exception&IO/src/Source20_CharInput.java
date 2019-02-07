import java.io.*;

public class Source20_CharInput {
	public static void main(String[] args) {
		
		// InputStreamReader ?
		
		File t = new File("arrayData.log");
		try(
			InputStreamReader isr = new InputStreamReader(new FileInputStream(t));	
				) {
			String sum ="";
			
			// �ϼ����� 1������ �о (�о�� ũ�Ⱑ �ٸ�������)
			// ==>byteũ�Ⱑ ��������, ��� �ϳ��� ���ڰ��� �������� ����
			for (int cnt = 1; cnt <= 10; cnt++) {
				int n = isr.read();
				System.out.println(n+" / " + (char)n);
				sum += (char)n;
			}
			char[] c = new char[10]; //available�� �����Ƿ� �̷�������ιۿ�
			while(true) {
				int n = isr.read(c);
				if(n == -1)
					break;
				sum += new String(c, 0, n);
			}
			System.out.println(sum);
		} catch (IOException e) {
			System.out.println("[�ý���] input fail...");
		}
		
		// Objectinput -> ��ü����
		// InputStreamReader -> ���ڰ�����(�ϼ�����) -> char[]������� -> String ��ȯ
	}
}

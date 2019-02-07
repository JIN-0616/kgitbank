import java.io.*;

public class Source19_CharInput {
	public static void main(String[] args) {
		// ������ �������ִ� ������ ���ڰ��� ����,
		// �о ���ڷ� ����� Ȯ���ϴ°͵� �����ϴ�.
		
		// (Source17 Output <-> Source19 Input)
		
		File t = new File("arraydata.log");
		
		try (FileInputStream is = new FileInputStream(t)) {
			// Output �Ҷ� ������ byte���� ������ ����ص� ���ڷ� Ȯ�� ���� �ϵ�..
			
			// ==>  ���� ����Ʈ �� ���ڿ��� �о�� (���ڿ���)
			byte[] ar = new byte[10];
			String s = "";
			while(is.available()>0) {
				int len = is.read(ar);	// byte[] �� ������ �о
				//s += new String(ar); ->�̷��� ���� �������κ��� ����
				
							//����Ʈ�迭���ũ�� 0~len����
				s += new String(ar, 0, len); 	// �װɷ� ���ڿ� �����ؼ�
				System.out.println(is.available());
			}
			System.out.println(s);	//Ȯ���غ��� �ִ�.
			// �߰��� ������ ���ڰ� ���� �ִ°�,
			// ������ �Ϻ� byte�� �������� ��Ȳ�� �־ �׷���.
			
			// ������ �������� �ִµ� byte[]�Լ��� ũ�Ⱚ�� ������ ����
			// -> �� ������ ũ�Ⱑ ������ �ٸ� (byte)
			
			// InputStreamReader�� ����ϰԵǸ�, �̷� ��Ȳ�� �Ͼ�� �ʰ� 
			// ���ڸ� ���� ���� Ȯ�� ����
			
		} catch (IOException e) {
			System.out.println("input fail...");
		}
	}
}

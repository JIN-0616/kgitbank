import java.io.*;

public class Source19_CharInput {
	public static void main(String[] args) {
		// ������ �������ִ� ������ ���ڰ��� ����, 
		// �о ���ڷ� ����� Ȯ���ϴ°͵� �����ϴ�.
		
		File t = new File("arrayData.log");
		
		try (FileInputStream is = new FileInputStream(t);) {
			// Output �Ҷ� ������ byte���� ������ ����ص� ���ڷ� Ȯ�� ���� �ϵ�...
			byte[] ar = new byte[16];
			String s = "";
			while(is.available()>0) {
				int len = is.read(ar);	// byte[] �� ������ �о
				s += new String(ar, 0, len);	// �װɷ� ���ڿ� �����ؼ�
				System.out.println(is.available()+"..left");
			}
			System.out.println(s);	// Ȯ���غ��� �ִ�. 
			// �߰��� ������ ���ڰ� ���� �ִ°�, 
			// ������ �Ϻ� byte�� �������� ��Ȳ�� �־ �׷���.
			
			// InputStreamReader�� ����ϰ� �Ǹ�, ���ڸ� ���� ���ϰ� Ȯ���Ҽ� �ִ�. 
			
			
			
			
			
		}catch(IOException e) {
			System.out.println("input failed..");
		}
		
		
		
		
		
		
	}
}

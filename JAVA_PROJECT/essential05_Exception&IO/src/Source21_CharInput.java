import java.io.*;

public class Source21_CharInput {
	public static void main(String[] args) {
		/*
		 * ���ڰ� ������ �ִ� ������ �о�µ�,���δ����� �о�°� �ʿ��Ҷ��� �ִ�.
		 *  (�α׺м�, ���...)
		 *  
		 *   BufferedReader ? 
		 */
		File t = new File("arrayData.log");
		try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(t)));) {
			// BufferedReader br = new BufferedReader(new FileReader(t));
			String str = "";		
			while(true) {
				String tmp = br.readLine();// 13,10 �ձ����� char �� ��Ƽ� String���� ����� ���� (�����б�)
				// ���̻� ���� byte�� ��� ���ڿ��� �ȸ��������, null�� ��ȯ.
				System.out.println("-> "+tmp);
				if(tmp == null)
					break;
				str += "\n"+tmp;
			}
			System.out.println(str);		
			
		}catch (IOException e) {
			System.out.println("[SYSTEM] IO ERROR");
		}
				
	}

}

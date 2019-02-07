import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

/*
 * 
 *	share ���������� access_log.txt ������ �غ��صξ���.
 *	�� ���Ͽ��� ���ڵ��� �о�� IP �� ��ûȸ�� ��踦 ���޶�.
 *		/ �� ������ ��û�� ���� IP �� ���� �� ���ص� �ȴ�.
 *	
 *
 */
public class Exercise03_CharInput {
	public static void main(String[] args) {
		System.out.println("[�ý���] �α� �м� ����");
		try(BufferedReader br = new BufferedReader(new FileReader("access_log.txt"));){
			int cnt=0;
			Set<String> ips = new LinkedHashSet<>();
			for(;;) {
				String line = br.readLine();
				if(line == null) 
					break;
				
				String[] datas = line.split(" ");
				
				String ip =  datas[0];
				ips.add(ip);
				cnt++;
			}
			System.out.println("[�ý���] �м� ��� (�� ������ : " + cnt+")");
			System.out.println("[�ý���] �� ��û �ּ� : " + ips.size() );
			for(String e : ips) {
				System.out.println("[�ý���] " +  e);
			}
			
		}catch (IOException e) {
			System.out.println("[�ý���] �м� ����. " + e.toString());
		}
		
		
		
		
		
	}
}

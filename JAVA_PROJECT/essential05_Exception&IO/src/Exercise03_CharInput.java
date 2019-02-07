import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * Share ���������� access_log.txt ������ �غ��صξ���. 
 * �� ���Ͽ��� ���ڵ��� �о�� ip�� ��ûȸ�� ��踦 �� �޶�.
 * 			/�� ������ ��û�� ���� IP�� ������ ���ض�.
 */

public class Exercise03_CharInput {
	public static void main(String[] args) {
		// �α����� �м��� ���ؼ� ���δ��� �Է��� �޾ƾ� �ϴ� ���
		// ==> readLine() 
		// ù��° ���鹮��ã�� -> �ű���� substring .. => [0��°] ������ ����
		// �����Ǻ� count --> Map ��� ��õ 
		// ī���ռ� ���¿� ����� ��
		File log = new File("access_log.txt");
		Map<String, List<String>> map = new HashMap<>();
		String str = "";
		try(BufferedReader br = new BufferedReader(new FileReader(log));) {
			while(true) {
				String a = br.readLine();
				if(a == null)
					break;
				String[] ar = a.split(" ");
				if(map.containsKey(ar[0])) {
					map.get(ar[0]).add(a);
				}else {
					List<String> list = new ArrayList<>();
					map.put(ar[0], list);
					list.add(a);
				}
			}
			
		} catch (IOException e) {
			System.out.println("[SYSTEM] IOE input Error");
		}
		Set<String> key = map.keySet();
		
		for (String s : key) {
			System.out.println(s+" => "+map.get(s).size());			
		}
	}
}

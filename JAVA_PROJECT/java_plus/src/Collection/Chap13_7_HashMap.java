package Collection;
/*
	3. Map
	Ű-�� ���� ����ϴ� �÷���, Ű�� ������ ������ ã�� ���� �߿��� �� ���� �ٸ� Ű�� ���� ���� ����
	���� �ߺ�����, Ű �ߺ��Ұ�
	
	 1.HashMap
	 -Map�� �⺻��	 
*/
import java.util.*;

public class Chap13_7_HashMap {
	public static void main(String[] args) {
		HashMap map = new HashMap<>();
			map.put("�嵿��", new Integer(80));
			map.put("�۽���", new Integer(70));
			map.put("����", new Integer(60));
			map.put("�̺���", new Integer(80));
			map.put("����", new Integer(50)); 
			// Ű�� �ߺ��ɼ� ������ �Ǹ������� �ش��ϴ� ������ �Է�
			
			System.out.println(map.get("����"));
			if (map.containsKey("����")) {
				System.out.println("����");
			} else {
				System.out.println("����");
			}
		
		HashMap data = new HashMap();
			data.put("aaa", "1234");
			data.put("bbb", "1234");
			data.put("ccc", "5678");
			data.put("ddd", "5678");
			data.put("eee", "9876");
		// Ű�� �ߺ��� ��� ������ �Էµ� ������ ����
		// ���� �ߺ��ǵ� ��� ����
			
		Scanner sc = new Scanner(System.in);
		String id, pw;
		while(true) {
			System.out.print("ID:");
			id=sc.nextLine();
			System.out.print("PW:");
			pw=sc.nextLine();
			if (!data.containsKey(id)) {
				System.out.println("id Ȯ�ιٶ�");
			} else if (!data.get(id).equals(pw)) {
				System.out.println("pw Ȯ�ιٶ�");
			} else {
				System.out.println(id+"�� �α��� �ϼ̽��ϴ�.");
				break;
			}			
		}
	}
}

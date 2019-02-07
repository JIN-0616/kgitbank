import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

public class Source03_Json {
	public static void main(String[] args) {
		// ���ڿ��� JSON ���ڿ��̸� �̰� Gson �� ������ ��ü�� ������.
		Gson gson = new Gson();
		String s1 = "true";
		Boolean b = gson.fromJson(s1, Boolean.class);
		System.out.println(b);
		String s2 = "[11,22,33,5,79]";	// �迭������ ������ǥ��
		int[] ar = gson.fromJson(s2, int[].class);
		for(int a: ar) {
			System.out.println("��" + a);
		}
		Hero h = new Hero("�տ���", 7, true);
		String s3 =gson.toJson(h);
		System.out.println(s3);
		Hero hh = gson.fromJson(s3, Hero.class);
		System.out.println(hh.name);
		System.out.println(hh.type);
		System.out.println(hh.special);
		// �� ���ڿ��� ������ �÷����� ���鶧�� ������,
		List li = gson.fromJson(s2, List.class);	// ���ڴ� Double ��
		for(Object obj : li) {
			System.out.println((obj instanceof Integer) +" / " + (obj instanceof Double));
		}
		String s4 = "[11,3.14,true,11]";	// �̷������� ǥ�Ⱑ �����ؼ�.
		Map map = gson.fromJson(s3, Map.class);
		System.out.println(map.get("name") instanceof String);	
		System.out.println(map.get("type") instanceof Double);
		System.out.println(map.get("special") instanceof Boolean);
		//=========================================================================
		
		
		
		
	}
}

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

public class Source03_Json {
	public static void main(String[] args) {
		
		// ���ڿ��� JSON ���ڿ��̸� �̰� GSON �� ������ ��ü�� ������.
		
		// ���ڿ��м� -> ��ü����
		
		Gson gson = new Gson();
		String s1 = "true";
		boolean b = gson.fromJson(s1, Boolean.class); //��ü��.class
		System.out.println(b);
		
		String s2 = "[11,22,33,5,79]"; //�迭������ ������ǥ��
		int[] ar = gson.fromJson(s2, int[].class);
		for(int a : ar) {
			System.out.println("-> "+a);
		}
		
		Hero h = new Hero("�տ���", 1, false);
		String s3 = gson.toJson(h);
		System.out.println(s3); 		//{"name":"�տ���","type":1,"special":false}
		
		Hero hh = gson.fromJson(s3, Hero.class);
		System.out.println(hh.name);
		System.out.println(hh.type);
		System.out.println(hh.special);
		
		// �� ���ڿ��� ������ �÷����� ���鶧�� �����ε�,
		List li = gson.fromJson(s2, List.class); //���ڴ� Double�� (���׸� ������ �ȵ�)
		for (Object obj : li) {
			System.out.println((obj instanceof Integer) + " / "+(obj instanceof Double));
		}
		// why?
		String s4 = "[11,3.14,true,11]"; // List�� ���ʸ������� ���ϸ� ���Ÿ���� ��
										 // �̷� ������ ǥ�Ⱑ �����ؼ�
		
		Map map = gson.fromJson(s3, Map.class);
		System.out.println(map.get("name") instanceof String); 
													// �⺻ Object ��ȯ ==>���� ���ʸ����� �Ұ�
		System.out.println(map.get("type") instanceof Double); 
													// ���ڴ� ������ Double ��ȯó��
		System.out.println(map.get("special") instanceof Boolean); 
		
		
		
		
		
		
		
		
		
		/*         ��.... �ϴ� ����
		//gson.fromJson(s2, Integer.class); //�Ұ� error
		// list�� double�� ������?
		List<Double> li = gson.fromJson(s2, List.class);
		for(double a : li) {
			System.out.println("->"+ a);
		}
		*/
	}
}

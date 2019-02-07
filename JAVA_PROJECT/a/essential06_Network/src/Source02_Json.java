import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

/*
 * ȿ������ ������ ������ ����, ���̺귯���� Ȱ���� ����.
 * 	��������\share �� gson-2.8.5.jar �� ���� ���� 
 * java ��ġ ���� jre�� lib ext ������ �־����.	
 *
 * 
 * build path �� library tab �� JRE System library ���� Ŭ��
 * 	�� 2��°�� alternate jre �� install jre �� ����Ŭ�� �� restore default
 * 
 * JRE System library �ʿ� , gson-2.8.5.jar �� ���̸� �ȴ�.
 */
public class Source02_Json {
	public static void main(String[] args) {
		// json ���ڿ� ����ٰų�, json ���ڿ� ���� ��ü�� ������ ���̺귯��
		Gson gson = new Gson();	
		// �⺻ ������, �迭(List), �÷���, ��
		String s1 = gson.toJson(true);
		System.out.println(s1);
		String s2 = gson.toJson(13);
		System.out.println(s2);
		String s3 = gson.toJson("���ڿ�");
		System.out.println(s3);
		
		int[] ar = new int[] {1,34,543 ,45};
		String s4 = gson.toJson(ar);
		System.out.println(s4);
		
		List<String> li = new ArrayList<>();
			li.add("������");
			li.add("ȭ����");
			li.add("������");
		String s5 = gson.toJson(li);
		System.out.println(s5);
		// Map �� �ϳ� ����, � put�صΰ�, toJson���� ����
		
		Map<String, Object> map = new HashMap<>();
			map.put("name", "����ȣ");
			map.put("age", 17);
			map.put("admin", true);
		String s6=	gson.toJson(map);
		System.out.println(s6);
		
		Hero h= new Hero("����", 1, true);
		String s7 = gson.toJson(h);
		System.out.println(s7);
		
		
		
		
	}

}

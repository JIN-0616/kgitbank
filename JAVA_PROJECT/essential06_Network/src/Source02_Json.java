import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.google.gson.Gson;

/*
 * ȿ������ ������ ������ ����, ���̺귯���� Ȱ���� ����.
 *  ��������\share �� gson-2.8.5.jar
 *  
 * JAVA ��ġ ���� jre�� lib ext ������ �־����.
 * ���۾� - config build path
 * 
 * Build Path -> library tab -> JRE System library ����Ŭ�� ->
 * 		2��°�� alternate JRE -> ����Ŭ��, restore default
 */
public class Source02_Json {
	public static void main(String[] args) {
		// json ���ڿ� ����ٰų�, json ���ڿ� ���� ��ü�� ������ ���̺귯��
		// json --> ���� ���Ǵ� ������ ǥ���
		Gson gson = new Gson();
		// �⺻ ������, �迭(List), �÷���, ��
		String s1 = gson.toJson(true);
		System.out.println(s1);					//true
		String s2 = gson.toJson(13);
		System.out.println(s2);					//13
		String s3 = gson.toJson("���ڿ�");
		System.out.println(s3);					//"���ڿ�"
		//������ ǥ���Ŀ� ���� ���� �˷���
		
		int[] ar = new int[] {1,34,543,45};
		String s4 = gson.toJson(ar);			//[1,34,543,45]
		System.out.println(s4);
		
		List<String> li = new ArrayList<>();
			li.add("������");
			li.add("ȭ����");
			li.add("������");
		String s5 = gson.toJson(li);
		System.out.println(s5); 				//["������","ȭ����","������"]
		
		// Map�� �ϳ� ����, � put�صΰ�, toJson���� ����
		
		Map<String ,String> map = new TreeMap();
			map.put("A", "1");
			map.put("B", "2");
			map.put("C", "3");
		String s6 = gson.toJson(map);
		System.out.println(s6);					//{"A":"1","B":"2","C":"3"}
		
		Map<String, Object> map2 = new HashMap<>();
			map2.put("name", "����ȣ");
			map2.put("age", "17");
			map2.put("admin", true);
		String s7 = gson.toJson(map2);
		System.out.println(s7);					//{"name":"����ȣ","admin":true,"age":"17"}

			
		Hero g = new Hero("����", 1, true);
		String s8 = gson.toJson(g);
		System.out.println(s8); 				//{"name":"����","type":1,"special":true}

		// ������ �����͸� ������ ���ϰ�, �޾Ƽ� ��üȭ��Ű�� ����
		
		// �ܺ� ���̺귯�� -- �߰��۾� �ʿ���
			
			
	}

}

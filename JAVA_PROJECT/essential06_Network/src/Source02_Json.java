import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.google.gson.Gson;

/*
 * 효율적인 데이터 전송을 위해, 라이브러리를 활용해 보자.
 *  공유폴더\share 에 gson-2.8.5.jar
 *  
 * JAVA 설치 폴더 jre의 lib ext 폴더에 넣어두자.
 * 수작업 - config build path
 * 
 * Build Path -> library tab -> JRE System library 더블클릭 ->
 * 		2번째꺼 alternate JRE -> 더블클릭, restore default
 */
public class Source02_Json {
	public static void main(String[] args) {
		// json 문자열 만든다거나, json 문자열 토대로 객체를 만들어내는 라이브러리
		// json --> 공통 사용되는 데이터 표기법
		Gson gson = new Gson();
		// 기본 데이터, 배열(List), 컬렉션, 맵
		String s1 = gson.toJson(true);
		System.out.println(s1);					//true
		String s2 = gson.toJson(13);
		System.out.println(s2);					//13
		String s3 = gson.toJson("문자열");
		System.out.println(s3);					//"문자열"
		//데이터 표기방식에 관한 것을 알려줌
		
		int[] ar = new int[] {1,34,543,45};
		String s4 = gson.toJson(ar);			//[1,34,543,45]
		System.out.println(s4);
		
		List<String> li = new ArrayList<>();
			li.add("월요일");
			li.add("화요일");
			li.add("수요일");
		String s5 = gson.toJson(li);
		System.out.println(s5); 				//["월요일","화요일","수요일"]
		
		// Map을 하나 만들어서, 몇개 put해두곡, toJson으로 변경
		
		Map<String ,String> map = new TreeMap();
			map.put("A", "1");
			map.put("B", "2");
			map.put("C", "3");
		String s6 = gson.toJson(map);
		System.out.println(s6);					//{"A":"1","B":"2","C":"3"}
		
		Map<String, Object> map2 = new HashMap<>();
			map2.put("name", "윤형호");
			map2.put("age", "17");
			map2.put("admin", true);
		String s7 = gson.toJson(map2);
		System.out.println(s7);					//{"name":"윤형호","admin":true,"age":"17"}

			
		Hero g = new Hero("루피", 1, true);
		String s8 = gson.toJson(g);
		System.out.println(s8); 				//{"name":"루피","type":1,"special":true}

		// 복잡한 데이터를 보내기 편하고, 받아서 객체화시키기 편함
		
		// 외부 라이브러리 -- 추가작업 필요함
			
			
	}

}

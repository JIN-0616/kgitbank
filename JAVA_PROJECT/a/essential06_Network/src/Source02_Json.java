import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

/*
 * 효율적인 데이터 전송을 위해, 라이브러리를 활용해 보자.
 * 	공유폴더\share 에 gson-2.8.5.jar 를 가져 간후 
 * java 설치 폴더 jre의 lib ext 폴더에 넣어두자.	
 *
 * 
 * build path → library tab → JRE System library 더블 클릭
 * 	→ 2번째거 alternate jre → install jre → 더블클릭 → restore default
 * 
 * JRE System library 쪽에 , gson-2.8.5.jar 가 보이면 된다.
 */
public class Source02_Json {
	public static void main(String[] args) {
		// json 문자열 만든다거나, json 문자열 토대로 객체를 만들어는 라이브러리
		Gson gson = new Gson();	
		// 기본 데이터, 배열(List), 컬렉션, 맵
		String s1 = gson.toJson(true);
		System.out.println(s1);
		String s2 = gson.toJson(13);
		System.out.println(s2);
		String s3 = gson.toJson("문자열");
		System.out.println(s3);
		
		int[] ar = new int[] {1,34,543 ,45};
		String s4 = gson.toJson(ar);
		System.out.println(s4);
		
		List<String> li = new ArrayList<>();
			li.add("월요일");
			li.add("화요일");
			li.add("수요일");
		String s5 = gson.toJson(li);
		System.out.println(s5);
		// Map 을 하나 만들어서, 몇개 put해두고, toJson으로 변경
		
		Map<String, Object> map = new HashMap<>();
			map.put("name", "윤형호");
			map.put("age", 17);
			map.put("admin", true);
		String s6=	gson.toJson(map);
		System.out.println(s6);
		
		Hero h= new Hero("루피", 1, true);
		String s7 = gson.toJson(h);
		System.out.println(s7);
		
		
		
		
	}

}

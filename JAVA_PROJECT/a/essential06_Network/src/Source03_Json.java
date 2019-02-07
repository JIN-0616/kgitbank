import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

public class Source03_Json {
	public static void main(String[] args) {
		// 문자열이 JSON 문자열이면 이게 Gson 이 역으로 객체도 만들어낸다.
		Gson gson = new Gson();
		String s1 = "true";
		Boolean b = gson.fromJson(s1, Boolean.class);
		System.out.println(b);
		String s2 = "[11,22,33,5,79]";	// 배열형태의 데이터표기
		int[] ar = gson.fromJson(s2, int[].class);
		for(int a: ar) {
			System.out.println("→" + a);
		}
		Hero h = new Hero("손오공", 7, true);
		String s3 =gson.toJson(h);
		System.out.println(s3);
		Hero hh = gson.fromJson(s3, Hero.class);
		System.out.println(hh.name);
		System.out.println(hh.type);
		System.out.println(hh.special);
		// 이 문자열을 가지고 컬렉션을 만들때가 문젠데,
		List li = gson.fromJson(s2, List.class);	// 숫자는 Double 로
		for(Object obj : li) {
			System.out.println((obj instanceof Integer) +" / " + (obj instanceof Double));
		}
		String s4 = "[11,3.14,true,11]";	// 이런형태의 표기가 가능해서.
		Map map = gson.fromJson(s3, Map.class);
		System.out.println(map.get("name") instanceof String);	
		System.out.println(map.get("type") instanceof Double);
		System.out.println(map.get("special") instanceof Boolean);
		//=========================================================================
		
		
		
		
	}
}

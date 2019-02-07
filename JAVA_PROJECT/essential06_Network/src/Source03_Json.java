import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

public class Source03_Json {
	public static void main(String[] args) {
		
		// 문자열이 JSON 문자열이면 이게 GSON 이 역으로 객체도 만들어낸다.
		
		// 문자열분석 -> 객체생성
		
		Gson gson = new Gson();
		String s1 = "true";
		boolean b = gson.fromJson(s1, Boolean.class); //객체명.class
		System.out.println(b);
		
		String s2 = "[11,22,33,5,79]"; //배열형태의 데이터표기
		int[] ar = gson.fromJson(s2, int[].class);
		for(int a : ar) {
			System.out.println("-> "+a);
		}
		
		Hero h = new Hero("손오공", 1, false);
		String s3 = gson.toJson(h);
		System.out.println(s3); 		//{"name":"손오공","type":1,"special":false}
		
		Hero hh = gson.fromJson(s3, Hero.class);
		System.out.println(hh.name);
		System.out.println(hh.type);
		System.out.println(hh.special);
		
		// 이 문자열을 가지고 컬렉션을 만들때가 문제인데,
		List li = gson.fromJson(s2, List.class); //숫자는 Double로 (제네릭 설정이 안됨)
		for (Object obj : li) {
			System.out.println((obj instanceof Integer) + " / "+(obj instanceof Double));
		}
		// why?
		String s4 = "[11,3.14,true,11]"; // List에 제너릭설정을 안하면 모든타입이 들어감
										 // 이런 형태의 표기가 가능해서
		
		Map map = gson.fromJson(s3, Map.class);
		System.out.println(map.get("name") instanceof String); 
													// 기본 Object 반환 ==>따라서 제너릭설정 불가
		System.out.println(map.get("type") instanceof Double); 
													// 숫자는 무조건 Double 변환처리
		System.out.println(map.get("special") instanceof Boolean); 
		
		
		
		
		
		
		
		
		
		/*         음.... 일단 보류
		//gson.fromJson(s2, Integer.class); //불가 error
		// list는 double로 나오나?
		List<Double> li = gson.fromJson(s2, List.class);
		for(double a : li) {
			System.out.println("->"+ a);
		}
		*/
	}
}

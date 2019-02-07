package Collection;
/*
	3. Map
	키-값 쌍을 사용하는 컬렉션, 키를 가지고 뭔가를 찾는 것이 중요할 때 서로 다른 키로 같은 값을 참조
	값은 중복가능, 키 중복불가
	
	 1.HashMap
	 -Map의 기본형	 
*/
import java.util.*;

public class Chap13_7_HashMap {
	public static void main(String[] args) {
		HashMap map = new HashMap<>();
			map.put("장동건", new Integer(80));
			map.put("송승헌", new Integer(70));
			map.put("원빈", new Integer(60));
			map.put("이병헌", new Integer(80));
			map.put("원빈", new Integer(50)); 
			// 키는 중복될수 없으며 맨마지막에 해당하는 값으로 입력
			
			System.out.println(map.get("원빈"));
			if (map.containsKey("장혁")) {
				System.out.println("있음");
			} else {
				System.out.println("없음");
			}
		
		HashMap data = new HashMap();
			data.put("aaa", "1234");
			data.put("bbb", "1234");
			data.put("ccc", "5678");
			data.put("ddd", "5678");
			data.put("eee", "9876");
		// 키는 중복될 경우 마지막 입력된 것으로 인정
		// 값은 중복되도 상관 없음
			
		Scanner sc = new Scanner(System.in);
		String id, pw;
		while(true) {
			System.out.print("ID:");
			id=sc.nextLine();
			System.out.print("PW:");
			pw=sc.nextLine();
			if (!data.containsKey(id)) {
				System.out.println("id 확인바람");
			} else if (!data.get(id).equals(pw)) {
				System.out.println("pw 확인바람");
			} else {
				System.out.println(id+"님 로그인 하셨습니다.");
				break;
			}			
		}
	}
}

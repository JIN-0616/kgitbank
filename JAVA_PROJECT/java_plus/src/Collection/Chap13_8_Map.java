package Collection;
/*
	2. Map의 변환
	
	Iterator <------------- Set <-------------- Map
		iterator 		 entrySet():키와 값을 같이 넘김
	
	변환된 형의 접근(하나의 항목만 접근)
	it.next()------>Map.Entry----->getKey(), getValue()
	
	키 ----> set
	keySet();
	
*/
import java.util.*;
public class Chap13_8_Map {
	public static void main(String[] args) {
		HashMap map = new HashMap();
			map.put("장동건", 80);
			map.put("송승헌", 70);
			map.put("원빈", 90);
			map.put("이병헌", 60);
			map.put("원빈", 50);
		
		// Iterator <-- Set <-- Map
		// Set set = map.entrySet();
		// Iterator it = set.Iterator();
		
		Iterator it = map.entrySet().iterator();	//한번에 변경 가능
		while (it.hasNext()) {
			Map.Entry e = (Map.Entry) it.next();			
			//Map.Entry 인터페이스
			System.out.println("성명:"+e.getKey()+"\n점수:"+e.getValue());
		}
		
		// 키---->set
		Set setkey = map.keySet();
		System.out.println("시험자명단: "+setkey);
		
		// 값(value) ---> Collection
		Collection cc =map.values();
		Iterator ccit = cc.iterator();
		
		System.out.println("점 수: " );
		int tot=0;
		while (ccit.hasNext()) {
			int aa = (Integer)ccit.next();
			System.out.println(aa+"\n");
			tot+=aa;			
		}
		System.out.println();
		System.out.println("총점:" + tot);
		System.out.println("최고점수:"+Collections.max(cc));
		System.out.println("최저점수:"+Collections.min(cc));
		
	}
}
/*
성명:원빈
점수:50
성명:장동건
점수:80
성명:송승헌
점수:70
성명:이병헌
점수:60
시험자명단: [원빈, 장동건, 송승헌, 이병헌]
점 수: 
50

80

70

60


총점:260
최고점수:80
최저점수:50
*/
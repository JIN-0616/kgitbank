import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Source14_Map {
	public static void main(String[] args) {
		Map<Integer, String[]> map = new HashMap<>();
		/*
		 * 이 안에 저장객체를 제어할때,
		 *  put, remove, get 을 통해 최초 put인지, remove가 된건지 확인하려면 리턴벨류를 받으면 된다.
		 *  처리결과는 value타입으로 발생한다. 그전에 있던 내용이 출력됨.
		 *  이 객체를 보고 판단을 할 수 있다.
		 *  
		 *  아니면, boolean containsKey(Key) 특정키가 사용되고 있는지를 확인가능
		 *  put 하기 전에 체크해서 없으면 최초put, 있으면 변경됨
		 *  get 하기 전에 체크해서 없으면 등록객체 없는것, 있다면 존재
		 *  remove 하기 전에 체크해서 없으면 삭제 실패, 있으면 삭제 
		 */
		
		String[]a = map.put(2, new String[] {Integer.toString(2,2),"이","둘","二","two","に"} ); // 일본어입력 : ㄸ + right_ctrl(or한자키);
		System.out.println(a == null); // 최초put이면 그 Key에 저장된 value의 이전 값이 null이므로
		String[]b =map.put(1, new String[] {"일","하나","一","one","いち"} ); 
		System.out.println(b == null); // 최초put이면 이전 값이 null이므로
		map.put(3, new String[] {"삼","셋","三","three","さん"} ); 
		map.put(4, new String[] {"사","넷","四","four","し"} ); 
		map.put(5, new String[] {"오","다섯","五","five","ご"} ); 
		map.put(6, new String[] {"육","여섯","六","six","ろく"} ); 
		
		
		//1부터 99사이의 숫자를 키로 해서 그걸 표현하는 문자열 배열을 2~3개만 put
		
		Integer key = 2;
		String[] obt = map.get(key);
		if(obt == null) {
			
		}else {
			System.out.println(key+"를 키로하는 String[] ");
			for (String m : obt) {
				System.out.println("=>"+m);
			}
		}
		
		String[] abc =map.remove(1); 
		System.out.println(abc);
		System.out.println("contains = "+map.containsKey(1));
		/*
		 * containsKey와 비슷하게 containsValue도 존재
		 */
		boolean f = map.containsValue(new String[] {Integer.toString(2,2),"이","둘","二","two","に"});
			// equlas 구현이 어떤형태로 되있는 객체냐에 따라서, 객체값이 달라도 true가 나올수도 있다.
		
			// cf# containsKey는 어떤 Map을 사용하냐에 따라 객체값이 달라도 동일객체로 판단되서 true가 나온다.
			//		hash -> hashCode, equals ,  TreeMap -> equals
			//      hashMap은 key를 hashSet으로 관리
			//      LinkedHashMap -> key가 LinkedHashSet으로 관리
			// equals, hashCode, compare..가 어떻게 구현되어있는가에 따라 달라짐
		
			// Hash계열은 key 값을 hashSet으로 관리하게 구현되어있음
		
		System.out.println(f);
		
		/*###########################################
		 
		  *** Map 의 내용을 출력받고자 하는 경우 ***
			
			1. map.keySet();		--Only key
			
				=> return [ Set	]
				
			2. map.values();		--Only value
			
				=> return [ Collection ]
				
			3. map.entrySet();		--Key + Value
			
				=> return [ Set<Entry<K, V>> ]	
								
		*///#########################################
		
		
		// Map의해 관리되는 모든 객체를 확인해보고자 하면, keySet()을 얻어내서,
		// 키 반복처리하면서 객체를 확보
		Set<Integer> k = map.keySet();
		System.out.println(k);
		for (Integer i : k) {		//	for( Integer i : map.keySet() )
			System.out.println(i +"..."+map.get(i));			
		}
		
		// 어떤 Key에 물려있는지는 몰라도 되고, 객체들만 얻어서 사용하고 싶으면
		Collection<String[]> vs = map.values(); 
		//최상위 Collection으로 반환됨
		for (String[] s : vs) { 	//	for( String[] c : map.values() )
			System.out.println(s);
		}
		
		System.out.println(map.toString());
		
		// entrySet()
		
		// Entry의 제너릭부분 설정은 Map이랑 동일하게 설정
		Set<Entry<Integer,String[]>> eset = map.entrySet();
		for (Entry<Integer, String[]> e : eset) {
			System.out.println("=> "+e);
			Integer ek = e.getKey();
			String[] ar = e.getValue();
			System.out.print(ek);
			System.out.println("---"+ar);
		}		
	}
}

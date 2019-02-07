import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

public class Source14_Map {
	public static void main(String[] args) {
		Map<Integer, String[]> map = new TreeMap<>();
		/*
		 * 이안에 저장객체를 제어할때, 
		 * put, remove, get 을 했을때 최초 put인지, remove가 된건지 확인하려면 리턴밸류를 받으면 된다.
		 * 처리결과는 밸류타입으로 발생한다. 그전에 있던애가 나옴. 이 객체를 보고 판단할수 있다.
		 * 
		 * 아니면, boolean containsKey(Key) 특정키가 사용되고 있는지가 확인을 할수 있다.
		 * put 하기 전에 체크해서 없으면 최초put, 있으면 변경
		 * get 하기 전에 체크해서 없으면 등록객체 없는거, 아님 있고
		 * remove 하기 전에 체크해서 없으면 삭제 실패, 있으면 삭제
		 */
		String[] a = map.put(2, new String[] {Integer.toString(2, 2), "둘", "二", "two"} );
		System.out.println(a ==  null);
		String[] ab = map.put(2, new String[] {Integer.toString(2, 2), "둘", "二", "two"} );
		System.out.println(ab ==  null);
		map.put(12, new String[] {Integer.toString(12, 2), "열둘", "十二", "twelve"} );
		map.put(21, new String[] {Integer.toString(21, 2),"스물하나", "二", "two"} );
		map.put(9, new String[] {Integer.toString(9, 2), "아홉", "九", "nine"} );// ㄸ 오른쪽 ctrl
		// 1~99 사이에 숫자를 키로 해서 그걸 표현하는 문자열배열을 2~3개 정도만 put
		Integer key = 11;
		String[] obt = map.get(key);
		if(obt == null) {
		}else {
			System.out.println(key+ "를 키로 하는 String[] ");
			for(String m : obt) {
				System.out.println("→" + m);
			}
		}
		String[] abc = map.remove(1);
		System.out.println(abc);
		System.out.println("contains = " + map.containsKey(1));
		/*
		 * containsKey랑 비슷하게 containsValue 도 있다.
		 * 
		 */
		boolean f = map.containsValue(new String[] {Integer.toString(21, 2),"스물하나", "二", "two"} );
			// equals 구현이 어떤형태로 되있는 객체냐에 따라서, 객체값이 달라도 true 가 나올수도 있다.
			// cf# containsKey 는 어떤Map을 쓰냐에 따라 객체값이 달라도 동일객체로 판단되서 true가 나온다. 
		System.out.println(f);
		
		// Map에 의해 관리되는 모든 객체를 확인해보고자 하면, keySet()를 얻어내서, 키 반복처리하면서 객체들을 확보
		Set<Integer> k = map.keySet();
		System.out.println(k);
		for(Integer i : k) {	// for(Integer i :  map.keySet())
			System.out.println(i + "..." +map.get(i));
		}
		
		// 어떤키에 물려있는지는 몰라도 되고, 객체들만 얻어서 사용하고 싶으면
		Collection<String[]> vs = map.values();
		System.out.println((vs instanceof Queue) +" ?");
		for(String[] c : vs) {		// for(String[] c : map.values())
			System.out.println(c);
		}
		System.out.println(map.toString());
		// entrySet()
		// Entry의 제너릭부분 설정은 Map이랑같게 설정
		Set<Entry<Integer, String[]> > eset  =  map.entrySet();
		for(Entry<Integer, String[]> e : eset) {
			System.out.println("→ " + e);
			Integer ek =e.getKey();
			String[] ar = e.getValue();
		}
	}
}

import java.util.HashMap;
import java.util.Map;

/*
 * 컬렉션형 객체의 Map계열에 대해서 살펴보자
 *   Map은 다른 컬렉션(Set,List,Queue계열)과는 사용법이 조금 다르다.
 *   저 위의 3개는 객체값을 저장하기 위해서 add로 객체값만 넘겨주면 되었다.
 *   Map계열은 객체값만 넘기는게 아니라, 객체값을 부여할 Key값을 같이 설정해서 저장시켜야 한다.
 *   나중에 객체를 지우거나, 재 확보해야되는 상황에 부여했던 키값이 사용된다.
 *  
 *  만약 객체를 저장하면서 키를 설정하는데,
 *   이 키가 이미 사용되고 있었다면, 덮어쓰여진다 (재등록됨)
 *   
 *  대표적인 Map 형 객체로는 Hashtable, HashMap, TreeMap, LinkedHashMap 이 있다.
 *   각각의 차이는 Key값 관리에 있다.
 *   
 */
public class Source13_Map {
	public static void main(String[] args) {
		// 타입설정에 두가지가 필요. 
		// 하나는 저장할 객체타입, 다른하나는 키로 쓸 객체타입이다.
		Map<String, String[]> map = new HashMap<>();
		 //<키타입, 벨류타입>
		System.out.println(map.size()); 	// int size() : 관리중인 객체
		System.out.println(map.isEmpty());  // boolean isEmpty() : 관리하고 있는 개체 없냐?
		
		String[] a = "하준,도윤,시우,민준".split(",");
		
		// 객체 저장이 put
		map.put("f",a);				//앞이 Key객체, 뒤가 value객체
		map.put("F",a);
		System.out.println(map.size()); //2
		
		//이 Key가 객체 확보나 삭제에 사용된다.
		String[] got = map.get("f");
		System.out.println(got + " / "+got[0]);
		String[] got2 = map.get("F");
		System.out.println(got2 + " / "+got2[1]);
		
		map.remove("t");
		//Key로 지우는 거고, 해당 키로 등록된 객체가 없어도 에러가 발생하진 않는다.		
		
		String[] got3 = map.get("F");  //키로 등록한 객체가 없으면 null
		System.out.println(got3+" / "+(got3==null));
		
		String[] b = "서연,하연,지우".split(",");
		map.put("f", b);			// 객체저장시 같은 Key로 put이 되면 덮어씌워짐
		String[] got4 = map.get("f");
		System.out.println(got4[0]);
		
		// Key를 통해서만 객체값을 제어할수있음
		// 없는 Key를 통해서 데이터를 제어해도 에러발생은 없다.
		// 직접적인 반응은 없으니 확인작업이 필요,
		// but, null값을 가진 key를 타고들어가 작업을 실행하려면 에러가 발생한다.
		
		map.clear();
		System.out.println(map.isEmpty());
		
	}
}

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

/*	
 * 	in java.util. 패키지
 * 	컬렉션형 객체들은 크게 분류가 4가지이다. 각 계열마다 특징이 조금씩 다르다.
 * 	
 *  - Collection  
 * 	  - Set 계열 : HashSet , TreeSet , LinkedHashSet ..
 * 	  - List 계열 : Vector , ArrayList , LinkedList  
 * 	  - Queue 계열 : ArrayDeque,,
 * 
 * 	- Map 계열 : Hashtable, HashMap, 
 * 
 */
public class Source02_Set {
	public static void main(String[] args) {
		/*
		 * Set 계열의 컬렉션 객체의 특징
		 *   - 동일요소(객체)를 중복으로 포함할수 없는 특징을 가진 객체
		 *   	: HashSet : 가장빠른(저장,삭제)연산을 처리하지만, 순서보장이 없다.
		 *   	: TreeSet : 크기에 따른 정렬을 지원하지만, HashSet 보다는 연산이 느림
		 *   	: LinkedHashSet : 들어간순서가 유지되지만, HashSet 보다는 연산이 느림.
		 *  이 3개 외에도 Set 형 컬렉션은 더 존재하지만, 위 3개가 대표적인 것들.
		 *   
		 */
		Set set;
			set = new HashSet();
		//	set = new LinkedHashSet();
		//	set = new TreeSet();
		// ※ 컬렉션객체를 사용할때는 어떤 객체값을 저장할껀지를 설정해두고 사용하는게 권장이지만,
		// 미 설정하면, Object 값으로 처리가 된다. (어떤 객체든 다 저장 가능)
		// Set 객체의 기능
		int size = set.size();	// 저장된 객체 수(관리중인 객체수)
		System.out.println("size = " + size);
		
		boolean b = set.isEmpty();	// 저장중인 객체가 없냐? (size==0 인지 확인)
		System.out.println("isEmpty = " + b);
		
		// 객체관리에 사용되는   
		// boolean add(Object o), boolean contains(Object o), boolean remove(Object o)
		boolean t1 = set.add("월요일");
		System.out.println(t1);
		boolean t2 = set.add("월요일");
		System.out.println(t2);
		
		int[] ar = new int[3];
		boolean t3 = set.add(ar);
		System.out.println(t3);
		System.out.println("size = " + set.size());
		boolean t4 = set.contains(ar);
		System.out.println("contains = " + t4);
//		set.add("금요일");
		System.out.println( set.contains("금요일"));
		
		System.out.println("remove ? " +set.remove("토요일") );	// 안가진 객체일때 false 
		
		System.out.println("set.size() : " + set.size());
		set.clear();	// 모든 객체값을 다 날려버림.
		System.out.println("set.size() : " + set.size());
		
		// 객체 저장개수에는 제한이 없다.
		for(int cnt=1; cnt<=100000; cnt++) {
			int[] z = new int[500];
			set.add(z);
		}
		System.out.println(set.size());
		// 각 객체의 특징을 살펴보자.
		
	}
}

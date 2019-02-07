import java.util.List;
import java.util.Vector;

/*
 * Set 형 컬렉션을 살펴보았는데, 
 *  이 컬렉션은 중복데이터를 제거하면서 객체를 모으기는 편한데, 
 *  나중에 그 집합안에서 특정객체를 다이렉트로 확보해서 사용하기 힘들다.
 *  
 * 이번에 살펴보려고 하는 List형 컬렉션은
 *  객체값을 저장해준다는 건 같지만, 
 *  중복객체를 저장하게 되있고, 
 *  특정객체의 위치를 알려주고, 위치를 안다면 바로 객체를 확보해서 사용할수 있다.
 *  
 * 기본적인 사용은 Set형 컬렉션과 비슷하다.
 */

public class Source10_List {
	public static void main(String[] args) {
		List<String> li;
		//	li = new Vector<>();   (Vector 는 컬렉션이 정립되기전부터 있던 객체, 배열기반)
		//  li = new ArrayList<>();   (컬렉션을 정립하면서, Vector의 문제점을 개선시켜서 만들어둔 객체, 배열기반)

		//  li = new LinkedList<>();  (Vector와는 다른형태로 객체를 관리하게 설계된 객체 - 배열기반이 아님)
		//  어떤 특징이 살려둔 객체인지는 List 형 컬렉션이 어떻게 작동되는지를 알아보고 살펴보자.
		li = new Vector<>();
		System.out.println(li.size());
		System.out.println(li.isEmpty());
		
		String s = "컬렉션";
		System.out.println("add = "+ li.add(s));
		System.out.println("contains = "+ li.contains(s));
	//	System.out.println("remove = "+ li.remove(s));
		
		System.out.println("add = "+ li.add(s));	// 중복객체도 저장되게 설계되있고
		System.out.println("add = "+ li.add(s));	//
		System.out.println("add = " +  li.add("collection"));
		System.out.println("add = "+ li.add(s));
	//	li.clear();
		System.out.println("size = " + li.size());	// 
		li.iterator();
		for(String m : li) {
			System.out.println("→" + m);
		}
	//  내부 index 처리를 해둬서, 객체 위치를 찾을수도 있고
		int idx = li.indexOf("collection");
		System.out.println("idx = " + idx);
	//  위치를 안다면, 그 위치에 해당하는 객체를 바로 얻을수도있다 (index 값은 0부터 설정되있고, 
		String m = li.get(0);	// 부적합 idx 설정시 Error 발생
		System.out.println(m);
	//  내부 index를 통해서 , set, add, remove 를 할수 있다. 
		System.out.println("size = " + li.size());	// 
		li.set(0, "set");
		System.out.println("size = " + li.size());	// 
		System.out.println(li.get(0));
		System.out.println(li.toString());
		li.add(2, "HashSet");
		System.out.println("size = " + li.size());	//
		System.out.println(li.toString());
		li.remove(4);
		System.out.println(li.toString());
		
		// 가지고 있는 일부분을 List로 사용할수가 있다.
		List<String> sub = li.subList(1, 4);
		System.out.println(sub);
		sub.add(1, "totoro");
		System.out.println(li.toString());

		// 내부 index 에 변화가 없다면, Vector or ArrayList가 가장 성능이 좋고,
		// 중간index에 설정되어있는 객체가 지워진다거나, 중간에 add가 되는 상황이 많다면 LinkedList 가 성능이 좋다. 
		
	}
}

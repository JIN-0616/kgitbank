import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

class CustomComparator implements Comparator<String>{
	@Override
	public int compare(String o1, String o2) {
		// o1객체가 작다고 처리하고 싶다면 -1
		// o1객체가 크다고 처리하고 싶다면 1
		// o1객체와 o2객체가 크기가 같다고 처리하고 싶으면 0
		int c = o1.compareTo(o2);
		return c < 0 ? -1 : (c > 0 ? 1: 0);
	}
}
class ParseComperator implements Comparator<String>{
	@Override
	public int compare(String o1, String o2) {
		Integer i1 = Integer.parseInt(o1,2);
		Integer i2 = Integer.parseInt(o2,2); //숫자비교의 경우 2진파싱하지 않아도 가능
		int c = i1.compareTo(i2);
		return c < 0 ? -1 : (c > 0 ? 1: 0);
	//	or
	//	return i1-i2;
			
	}
}

//===================================================================
// Set과 다르게 List는 성능차이뿐 뚜렷한 사용목적요소로 갈리지 않는다.
public class Source11_List {
	public static void main(String[] args) {
		List<String> li = new ArrayList<>();
		li.add("111");
		li.add("101");
		li.add("10");
		li.add("100");
		li.add("110");
		li.add("1001");
		li.add("111");
		System.out.println(li.toString()); //[111, 101, 10, 100, 110, 111]
		System.out.println("contains? "+li.contains("101")); //true
		String data = new String("10");
		System.out.println("contains? "+li.contains(data)); //true
		//List 계열은 contains 나 indexOf 객체 판별할때 equals만 사용한다. (hashCode안봄)
		
		System.out.println("indexOf..."+li.indexOf(data)); // equals(value가 같음)
		System.out.println(li.get(2) == data); //false, 실제 같은객체는 아님
		System.out.println(li.get(2).equals(data)); //true
		
		// List안에 저장된 객체를 정렬을 시킬수도 있는데, 객체자체의 compareTo가 사용되는게 아니라,
		// 크기비교를 할 객체를 설계해서 넘겨줘야 한다.
		// 예를 들어, String 객체값이 들어있는 List를 특정조건으로 정렬을 하고 싶다면 비교 객체(class)생성
		
// 		class 클래스이름 implements Comparator<E>{
//			@Override
//			public int compare(String o1, String o2) {
//				return 0;
//			}
//		}
		
		// iterator 방식, inhanced for방식, + 추가로 접근방식에 사용
		
		Comparator<String> c = new CustomComparator();
		li.sort(c);
		// == li.sort( new CustromComparator() );
		for (int idx = 0; idx < li.size(); idx++) {
			String m = li.get(idx);
			System.out.println("-->"+m+" / "+Integer.parseInt(m,2)); //2진법 파싱			
		}
		System.out.println();
		Comparator<String> b = new ParseComperator(); //문자열 받아서 2진법비교로 생성할것!
		li.sort(b);
		for (Iterator i = li.iterator(); i.hasNext();) {
			String d = (String) i.next();
			System.out.println("-->"+d+" / "+Integer.parseInt(d,2));
			
		}
		
		// 기본 제공 방법 (Custom객체가 아닌 경우에)
		// Collections.sort(li);
		// or
		// li.sort(null);
		
		//######### List사용시 기본정렬 이 외의 sort(정렬)이 필요한 경우 ##########
		
		//######### Comparator를 비교기준이 필요할때마다 class를 생성해서 설정 ###########
		
		// 	----->	List가 더 많이 사용되므로 잘 알아둘 필요성이 높음
		
	}
}

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

class CustomComparator implements Comparator<String> {
	@Override
	public int compare(String o1, String o2) {
		// o1 객체가 작다고 처리하고 싶다면 -1
		// o1 객체가 크다고 처리하고 싶다면 1
		// o1 객체와 o2객체가 크기가 같다고 처리하고 싶으면 0
		int c = o1.compareTo(o2);
		int r =  c < 0 ? -1 : (c > 0 ? 1 : 0);
		return r;
	}
}

//=============================================
class ParseComparator implements Comparator<String> {
	@Override
	public int compare(String o1, String o2) {
		int n1 = Integer.parseInt(o1, 2);
		int n2 = Integer.parseInt(o2, 2);
		
		if (n1 < n2)
			return -1;
		else if (n1 > n2)
			return 1;
		else
			return 0;

	}

}

//=============================================
public class Source11_List {
	public static void main(String[] args) {
		List<String> li = new ArrayList<>();
		li.add("11");
		li.add("101");
		li.add("10");
		li.add("100");
		li.add("110");
		li.add("1001");
		li.add("111");
		System.out.println(li.toString());
		System.out.println("contains? " + li.contains("101")); // true
		String data = new String("10");
		System.out.println("contains? " + li.contains(data)); // true
		// List 계열은 contains 나 indexOf 객체 판별할때 equals 만 사용한다.
		System.out.println("indexOf.. " + li.indexOf(data));
		System.out.println(li.get(2) == data);
		System.out.println(li.get(2).equals(data));
		// List안에 저장된 객체를 정렬을 시킬수도 있는데, 객체자체의 compareTo가 사용되는게 아니라,
		// 크기비교를 할 객체를 설계해서 넘겨줘야 한다.
		// 예를 들어, String 객체값이 들어있는 List를 특정조건으로 정렬을 하고 싶다면
		Comparator<String> c = new CustomComparator();
		li.sort(c);
		// li.sort(new CustomComparator() );
		for (int idx = 0; idx < li.size(); idx++) {
			String m = li.get(idx);
			System.out.println("→" + m + " / " + Integer.parseInt(m, 2));
		}

		Comparator<String> b = new ParseComparator();
		li.sort(b);
		for (Iterator<String> i = li.iterator(); i.hasNext();) {
			String d = i.next();
			System.out.println("→" + d + " / " + Integer.parseInt(d, 2));
		}

	}
}

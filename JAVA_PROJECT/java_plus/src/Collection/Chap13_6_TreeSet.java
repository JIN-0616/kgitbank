package Collection;
/*
	2.TreeSet : 데이터를 정렬한 형태
	- 숫자형만 가능
	- 정렬방식 변경 : 사용자 정의 정렬 클래스를 생성자로 받음
					  정렬클래스는 Comparator 인터페이스를 구현하여 정리
*/
import java.util.*;

class user_com implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		Comparable oo1 = (Comparable)o1;
		Comparable oo2 = (Comparable)o2;
		
		return oo1.compareTo(oo2)*-1;
	}
	
}

public class Chap13_6_TreeSet {
	public static void main(String[] args) {
		int[] arr = {23,12,45,78,43,98,65,98};
		
		LinkedHashSet sss = new LinkedHashSet<>();
		for (int i = 0; i < arr.length; i++) {
			sss.add(arr[i]);
			/* ss1.add(arr[i]);
			   ss2.add(arr[i]); */
		}
		TreeSet ss1 = new TreeSet<>();
		TreeSet ss2 = new TreeSet<>(new user_com());
		// 생성자로 collection과 comparator를 같이 받을수 없다
		
		Iterator it = sss.iterator();
		
		while(it.hasNext()) {
			int data = (int)it.next();
			ss1.add(data);
			ss2.add(data);
		}
		System.out.println("sss : "+sss);
		System.out.println("ss1 : "+ss1);
		System.out.println("ss2 : "+ss2);
		
		System.out.println("ss1.headSet(50) : "+ss1.headSet(50));
		System.out.println("ss1.tailSet(50) : "+ss1.tailSet(50));
		System.out.println("ss1.headSet(50) : "+ss2.headSet(50));
		System.out.println("ss1.tailSet(50) : "+ss2.tailSet(50));
		
	}
}
/*
sss : [23, 12, 45, 78, 43, 98, 65]
ss1 : [12, 23, 43, 45, 65, 78, 98]
ss2 : [98, 78, 65, 45, 43, 23, 12]
ss1.headSet(50) : [12, 23, 43, 45]
ss1.tailSet(50) : [65, 78, 98]
ss1.headSet(50) : [98, 78, 65]
ss1.tailSet(50) : [45, 43, 23, 12]
*/
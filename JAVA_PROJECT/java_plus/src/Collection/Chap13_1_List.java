package Collection;
/*
	<List>
	순서가 있는 데이터 집합(중복이 가능함)
	
	1. Vector
	
	-동기화 처리가 내부적으로 이루어진다
	
	-예를 들어 한 쓰레드에서 어떤 작업을 하고 있으면 다른 쓰레드에서는 접근할 수 없도록 한번에 하나의 쓰레드만 사용할 수 있도록 내부적으로 처리되고 있다.
	
	-단일 쓰레드에서는 불필요한 처리 코드만 가지게 되기 때문에 ArrayList나 LinkedList에 비해 성능 저하를 가져오게 된다.
	
	-동기화를 고려한다면 Vector의 사용 보다는  Collection.synchronizedCollection(Collection c) 나
	 sysnchronizedList, Map 등을 사용하는 것이 낫다.  
	
	2. ArrayList
	
	-내부적으로 따로 동기화 처리를 하지 않는다.
	
	-동기화 처리를 위해선 Collection.synchronizedCollection을 사용해야 한다.
	
	-데이터의 추가/삭제 작업이 발생했을 시, 내부적으로 배열 복사가 일어난다.(데이터가 많을 수록 성능 저하가 심함)
	
	-하지만 개개 요소의 index를 따로 가지고 있어서 많은 데이터를 검색하는데 용이하다.
*/
import java.util.*;

public class Chap13_1_List {
	public static void main(String[] args) {
		ArrayList l_1 = new ArrayList<>();
		List l_2 = new ArrayList<>();
		//List L_3 = new List() { };
		l_1.add(new Integer(5)); // Object 단위로 처리
		l_1.add(new Integer(7)); 
		l_1.add(new Integer(4)); 
		l_1.add(new Integer(5)); 
		l_1.add(new Integer(3)); 
		l_1.add(new Integer(7)); 
		l_1.add(new Integer(2)); 
		
		ArrayList l_4 = new ArrayList(l_1.subList(1, 4)); //일부만 추출하여 생성
		l_4.add(new Integer(0));
		l_1.set(2, new Integer(11));
		System.out.println(l_1.get(4)); // 3
		System.out.println(l_1);  // [5, 7, 11, 5, 3, 7, 2]
		System.out.println(l_4); // [7, 4, 5, 0]
		
		Collections.sort(l_1);				//정렬 Collections.sort()
		Collections.sort(l_4);  			//정렬---> 같은 자료형을 기준으로 가능
		
		System.out.println(l_1); // [2, 3, 5, 5, 7, 7, 11]
		System.out.println(l_4); // [0, 4, 5, 7]

		l_1.remove(2);
		l_1.retainAll(l_4);		 // 1_4에 있는 항목만 제외하고 나머지 삭제
		System.out.println(l_1); // [5, 7, 7]   
		System.out.println(l_4); // [0, 4, 5, 7]
		
		for (int i = (l_4.size()-1); i >=0; i--) { //뒤에서 부터 빼기 위해서
			//l_4.size => 리스트의 개체 갯수
			if(l_1.contains(l_4.get(i))) { // l_1.contains(요소)--요소가 리스트에 존재하는가
				l_4.remove(i);
			}
		}
		print(l_1,l_4); //[5, 7, 7] [0, 4]
	}
	static void print(ArrayList l_1, ArrayList l_2) {
		System.out.println(l_1);
		System.out.println(l_2);
	}
}

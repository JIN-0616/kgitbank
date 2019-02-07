package Collection;
/*
	3. LinkedList
	
	-내부적으로 따로 동기화 처리를 하지 않는다.
	
	-동기화 처리를 위해선 Collection.synchronizedCollection을 사용해야 한다.
	
	-c의 연결리스트라고 생각하면 된다.
	
	-데이터의 추가/삭제 시 , 요소의 링크 값만 넘겨주면 되기 때문에, 많은 양의 데이터도 빠르게 처리가 가능하다.
	
	-하지만 개개 요소의 index를 따로 가지고 있지 않아서 많은 데이터를 검색할 경우 순차적 접근의 검색을 해야한다.
	(header부터 시작해서 링크를 따라가며 검색, 많은 성능 저하)
	
	ArrayList : 순차적 진행
	
	LinkedList : 비순차적 진행, 검색
	
*/
import java.util.*;
public class Chap13_2_LinkedList {
	
	static void remove1(String name, List ls) { // 순차적 삭제
		long tt = System.currentTimeMillis();
		for (int i = ls.size()-1; i >= 0; i--) {
			ls.remove(i);
		}
		System.out.println(name+" 순차삭제: "+(System.currentTimeMillis()-tt));
	}
	
	static void remove2(String name, List ls) { // 비 순차적 삭제
		long tt = System.currentTimeMillis();
		for (int i = 100; i >= 0; i--) {
			ls.remove(i);
		}
		System.out.println(name+" 비순차삭제: "+(System.currentTimeMillis()-tt));

	}
	
	static void add1(String name, List ls) { // 순차적 입력
		long tt =System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			ls.add(new Integer(i));
		}
		System.out.println(name +" 순차입력 : "+(System.currentTimeMillis()-tt));
	}
	
	static void add2(String name, List ls) { // 비 순차적 입력
		long tt =System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			ls.add(500, new Integer(i));
		}
		System.out.println(name +" 비순차입력 : "+(System.currentTimeMillis()-tt));
	}
	
	public static void main(String[] args) {
		ArrayList ar = new ArrayList<>();
		LinkedList li = new LinkedList<>();
		
		add1("array",ar);
		add1("linked",li);
		
		add2("array",ar);
		add2("linked",li);
		
		remove2("array",ar);
		remove2("linked",li);
		
		remove1("array",ar);
		remove1("linked",li);
	}
}
/*

array 순차입력 : 10
linked 순차입력 : 0
array 비순차입력 : 120
linked 비순차입력 : 14
array 비순차삭제: 0
linked 비순차삭제: 0
array 순차삭제: 6
linked 순차삭제: 0

*/
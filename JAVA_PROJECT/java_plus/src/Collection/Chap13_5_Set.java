package Collection;
/*
 	2.set
 	-> 순서가 없는 데이터 집합, 중복 불가
 	
 	 HashSet(기본형태), LinkedHashSet(순서기억). TreeSet(오름차순,내림차순)

*/
import java.util.*;
public class Chap13_5_Set {
	public static void main(String[] args) {
		
		HashSet set = new HashSet(); // 순서가 없는 형태
		LinkedHashSet set2 = new LinkedHashSet<>(); // 순서 기억
		Object [] oo = {"1","7","7","3","2","1","1","2","4","3","1","2",new Integer(1)};
		
		for (int i = 0; i < oo.length; i++) {
			set.add(oo[i]); // 중복된 자료는 입력되지 않는다.
			set2.add(oo[i]);
		}
		System.out.println(set);
		System.out.println(set2);
		
		//-------------------------------------빙고
		
		HashSet bingo = new HashSet();
		for(;bingo.size()<25;) { // bingo의 크기가 25일때까지 돌린다			
			bingo.add((int)(Math.random()*50)+1);
			//같은 값은 입력되지 않고 다른값으로만 25개가 들어감
			//1--->50 사이의 경우에 값이 입력됨
		}
		System.out.println("빙고");
		Iterator it = bingo.iterator();
		for (int i = 1; i <= bingo.size(); i++) {
			System.out.print(it.next()+"\t");
			
			if(i%5==0) {
				System.out.println(); // i가 5일때마다 줄바꿈
			}
		}
	}
}

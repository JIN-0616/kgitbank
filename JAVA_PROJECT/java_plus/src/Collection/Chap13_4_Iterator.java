package Collection;
/*
	5. Iterator
	- Iterator는 무엇인가를 "반복하다" 라는 의미,
	 Iterator 패턴은 일련의 요소들 또는 무엇인가 많이 모여있는 것들을
	 순서대로 지정하면서 반복적인 작업을 하거나, 전체를 검색하는 처리를
	 실행하기 위한 패턴
	 
	- Iterator(반복자)의 역활 : 요소를 순서대로 검색해가는 인터페이스(API)를 결정하는 역활.
						(hasNext메소드는 다음 요소가 존재하는지 여부를 확인하는 내용을 구현하기 위한 추상 메소드이며,
						 next는 다음 요소를 리턴 해주는 내용을 구현하기 위한 추상 메소드이다.)
						 
	- Iterator : 모든 컬렉션 저장 요소에 접근하는 인터페이스
				List에 대한 접근성이 좋음, 전진만 가능
				
	- ListIterator lit = list.listIterator(); //후진이 가능	
*/
import java.util.*;
public class Chap13_4_Iterator {
	public static void main(String[] args) {
		ArrayList li = new ArrayList();
		li.add("1");
		li.add("3");
		li.add("7");
		li.add("9");
		li.add("2");
		
		Iterator it = li.iterator();	//List객체로부터 iterator를 가져옴
		
		while(it.hasNext()) { // 다음 내용이 존재한다면
			System.out.println(it.next());
			//다음 내용을 가져온다			
		}
		System.out.println("----------------------------");
		//it = li.iterator(); //처음부터 다시하기 위해서는 새로 불러와야 한다
		//System.out.println(it.next());
		
		ListIterator lit = li.listIterator(); // 후진 가능
		while(lit.hasNext()) { // 다음 내용이 존재한다면
			System.out.println(lit.next());
			// 다음 내용을 가져온다
		}
		while(lit.hasPrevious()) { //뒤에 내용이 존재한다면
			System.out.println(lit.previous());
		}
	}
}

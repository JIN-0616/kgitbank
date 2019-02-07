import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class Source12_Queue {
	public static void main(String[] args) {
		/*
		 * Queue (I) 
		 * 	기본 컬렉션의 한계열로 실제 구현 객체로는 ArrayDeque , PriorityQueue 
		 *  정도가 존재하는데, 
		 * 저장시켜둔 객체를 하나씩 제거하면서 뽑을수 있게 구현시켜둔 컬렉션이다. (중복객체 허용함)
		 *    
		 */
		Queue<String> que = new PriorityQueue<>();
//		Queue<String> que = new ArrayDeque<>();
		// 기본컬렉션의 공통기능은 다 가지고 있고,
		que.add("Monday");
		que.add("Monday");
		System.out.println(que.size());
		System.out.println(que.contains("Monday"));
		que.add("Friday");
		que.add("Thursday");
		System.out.println(que.toString());
		/*
		 * Queue 계열만의 특수기능이 ,
		 * peek() , element(),  poll(),  remove(),  offer() 가 있다. 
		 */
		System.out.println(que.peek());	// 첫번째 객체
		System.out.println(que.peek());	// 첫번째 객체
		System.out.println(que.element());	// 첫번째 객체
		System.out.println(que.size());
		String s = que.poll();	// 컬렉션에 이 객체가 제외됨.
		System.out.println("poll = " +s );
		System.out.println(que.size() + " /" + que.toString());
		
		que.remove("Friday");		// Queue 형객체의 고유기능이 아니라, 객체 주고 지워달라는건 모든 컬렉션에 다있음.
		String s1 = que.remove();	// poll() 이랑 같음.
		System.out.println("remove = " + s1);	
		System.out.println(que.size() + " /" + que.toString());
		
		que.offer("Sunday");	// add() 랑 같음
		System.out.println(que.size() + " /" + que.toString());
		
		// list.add 시키고 remove(0)  뽑는게 remove(), poll(),     list.get(0)  해서 확인   element(), peek()
		// 실제 객체가 달라도 equals()로 확인.
		
	}
}




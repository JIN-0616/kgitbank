import java.util.ArrayDeque;
import java.util.Deque;

/*
 * Queue 의 특수계열인 Deque 는
 * 	기본 Queue 하고 같지만, 앞쪽에서만 처리를 할수 있는게 아니라 뒤쪽에서 처리할수 있게 해두었다.
 */
public class Source12_Deque {
	public static void main(String[] args) {
		Deque<String> deque = new ArrayDeque<>();
		
		deque.add("조운");
		deque.offer("관우");
		deque.addLast("주유");
		deque.offerLast("태사자");
		System.out.println(deque.toString());
		deque.addFirst("제갈량");
		deque.addFirst("하후돈");
		deque.offerFirst("사마의");
		deque.push("순욱");
		System.out.println(deque.toString());
		
		// peekFirst(), peekLast()  ,   pollFirst(), pollLast();      pop()  == pollFirst()
		System.out.println(deque.peek());
		System.out.println(deque.peekFirst());
		System.out.println(deque.peekLast());
		
		System.out.println(deque.pollFirst());	
		System.out.println(deque.peekFirst());
		
		System.out.println(deque.pollLast());
		System.out.println(deque.toString());
		System.out.println(deque.pop());
		
		// push 로 객체 저장하고  pop 으로 객체확보하면,  가장최근에 add된 순서대로 객체를 확보할수 있다. 
		// offer 로 객체 저장하고  poll 로 확보하면,  가장오래된 객체 순서대로 확보할수 있다.
		
		
		
	}
}

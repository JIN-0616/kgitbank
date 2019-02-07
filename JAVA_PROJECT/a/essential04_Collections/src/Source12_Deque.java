import java.util.ArrayDeque;
import java.util.Deque;

/*
 * Queue �� Ư���迭�� Deque ��
 * 	�⺻ Queue �ϰ� ������, ���ʿ����� ó���� �Ҽ� �ִ°� �ƴ϶� ���ʿ��� ó���Ҽ� �ְ� �صξ���.
 */
public class Source12_Deque {
	public static void main(String[] args) {
		Deque<String> deque = new ArrayDeque<>();
		
		deque.add("����");
		deque.offer("����");
		deque.addLast("����");
		deque.offerLast("�»���");
		System.out.println(deque.toString());
		deque.addFirst("������");
		deque.addFirst("���ĵ�");
		deque.offerFirst("�縶��");
		deque.push("����");
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
		
		// push �� ��ü �����ϰ�  pop ���� ��üȮ���ϸ�,  �����ֱٿ� add�� ������� ��ü�� Ȯ���Ҽ� �ִ�. 
		// offer �� ��ü �����ϰ�  poll �� Ȯ���ϸ�,  ��������� ��ü ������� Ȯ���Ҽ� �ִ�.
		
		
		
	}
}

package Collection;
/*
	4. Stack, Queue
	stack - LIFO (Last in Fist out) : 나중에 입력된 데이터가 먼저 출력
	Queue - FIFO (First in First out) : 먼저 입력된 데이터가 먼저 출력
*/
import java.util.*;
public class Chap13_3_Stack_Queue {
	static Stack back = new Stack();
	static Stack next = new Stack();
	
	static void goURL(String url) {
		back.push(url);
		if(!next.empty()) { // 다음페이지에 내용이 있으면
			next.clear();	// 모든 내용 지우기			
		}
		System.out.println("=====================gourl");
		print();
	}
	
	static void goNext() {
		if(!next.empty()) { // 뒤로에 내용이 있다면
			back.push(next.pop());
			//back에 삽입(next의 처음내용)
		}
		System.out.println("=====================다음");
		print();
	}
	static void goBack() {
		if(!back.empty()) { // 뒤로에 내용이 있다면
			next.push(back.pop());
			//next에 삽입(back의 처음내용)			
		}
		System.out.println("=====================뒤로");
		print();
	}
	static void print() {
		System.out.println("뒤로:"+back);
		System.out.println("다음:"+next);
		System.out.println("현재:"+back.peek());
		// peek() --> 꺼내지 않고 출력
	}
	public static void main(String[] args) {
		goURL("다음");
		goURL("네이버");
		goURL("구글");
		goBack();
		goBack();
		goNext();
		goURL("네이트");
		goNext();
		goBack();
		goBack();
		
				
		
		//-----------------------------------------------------

		Stack st = new Stack();
		Queue qq = new LinkedList(); //인터페이스 임
		
		st.push("1");
		st.push("2");
		st.push("3");
		
		qq.offer("1");
		qq.offer("2");
		qq.offer("3");
		
		while(!st.isEmpty()) { //값이 없다 가 아니라면
			System.out.println(st.pop());	// 꺼내기 - LIFO
		}	// 3 , 2 , 1
		
		while(!qq.isEmpty()) {
			System.out.println(qq.poll());	// 꺼내기 - FIFO
		}	// 1 , 2 , 3
		
		//-----------------------------------------------------
	}
}

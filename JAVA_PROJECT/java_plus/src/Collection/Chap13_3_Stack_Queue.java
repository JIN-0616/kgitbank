package Collection;
/*
	4. Stack, Queue
	stack - LIFO (Last in Fist out) : ���߿� �Էµ� �����Ͱ� ���� ���
	Queue - FIFO (First in First out) : ���� �Էµ� �����Ͱ� ���� ���
*/
import java.util.*;
public class Chap13_3_Stack_Queue {
	static Stack back = new Stack();
	static Stack next = new Stack();
	
	static void goURL(String url) {
		back.push(url);
		if(!next.empty()) { // ������������ ������ ������
			next.clear();	// ��� ���� �����			
		}
		System.out.println("=====================gourl");
		print();
	}
	
	static void goNext() {
		if(!next.empty()) { // �ڷο� ������ �ִٸ�
			back.push(next.pop());
			//back�� ����(next�� ó������)
		}
		System.out.println("=====================����");
		print();
	}
	static void goBack() {
		if(!back.empty()) { // �ڷο� ������ �ִٸ�
			next.push(back.pop());
			//next�� ����(back�� ó������)			
		}
		System.out.println("=====================�ڷ�");
		print();
	}
	static void print() {
		System.out.println("�ڷ�:"+back);
		System.out.println("����:"+next);
		System.out.println("����:"+back.peek());
		// peek() --> ������ �ʰ� ���
	}
	public static void main(String[] args) {
		goURL("����");
		goURL("���̹�");
		goURL("����");
		goBack();
		goBack();
		goNext();
		goURL("����Ʈ");
		goNext();
		goBack();
		goBack();
		
				
		
		//-----------------------------------------------------

		Stack st = new Stack();
		Queue qq = new LinkedList(); //�������̽� ��
		
		st.push("1");
		st.push("2");
		st.push("3");
		
		qq.offer("1");
		qq.offer("2");
		qq.offer("3");
		
		while(!st.isEmpty()) { //���� ���� �� �ƴ϶��
			System.out.println(st.pop());	// ������ - LIFO
		}	// 3 , 2 , 1
		
		while(!qq.isEmpty()) {
			System.out.println(qq.poll());	// ������ - FIFO
		}	// 1 , 2 , 3
		
		//-----------------------------------------------------
	}
}

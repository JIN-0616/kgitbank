import java.util.ArrayList;
import java.util.List;

/*
 * 주의해야되는 점.
 * 	여러 쓰레드에서 같은 객체를 접근시 동시에 사용된다는 것. 
 * 	거기서 발생하는 동기화라는 것을 알아야 한다. 
 * 
 * 만약에 애초에 동시사용되는 객체가 기능자체를 synchronized 해두엇다면 multi-thread에서 안전하게 작동하지만,
 * 그게 아니라면 락을 걸어야 한다.
 */

class NumberSaver extends Thread {
	List<Integer> li;
	NumberSaver(List<Integer> li) {
		this.li = li;
	}
	
	synchronized void test( ) {
		
	}

	public void run() {
		for(int i=1; i<=10000; i++) {
			synchronized (li) {
				li.add(i);
			}
		}
		String name = getName();
		System.out.println("["+ name + "]  size = " + li.size());
	}
}

//==================================================================================
public class Source04_Thread {
	public static void main(String[] args) {
		// Vector : 멀티 쓰레드를 고려해서 만들어진 객체 (동기화 처리를 해둠)
		// 			동시에 여러쓰레드에서 객체가 사용되도, 안전하게 처리를 함. (대신에 add 작업이 무거움)

		// ArrayList : 멀티 쓰레드를 고려하지 않고, 단일(Single) 쓰레드만을 생각해서 처리함. 
		// 			(동기화 처리를 안하고)
		
		// 동기화 처리가 애초에 안되있는 객체를 사용하다보면, 예상치 못한 에러가 발생할수 있다. 
		
		List<Integer> li = new ArrayList<>();	
		
		NumberSaver t1 = new NumberSaver(li);
		NumberSaver t2 = new NumberSaver(li);
		
		t1.start();
		t2.start();
		System.out.println("MAIN-TERMINATE");
		
		
		
	}
}
	
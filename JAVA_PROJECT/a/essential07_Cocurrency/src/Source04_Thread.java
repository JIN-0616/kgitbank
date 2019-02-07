import java.util.ArrayList;
import java.util.List;

/*
 * �����ؾߵǴ� ��.
 * 	���� �����忡�� ���� ��ü�� ���ٽ� ���ÿ� ���ȴٴ� ��. 
 * 	�ű⼭ �߻��ϴ� ����ȭ��� ���� �˾ƾ� �Ѵ�. 
 * 
 * ���࿡ ���ʿ� ���û��Ǵ� ��ü�� �����ü�� synchronized �صξ��ٸ� multi-thread���� �����ϰ� �۵�������,
 * �װ� �ƴ϶�� ���� �ɾ�� �Ѵ�.
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
		// Vector : ��Ƽ �����带 ����ؼ� ������� ��ü (����ȭ ó���� �ص�)
		// 			���ÿ� ���������忡�� ��ü�� ���ǵ�, �����ϰ� ó���� ��. (��ſ� add �۾��� ���ſ�)

		// ArrayList : ��Ƽ �����带 ������� �ʰ�, ����(Single) �����常�� �����ؼ� ó����. 
		// 			(����ȭ ó���� ���ϰ�)
		
		// ����ȭ ó���� ���ʿ� �ȵ��ִ� ��ü�� ����ϴٺ���, ����ġ ���� ������ �߻��Ҽ� �ִ�. 
		
		List<Integer> li = new ArrayList<>();	
		
		NumberSaver t1 = new NumberSaver(li);
		NumberSaver t2 = new NumberSaver(li);
		
		t1.start();
		t2.start();
		System.out.println("MAIN-TERMINATE");
		
		
		
	}
}
	
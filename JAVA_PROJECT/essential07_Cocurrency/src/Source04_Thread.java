import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/*
 *  �����ؾߵǴ� ��
 *   ���� �����忡�� ���� ��ü�� ���ٽ� ���ÿ� ����Ѵٴ� ��
 *   �ű⼭ �߻��ϴ� ����ȭ��� ���� �˾ƾ� �Ѵ�.
 *   
 *  ���࿡ ���ʿ� ���û��Ǵ� ��ü�� �����ü�� synchronized �صξ��ٸ�
 *   multi-thread���� �����ϰ� �۵��ϰ�����, �װ� �ƴ϶�� lock�� �ɾ�� �Ѵ�.
 */
class NumberSaver extends Thread {
	List<Integer> li;

	NumberSaver(List<Integer> li) {
		this.li = li;
	}
	synchronized void test() {
		// �����ÿ� ���� ����
	}
	
	@Override
	public void run() {
		for (int i = 1; i <=10000; i++) {
			synchronized (li) { // �������� Lock�� �����ϴ� ���� 
				li.add(i);				
			}
		}
		String name = getName(); //������ �̸�
		System.out.println("["+name+"]"+"size = "+li.size());
	}
}

public class Source04_Thread {
	public static void main(String[] args) {
		//List<Integer> li = new ArrayList<>();
		//ArrayList�� ���ü�ó�� �ȵǴ� ��ü
		
		List<Integer> li = new ArrayList<>(); 
		
		// Vector�� Thread����, �켱���� �ο��Ͽ� ��������
		
		// Vector : ��Ƽ �����带 ����ؼ� ������� ��ü (����ȭ ó���� ����)
		//			���ÿ� ���������忡�� ��ü�� ���ǵ�, �����ϰ� ó���� ��
		//			(��ſ� add �۾��� ���ſ�(����))
		
		// ArrayList : ��Ƽ �����带 ������� �ʰ�, (����ȭ ó���� ����)
		//			   ����(Single) �����常�� �����ؼ� ó���� 
		
		// synchronized : lockó��
		
		// ����ȭ ó���� ���ʿ� �ȵǴ� ��ü�� ����ϴٺ���,
		// ����ġ ���� ������ �߻��Ҽ� �ִ�.
		
		NumberSaver t1 = new NumberSaver(li);
		NumberSaver t2 = new NumberSaver(li);
		
		t1.start();
		t2.start();
		System.out.println("Main-TERMINATE");
	}
}

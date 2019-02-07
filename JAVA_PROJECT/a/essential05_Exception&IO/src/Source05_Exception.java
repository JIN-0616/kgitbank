import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * 
 */
public class Source05_Exception {
	public static void main(String[] args) {
		/*
		 * catch�� �ͼ��� ��Ƽ� �ó���� �Ҳ���..?
		 * 
		 * 1. �����޽��� ����ְ� ���α׷� ���Ḧ ��Ű����,
		 * 
		 * 2. �� ��Ȳ�϶��� �ٸ������� �۵��Ҽ� �ְ� �����Ѵٴ��� 
		 */
		/*
		 * ��Ʈ��ũ ���α׷��� ����ٰ� ����������, ������ �ȵǼ�
		 *  ���̻��� �۾��� ���ǹ��ϴٸ�
		 */
		Socket s = null;
		try {
			s = new Socket("192.168.10.27", 5040);
			System.out.println("try success");
		}catch(UnknownHostException  e) {
			System.out.println(e.getMessage());	// �ͼ��� �߻��� ������ ������ ���մµ� �װ� Ȯ���غ��ٵ���
			System.exit(0);	// ���α׷� ����
		}catch(IOException e) {
			System.out.println(e.toString());	// toString()���� Ȯ���غ��ٵ���.
			System.exit(0);	// ���α׷� ����
		}
		System.out.println(s.isConnected());
		//================================================================================
		Triangle t = null;
		try {
			t = new Triangle(1, 2,2);
			System.out.println("try success");
		}catch(NotEnoughException e) {
			System.out.println("try fail");
			t = new Triangle(1,1,1);
		}finally {
			System.out.println("finally object = " + t);
		}
		// try~ catch �۾��ϸ鼭 finally block ������ �����ѵ�,
		// finally ó���� �κ��� try success �ϴ�, fail�� �ϴ� ������ �۵��ؾߵǴ� �۾���
		// �����Ҷ� ���. 
		//  
		
		
		
		
		
		
		
	}
}
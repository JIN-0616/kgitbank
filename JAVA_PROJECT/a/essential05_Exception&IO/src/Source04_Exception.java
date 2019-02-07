import java.net.DatagramSocket;
import java.net.SocketException;

/*
 * �ʼ�ó�� Exception �� extends Exception ���� ��ü�� ����
 */
class CriticalException extends Exception {
	
}

class Account {
	int balance;
	
	public void addBalance(int m) throws CriticalException {
		if(m < 0) {
			// �ͼ����� �Ͷ߸���, �̰� �ʼ������� ó���� ������ �ͼ����� �Ͷ߸����� �Ѵٸ�
			// �׳��� �ȵǰ�, �����Ҷ� �ͼ����� �߻���Ű�ڴ�(����Ѱ������� �ѱ�ڴ�.)��
			// ������ �ϰ� ������ �Ѵ�. 
			throw new CriticalException();	 
		}
		if(m %100 !=0)
			throw new InvalidException();
		
		balance += m;
	}
}

public class Source04_Exception {
	public static void main(String[] args) {
		Account ac = new Account();
		try {
			ac.addBalance(100);	// �� �۾��� �Ҷ� CriticalException�� �߻��ϰ� �ɶ�
								// ��� �ϰٴٶ�� ó���� �ؾ����� ����Ҽ� �ִ�.
			System.out.println("try success");
		}catch(CriticalException e) {
			System.out.println("CriticalException");
			System.out.println("try fail");
		}
		//==================================================================
		try {
			Thread.sleep(2000, 100);	// millis, nano  Thread.sleep(-1) 
			System.out.println("try success");
		}catch(InterruptedException  e) {
			System.out.println("try fail");
		}
		
		
		try {
			new DatagramSocket(5353);		// 
			System.out.println("try success");
		} catch (SocketException e) {
			System.out.println("SocketException .. try fail" );
		}	
		
		
		
	}
}

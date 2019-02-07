import java.net.DatagramSocket;
import java.net.SocketException;

/*
 * 필수처리 Exception 은 extends Exception 으로 객체를 설계
 */
class CriticalException extends Exception {
	
}

class Account {
	int balance;
	
	public void addBalance(int m) throws CriticalException {
		if(m < 0) {
			// 익셉션을 터뜨릴때, 이게 필수적으로 처리를 유도할 익셉션을 터뜨리고자 한다면
			// 그냥은 안되고, 설계할때 익셉션을 발생시키겠다(사용한곳쪽으로 넘기겠다.)고
			// 선언을 하고 만들어야 한다. 
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
			ac.addBalance(100);	// 이 작업을 할때 CriticalException이 발생하게 될때
								// 어떻게 하겟다라고 처리를 해야지만 사용할수 있다.
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

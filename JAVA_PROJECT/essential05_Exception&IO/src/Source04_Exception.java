import java.net.DatagramSocket;
import java.net.SocketException;

/*
 * 필수처리 Exception 은 extends Exception 으로 객체를 설계
 */

class CriticalException extends Exception {
								//중요 Exception은 Exception을 extends 받아서 생성
								//-->상황에 적용시에 throws ExceptionName을 걸고 적용해야하는 강제성부여
}

class Account {
	int balance;
									//설계시 throws를 걸게되면 try~catch작업이 강제된다.
	public void addBalance(int m) throws CriticalException{
		if (m < 0) {
			// 익셉션을 던질때, 이게 필수적으로 처리를 유도할 익셉션을 터트리고자 한다면
			// 그냥은 안되고, 설계할때 익셉션을 발생시키겠다(사용한곳쪽으로 넘기겠다.)고
			// 선언을 하고 만들어야 한다.
			throw new CriticalException();
		}
		if(m %100 !=0) {
			throw new InvalidException();
		}
		balance += m;
	}
}

public class Source04_Exception {
	public static void main(String[] args) {
		Account ac = new Account();
		try {
			ac.addBalance(1000); 	// 이 작업을 할때 CriticalException이 발생하게 될때
									// 어떻게 하겠다라고 처리를 해야지만 사용할수 있다.
			System.out.println("try success");
		}catch(CriticalException e) {
			System.out.println("CriticalException");
			System.out.println("try fail");
		}
		//-----------------------------------------------
		try {			//millis, nano  Thread.sleep(-1);
			Thread.sleep(1000,100);			//프로그램적 딜레이를 주고자 하는 상황
											//멀티쓰레드상황에서 발생하는 예외상황을 꼭 예외처리해야 사용가능
											//코드로 막을수 없는 익셉션에 대한 처리는 강제됨
											//그 외의 상황에 대해서는 강제가 아님(선택사항)
			System.out.println("try success");
		} catch (InterruptedException e) {
			 System.out.println("try fail");
		}
		
		try {
			new DatagramSocket(3702);	//5353 음수면 에러
										//자기컴퓨터의 사용할 소켓설정
		} catch (SocketException e) {
			System.out.println("SocketException...try fail");
		}
	}
}

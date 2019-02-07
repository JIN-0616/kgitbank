package server;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerMain {
	public static ArrayList<String> list;
	public static void main(String[] args) {
		System.out.println("[server] started");
		list = new ArrayList<String>();
			list.add("1-A");
			list.add("1-B");
			/*
			 *  사용자간에 공통적으로 써야되는 객체가 있을때,
			 *  이걸 메인쓰레드에서 꼭 일일히 만들어서 넘겨줘야 하나?
			 *  
			 *  결론은 안그래도 된다.
			 *  ---------------------------------------------
			 * 	static List<String> seats;
	
				static {
					seats = new ArrayList<>();
					seats.add("1-A");
					seats.add("4-H");
				}
				
			 *  Socket socket;
				ObjectInputStream ois; 
				ObjectOutputStream oos;
				 ---------------------------------------------

			 */
		try {
			ServerSocket sc = new ServerSocket(56789);
			
			//사용자 접속종료후 다른사용자 접속을 위한 구조
			while(!sc.isClosed()) {
				Socket soc =sc.accept(); // 쓰레드로 넘기면 안됨
				System.out.println("[server] init....");
				
				Thread p = new ServerPersonal(soc);
				p.start();
				
			}
			sc.close();
		} catch (IOException e) {
			System.out.println("[server] network error"+e.toString());
		}
	}
}

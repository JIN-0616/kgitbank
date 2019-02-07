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
			 *  ����ڰ��� ���������� ��ߵǴ� ��ü�� ������,
			 *  �̰� ���ξ����忡�� �� ������ ���� �Ѱ���� �ϳ�?
			 *  
			 *  ����� �ȱ׷��� �ȴ�.
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
			
			//����� ���������� �ٸ������ ������ ���� ����
			while(!sc.isClosed()) {
				Socket soc =sc.accept(); // ������� �ѱ�� �ȵ�
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

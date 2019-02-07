import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Exercise02_Client {
	public static void main(String[] args) {
		/*
		 * TCP������� �����Ǵ� ���α׷� ���� ��쿣 �Ź� ������ �õ��ϴ°� �ƴ϶�,
		 */
		Scanner cin = new Scanner(System.in);
		System.out.print("[client] input server ip address : ");
		String ip = cin.nextLine();
		try(Socket soc = new Socket(ip, 56789);) {
			/*
			 * ���α׷��� ���۵Ǹ鼭 �ѹ� ������ ��Ƽ�, IO Ȯ���ϰ�
			 */
			System.out.println("[client] connected to server");
			ObjectOutputStream oos = new ObjectOutputStream(soc.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(soc.getInputStream());
			System.out.println("[client] established i/o stream");
			
			// �翬���̳�, io �� Ȯ�� ����, ��� ���� ��Ų���¿��� ������ �ְ� ������ �ȴ�.
			while(soc.isConnected()) {
				System.out.print("[client] request : ");
				String req = cin.nextLine();
				if(req.equals("exit")) {
					break;
				}
				oos.writeObject(req);
				String resp = (String)ois.readObject();
				System.out.println("[client] response : " + resp);			
			}
			
		}catch(ClassNotFoundException |IOException e) {
			System.out.println("[client] network error " + e.toString());
		}
		/*
		 * �������� ���������̴�.
		 * �ѹ� accept �޾Ƽ�, io Ȯ�� �� , �״����� ����ڰ� ���� ���������� ó�����ָ� �ȴ�.
		 * 
		 * �� ���α׷��� �̿��ؼ� �����е��� ������ ��� ������ ��û�� �������� �Ѵ�.
		 * �� ��û�� ó�����ִ� TCP ������ ����� �ȴ�.
		 *  
		 *  reserve#1-A   reserve#9-C  �� ���·� ��������.
		 *  	: reserve#����-���ĺ�    
		 *  	�̹� 1-A�� �������� �ִٸ�, "false",  
		 *  	ó�������°Ÿ� �����ϰ� "true"��� �����ּ���.
		 *  
		 *  cancel#1-A   cancel#9-B  �� ���·� ��������
		 *  	: cancel#����-���ĺ�
		 *  	�� �����͸� ������ �־����� ����� "true" ������ "false"
		 *  		
		 * 	(����ڵ��� ���� ������ ������ �÷����� �̿��ؼ� ����,
		 * 	 � ������ �÷����� ���������� �˾Ƽ� �Ǵ�.)
		 * 		
		 * 
		 * 
		 */
		
		
	}
}

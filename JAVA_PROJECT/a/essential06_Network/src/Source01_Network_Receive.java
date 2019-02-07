
/*
 * �������� ���� ���α׷� ���¿ʹ� �ٸ���, 
 * �̹����� java.net ��Ű���� ��ü���� �̿��ؼ� 
 * ��������� ����Ǿ� ���� ���� ���� �ٸ� �ӽŰ��� 
 * �����͸� �ְ� �޴� ��Ʈ��ŷ �۾��� ���Ͽ� �˾ƺ���.
 * 
 *  ��Ʈ��ũ�� �̿��� ������ ������ TCP ��İ� UDP ����� �����Ѵ�.
 *   TCP - ��ȭ ��� (�����ѹ��)
 *   	(���� ���� ������ �Ͼ�� �ϰ� �� �Ŀ� �����͸� �ְ� �޴ٰ� 
 *   		�� �̻� �ְ� ���� �����Ͱ� ���ٸ� ������ ������ ��)
 *   UDP - ���� ��� (������� ���)
 *   	(������ �ּҸ� �˰� ������ ������ ����������� ������ �ޱⰡ ������) 	 
 *  
 * ���α׷��Ӵ� ���� ���ۿ������ٴ�, �� ���۹���� � Ư¡�� ������ �ְ�,
 * 	��Ŀ� ���� ����ϴ� ��ü�� ���¹��� �ٸ��� ���⿡ ���ؼ� ���������� �ȴ�.
 * 
 * ��κ� ��Ʈ��ũ ������ TCP�� ���̽��� ��� �����ϴ°�찡 ����.
 * 	������ü�� UDP�� ���� ���� ������, �̰ͺ��� ���캸�� TCP�� main���� �˾ƺ���.
 */

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;
import java.net.SocketException;

public class Source01_Network_Receive {
	public static void main(String[] args) {
		/* 
		 * UDP �������
		 * ���� ��ǻ�ͷκ��� �����͸� ���۹޾Ƽ� �� ���۹��� �����͸�
		 * Ȯ���غ��� �۾��� �غ����� �Ѵ�. 
		 */
		System.out.println("[�ý���] ��ŸƮ");
		/*
		 * UDP ����� ��쿡�� 
		 * DatagramSocket : (�޽��� ����) 
		 * DatagramPacket : (���� ����)
		 * ��ü �ΰ��� ����ϸ� �ȴ�.
		 */
		DatagramSocket socket= null;
		try {
			socket = new DatagramSocket(45454);	// 1~65535	
			// ����鼭 port ��ȣ�� ��� �������� �����ؾߵǴµ� �⺻ �����ÿ�, �˾Ƽ� ������ ��.
			// �����ÿ� ���ϴ� ��ȣ�� ����Ҽ� ������, �̹� ������̰ų� ���� ��ȣ�� Exception�� ��.
			int port = socket.getLocalPort();
			System.out.println("[�ý���] ���� Ȯ����! " + port);
			for(int cnt=1;cnt<=100;cnt++) {
				// �޴� �۾��� �غ����� �ϴµ�,
				// Packet ��ü�� �����ϴµ� byte[] �迭 ������ �������ְ�, �ڿ� �迭 ũ�⸦ �������ָ� ��.
				byte[] t = new byte[1024];
				DatagramPacket packet = new DatagramPacket(t, 1024);
				// DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);	
				System.out.print("[�ý���] ���Ŵ��..");
				socket.receive(packet);	// receive ���� �صθ�.. ��⿡ �ִٰ�, ���� ���� ������..
				SocketAddress addr = packet.getSocketAddress();
				System.out.println("�Ϸ� .. "+ addr.toString() );	// Ǯ����
				byte[] b = packet.getData();
				System.out.println((b == t)   + "? ");
				int len = packet.getLength();
				// System.out.println(b.length+ ".. " + len);
				// byte[]  �� String  (�� parse or split)
				String recv = new String(b, 0, len);
				System.out.println("[�ý���] ���� ��Ŷ�� ������ : " + recv);
				/*
					System.out.println(b.length);
					for(int i=0; i<10; i++) {
						System.out.println(b[i]);
					}
				*/
			}
			
			socket.close();	// try with resource �� ���� ¥�� ��.
			
		} catch(SocketException se ) {
			System.out.println("[�ý���] ���� ����! (��Ʈ �浹)" + se.toString());
		} catch(IOException e) {
			System.out.println("[�ý���] ���� ����! (��Ʈ �浹)" + e.toString());
		} finally {
			if(socket != null)
				socket.close();
		}
		
		
		
		
	}
}















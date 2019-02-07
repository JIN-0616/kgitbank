
/*
 * �������� ���� ���α׷� ���¿ʹ� �ٸ���,
 *  �̹����� java.net ��Ű���� ��ü���� �̿��ؼ� ��������� ����Ǿ� ���� ����
 *  ���� �ٸ� �ӽŰ��� �����͸� �ְ� �޴� ��Ʈ��ŷ �۾��� ���Ͽ� �˾ƺ���.
 *  
 * ��Ʈ��ũ�� �̿��� ������ ���� ����� TCP ���, UDP ����� �����Ѵ�.
 * 
 *  TCP - ��ȭ ��� -(�����ѹ��)
 *      (���� ���� ������ �Ͼ�� �ϰ�, �� �Ŀ� �����͸� �ְ� �޴ٰ� ������ �����
 *       �� �̻� �ְ� ���� �����Ͱ� ���ٸ� ������ ������ ��)  
 *       
 *  UDP - ���� ��� -(�� ������ ���)
 *  	(������ �ּҸ� �˰� ������ ������ ����������� �����͸� ������ް� ������)
 * 		- ���ۼӵ� �� ����
 * 
 * ���α׷��Ӵ� ���� ���ۿ������ٴ�, �� ���۹���� � Ư¡�� ������ �ְ�,
 *  ��Ŀ� �ٶ� ����ϴ� ��ü�� �ٸ���, ������ �ٸ��� ���⿡ ���Ͽ� ���������� �ȴ�.
 *  
 * ��κ� ��Ʈ��ũ ������ TCP�� ���̽��� ��� �����ϴ� ��찡 ����.
 *  ���� ��ü�� UDP�� ���� ���� ������, �̰ͺ��� ���캸�� TCP�� main���� �˾ƺ���.
 */
import java.io.IOException;
import java.net.*;

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
		 *  DatagramSocket : �ۼ��ű� (�޽��� ��Ȱ)
		 *  DataggramPacket : ������ (���� ��Ȱ)
		 *   ��ü �ΰ��� ����ϸ� �ȴ�.
		 */
		
		//��Ģ�� �ܺο��� ����=null, finally���� !=null�̸� close();
		
		DatagramSocket socket = null;
		try {
			socket = new DatagramSocket(49604); // 1~65535 
			// ����鼭 port ��ȣ�� ����������� �����ϸ� ����
			// �޴� �ʿ����� ���� �����ϴ� ���� ��õ
			// ==> �������� ȸ���Ҷ� ������ ��Ʈ�� �˼��ֱ⶧����
			
			// �⺻ �����ÿ�, �˾Ƽ� ������ ��  but,  BindException --> ��Ʈ��ȣ �浹 ����
			// �����ÿ��� ���ϴ� ��ȣ�� ����Ҽ� ������, �̹� ������̰ų� ���� ��ȣ�� Exception�߻�
			int port = socket.getLocalPort();			
			System.out.println("[�ý���] ���� Ȯ���� "+port );
			
			// �޴� �۾��� �غ����� �ϴµ�,
			// Packet ��ü�� �����ϴµ� byte[] �迭 ������ �������ְ�, �ڿ� �迭ũ�⸦ �������ָ� ��
			byte[] t = new byte[1024];
		//	DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
			DatagramPacket packet = new DatagramPacket(t, 1024);

			System.out.print("[�ý���] ���Ŵ��...");
			socket.receive(packet); //IOException,
			// receive �����صθ� ����� �ִٰ�, ���� ���޹����� ������½� ���������
			SocketAddress addr = packet.getSocketAddress();
			System.out.println("�Ϸ�... "+addr.toString()); // Ǯ����
			
			byte[] b = packet.getData();
			int len = packet.getLength(); // send �ʿ��� ������ length
			System.out.println(b.length+"..."+len); //String ���� ���� 2����Ʈ
			
			// byte[] �� String (��parse or split)
			String recv = new String(b, 0, len);
			System.out.println("[�ý���] ���� ��Ŷ�� ������ : "+recv);
			
			/*
				System.out.println(b.length);
				for (int i = 0; i < 10; i++) {
					System.out.println(b[i]);
				}
			*/			
			
			//socket.close(); // try with resource ������ �����ص� ��
		} catch (SocketException e) {
			System.out.println("[�ý���] ���� ����!! (��Ʈ �浹) "+e.toString());
		} catch (IOException e) {
			System.out.println("[�ý���] ���� ����!! (��Ʈ �浹) "+e.toString());
		} finally {
			if(socket != null)
				socket.close();
		}
		
	}
}
/*
==================================================
 ������
 packet { byte[] , address } ==> Socket
        data->    to->

--------------------------------------------------
 ������
 Socket 	<--packet = { addr | byte[] }

   -->  packet{ �������addr | byte[] }
==================================================

 input/receive		
-------------->				init
				[server]   <- File/Dir	
<-------------			  
  output/send			    exit
  						   -> File/Dir
 

==================================================
[ USER ]
 cli
 gui
 ->	 output/send
 -------------------->
  
 <-------------------
 	input/receive
  
 ->cli
   gui 
[ USER ]  
==================================================

*/
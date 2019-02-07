import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
/*
 * client �� server ���� ������ packet�� �����͸� ���� ���ؼ�, ������ �ϰ� �ִµ�
 * 
 * ����, ���������� ���ְ� ���� ����� �ջӸ� �ƴ϶�, �ִ밪, ��� �̷��͵� ���ְ� 
 * �ʹٸ�..���?
 * 	1. ��Ʈ���� ������ ������ �� ���� ���� (�� 60000�� ��, 60001�� ���...) - ��ȿ������.
 *  1. �̸����� ���α׷� ���� ���� (��Ŷ�� ���û������ ���� ����, ��û�� ���� �ٸ� ó��) - ȿ������
 *  
 *   
 */
public class Exercise01_Server {
	public static void main(String[] args) {
		System.out.println("[server] starting");
		try (DatagramSocket ds = new DatagramSocket(54321);) {
			System.out.println("[server] started");
			
			for(int cnt=1; cnt<=10; cnt++) {
				System.out.print("[server] listen,  ");
				DatagramPacket resp = new DatagramPacket(new byte[1024], 1024);
				ds.receive(resp);
				String data = new String(resp.getData(), 0, resp.getLength());
				System.out.println("received data " + data);

				String[] datas = data.split(" ");     // split(" ");
				List<Integer> li = new ArrayList<>();
				for(int i=1; i<datas.length; i++) {
					li.add(Integer.valueOf(datas[i]));
				}
				/* 
				 * sort �� null �����ϸ�, ��ü ��ü order�� ���� ���ĵ�.
				 * �׿��� order�� ���� ������ Comparator �� �ʿ��ϴٰ� ��.
				 */
				Comparator c = new Comparator<Integer>() {
					@Override
					public int compare(Integer o1, Integer o2) {
						if(o1.intValue() < o2.intValue())
							return -1;
						else if(o1.intValue()>o2.intValue())
							return 1;
						else 
							return 0;
					}
				};
				
				li.sort(c);
				System.out.println(li.get(0));	// min
				System.out.println(li.get(li.size()-1));	// max
				
				String result;
				switch(datas[0]) {
				case "sum":
					result = "sum error";
					break;
				case "avg":
					result = "avgerage error";
					break;
				case "max":
					result = "max error";
					break;
				default:
					result = "unknown mode";
				}
				
				byte[] b = result.getBytes();
				DatagramPacket req = new DatagramPacket(b, b.length, resp.getSocketAddress());
				ds.send(req);
				System.out.println("[server] data sent : "+ result);
			}
			
			
			
			
			
		} catch (IOException e) {
			System.out.println("[server] terminated by error " + e.toString());
		} finally {
			System.out.println("[server] shutdown");
		}

	}
}

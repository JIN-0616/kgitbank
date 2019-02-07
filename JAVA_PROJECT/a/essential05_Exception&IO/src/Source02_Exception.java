/*
 * �ڹٿ��� Exception ��ü���� �������� �����صξ���.
 *  �ռ� ���캻 RuntimeException ��ü���� �ؼ�, 
 *  IndexOutOfBoundsException, NullPointerException ��ü ���� ���� ���� ����.
 *  
 *  ���α׷��� ���̻� �����ʿ䰡 ���ٰ� �����ϴ� ��Ȳ�� ��ü�� ���� �����аű� ������,
 *  �� ��Ȳ�� ���� ��ü���� ����ȭ���� �����ϴٺ���, ������ �پ����� ���̴�.
 */

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class Source02_Exception {
	public static void main(String[] args) {
		String str = "�ڹ��� ���ڿ�";
		// str.substring(5, 2);
		// System.out.println(str.length());
		List<String> li = new ArrayList<>();	
		// li.add(3, "������");
		// �ͼ��� ��ü�� �̿��ؼ� ������ �Ͷ߸��� �صθ�, ������ ���忡�� ���ǹ���ó���� ���ص� �ǰ�, 
		// ��ü�� ���� ������ ���忡�� �����ؼ� ����ϱ� ������ ���� ������ ���α׷��� �������� �����
		// �ϰ� ���� �Ҽ� �ִ�.
		
		/*
		 *  �� �ͼ��� ��ü��, ũ�� �ΰ����� �з��� �Ǵµ�,
		 *  
		 *  �ϳ��� ��ġ�ص� �Ǵ� �ͼ���, (�ͼ���ó���� �ʼ��� �ƴ�)
		 *  	JVM�� ũ�� �ǿ����� ����, if�� ���α׷������� �� ���Ƴ��� �ִ� �͵��� ����.
		 *  
		 *  �ٸ� �ϳ��� ��ġ�ؼ��� �ȵǴ� �ͼ��� (�ͼ���ó���� �ʼ���)
		 *  	���� ������ �ǹپ߸� �ƴ� ���ܵ��, ���α׷������� ���Ƴ��°� �Ұ����ϰ�
		 *  	������ ��� �ǳĿ� ���� �߻��Ҽ��� �ְ�, �ƴҼ��� �ִ� ���ܵ��
		 *  	�̷� ���ܴ� JVM������ ���°� ���ƾ߸� �ϴ� �͵�. 
		 *   	
		 *  
		 *  ����¿� ���õ� ��ü�鵵 Ÿ ��ü���̶� ����������, Exception �� �߻��ϱ� ������,
		 *  ���� ���� ó���� �ʼ��� �ͼ��ǵ� ���ַ� �߻��ؼ� ó������ ���� �˾ƾ� �Ѵ�.
		 */
		// Socket ��ü�� ��ſ� ���Ǵ� ��ü�ε�,
		// �� ���� ������ �ͼ��ǵ��� �߻��ǰ� ������ִ�.
		// UnknownHostException,  IOException , IllegalArgumentException , �̷��� 3��
		// ���߿���, �տ�2���� �ʼ� ó�� �ͼ���, �ڿ� �ϳ��� �ʼ�ó���� �ƴ�.
		// �տ� �ΰ��� �ͼ����� ó���� ���� ������ ��ü ����� �Ұ����ϴ�.
				
		try {
			new Socket("192.168.10.27", 135);	//
			System.out.println("��ü ���� ����");
		} catch(UnknownHostException e) {	// java.net
			System.out.println("UnknownHostException");
		} catch(IOException e) {	// java.io
			System.out.println("IOException");
		} catch(IllegalArgumentException e) {
			System.out.println("IllegalArgumentException");
		}
		
		System.out.println("���� ����");
		
	}
}








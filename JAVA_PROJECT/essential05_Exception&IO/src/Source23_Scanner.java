import java.util.Scanner;

public class Source23_Scanner {
	public static void main(String[] args) {
		/*
		 * Scanner �� java.io ��Ű���� ��ü�� �ƴϴ�. java.util. ��Ű���� ��ü
		 *  ����� �۾� ��ü�� �Ҽ��� �������� �ʾҴ�.
		 */
		String data = "������ ������̴�.\n�� ������ ����ð��̴�.\n2018 10.25";
		System.out.println(data);
		Scanner scan = new Scanner(data);
		
		String s1 = scan.nextLine(); 			// �ٹٲޱ����� ���� �� Ŀ���ȱ�
		System.out.println("s1 = "+s1);
		
		for (int i = 1; i <= 3; i++) {
			String s2 = scan.next();				// ���������� ������, ��������� ����, 
			System.out.println("s2 = "+s2);	
		}
		
		String s3 = scan.nextLine(); 			
		System.out.println("s3 = "+s3+"..."+s3.length());
		
		int n = scan.nextInt(); //next()�� String�� parseInt() : �ڵ��Ḻ̌��
		System.out.println(n);
		double d = scan.nextDouble();
		System.out.println(d);
		System.out.println(scan.hasNext()); // ���� �����Ͱ� �����ִ����� �˷��ִ� �޼ҵ�
		scan.next(); 						// ���� �����Ͱ� ������ NoSuchElementException �� �߻�
		//===================================================================
		
		// Scanner ��ü�� ���ڿ��� ���� �ҽ��� ���� ���ص�,
		// ����byte�� �о�� �ִ� InputStream�� �����ص� 
		// �ش� Input�� �˾Ƽ� �����ؼ� ���ڵ��� Ȯ���ϸ鼭 �۾��� �Ѵ�.
		
		// �о�� �ִ� Stream�� �Ѱܵ� �� ex) System.in
		
	}	
}

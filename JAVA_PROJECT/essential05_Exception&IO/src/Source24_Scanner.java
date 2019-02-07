import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

// Scanner ��ü�� ���ڿ��� ���� �ҽ��� ���� ���ص�,
// ����byte�� �о�� �ִ� InputStream�� �����ص� 
// �ش� Input�� �˾Ƽ� �����ؼ� ���ڵ��� Ȯ���ϸ鼭 �۾��� �Ѵ�.

// �о�� �ִ� Stream�� �Ѱܵ� �� ex) System.in
public class Source24_Scanner {
	public static void main(String[] args) {
		/*
		 * Scanner �� System.in �����ߴ� ����
		 * Ű����� �Է¹��� ������, ������ �������� �ʴ� �޸𸮻��� ���ϰ��� ����
		 * byte�� ������ �Ǵµ�, �ű⼭ byte���� �о�� �ְ� ������ ��ü�� System.in
		 * 
		 * �� �Է¹��ۿ��� ������ �� byte�� ���ٸ�, �ý��������� ��� ���¿� ������ �Ǿ��ִ�.
		 */
		System.out.println("Use Scanner=>");
		Scanner cin = new Scanner(System.in);
		System.out.println(cin.next());	// ������ 3 5 OKKKKKKKKK!
		int a = cin.nextInt();
		int b = cin.nextInt();
		System.out.println(a+b);
		String s = cin.nextLine(); //���Ͱ� ���� �����ִٸ� �װ� �������ԵǼ� ������
		System.out.println(s);
		cin.nextLine(); // �������� ���ٸ� �����·�
		
		
		try(Scanner scan = new Scanner(new FileInputStream("last-log.txt"));) {
			System.out.println(scan.hasNext() + "..."+scan.hasNextLine());
			
			System.out.println(scan.next());
			System.out.println(scan.nextLine());
			
			System.out.println(scan.nextDouble());
			System.out.println(scan.nextLine());
			System.out.println(scan.nextLine());
			System.out.println(scan.nextLine());			
		} catch (IOException e) {
			System.out.println("# scan Error #");
		}
	}
}
/*

true...true
���ڿ�
 ����غ���!!
3.141592653589793

true
44651

*/
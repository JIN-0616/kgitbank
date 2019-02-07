import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

// Scanner ��ü��  ���ڿ��� ���� �ҽ��� �������ص�, 
// ����byte�� �о�� �ִ� InputStream �� �����ص�  
// �ش� input�� �˾Ƽ� �����ؼ� ���ڵ��� Ȯ���ϸ鼭 �۾��� �Ѵ�
public class Source24_Scanner {
	public static void main(String[] args) {
		/*
		 * Scanner System.in �����޴���.. 
		 * Ű����� �Է¹��� ������, ������ �������� �ʴ� �޸𸮻��� ����(�Է¹���)���� ���� 
		 * byte�� ������ �Ǵµ�, �ű⼭ byte���� �о�� �ְ� ������ ��ü�� System.in 
		 * 
		 * �� �Է¹��ۿ��� ������ �� byte�� ���ٸ�, ���α׷������� ��� ���¿� ������ ���ִ�.
		 */
		System.out.println("USE SCANNER==");
		Scanner cin = new Scanner(System.in);
		System.out.println(cin.next());
		int a = cin.nextInt();
		int b = cin.nextInt();
		System.out.println(a+b);
		String s = cin.nextLine();
		System.out.println(s);
		cin.nextLine();
		try(Scanner scan = new Scanner(new FileInputStream("last-log.txt"));) {
			System.out.println(scan.hasNext() + ".." + scan.hasNextLine());
			
			System.out.println(scan.next());
			System.out.println(scan.nextLine());
			
			System.out.println(scan.nextDouble());
			System.out.println(scan.nextLine());
			System.out.println(scan.nextLine());
			System.out.println(scan.nextLine());
			
			
		}catch(IOException e) {
			System.out.println("# scan Error #");
		}
	}
}

import java.util.Scanner;

public class Exercise05 {
	public static void main(String[] args) {
		/*
		 * ����Ų��� 31 ������
		 * 	- ����ڴ� �ִ� 3������ �Է°��� (��ġ�� �ȵ�)
		 *  - �� �Ϸ��� ���ڸ� ��ĥ �ʿ�� ���� 
		 *  (ù��° ���ڰ� ���� ������ +1 �̱⸸ �ϸ�ȴ�)
		 *  - ���� ��ģ ���ڳ� ������ ��ģ���ڸ� ����� �ȳ��� �� ��ġ�� �ȵ�.
		 *  
		 *  - ���� ��ĥ ���ڰ� �� �̻� �������� �ʴ´ٸ�, ������ ��. 
		 *  
		 *  (������ 1~15���� �� ��ȿ)
		 */
		Scanner cin = new Scanner(System.in);
		
		while(true) {
			System.out.print("[system] ");
			String in = cin.nextLine();
			String[] ar = in.split(" ");
			System.out.println(ar.length);
			
		}
	}
}

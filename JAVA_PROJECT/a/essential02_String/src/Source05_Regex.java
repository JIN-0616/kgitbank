import java.util.Scanner;

public class Source05_Regex {
	public static void main(String[] args) {
		/*
		 * ��ݻ��캻�͵��� �����ϳ��� �����ѰŰ�,
		 * [Ư���׷�]<���ѹ���>
		 * 			? �ְų� ���ų� {0,1}
		 * 			+ �Ѱ��̻��־�� �ȴ�. {1,}
		 * 			* ��� �ǰ� �������� �־ �ȴ�. {0,}
		 * 			{n} ��Ȯ�ϰ� ��� �־�� �Ѵ�.
		 * 			{n,} �ּ��� ��� �־�� �Ѵ�.
		 * 			{n,m} �ּ��� �, �ִ� �
		 */
		String[] s1 = "A1,A-1,B-14,C-".split(",");
		for(int i = 0 ; i< s1.length; i++) {
			System.out.println(s1[i] + " matches " + s1[i].matches("\\w-?\\d"));
		}
		System.out.println();
		String[] s2 = "A1,A-1,B-14,C-".split(",");
		for(int i = 0 ; i< s1.length; i++) {
		//	System.out.println(s2[i] + " matches " + s2[i].matches("\\w-?\\d+"));
			System.out.println(s2[i] + " matches " + s2[i].matches("\\w-?\\d*"));
		}
		System.out.println();
		String[] s3 = "41��9135,97 ��4535,11��321".split(",");
		for(int i = 0 ; i< s3.length; i++) {
			System.out.println(s3[i] + " matches " + s3[i].matches("\\d{2}\\s{0,1}[��-Ş]\\d{3,4}"));
		}
		Scanner cin = new Scanner(System.in);
		/*
		System.out.print("��� ����ó?(�ڵ�����ȣ) : ");
		String in = cin.nextLine();
		boolean r = in.matches("01[01789]-?\\d{3,4}-?\\d{4}");
		System.out.println("r = " + r);
		*/
		System.out.println("���� �̸���? ");
		/*
		 *  ������ ©�� + * ? [ {   }  ] �̷����� �ǹ̸� �ǹ̸� ��� �ִ� �����ε�
		 *  �̰� ������ü�� �νĽ�Ű���� \\
		 *  
		 *  Ư�������� �׷�ó���� ������ ()
		 */
		String addr = cin.nextLine();
		boolean rr =addr.matches("\\w{1,}@\\w{1,}\\.\\w{1,}(\\.\\w{1,})*");
		boolean rrr =addr.matches("\\w{1,}@\\w{1,}(\\.\\w{1,}){1,}");
		System.out.println("rr = "+ rr);
		
	}
}




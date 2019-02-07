import java.util.Scanner;

public class Source05_Regex {
	public static void main(String[] args) {
		/*
		 * 방금살펴본것들은 문자하나를 설정한거고,
		 * [특정그룹]<제한문자>
		 * 			? 있거나 없거나 {0,1}
		 * 			+ 한개이상있어야 된다. {1,}
		 * 			* 없어도 되고 여러개가 있어도 된다. {0,}
		 * 			{n} 정확하게 몇개가 있어야 한다.
		 * 			{n,} 최소한 몇개가 있어야 한다.
		 * 			{n,m} 최소한 몇개, 최대 몇개
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
		String[] s3 = "41오9135,97 나4535,11허321".split(",");
		for(int i = 0 ; i< s3.length; i++) {
			System.out.println(s3[i] + " matches " + s3[i].matches("\\d{2}\\s{0,1}[가-힇]\\d{3,4}"));
		}
		Scanner cin = new Scanner(System.in);
		/*
		System.out.print("비상 연락처?(핸드폰번호) : ");
		String in = cin.nextLine();
		boolean r = in.matches("01[01789]-?\\d{3,4}-?\\d{4}");
		System.out.println("r = " + r);
		*/
		System.out.println("개인 이메일? ");
		/*
		 *  패턴을 짤때 + * ? [ {   }  ] 이런식의 의미를 의미를 담고 있는 문자인데
		 *  이걸 문자자체로 인식시키려면 \\
		 *  
		 *  특정패턴을 그룹처리가 가능함 ()
		 */
		String addr = cin.nextLine();
		boolean rr =addr.matches("\\w{1,}@\\w{1,}\\.\\w{1,}(\\.\\w{1,})*");
		boolean rrr =addr.matches("\\w{1,}@\\w{1,}(\\.\\w{1,}){1,}");
		System.out.println("rr = "+ rr);
		
	}
}




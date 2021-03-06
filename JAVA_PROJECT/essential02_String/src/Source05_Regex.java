import java.util.Scanner;

public class Source05_Regex {
	public static void main(String[] args) {
		/*
		 * 방금 살펴본것들은 문자하나를 설정한것이고,
		 * 
		 * [특정그룹] <제한문자>
		 * 
		 * 				?	있거나 없거나 {0,1}
		 * 
		 * 				+	1개 이상 있어야 된다 {1,}
		 * 
		 * 				*	없어도 되고 여러개가 있어도 된다. {0,}
		 * 	
		 * 				{n}		정확하게 몇개가 있어야 된다
		 * 
		 * 				{n,}	최소한 몇개가 있어야 한다
		 * 
		 * 				{n,m}	최소 몇개 이상, 최대 몇개 이하
		 * 
		 */
		String[] s1 = "A1,A-1,B-14,C-".split(",");
		for (int i = 0; i < s1.length; i++) {
			System.out.println(s1[i]+ " matches "+ s1[i].matches("\\w-?\\d"));
		}
		System.out.println();//---------------
		String[] s2 = "A1,A-1,B-14,C-".split(",");
		for (int i = 0; i < s1.length; i++) {
			//System.out.println(s2[i]+ " matches "+ s2[i].matches("\\w-?\\d+")); //1개이상
			System.out.println(s2[i]+ " matches "+ s2[i].matches("\\w-?\\d*"));
		}
		System.out.println();//---------------
		String[] s3 = "41오9135,97 나4539,1허3211".split(",");
		for (int i = 0; i < s3.length; i++) {
			System.out.println(s3[i]+ " matches "+ s3[i].matches("\\d{2}\\s?[가-힣]\\d{3,}"));
								// 내부콤마띄어쓰기x,공백없이 //숫자2,공백1있없,문자하나,숫자3개이상
		}
		
		Scanner cin = new Scanner(System.in);
//		System.out.println("비상 연락처? (휴대전화 번호) : ");
//		String in = cin.nextLine();
//		System.out.println(in.matches("[0][1]\\d[-]?\\d{4}[-]?\\d{4}"));
								    // "01[01789]-?\\d{3,4}-?\\d{4}"
									//01046148225
									//kyoungho@kgitbank.co.kr
		
		/*
		 *  패턴을 짤때 . + * ? [ ] { } 이런식의 의미를 담고있는 문자인데
		 *  
		 *  이걸 문자자체로 인식시키려면 \\을 붙이고 사용 
		 *  
		 *  특정패턴을 그룹처리가 가능함 ( )
		 *  (사용자패턴) {1,2}
		 *  (사용자패턴) +
		 */
		
		System.out.println("개인 이메일? ");
		String addr = cin.nextLine();
		boolean rr = addr.matches("\\w{1,}@\\w{1,}(\\.\\w{1,}){1,2}"); // (.-> 그냥 입력시 모든문자)
								  // \\w{1,}@\\w{1,}\\.\\w{1,}(\\.\\w{1,})*
		System.out.println("arr = "+rr);
	}
}

/*
 *  정규식 ? regular expression
 */
public class Source04_Regex {
	public static void main(String[] args) {
		// 정규식은 문자열로 작성하면 된다. 
		// 그 안에 문자값들이, 패턴을 분석하는데 사용된다.
		
		/*
		 * [] : 한문자를 나타내고자 할때 사용 이안에 적혀있는 문자는 전부 or 처리
		 *    : 이안에 문자구성을 하고자 할때, 연결되어있는 문자값이라면 - 처리가 가능함.
		 *    예를 들어 [A-Za-z] 알파벳 , [가-힇] 한글완성형문자
		 *    : ^을 붙이면 제외를 의미한다.
		 * 모든 그룹을 만들어서 써야되는건 아니고,
		 * 미리 정해져 있는 특수 그룹이 있다.
		 *  .  아무문자 
		 *  \\d  수치형문자 : [0-9]
		 *  \\D  숫치형문자 제외 : [^0-9]
		 *  \\w : 문자형문자 : [A-Za-z_0-9]
		 *  \\W : \\w 제외
		 *  \\s : 공백형문자 
		 *  \\S : 공백형문자 제외
		 */
		String[] sample = "홍길동,trumt,trump, rump,prump,te0506,Arump".split(",");
		for(int i=0; i<sample.length; i++) {
			String s = sample[i];
			System.out.print("["+ i+"] "+s+" : " );
			// System.out.println(s.matches("[at]rum[pt]") );
			// System.out.println(s.matches("[a-t]rum[pt]") );
			// System.out.println(s.matches("[^a-p]rum[pt]") );
			System.out.println(s.matches(".rum[pt]") );
		}
		System.out.println("loc_p5".matches("loc_[a-z][0-9]"));
		System.out.println("loc_pa".matches("loc_[a-z]\\D"));
		
	}
}

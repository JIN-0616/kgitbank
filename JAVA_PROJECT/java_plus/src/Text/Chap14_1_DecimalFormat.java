package Text;
/*
	1. DecimalFormat
	- 패턴문자열의 형태로 형식화
	- 출력 양식의 "패턴문자열"을 매개변수로 사용하는 생성자를 호출하여
	 객체를 생성하고 이 클래스의 format()메소드를 호출하여 데이터를 형식화 한다.
	 
	 DecimalFormat fmt = new DecimalFormat("패턴문자열");
	 
	 DecimalFormat : 숫자 혹은 문자열의 출력방식
	 	생성자에 String 형태의 패턴을 입력
	 	new DecimalFormat("패턴");
	 	출력 -> printf( DecimalFormat );
	 	
	 	0 : 자릿수 표현, 값이 없으면 0으로 처리
	 	# : 자릿수 표현, 값이 없으면 생략
	 	- : 음수부호, 음수의 표현위치 결정
	 	, : 단위구분자
	 	% : 백분율
	 	; : 양수, 음수 구분	 	
 
*/
import java.text.*;
import java.awt.*;
public class Chap14_1_DecimalFormat {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double dd = -123.456;
		String[] pp = {"0","0.0000","#.####","##,##.##","00,000.00","-##","##-","##.#%","#,##;음수#,##"};
		
		DecimalFormat df = new DecimalFormat("#,##0");	//표현방식 정하기
		
		System.out.println(df.format(dd));	// 숫자 데이터를 표현방식으로 변환
		
		System.out.println("DeciamlFormat 출력방식");
		System.out.println("원본 : "+dd);
		for (int i = 0; i < pp.length; i++) {
			df = new DecimalFormat(pp[i]);
			System.out.println(pp[i]+ "  ->  "+df.format(dd));			
		}
		/*
		-123
		DeciamlFormat 출력방식
		원본 : -123.456
		0  ->  -123
		0.0000  ->  -123.4560
		#.####  ->  -123.456
		##,##.##  ->  -1,23.46
		00,000.00  ->  -00,123.46
		-##  ->  --123
		##-  ->  -123-
		##.#%  ->  -12345.6%
		#,##;음수#,##  ->  음수1,23
		*/
	}
}

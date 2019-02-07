package java_plus;

/*
	4. Wrapper
	- 프리미티브 타입의 데이터를 객체로 만들 때 프리미티브 타입을 표현하는 클래스들이다.
	-->프리미티브 타입의 값을 담는 객체 생성
	
	* Wrapper 클래스의 사용방법
	 -Byte, Short, Integer, Long, character, Float, Double, Boolean class가 있다.
	 -기본적인 사용방법
	 --하나의 객체에는 하나의 값을 담을 수 있다.
	 --랩퍼클래스에 포함된 값을 수정하는 방법 : 값구하기->값수정->수정된 값을 이용하여 새 랩퍼클래스를 생성
	 
	* Wrapper 클래스의 정적메소드와 상수
	 -toBinaryString() : Integer와 Long 클래스에 있으며 파라미터로 넘겨준 값의 내부비트패턴을 문자열로 리턴한다.
	 -xxxValue : 객체안에 들어있는 값을 프리미티브 값으로 가져온다.
	 -parseXxx : 파라미터로 받은 문자열을 해석하여 프리미티브 값으로 리턴한다.
	 -valueOf : 생성자를 대신하는 정적 메소드로 파라미터를 넘겨주면 그 값을 가진 래퍼객체를 리턴한다.
*/
import java.util.*;
public class Chap11_4_Wrapper {
	public static void main(String[] args) {
		String a = "1234";
		String aa = "1234.567";
		//int b = a; 일반자료형으로 형 변환 불가
		int b = Integer.parseInt(a); // Int 형으로 자료변환
		double c = Integer.parseInt(a); // double <--int형 변환
		double d = Double.parseDouble(aa);
		int e = (int)Double.parseDouble(aa);
		//int <-(int)<--Double<--String
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		
		int now_year=2018;
		Scanner sc = new Scanner(System.in);
		System.out.println("주민번호를 입력하세요");
		System.out.println("입력:");
		String jumin = sc.nextLine();
		
		int code = Integer.parseInt(jumin.substring(7, 8));
		String sex = "남자";
		int add_year = 1900;
		String local="내국인";
		if(code%2==0)
			sex = "여자";
		if(code==3 || code==4)
			add_year = 2000;
		if(code==5 || code==6)
			local="외국인";
		if(code==7 || code==8)
			local="외계인";
		int my_year = add_year+Integer.parseInt(jumin.substring(0,2)); //태어난 해
		int age = now_year-my_year+1;
		System.out.println("출생연도:"+my_year);
		System.out.println("나이:"+age);
		System.out.println("성별:"+sex);
		System.out.println("국적:"+local);
		
		
	}
}

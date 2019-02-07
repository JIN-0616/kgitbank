package java_plus;

public class Chap02_자료형{
	/**
	 *	@param args 
	 */
	public static void main(String[] args) {
		int x,z,t=30;
		int y =10; //변수가 초기값을 받아 선언
		x=5+3;
		//int a = 123.456; //자료형에 맞지 않는 값은 선언불가
		
		float a = 123.456f; //실수형으로 선언
					//단 float형은 끝에 f를 기재
		double b = 123.456;
		
		//int c = 2147483649; // 범위 이상의 값도 입력 불가
		//int a = 4567; // 같은 이름으로 변수 선언 불가
		
		char ch = 'A'; // 문자의 입력 ' '안에 입력
		//char ch2='ABC'; // 한글짜만 가능
		
		String str = "ABC def";	// 문자열의 "  " 안에 입력
		//int 1_a=; // 변수명은 반드시 영문으로 시작
					// 숫자나 특수기호로 시작 불가
					// 한글 사용 금지
					// 헝가리안 표기법 권장 : 알아보기 쉬운 용어로 선언
						//-> 이름 : name. 번호 : num 
		System.out.println(x);
		System.out.println(x+y);
		System.out.println(t);
		System.out.println(a);
		System.out.println(b);
		System.out.println(ch);
		System.out.println(str);
		//System.out.println(z);
	}
}
class instance_c {
 
/* 1. 주석 - 설명이나 참조내용을 기재할때 사용
 *		-주석구간안에 주석 구간을 넣을수 없다.	
 *
 * 2. 상수와 변수
 *  1) 상수 : 고유햔 Data값, 변하지 않는 수
 *  2) 변수 : 변하는 공간, 대입이 가능한 공간
 *  3) 식별자 정의
 *  	- 첫글자 : _, $, 영문, 한글가능, 숫자사용불가
 *  	- 공백, 특수문자, 예약어 불가
 *   	- 헝가리안 표기법 : 프로그래밍에서 변수명, 함수명을 지을때 일정 규칙을 가지고 만드는 것
 *   						변수의 의미있는 이름을 기술하며, 3위치는 대문자를 사용,
 *   						변수 이름이 너무 긴 경우 자음만을 기술
 *  4) 클래스 정의
 *   	-첫글자 : 영문 대문자
 *   	-main class : 파일이름과 클래스 이름 일치
 *   
 * 3. 자료형
 * 	 자료형	키워드	크기(byte)	기본값		표현범위
 *   ---------------------------------------------------------------------- 
 *    논리	boolean		1		false		false,true
 *    
 *    문자	char		2		\u0000		0 ~ 65535
 *    
 *    정수	byte		1		0			-128 ~ 127
 *    		short		2		0    		-32768 ~ 32767
 *    		int			4 		0			-2,147,483,648 ~ 2,147,483,647
 *    		long		8		0			-9,223,372,036,854,775,808
 *                       					~ 9,223,372,036,854,775,807
 *    실수	float		4		0.0f		-3.4e38 ~ +3.4e38
 *    		double		8		0.0			-1.7e308 ~	+1.7e308                        
 */
	
}


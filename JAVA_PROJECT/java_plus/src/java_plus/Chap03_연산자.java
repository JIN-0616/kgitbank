package java_plus;

public class Chap03_연산자 {
	/**
	 * @param args
	 * 
	 1. 1항 연산자
	 - : 음수표현 (숫자)
	 ! : 부정 (boolean)
	 ++, -- : 증감(1씩 증가, 감소)
	 		전위처리 연산 ++변수 : 먼저 계산하여 변수에 입력
	 		후위처리 연산 변수++ : 변수 실행 후 ++연산
	 
	 2. 2항 연산자
	  1) 산술 --> return 숫자형
	   +, -, *, /, %
	   글자는 연산이 되지 않음 에러 --> 숫자만 가능
	   단 +는 글자 사용시 문자열을 결합하는 연산자로 사용
	   
	  2) 비교 --> return boolean (true, false)
	   >	크다 초과
	   >= 	크거나 같다, 이상 (=가 같이 들어가는 경우 반드시 뒤에써야 된다.)
	   <=	작거나 같다, 이하 (=가 먼저 입력되는 경우 대입으로 인지)
	   <	작다 미만
	   ==	같다
	   !=	다르다
	   
	  3) 논리 --> return boolean (true, false)
	   && - and (연산항이 모두 참일때 참)
	   || - or (연산항 중 하나라도 참이면 참)
	   ^ - xor (연산항의 값이 다를때만 참)
	   boolean을 연산항으로 사용
	  
	  4) shift 비트 연산 --> return 2진 자리이동
	   x<<n 정수x를 n비트 왼쪽으로 이동 (오른쪽은 0으로 채움)
	   x>>n 정수x를 n비트 오른쪽으로 이동 (오른쪽은 양수 :0, 음수:1로 채움
	   x>>>n 정수x를 n비트 오른쪽으로 이동 (오른쪽은 0으로 채움)
	 
	 3. 3항 연산자 ---> if 문
	  조건 ? 참일때 값 : 거짓일때 값
	  	조건은 boolean 형으로 결과가 유추되야 함
	  	조건이 true --> 참일때 값
	  	조건이 false --> 거짓일때 값
	  	
	*/
	public static void main(String[] args) {
		//1. 1항 연산자
		int a=5, c=10;
		boolean b = true;
		System.out.println(a+" (-) "+-a);
		System.out.println(b+" (!) "+!b);
		
		//c++;	//c=c+1;
		//System.out.println(c++); //후위처리
		System.out.println(++c); //전위처리
		System.out.println(c);
		
		//2.1 산술연산자
		int x = 6, y =3;
		System.out.println(x+" + "+y+" = "+(x+y));
		System.out.println(x-y);
		System.out.println(x*y);
		System.out.println(x/y);
		System.out.println(x%y);
		System.out.println(5+4*3);
		System.out.println((5+4)*3);
		
		String s1="이신협", s2="장동건";
		System.out.println(s1+s2);
		//글자는 + 연산으로 문자 합치기만 가능
		
		//2.2 비교 연산자
		int xx = 8, yy = 8;
		System.out.println(xx+ " > "+ yy +" = "+(xx>yy));
		System.out.println(xx+ " >= "+ yy +" = "+(xx>=yy));
		System.out.println(xx+ " <= "+ yy +" = "+(xx<=yy));
		System.out.println(xx+ " < "+ yy +" = "+(xx<yy));
		System.out.println(xx+ " == "+ yy +" = "+(xx==yy));
		System.out.println(xx+ " != "+ yy +" = "+(xx!=yy));
		
		//2.3 논리 연산자
		boolean xxx=false, yyy=false;
		
		//&&(and)--양쪽 항이 다 true일때 true 리턴
		System.out.println(xxx + " && " +yyy+ " = "+(xxx&&yyy));
		
		//||(or)--한쪽 항이라도 true일때 true 리턴
		System.out.println(xxx + " || " +yyy+ " = "+(xxx||yyy));
		
		//^(xor)--한쪽 항이 다르면 true 리턴
		System.out.println(xxx + " ^ " +yyy+ " = "+(xxx ^ yyy));
		
		int height =170, pay=100;
		
		// boolean h_test = (height>=185);
		// boolean p_test = (pay>=700);
		
		// System.out.println(h_test && p_test);
		System.out.println("결혼가능 여부: "+((height>=185)&&(pay>=700)));
		System.out.println("결혼가능 여부: "+((height>=1885||(pay>=700))));
		
		//2.4 비트 연산자
		/*
		 * 	10진		2진
		 *  0	->	00000000
		 *  1		00000001
		 *  2		00000010
		 *  3		00000011
		 *  4		00000100
		 *  5		00000101
		 *  6		00000110
		 *  7		00000111
		 *  8		00001000
		 *  -8		11111111_11111111_11111111_11111000
		 *  
		 *  x<<n 정수x를 n비트 왼쪽으로 이동 (오른쪽은 0으로 채움)
		 *  
	   	 *	x>>n 정수x를 n비트 오른쪽으로 이동 (오른쪽은 양수 :0, 음수:1로 채움)
	   	 *
	   	 *	x>>>n 정수x를 n비트 오른쪽으로 이동 (오른쪽은 0으로 채움)
		 */
		
		System.out.println(2<<2);
		System.out.println(5<<4);
		System.out.println(-8>>2);
		System.out.println(-8>>>2);
		System.out.println(Integer.toBinaryString(-8));
		
		//3.3 3항 연산자
		System.out.println(xxx ? "true" : "거짓");
		
		int jum = 87;
		
		int hh = 190, pp=800;
		
		System.out.println(jum>=80 ? "합격":"불합격");
		
		System.out.println(((hh>=185)||(pp>=700) ? "결혼가능":"결혼불가"));
		
		System.out.println(((hh>=185)||(pp>=700) ? 
				(((hh>=185) && (pp>=700)) ? "우수회원":"결혼가능")
				:"결혼불가능"));
		
		
		
		
		
		
	}
}

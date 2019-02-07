package java_plus;

public class Chap05_1_반복문_for {
	/*
	 1. for문
	  1) for 문의 형태
	  	for (반복시킬변수=초기값;조건;증감)
	  	{
		  	//사용할 변수를 for문 안에서 선언해도 상관없음
		  	//반복시킬 프로세스
		  	
	  	  	for(){
		  		//다중 for문 가능
		  	}
		  	
		  	if(){
		  		//if문도 사용가능
		  	}
		}
	  
	  2) for문 유의사항
	   for문 안에서 선언한 지역변수는 for문 안에서만 사용가능
	   단 for문 밖에서 선언한 변수는 for문 밖에서도 사용가능
	   반복변수로 사용할 경우에는 밖에서 기본값을 가지고 있다 하더라도
	   반드시 for 구문안에서 초기화 시켜야 한다.
	   증감의 값과 조건이 반복구문을 빠져나오는 형태로 있어야 한다. (무한루프를 미연에 방지)	   
	  
	 */
	public static void main(String[] args) {
		/**
		 * @param args
		 */
		int sum=0; //누적 값
		
		for (int i = 0; i < 10; i++) {
			// 반복시킬변수 : i -> 0(초기값)
			// 사용할 변수를 for문 안에서 선언해도 상관없음
			// for문 안에서 선언할 경우 for문 지역내에서만 사용하는 지역변수
			// for문 이외지역에서 사용 불가
			// 조건 : i<10
			// 증감 : i++ (1씩 증가)
			System.out.println(i);
			sum=sum+i; // sum += i;
		}
		System.out.println(sum);
		//System.out.println(i); //--> i는 지역변수이므로 사용불가
		
		// 2중 for 문
		
		//-----------------------------------구구단
		
		for(int i=2;i<10;i++) {//단수
			System.out.println("======= "+ i+" 단 =======");
			for (int j = 1; j < 10; j++) {//곱하기
				System.out.println(i+" x "+j+ " = "+(i+j));
			}
		}
		//===========================================================
		/* 다음 별을 출력하시오
		1)			2)			3)			4)
		*				   *	  *****			***** 
		**				  **	  ****			 ****
		***				 ***	  ***			  ***
		****			****	  **			   **
		*****		   *****	  *					*
					
		*/
		//1
		for (int i = 1; i < 6; i++) {
			for (int j = 1; j < i+1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		//2
		for (int i = 1; i < 6; i++) {
			for (int j = 0; j < 5-i; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j < i+1; j++) {
				System.out.print("*");
			}
			System.out.println();			
		}
		
		//3
		System.out.println();
		for (int i = 1; i < 6; i++) {
			for (int j = 0; j < 6-i; j++) {
				System.out.print("*");
			}
			System.out.println();			
		}
		
		//4
		for (int i = 1; i < 6; i++) {
			for (int j = 1; j < i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < 6-i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}

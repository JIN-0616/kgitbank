package java_plus;

public class Chap04_2_분기문_switch {
	/*
	 2. switch
	  1) if문과 달리 구간보다 값에 의한 분기 실행
	  2) 조건값 : 정수형 - byte, short, int와 문자형 char 사용
	  			  (boolean, float, double 사용불가)
	  3) break : 조건문에 해당하는 수행문만 실행시 사용
	  4) default: 조건에 해당하는 인자 값이 없을 경우 사용
	  6) 조건값은 중복 불가
	  
	  // if -> 구간에 의한 분기
	    	avg>= 90 : 수
	    	
	  // switch -> 값에 의한 분기
	    	gra -> 과장 : 보너스=200%
	    	// case에 같은 값을 넣을 수 없다
	 
	 switch(값) // 분기문
	 {
	 	case 해당값:
	 		실행 프로세스
	 		break; //해당 내용만 실행하고 switch를 빠져나온다
	 		//break; 빠져나오는 구문
	 	
	 	case 해당값:
	 		실행 프로세스
	 		break;
	 		
	 	case 해당값:
	 		실행 프로세스
	 		break;
	 		
	 	default : 	//기본값-> if문의 else처럼 사용
	 				//맨 마지막에 작성한다
	 		실행 프로세스
	 		break;
	 		// default에서는 생략해도 됨
	 }	 
	 */
	public static void main(String[] args) {
		int a=3;
		
		switch(a) // 분기될 값을 넣는다
		{
		case 1: // 분기값에 해당하는 경우를 지정
			System.out.println("와 1이다");
			break; // 해당 구문을 실행하고 switch문을 빠져나오기 위해 실행
		case 7:
			System.out.println("와 7이다");
			break;
		case 3:
			System.out.println("와 3이다");
			break;
		case 8:
			System.out.println("와 8이다");
			break;
		default:
			System.out.println("와 기본이다");
		}		
	
	
	//직급별 월급을 계산하세요
		//부장 : 50%, 과장 : 30%, 대리 : 20%, 사원: 10%
		//월급 : 기본급 + 기본급*보너스
		//직급과 기본급은 입력받아 처리
	
		int wag = 100_0000;
		String level = "과장";
		double result = 0.0;
	
		switch(level) {
		case "부장":
			result = wag + (wag*0.5);
			break;
		case "과장":
			result = wag + (wag*0.3);
			break;
		case "대리":
			result = wag + (wag*0.2);
			break;
		default:
			result = wag + (wag*0.1);				
		}
		System.out.println(result);
	}
}

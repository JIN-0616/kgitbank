package java_plus;

public class Chap04_1_분기문_if {
	/**
	 * @param args
	 * 
	 1. if문
	  1) 정의
	   if : "만약에 ~ 라면". 특정조건에 대해 "true라면 실행" 이라는 의미를 내포
	   
	   if(조건문) //조건문 boolean 형태의 return
	   { 
	   	   
	   //조건이 참일때의 프로세스
	   
	   }
	   else if(조건문)
	   {
	   
	   //위의 결과가 거짓인 것 중에서 참일때 프로세스
	    
	   }
	   else
	   {
	   
	   //거짓일 때 프로세스
	   
	   }
	  
	  
	  2) 여러번의 분기를 할 경우
	  꼭 범위의 것이 작은 것부터 포함 정도가 작은 순으로 순차적으로 작업
	  
	  90>80>70>60>50 , 50<60<70<80<90 이 방법은 가능하나
	  
	  90>70>80>50>60 ===> 이 순서로 if문을 사용할 수 없다
	 
	  3) 중첩 if 문이 사용가능
	 
	 */
	
	public static void main(String[] args) {
		int a= 70;
		
		if(a>=80){
			//if문의 조건이 참이라면
			System.out.println("우수");
		}else if(a>=70) {
			//위의 항복은 거짓이고 현재 if문의 조건은 참이라면
			//단계별 분기가 가능하다
			System.out.println("정상");
		
		//}else(a>50){ else 는 조건을 넣을 수 없다
			
		}else {
			System.out.println("불량");
		}
		//------------------------------------------------------
		if(a<70) {
			//if문의 조건이 참이라면
			System.out.println("불량");
		}else if(a<80) {
			//위의 항목은 거짓이고, 현재 if문의 조건은 참이라면
			//단계별 분기가 가능하다
			System.out.println("정상");
			
		//}else(a>=50){ else 는 조건을 넣을 수 없다
			
		}else {
			System.out.println("우수");
		}
		//------------------------------------------------------
		int kor=99, eng=97, mat=99;
		double avg=(double)(kor+eng+mat)/3;
		
		if(avg>90) {
			System.out.println("평가 : 수");
			
			if(kor>=90 && eng>=90 && mat>=90)
				System.out.println("우등생");
		}else if(avg>=80) {
			System.out.println("평가 : 우");
		}else if(avg>=70) {
			System.out.println("평가 : 미");
		}else if(avg>=60) {
			System.out.println("평가 : 양");
		}else {
			System.out.println("평가 : 가");
		}
		//------------------------------------------------------
		
		// 자동차 성능 테스트를 해보세요
		
		// 각 점수는 만점 : 100점
		
		// 평점 : 속도 50%, 안정성 : 30%, 연비 : 20%
		
		// 평점 80 이상 - 우수, 70이상 - 보통, 나머지 - 불량
		
		// 모든 점수가 80점이상인 경우 베스트
		
		int speed = 80, safe = 80, eco = 80;
		double av = (double)(speed*0.5+safe*0.3+eco*0.2);
		a:
		if(av>=80) {
			if(speed>=80 && safe>=80 && eco>=80) {
				System.out.println("베스트");
				break a;
			}
			System.out.println("우수");
		}else if(av>=70) {
			System.out.println("보통");
		}else {
			System.out.println("불량");
		}
	}
	
}

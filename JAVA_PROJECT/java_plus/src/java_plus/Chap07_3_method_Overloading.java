package java_plus;
	/*
	
	3. 메소드의 오버로딩
	   : 메소드의 이름이 같으나 인수가 달라 다른 메소드로 인지
	   
	 -메소드의 인수가 다른경우
	 
	 1) 인수의 갯수가 다른경우
	   method(int a, int b), method(int a, int b, int c)
	 
	 2) 인수의 자료형이 다른경우
	   method(int a, int b), method(int a, String b)
	   
	 3) 인수의 순서가 다른경우
	   method(int a, String b), method(String b, int a)
	   
	 -인수가 선언되는 변수명이 다른 것으로는 인사가 다르다고 볼수없음
	   method(int a, String b) method(int c, String b) ==> X
	 
	 -오버로딩과 리턴형과는 아무런 관련이 없음
	 
	*/ 

class cla_over{
	void meth() {
		System.out.println("메소드0");
	}
	
	void meth(int a, int b) { //오버로딩_1
		System.out.println("메소드1");		
	}
	
	void meth(String a, int b) {//오버로딩_2
		System.out.println("메소드2");			
	}
	
	void meth(int b, String a) {//오버로딩_3
		System.out.println("메소드3");			
	}
	/*
	void meth(int c, int d){ // 오버로딩이 아님
	  	System.out.println("메소드1");
	}
	
	int meth() { //오버로딩이 아님
		System.out.println("메소드1");
		return 1;
	}
	*/
	
	void area(int r) {
		System.out.println("원의 넓이:"+r*r*Math.PI);
	}
	
	void area(int h, int w) {
		System.out.println("사각형의 넓이:"+h*w);
	}
}


public class Chap07_3_method_Overloading {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		cla_over aa = new cla_over();
		
		aa.meth();
		aa.meth(1, 2);
		aa.meth("a", 1);
		aa.meth(1, "a");
		
		aa.area(20);
		aa.area(20,30);
		
		
	}
	// 사원 명단을 출력하세요
	 // 멤버는 클래스로 정의하며
	 // 클래스 요소는 부서마다 다름
	 // 총무부 - 사원명, 사원번호, 연봉
	 // 웹부 - 사원명, 사원번호, 연봉, 특기
	 // 영업부 - 사원명, 사원번호, 실적건수
	 // 같은이름의 메소드로 출력하세요(오버로딩)
	
}

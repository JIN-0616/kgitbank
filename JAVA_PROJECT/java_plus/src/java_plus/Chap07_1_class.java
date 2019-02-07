package java_plus;

public class Chap07_1_class {
	/*
	1. 클래스
	 1) 객체지향 특성
	  -1. 코드의 재사용성이 높다
	   : 새로운 코드를 작성할 때 기존의 코드를 이용하여 쉽게 작성할 수 있다.
	  -2. 코드의 관리가 용이하다.
	   : 코드간의 관계를 이용해서 적은 노력으로 쉽게 코드를 변경할 수 있다.
	  -3. 신뢰성이 높은 프로그래밍을 가능하게 한다.
	   : 제어자와 메소드를 이용해서 데이터를 보호하고 올바른 값을 유지하도록 하며,
	     코드의 중복을 제거하여 코드의 불일치로 인한 오동작을 방지할 수 있다.
	
	2. 클래스와 객체 정의
		클래스 : 객체를 정의
		클래스는 객체를 생성하는데 사용
		
	 class 클래스명 {
	 	int a = 3;		맴버변수
	 	void mm(){		맴버메소드
	 	
	 	}
	 }
	
	3. 클래스의 구조
	 멤버 필드
	 1) 변수, 상수
	 2) 객체가 만들어질 때 속성 부여
	 3) static, instance, 상수
	 
	 멤버 메소드
	 1) 특정 프로세스의 행위, 동작
	 2) static, instance 메소드로 구분
	*/ 
	static class Aaa { // 클래스의 정의
	 	int a = 50; //멤버변수
	 	//int a = 30;
	 	void meth_1() { //메소드
			int b=30;
			System.out.println("난 meth_1 이야");
	 	}
	 }
	 
	static class Bbb { // 클래스의 정의
		int a= 50; //멤버변수
		//int a=30;
		void meth_1(){ //메소드
			System.out.println("난 meth_1 이야");
		}
	}
	
	// class Aaa{} 이미 선언한 동일한 이름으로 클래스를 선언할 수 없다. 
		
	
	
	/**
	 * @param args 
	 * 
	 */
	public static void main(String[] args) {
		//Aaa a_1;  선언시에는 반드시 메모리할당을 해야한다
		Aaa a_1 = new Aaa(); // 메모리할당
		
		//Aaa a_1 = new Aaa(); //동일한 이름으로 선언 불가
		//Aaa a_2 = new Bbb(); //내용형태가 같아도 다른 클래스로 특정한 이유없이 생성불가
		
		//A_2.a=100;
		System.out.println(a_1.a);
		//System.out.ptintln(a_2.a); //존재하지 않는 접근자로 클래스멤버 접근 불가
		//접근자.멤버요소
		a_1.meth_1();
		//a_2.math_1();
		//System.out.println(a_1.b); 클래스안에 있다하더라도 지역변수는 직접접근 불가
	}
}

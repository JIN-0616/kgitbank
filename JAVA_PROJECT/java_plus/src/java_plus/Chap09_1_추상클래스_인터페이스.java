package java_plus;
	/*
	1. 제어자 : 클래스의 선언시 변형 및 접근의 권한을 설정
	
		static - 공통 : 클래스변수로 스태틱 영역의 메모리에 할당 받은, 동적할당 없이 접근가능
		
		final - 변수에만 사용, 캡슐화 메소드 사용불가, 변경불가 : 마지막 형태의 값으로 변경 --> 상수화

		추상화 : 구체적인 개념으로부터 공통된 부분만 추려내어 일반화 하는 것을 의미, 일반적을 사용할 수 있는
				단계가 아닌 아직 미완성적 개념
		
		추상메소드 : 메소드 정의시 메소드 명만 정의하고 내용 즉 brace( { } ) 을 생략하여 실제적 메소드의
		 			수행문이 없도록 함. 메소드 앞에 abstract 제시어 명시
		 			
		 			abstract 메소드명();
	 */

class final_1{
	int a=10;
	static int b = 20;
	final int c = 30; //상수화: 변경불가
}

abstract class ab_per{
	//abstract int d = 40; abstract는 멤버변수로 정의하지 않음
	
	abstract void ab_cal();
	abstract int child_get(); // 자식클래스의 멤버 가져옴
}

class ab_child extends ab_per{
	int ab_a=111;
	int child_get() { //자식클래스에서 자신의 멤버변수를 리턴
		return ab_a;
	}
	void ab_cal() { //자식클래스에서 반드시 abstract 메소드를 정의해야 한다
		System.out.println("난 추상이야");
	}
}

public class Chap09_1_추상클래스_인터페이스 {
	public static void main(String[] args) {
		final_1.b = 200;
		final_1 ff = new final_1();
		ff.a = 100;
		ff.b = 2000;
		//ff.c=300; --> 상수화
		System.out.println("ff.c="+ff.c);
		//호출에는 문제 없음
		
		//ab_per pp = new ab_per();
		//추상메소드의 대한 정의 내용이 없으므로 단독으로 사용불가
		
		//ab_per pp = new ab_per(){ void ab_cal(){} };
			//단독으로 사용하기 위해서는
			//생성시에 추상메소드에 대한 정의를 해주어야 한다
		
		ab_per p1 = new ab_child();
		ab_child cc = new ab_child();
		//부모클래스를 자식클래스로 할당 받아 선언하거나
		//자식클래스로 선언
		System.out.println("p1.child_get() : "+p1.child_get());
			
		}
		
	}

//-----------------------------------------------------------------------




package java_plus;
	/*
	
	4. 클래스 (staitc) 과 인스턴스 의 비교
	
				스테틱(클래스)				인스턴스
	
	메모리		메소드					메소드-->힙-->스택
	
	동작		직접					메모리할당 후 접근
	
	접근		어디서든 가능			접근자에 의해 가능
	
	호출		스테틱->스테틱			인스턴스 -> 스태틱, 인스턴스
	
	사용		공동					권한 및 보호
	
	*/

class S_c_1{
	int a = 10;			//인스턴스 변수
	static int b = 20; 	//클래스(스태틱) 변수
	
	void method1() { 			//인스턴스 메소드
		int aa = a;				//인스턴스 객체 접근가능
		int bb = b; 			//스테틱 객체 접근 가능
		System.out.println("난 인스턴스 메소드_1");
		method2();				//인스턴스 메소드 접근가능
		st_method2(); 			//스테틱 메소드 접근가능
		
	}
	
	static void st_method1() {		//스테틱 메소드
		// int aa = a;  			//스테틱 메소드이어서 인스턴스 객체를 접근시킬수 없다
		int bb = b;					//스세틱 객체 접근 가능
		System.out.println("난 스태틱 메소드_1");
		//method2();				//인스턴스 메소드 접근불가
		st_method2();				//스태틱 메소드 접근 가능
		
		S_c_1 ss = new S_c_1();				//자신 클래스를 동적할당
		int aaa= ss.a;						//할당방든 접근자를 이용하여 인스턴스 접근가능
		System.out.println("스태틱 메소드에서 할당받은 a : "+aaa);
						//현재 메소드가 속해있는 클래스의 멤버변수를 받는 것이 아니다
						//새로 생성된 ss의 멤버를 받는 것이다.
		ss.method2();
	}
	void method2() {
		System.out.println("난 인스턴스 메소드_2");		
	}
	static void st_method2() { //스테틱 메소드
		System.out.println("난 스세틱 매소드_2");
	}
}

public class Chap07_4_static_vs_Instance {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		S_c_1 s1 = new S_c_1();
		S_c_1 s2 = new S_c_1();
		
		s1.a=100;
		s1.b=200; //메소드 영역에 위치 따라서 모든 변수가 같이 바뀐다.
		System.out.println("s1.a:"+s1.a);
		System.out.println("s2.a:"+s2.a);
		System.out.println("s1.b:"+s1.b);
		System.out.println("s2.b:"+s2.b);
		
		System.out.println("S_c_1.b : "+S_c_1.b ); //스테틱 변수는 접근 가능(클래스명으로 접근가능)
		//System.out.println(S_c_1.a); 			   //인스턴스 변수는 클래스명으로 접근 불가
		
		System.out.println("----");
		
		s1.method1();
		System.out.println("----");

		s1.st_method1();
		System.out.println("----");

		//S_c_1.st_method1(); 접근자 없이 호출불가
		S_c_1.st_method1();   // 클래스명으로 접근 가능
		System.out.println("----");
		
		/*
		 
		s1.a:100
		s2.a:10
		s1.b:200
		s2.b:200
		S_c_1.b : 200
		----
		난 인스턴스 메소드_1
		난 인스턴스 메소드_2
		난 스세틱 매소드_2
		----
		난 스태틱 메소드_1
		난 스세틱 매소드_2
		스태틱 메소드에서 할당받은 a : 10
		난 인스턴스 메소드_2
		----
		난 스태틱 메소드_1
		난 스세틱 매소드_2
		스태틱 메소드에서 할당받은 a : 10
		난 인스턴스 메소드_2
		----
		
		*/
	}
}

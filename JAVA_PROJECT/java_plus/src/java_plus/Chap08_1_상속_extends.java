package java_plus;
/*
1.상속

 1) 상속
 - 기존 클래스의 재사용
 - 재사용 하고자 하는 클래스를 부모클래스로 정의하여 이용
 - 클래스의 선언이나 호출없이 접근가능
 - 동시 다중 상속 불가

 2) 상속간 클래스 연관관계
 - 오버라이딩 : 메소드의 재정의. 상속관계로 이루어진 객체간의 관계에서
 			 변수명, 메소드명이 부모와 같은 경우 자식이 우선순위
 - super : 부모 멤버 접근자, 자식 클래스 내부에서만 사용가능
 - 부모 생성자 : 부모클래스가 생성자가 정의되었을 경우
  			 자식 클래스의 생성자에서 이를 명시해야 한다.
 - 다차원상속 : 오버라이딩 개체는 한번에 다차원을 넘어 접근 불가
 			--> 단계별 부모 접근 시도
 - 동시에 두개 이상의 클래스를 상속받을 수 없음
 
2.상속 방법
 클래스명 extends 부모클래스명{
 }
 
3.생성과 상속
 1) 자식의 기본생성자에 super()가 생략되어 있음
 2) 인스턴스 생성시 부모클래스 즉 부모의 생성자를 반드시 먼저 호출함
 3) 부모의 멤버 메모리 할당 : 부모멤버 접근불가 --> 부모클래스에서 직접해야 한다
 4) 부모의 생성자 : 부모멤버 접근불가 --> 부모클래스에서 직접해야한다
 5) 자식의 멤버 메모리할당 : 부모의 멤버에 접근가능하여 값을 변경가능하다
 6) 자식의 생성자 : 부모의 멤버에 접근가능하여 값을 변경가능하다

 */
class grand{
	int gg = 10000;
}
class parent1{
	
}

class parent extends grand{
	int gg = super.gg;
	
	// 부모접근자 super는 한단계씩 접근이 가능하므로
	// 각 자식마다 접근토록 다리를 놓아 최상위 부모에 접근토록 한다
	
	int a = 30;
	void meth_1() {
		System.out.println("난 부모 메소드");
	}
	parent(int a) { //부모의 생성자가 존재한다.
		this.a=a;
	}
	parent(int a, int b) { //부모의 생성자가 존재한다
		this.a =a;
	}	
}
class child extends parent { //상속
	child(){
		//super.a = b;
		super(3000);
		//부모에 특정생성자가 존재한다면 자식클래스의 생성자에서 정의해야 한다
		//부모생성자가 반드시 맨 위에 있어야 한다.
		
		super.a=b;
		//생성 이후에는 접근이 가능하다
		
		System.out.println("난 자식생성자 시작");
	}
	child(int c){ //자식생성자 모두 부모생성자를 정의해야한다
		//super(3000);
		super(100,200);
	}
	int b = 50;
	int a = 300; //부모와 중첩된 경우 자식클래스의 것이 우선(오버라이딩)
	int c = super.a;
	//부모접근자를 이용하여 자신의 멤버와 부모의 멤버를 구분한다.
	//int d = super.super.gg;
		//부모 접근자는 한차원 만 가능하다
	int d = super.gg;
	void meth_2() {
		System.out.println("난 자식 메소드");		
	}
	void meth_3() {
		System.out.println("부모a:"+super.a);
	}
	void meth_1() {
		super.meth_1();
		System.out.println("난 오버라이딩 메소드");
	}
}

class child2 extends parent { //하나의 부모에 여러개의 자식클래스가 상속 가능
	child2() {
		super(7000);
	}
	void meth_1() {
		System.out.println("난 부모를 바꿧어");
	}
}
/*
class child3 extends parent,parent1{ // 다중상속 불가 
	child3(){
		super(9000);
 	}
}
 */
public class Chap08_1_상속_extends {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		child cc = new child();
		System.out.println(cc.b);
		System.out.println(cc.gg); //다차원상속의 접근이 가능
		System.out.println(cc.d);
		cc.meth_2();
		
		System.out.println(cc.a); // 상속으로 부모클래스의 멤버에 접근 가능
		System.out.println(cc.c); //
		//System.out.println(cc.super.a);
		//스택의 접근자로 부모접근자를 사용할 수 없다
		cc.meth_1();
		cc.meth_3();
		
		parent pp = new parent(90);
		pp.meth_1();
		//System.out.println(pp.b);
		//pp.meth_2();
		//부모클래스로 자식클래스의 멤버에 접근 불가
		
		child2 c2 = new child2();
		
		c2.meth_1();
	}
}

package java_plus;
	/*
	2. 인터페이스
	
	 1) 인퍼메이스의 특징 - 추상클래스 처럼 추상 메서드를 가짐
	 
	   - 추상화의 심도가 더 좋음
	   
	   - 하나의 클래스에서 여러 인터페이스를 구현가능함
	   
	   - 일반메소드는 넣을수 없음
	   
	   - 인터페이스를 구현하는 클래스에서는 반드시 메소드를 재정의해야 사용가능
	   
   			: public으로 접근자를 할당해야 한다.
   			
   	   - 인터페이스로 생성시 생성과정에서 메소드를 재정의 해야만 한다.
   	   
   	  2) 구현
   	  
   	   - 인터페이스를 구현하는 클래스는 implements 를 통해 접근
   	   
   	   - 동시에 여러개의 인터페이스를 구현가능함(상속과 다름)
   	   
   	   - 보통의 경우 인터페이스로 선언도 가능하지만
   	   
   	   - 인터페이스를 구현한 클래스로 선언하는 것이 일반적인 방법임
   	
   	  3) 인터페이스 코딩
   	  
   	  정의 :
   	   interface 인터페이스명{
   	   		멤버변수;
   	   		추상메소드;
   	   }
   	  
   	  구현 :
   	   class 클래스명 implements 인터페이스1, 인터페이스2...{
   	   		
   	   		추상메소드 재정의1(){
   	   		
   	   		}
   	   }
   	   		
   	 
	 */
interface in_1{
	int a=10;
	/*
	void method_1(){
	
	}
	
	*/
	void method_1(); //반드시 추상메소드만
					 //abstract를 생략해도 추상개념으로 인지
}

interface in_2{
	int a=100, b=20;
	
	abstract void method_1();	// 반드시 추상메소드만
}

abstract class int_3{
	int a = 10;
	void method_2() {
		int a= 10;
		System.out.println("나는야 일반메소드");
	}
	abstract void method_1(); //반드시 추상메소드만
	
}

abstract class int_4{
	int a=10;
	void method_2() {
		System.out.println("나는야 일반메소드");
	}
	abstract void method_3();
}

class child_12 extends int_3 implements in_1,in_2{
				//인터페이스를 구현하는 클래스
				//동시에 여러 인터페이스를 구현가능
	void method_2() {
		System.out.println("나는야 오버라이딩");
	}
	public void method_1() { //인터페이스의 메소드 정의는 public
							 //추상클래스의 추상메소드도 동시에 사용가능
		System.out.println("나는야 인터페이스 메소드");
	}
	void method_3() {
		System.out.println("나는야 추상메소드");
	}
}
public class Chap09_3_Interface {
	/*
	 * @param args
	 */
	public static void main(String[] args) {
		in_1 aaa = new in_1() {
			public void method_1() {}
		};
		//인터페이스로 메모리 할당할 경우 메소드의 정의가 필요
		System.out.println("aaa.a ="+aaa.a);
		
		in_1 bbb = new child_12();
		//메모리 할당을 클래스로 한 인터페이스 선언
		//System.out.println("bbb.b = "+bbb.b);
		//구현하고 있는 클래스에서 다른 인터페이스를 구현하고 있어서
		//이에대한 다른 멤버로 접근할수는 없다.
		bbb.method_1();
		
		child_12 ccc = new child_12();
		ccc.method_1();
		System.out.println("ccc.b = "+ccc.b);
		//인터페이스에 정의된 멤버변수명이 겹쳐지게 될 경우 에러 발생
		
		/*
		aaa.a =10
		나는야 인터페이스 메소드
		나는야 인터페이스 메소드
		ccc.b = 20
 
		 */
	}
}

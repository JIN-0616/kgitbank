package java_plus;
	/*
	3. 인터페이스의 상속
	 - 인터페이스 내에는 상수 또는 동작구분을 구현하지 않은 추상 메소드 정의, 따라서 인터페이스를 구현하는
	  일반클래스에서 원하는 형태로 실제 구현, 인터페이스간 같은 이름의 메소드들은 실제 수행문이 없으므로
	  인터페이스 간 다중 상속이 가능함
	 - 다중 상속 받은 클래스는 모든 추상메소드를 재정의해야 함
	 
	 인터페이스를 구현한 클래스의 상속
	 	여러개의 interface --> 단일 class --> 여러 자식 클래스
	 	   추상메소드 ------>부모추상메소드
	 	   						자신추상메소드------->정의
	 	   						
	 	여러개의 interface --> 단일 인터페이스---> 여러 클래스:
	 					extends(상속)		implements
	 					다중상속가능		(구현)
	 							      상속,구현된 모든 인터페이스의 메소드를 정의	
	 */
interface ll_1{
	void meth_1();
	void meth_2();	
}
interface ll_2{
	void meth_1();
	void meth_3();	
}
interface ll_3{
	void meth_4();	
}
interface ll_tot extends ll_1,ll_2,ll_3{
	
}
abstract class ll_par{
	int a= 10;
	abstract void meth_5();
	
	public void meth_1() {
		System.out.println("난 부모클래스 메소드 1");
	}
	public void meth_2() {
		System.out.println("난 부모클래스 메소드 2");
	}
}

class ll_pro extends ll_par{

	@Override
	void meth_5() {
		System.out.println("자식 클래스 메소드 5");
		
	}
	@Override
	public void meth_1() {
		System.out.println("자식 클래스 메소드 1");
	}
	public void meth_3() {
		System.out.println("자식 클래스 메소드 3");
	}
	public void meth_4() {
		System.out.println("자식 클래스 메소드 4");
	}
}
//class llm_c implements ll_1,ll_2,ll_3
class llm_c extends ll_pro implements ll_tot{
	//결합기로 사용한 클래스
}
public class Chap09_4_interface의_상속 {
	public static void main(String[] args) {
		
		llm_c mc = new llm_c();
		
		/*
		ll_1 in1 = new llm_c();
		ll_2 in2 = new llm_c();
		ll_par par = new llm_c(); 
		*/
	  		 
		ll_1 in1 = mc;
		ll_2 in2 = mc;
		ll_par par = mc;
		
		in1.meth_1();
		in1.meth_2();
		in2.meth_3();
		par.meth_1();
		par.meth_5();
		
//		자식 클래스 메소드 1
//		난 부모클래스 메소드 2
//		자식 클래스 메소드 3
//		자식 클래스 메소드 1
//		자식 클래스 메소드 5

	}
}

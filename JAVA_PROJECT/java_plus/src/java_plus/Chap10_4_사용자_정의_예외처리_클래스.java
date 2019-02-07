package java_plus;
/*
사용자 정의 예외처리 클래스를 생성
예외처리 클래스를 상속받아 처리
사용자정의 예외처리 클래스 사용

class 클래스명 extends 예외처리클래스 {

}

class 일반클래스{

	######### 사용방법 1 ###########
	method() throws 사용자정의예외처리클래스{
	
	}
	
	or
	
	######### 사용방법 2 ############
	try{
		throw new 사용자정의예외처리클래스();
		
	}catch(사용자정의예외처리클래스 ee) {
	
	}
	
}
 */

class my_excep extends Exception{
	String msg="";
	
	public my_excep(String msg) {	// 인수가 있는 생성자
		// super(msg); 				// 인수를 부모에게 넘김
		this.msg = msg;
	}
	
	public my_excep() { 			// 인수가 없는 생성자
		// super(msg);				// 인수를 부모에게 넘김
		this.msg = "죄송합니다. 빠른 시일내에 복구 처리하겠습니다.";
	}
	
	@Override
	public String getMessage() {
		return "에러메시지 : "+msg;
	}
	
	@Override
	public void printStackTrace() {
		//super.printStackTrace();
		System.out.println(getMessage());
	}	
}



public class Chap10_4_사용자_정의_예외처리_클래스 {
	
	static void meth() {
		try {
			throw new my_excep();
		} catch (my_excep e) {
			//System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		meth();
	}
}

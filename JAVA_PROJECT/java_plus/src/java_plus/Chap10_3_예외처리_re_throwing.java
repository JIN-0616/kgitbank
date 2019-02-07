package java_plus;
/*
	3. 예외처리
	
	try ~ catch		: 자체적으로 예외처리가 다 완성됨 -> 이후의 프로세스 가능
	 				 -> 자신을 사용하는 구문에 예외처리 필요성이 없음
	
	throws Exception : 자체적 예외처리가 없고 예외처리를 포함하는 개체에게 넘김
					 -> 예외발생시의 이후 프로세스 불가능
					 
	re ~ throwing : 받은 예외처리를 그대로 자신을 포함하는 개체에 전달
				throw 예외변수;
				
		:자신을 포함한 개체에게 넘기는 방식은 한꺼번에 에러처리의 필요성이 있을때 사용
	
		
		
	throw 구문을 method에 포함시켜 외부에서 던짐
	메소드에서는 반드시 예외처리에 접근가능한 throws 예외클래스1,...를 메소드에 함께 정의해야 한다
	
	--> re ~ throwing
	
	--> 이 방법은 예외를 발생시키고 이를 처리하는 구문을 이 메소드를 포함하는
	--> 메소드에서 처리하도록 예외를 다시 보내는 형태이다
	
	--> 만일 현 메소드에서 처리하기도 하고 포함하는 메소드에서 처리하기도하는
	--> 이중 작업을 필요로 할 경우 현 메소드에서도 try ~ catch 구문을 사용해야 한다.
	--> 
		//메인에서 똑같이 처리해야하는 경우 (re~throwing)
		//인수로 받은 예외처리를 다시 던진다
		
		  
 	--> 단일 메소드에서 사용하는 경우는 당연하게
 	   throws 예외클래스1 ... 나 re~throwing 을 사용할 필요가 없으며
 	   이를 포함하고 있는 메소드에서도 try ~ catch 구문을 사용할 필요가 없다
 	   
 	 try{
 	 	method();
 	 }catch(){
 	 
 	 }
 	 void method() throws 예외클래스1, 예외클래스2...{
 	 
 	 	//throws 예외클래스 구문이 있어야 하며
 	 	//예외처리를 포함하는 예외클래스이어야 한다
 	 	throw new Exception();
 	 }
*/

public class Chap10_3_예외처리_re_throwing {

	static void method() throws Exception{ //-----------2, 5
		System.out.println("예외를 던져주겠다 ㅋㅋㅋ"); //--------3
		throw new Exception("던졌다 아하하");	//------4(예외발생)
		
		//System.out.println("나를 실행해"); //-----실행시킬수 없다
		//예외처리가 불가능하고 권한을 throws Exception으로 구문을 나감
	}
	
	static void method1() { //----------2,5
		try {
			System.out.println("예외1준비"); //-------3
			throw new Exception("예외 1 던지기"); //--------4(예외발생)
		} catch (Exception e) {
			System.out.println("예외1받기");
		}
		System.out.println("예외1 끝나고 실행해");
	}
	
	static void method2() throws Exception { //----------2,5
		try {
			System.out.println("예외2준비"); //-------3
			throw new Exception("예외 2 던지기"); //--------4(예외발생)
		} catch (Exception e) {
			System.out.println("예외2받기");
			throw e;
		}
		//System.out.println("예외2 끝나고 실행해");		
	}
	public static void main(String[] args) {
		
		try {
			method();	//---------1
			method2();
			
		} catch (Exception e) {  //---------6
			System.out.println("메인처리: "+e.getMessage()); //--------7
		}
		//method(); ----메인까지 종료
		method1();  //-------메인이 종료되지 않음
		//메인이 method1의 에러처리할 필요가 없음
		
		try {
			method2();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("메인종료");
		
		/*
		예외를 던져주겠다 ㅋㅋㅋ
		메인처리: 던졌다 아하하
		예외1준비
		예외1받기
		예외1 끝나고 실행해
		예외2준비
		예외2받기
		메인종료
		java.lang.Exception: 예외 2 던지기
			at java_plus.Chap10_3_예외처리_re_throwing.method2(Chap10_3_예외처리_re_throwing.java:73)
			at java_plus.Chap10_3_예외처리_re_throwing.main(Chap10_3_예외처리_re_throwing.java:94)
		*/

	}
}

/*
 * 프로그램을 만들때, 
 * 	데이터 관리를 용이하기 위해 컬렉션 계열을 이용하는 법과,
 * 	그래픽UI 를 입혀서 작동되게 하는 법까지를 살펴보았다.
 * 
 * 지금까지의 프로그램은 가동중인 상태에서야 데이터가 유지되며 관리가 되겠지만,
 * 프로그램 종료가 되고 나면, 따로 저장을 안했기 때문에 데이터들이 다 사라지게 될꺼다.
 * 
 * 이번에 보려고 하는건, 데이터를 외부에 출력한다거나, 외부로부터 입력받고자 할때 
 * 사용되는 객체들이다 (입,출력/Input,Ouput 객체)
 * (파일세이브,파일로드 같은.. )
 *   
 *  이렇게 데이터를 외부(파일포함)에 쓴다거나, 외부로부터 읽어내는 작업을 하는 객체는 
 *  Exception 객체에 대해서 알고 있어야 하고,  Exception 처리법을 알아야만 가능하다.  
 *
 *  
 */

public class Source01_Exception {
	/*
	 * Exception 은 일반 객체랑은 다르게 특별하다. 
	 * 기능적으로 어떤것들을 처리하기 위해서 설계된 객체는 아니고, 
	 * JVM 실행을 멈출수있는 능력이 있는 객체이다.
	 */
	public static void main(String[] args) {
		String str = "string";
		System.out.println("main...start..");
		RuntimeException re = new RuntimeException();
		System.out.println("exception create");
		if(Math.random() > 0.5) {
			/*
			 * throw 객체값;
			 *	아무객체나 되는건 아니고, Exception 객체들에만 설정할수 있는 키워드로,
			 *	실제 이 코드가 작동하게 되면 Exception 객체가 작동하게 되고, 
			 *  작동하게 된다면 JVM이 위험감지해서, 바로 종료되게 되있다. 
			 */
		//	throw str;	
			throw re;	 
		}
		if(Math.random() >0.5) {
			throw new IndexOutOfBoundsException();
		}
		System.out.println("main...end..");
		// 이런식으로 에러가 뜨면서 프로그램이 정상적으로 작동하지 못하고
		// 종료되는 경우를 경험해 본적이 있었을것이다.
		
		// 이전까지는 에러가 뜨는걸 방치를 해도 상관이 없었지만, 지금 입출력에 관련된
		// 객체를 사용할때는 이걸 방치를 하면 안된다. 
	}
}







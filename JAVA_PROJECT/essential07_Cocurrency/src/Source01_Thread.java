
/*
 * Concurrency : 병행
 * 
 *  TCP방식으로 데이터 교환하며 작동하는 Network 프로그램을 만들어 보았다.
 *  네트워크 연결의 특성상, 동시 클라이언트 처리가 일반적인 방식으로는 구현이 안된다.
 *  
 *  이 처리를 하려면, Thread 객체를 이용한 병렬 처리 법을 알아야 한다.
 *  
 *  Thread 객체는 어떤식으로 제어하고, 어디에 활용되는지 알아보자.
 * 
 * 	Thread는 독자적인 흐름을 가진 또하나의 메인 이라고 생각하면 된다.
 * 
 *  이제까지 작동했던 프로그램은 하나의 메인이 돌아가는 Single Thread 프로그램이고,
 *  멀티 쓰레드를 구현해보려고 하는데, 이건 메인 여러개가 동시에 작동한다고 생각하는게
 *  흐름을 이해하는데 도움이 된다.
 */

public class Source01_Thread {
	public static void main(String[] args) {
		/*
		 */
		for (char c = '가'; c < '나'; c++) {
			System.out.print(c);			
		}
		System.out.println();
		for (char c = '나'; c < '다'; c++) {
			System.out.print(c);			
		}
		System.out.println();
	}
}

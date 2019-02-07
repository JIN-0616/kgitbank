/*
 * 메인 흐름과 별도로 작동하는 다른 추가흐름이 필요하면,
 * 객체를 설계할때, extends Thread 
 */
class CharPrint extends Thread {
	char start;
	char end;

	CharPrint(char s, char e) {

		start = s;
		end = e;
	}

	@Override
	public void run() {
		char c = start;
		while (c < end) {
			String str = "";
			for (int cnt = 1; cnt <= 20; cnt++) {
				str += c++;
				if (c == end)
					break;
			}
			synchronized (System.out) {
				System.out.println(getName() + " : " + str);
			}
		}
	}
}



public class Source02_Thread {
	public static void main(String[] args) {

		Thread t = new CharPrint('가', '나');
		// run() 으로 콜하는건 무의미하고
		t.start(); // 쓰레드 가동 (병렬적으로 처리할 독립작업을 시작시키는 )
		Thread t2 = new CharPrint('나', '다');
		t2.start();

		for (int cnt = 1; cnt <= 10; cnt++) {
			System.out.println("─");
		}
		// t.stop();
		// t2.stop();

	}
}

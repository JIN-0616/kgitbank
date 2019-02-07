/*
 * ���� �帧�� ������ �۵��ϴ� �ٸ� �߰��帧�� �ʿ��ϸ�,
 * ��ü�� �����Ҷ�, extends Thread 
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

		Thread t = new CharPrint('��', '��');
		// run() ���� ���ϴ°� ���ǹ��ϰ�
		t.start(); // ������ ���� (���������� ó���� �����۾��� ���۽�Ű�� )
		Thread t2 = new CharPrint('��', '��');
		t2.start();

		for (int cnt = 1; cnt <= 10; cnt++) {
			System.out.println("��");
		}
		// t.stop();
		// t2.stop();

	}
}

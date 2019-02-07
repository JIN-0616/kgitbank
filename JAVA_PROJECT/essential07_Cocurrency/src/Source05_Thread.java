import javax.swing.JOptionPane;

/*
 * ������ ���� : Start, stop
 * 
 *  : sleep, interrupt, join, 
 *  
 */
class Worker extends Thread{
	
	@Override
	public void run() {
		for(;;) {
			boolean b = this.isInterrupted();		// interrupt �ñ׳��� ��뿹
			System.out.println("do working...");
			if(b)
				break;
		}
	}
}

public class Source05_Thread {
	public static void main(String[] args) { // main�� ��ŸƮ�� JVM�� �ɾ���
		System.out.println("[Main] start");
		Worker w = new Worker();
		w.setDaemon(true); 
		// ����Ʈ�� false, true�� ������ �ؼ� start�� �ɸ�
		// �ڽ��� ������ �������� �����尡 ������ ���� (��������� �ƴ�)
		// ������ ������ ���� ���
		
		w.start();
		
		try {
			for(;;) {
				String cmd = JOptionPane.showInputDialog("controll?");
				switch (cmd) {
				case "sleep":
					Thread.sleep(3000); 		// ���� �������� �۾��� ��� ���� (�ڱ��ڽ�?)
					break;						
					
				case "start":					// ������ �ɸ��� main thread�� �׾����
					w.start(); break;			// start �ι� �ɸ���, IllegalThreadStateException
												
				case "interrupt":
					w.interrupt(); break;		// ��ȣ�� �ټ� ����
					
				case "join":
					//w.join();					// �ش� �������� �۾��� ������ ��ٸ���. ���� �����忡 �Ͻ������� �ɸ�
					w.join(2000);				// ������� ��� �����忡 �Ѱܹ���
					//==sleep(2000)
					break;
					
				case "suspend":
					w.suspend();				// �ش� �����带 �Ͻ�����
					break;
					
				case "resume":					
					w.resume();					// �����Ǿ��� �����带 �ٽ� �⵿
					break;
				}
			}
		} catch(InterruptedException e) {
			System.out.println("InterruptedException");
		} finally {
			w.stop();
		}
	}
}
/*
do working...
do working...Exception in thread "main" java.lang.IllegalThreadStateException
	at java.lang.Thread.start(Thread.java:708)
	at Source05_Thread.main(Source05_Thread.java:31)*/
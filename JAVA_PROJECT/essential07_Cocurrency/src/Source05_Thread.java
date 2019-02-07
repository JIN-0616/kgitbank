import javax.swing.JOptionPane;

/*
 * 쓰레드 제어 : Start, stop
 * 
 *  : sleep, interrupt, join, 
 *  
 */
class Worker extends Thread{
	
	@Override
	public void run() {
		for(;;) {
			boolean b = this.isInterrupted();		// interrupt 시그널의 사용예
			System.out.println("do working...");
			if(b)
				break;
		}
	}
}

public class Source05_Thread {
	public static void main(String[] args) { // main의 스타트는 JVM이 걸어줌
		System.out.println("[Main] start");
		Worker w = new Worker();
		w.setDaemon(true); 
		// 디폴트가 false, true로 변경을 해서 start를 걸면
		// 자신을 제외한 가동중인 쓰레드가 없으면 중지 (즉시정지는 아님)
		// 안전한 정지를 위해 사용
		
		w.start();
		
		try {
			for(;;) {
				String cmd = JOptionPane.showInputDialog("controll?");
				switch (cmd) {
				case "sleep":
					Thread.sleep(3000); 		// 현재 쓰레드의 작업을 잠시 멈춤 (자기자신?)
					break;						
					
				case "start":					// 에러가 걸리면 main thread가 죽어버림
					w.start(); break;			// start 두번 걸리면, IllegalThreadStateException
												
				case "interrupt":
					w.interrupt(); break;		// 신호를 줄수 있음
					
				case "join":
					//w.join();					// 해당 쓰레드의 작업이 끝나길 기다린다. 현재 스레드에 일시정지가 걸림
					w.join(2000);				// 제어권을 상대 쓰레드에 넘겨버림
					//==sleep(2000)
					break;
					
				case "suspend":
					w.suspend();				// 해당 쓰레드를 일시정지
					break;
					
				case "resume":					
					w.resume();					// 정지되었던 쓰레드를 다시 기동
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
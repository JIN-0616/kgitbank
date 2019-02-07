import javax.swing.JOptionPane;

/*
 * 
 * 쓰레드 제어.  start, stop
 * 	
 * 	: sleep ,  interrupt , join   
 * 
 */

class Worker extends Thread {
	
	public void run() {
		for(int cnt=1;cnt<=10000000;cnt++) {
			boolean t = this.isInterrupted();
			System.out.println(cnt+" do working.." + t);
			if(t) 
				break;
		}
	}
}

public class Source05_Thread {
	public static void main(String[] args) {
		System.out.println("[Main] start");
		Worker w = new Worker();
	//	w.setDaemon(true);	
		// 디폴트가 false, true 로 변경을 해서 start 를 걸면 ,
		// 자신을 제외한 가동중인 쓰레드가 없으면, 알아서 멈춘다.
		w.start();
		try {
			for( ;; ) {
				
				String cmd = JOptionPane.showInputDialog("controll? : ");
				switch(cmd) {
				case "sleep" :
					Thread.sleep(3000);	
					break;		// 현재 Thread의 작업을 잠시 멈춤.  
				case "start" :
					w.start();	break;	// start 두번 걸리면, java.lang.IllegalThreadStateException
				case "interrupt" :
					w.interrupt();	break;
				case "join":
					// w.join();	// 해당 쓰레드의 작업이 끝나길 기다린다. (현재 쓰레드에 일시정지가 걸림)
					w.join(2000);	break;
				case "suspend":
					w.suspend();	// 해당 쓰레드를 일시 정지	
					break;
				case "resume" :
					w.resume();	// 정지되있던 쓰레드를 다시 가동
				}
			}
		} catch(InterruptedException e) {
			System.out.println("InterruptedException ..");
		} finally {
			 w.stop();
		}
		
		
	}
}

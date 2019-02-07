import javax.swing.JOptionPane;

/*
 * 
 * ������ ����.  start, stop
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
		// ����Ʈ�� false, true �� ������ �ؼ� start �� �ɸ� ,
		// �ڽ��� ������ �������� �����尡 ������, �˾Ƽ� �����.
		w.start();
		try {
			for( ;; ) {
				
				String cmd = JOptionPane.showInputDialog("controll? : ");
				switch(cmd) {
				case "sleep" :
					Thread.sleep(3000);	
					break;		// ���� Thread�� �۾��� ��� ����.  
				case "start" :
					w.start();	break;	// start �ι� �ɸ���, java.lang.IllegalThreadStateException
				case "interrupt" :
					w.interrupt();	break;
				case "join":
					// w.join();	// �ش� �������� �۾��� ������ ��ٸ���. (���� �����忡 �Ͻ������� �ɸ�)
					w.join(2000);	break;
				case "suspend":
					w.suspend();	// �ش� �����带 �Ͻ� ����	
					break;
				case "resume" :
					w.resume();	// �������ִ� �����带 �ٽ� ����
				}
			}
		} catch(InterruptedException e) {
			System.out.println("InterruptedException ..");
		} finally {
			 w.stop();
		}
		
		
	}
}

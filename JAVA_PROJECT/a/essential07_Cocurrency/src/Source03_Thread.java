import javax.swing.JDialog;

/*
 * 병행처리를 위한 Thread 를 설계하는 법.
 * 	1. extends Thread
 * 	1. implements Runnable
 * 	1. anonymous class
 */

class Terror implements Runnable {
	String t;
	Terror(String t) {
		this.t=t;
	}
	public void run() {
		for(int cnt=1; cnt<=10; cnt++ ) {
			JDialog d = new JDialog();
				d.setTitle(t);
				int s = 200 + (int)(Math.random()*200);
				int x = 0 + (int)(Math.random()*1000);
			d.setSize(s, s);
			d.setLocation(x, x);
			d.setVisible(true);
		}
	}
}

public class Source03_Thread {
	public static void main(String[] args) {
		Terror r = new Terror("T E R R O R");	// Runnable
		Thread t = new Thread(r);
		t.start();
		
		Thread tt = new Thread() {
			@Override
			public void run() {
				for(int cnt=1; cnt<=10;cnt++) {
					System.out.println("!!!!");
				}
			}
		};
		
		tt.start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		});
		
		new Thread() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
			}
		}.start();
	}
}






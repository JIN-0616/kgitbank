import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

class Counter extends Thread {
	JLabel t;
	Counter(JLabel t) {
		this.t= t;
	}
	@Override
	public void run() {
		long e = 0;
		for(;;) {
			e++;
			t.setText(String.valueOf(e/100.0));
			try {
				Thread.sleep(10);
			} catch (InterruptedException e1) {
				break;
			}
		}
	}
}

class FrameKeyHandler implements KeyListener{
	Exercise02_Thread ui;
	Counter c;
	int count = 0;
	public FrameKeyHandler(Exercise02_Thread ui) {
		this.ui = ui;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
	//	System.out.println("keytTyped"); // 글자 찍히는 키	
		if (ui.getTitle().equals("Start")) {				
			System.out.println("keyTyped "+ ++count);
				ui.lb.setText(String.valueOf(count));			
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) { // 모든키 
		//System.out.println("keyPressed"+e.getKeyCode() ); //enter==10 
		if (e.getKeyCode()==10) {	// enter 입력시 처리
			if(ui.getTitle().equals("Stop")) {
				ui.setTitle("Start");
				if(c == null) {
					c = new Counter(ui.lbtime);
					c.start();
				}else {
					c.resume();
				}
			}else {
				ui.setTitle("Stop");
				c.suspend();
			}
		}else if (e.getKeyCode()==27) {
			System.exit(0);
		}		
	}

	@Override
	public void keyReleased(KeyEvent e) {
	//	System.out.println("keyReleased");
		
	}
	
}

public class Exercise02_Thread extends JFrame{
	JLabel lb;
	JLabel lbtime;
	public Exercise02_Thread() {
		setSize(400,500);
		setTitle("Stop");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		lb = new JLabel("New label");
		lb.setBounds(50, 199, 57, 15);
		getContentPane().add(lb);
		
		lbtime = new JLabel("New label");
		lbtime.setBounds(50, 78, 261, 45);
		getContentPane().add(lbtime);
		
		this.addKeyListener(new FrameKeyHandler(this));
		// 키 감지 Event 처리
	}
	public static void main(String[] args) {
		JFrame f = new Exercise02_Thread();
		f.setVisible(true);
	}
}

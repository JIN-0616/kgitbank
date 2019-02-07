import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;



class Counter extends Thread {
	JLabel t;
	Counter(JLabel t) {
		this.t= t;
	}
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

class FrameKeyHandler implements KeyListener {
	Exercise02_Thread ui;
	Counter c;
	public FrameKeyHandler(Exercise02_Thread ui) {
		this.ui = ui;
	}
	public void keyTyped(KeyEvent e) {
	//	System.out.println("keyTyped");
	}
	public void keyPressed(KeyEvent e) {
		System.out.println("keyPressed : " + e.getKeyCode());
		if(e.getKeyCode()==10 || e.getKeyCode()==32) {
			if(ui.getTitle().equals("STOP") ) {
				ui.setTitle("START");
				if(c == null) {
					c = new Counter(ui.lb);
					c.start();
				}else {
					c.resume();
				}
			}else {
				ui.setTitle("STOP");
				c.suspend();
			}
		}else if(e.getKeyCode() == 27) {
			System.exit(0);
		}
	}
	public void keyReleased(KeyEvent e) {
	//	System.out.println("keyReleased");
	}
}


public class Exercise02_Thread extends JFrame {
	public JLabel lb;
	
	public Exercise02_Thread() {
		setTitle("STOP");
		setSize(400, 230 );
		getContentPane().setLayout(null);
		
		lb = new JLabel("0.00");
		lb.setHorizontalAlignment(SwingConstants.CENTER);
		lb.setFont(new Font("³ª´®°íµñÄÚµù", Font.PLAIN, 17));
		lb.setBounds(141, 133, 87, 72);
		getContentPane().add(lb);
		
		JLabel lblMs = new JLabel("ms");
		lblMs.setHorizontalAlignment(SwingConstants.CENTER);
		lblMs.setFont(new Font("³ª´®°íµñÄÚµù", Font.PLAIN, 17));
		lblMs.setBounds(218, 154, 44, 30);
		getContentPane().add(lblMs);
		
		this.addKeyListener(new FrameKeyHandler(this));
	}

	
	public static void main(String[] args) {
		JFrame t = new Exercise02_Thread();
		t.setVisible(true);
	}
}

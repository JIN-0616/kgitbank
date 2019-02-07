import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class Exercise01_Thread extends JFrame {
	private JTextField textField;
	private JLabel lb;
	
	public Exercise01_Thread() {
		setSize(400, 300);
		getContentPane().setLayout(null);
		
		lb = new JLabel("WELCOME TO MY APPLICATION");
		lb.setFont(new Font("³ª´®°íµñÄÚµù", Font.PLAIN, 17));
		lb.setBounds(12, 23, 283, 48);
		getContentPane().add(lb);
		
		textField = new JTextField();
		textField.setFont(new Font("³ª´®°íµñÄÚµù", Font.PLAIN, 12));
		textField.setBounds(256, 206, 116, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		new Thread() {
			@Override
			public void run() {
				String txt ="WELCOME TO MY APPLICATION";
				for(;;) {
					for(int end=1; end<=txt.length(); end++) {
						lb.setText(  txt.substring(0, end) );
						try {
							Thread.sleep(100);
						} catch(InterruptedException e) {
							
						}
					}
				}
			}
		}.start();
		
		
	}
	
	
	public static void main(String[] args) {
		JFrame f = new Exercise01_Thread();
		f.setVisible(true);
	}
}

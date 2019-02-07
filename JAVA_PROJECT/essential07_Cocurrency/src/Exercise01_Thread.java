import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class Exercise01_Thread extends JFrame{
	private JTextField textField;
	private JLabel lb;
	public Exercise01_Thread() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,300);
		getContentPane().setLayout(null);
		
		lb = new JLabel("WelCome to my Application");
		lb.setFont(new Font("나눔고딕코딩", Font.PLAIN, 25));
		lb.setBounds(23, 26, 341, 71);
		getContentPane().add(lb);
		
		textField = new JTextField();
		textField.setBounds(279, 211, 116, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		new Thread() {
			@Override
			public void run() {
				String txt = "WelCome to my Application";
				for(;;) {
					for (int end = 1; end < txt.length(); end++) {
						lb.setText( txt.substring(0, end));
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							
						}
					}
				}
			}			
		}.start();
		// 병행처리하지 않으면 이펙트효과를 사용하기 힘듬
		// 병렬처리가 되지 않으면 작업이 끝나기 전까지
		// MAIN thread setVisibble 작업이 안됨
		
	}
	public static void main(String[] args) {
		JFrame f = new Exercise01_Thread();
		f.setVisible(true);
	}
}

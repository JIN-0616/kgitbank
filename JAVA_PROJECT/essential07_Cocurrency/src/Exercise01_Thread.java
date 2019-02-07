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
		lb.setFont(new Font("��������ڵ�", Font.PLAIN, 25));
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
		// ����ó������ ������ ����Ʈȿ���� ����ϱ� ����
		// ����ó���� ���� ������ �۾��� ������ ������
		// MAIN thread setVisibble �۾��� �ȵ�
		
	}
	public static void main(String[] args) {
		JFrame f = new Exercise01_Thread();
		f.setVisible(true);
	}
}

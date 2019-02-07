package UI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.BoxLayout;
import javax.swing.JTextArea;

public class LineBingo_Game extends JFrame {
	public LineBingo_Game() {
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 365, 616, 181);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 5, 10, 10));
		
		JToggleButton tglbtnNewToggleButton_2 = new JToggleButton("New toggle button");
		panel.add(tglbtnNewToggleButton_2);
		
		JToggleButton tglbtnNewToggleButton_3 = new JToggleButton("New toggle button");
		panel.add(tglbtnNewToggleButton_3);
		
		JToggleButton tglbtnNewToggleButton_6 = new JToggleButton("New toggle button");
		panel.add(tglbtnNewToggleButton_6);
		
		JToggleButton tglbtnNewToggleButton_7 = new JToggleButton("New toggle button");
		panel.add(tglbtnNewToggleButton_7);
		
		JToggleButton tglbtnNewToggleButton_8 = new JToggleButton("New toggle button");
		panel.add(tglbtnNewToggleButton_8);
		
		JToggleButton tglbtnNewToggleButton_9 = new JToggleButton("New toggle button");
		panel.add(tglbtnNewToggleButton_9);
		
		JToggleButton tglbtnNewToggleButton_5 = new JToggleButton("New toggle button");
		panel.add(tglbtnNewToggleButton_5);
		
		JToggleButton tglbtnNewToggleButton_4 = new JToggleButton("New toggle button");
		panel.add(tglbtnNewToggleButton_4);
		
		JToggleButton tglbtnNewToggleButton_1 = new JToggleButton("New toggle button");
		panel.add(tglbtnNewToggleButton_1);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("New toggle button");
		panel.add(tglbtnNewToggleButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(36, 132, 571, 181);
		getContentPane().add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		JTextPane txtpnUser = new JTextPane();
		txtpnUser.setText("user1 = [ ?? , ?? , ?? , ?? , ?? ]\nuser2 = [ ?? , ?? , ?? , ?? , ?? ]");
		panel_1.add(txtpnUser);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(36, 10, 571, 109);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JTextArea txtrcom = new JTextArea();
		txtrcom.setText("\uB098/com \uC774\uBC88\uD134\uC758 \uC120\uD0DD\uC22B\uC790");
		txtrcom.setBounds(12, 10, 547, 89);
		panel_2.add(txtrcom);
	}

}

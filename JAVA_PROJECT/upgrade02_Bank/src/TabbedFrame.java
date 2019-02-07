import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;

public class TabbedFrame extends JFrame{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	public TabbedFrame() {
		getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setBounds(12, 10, 410, 241);
		getContentPane().add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_2, null);
		panel_2.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(108, 128, 141, 24);
		panel_2.add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(108, 155, 4, 24);
		panel_2.add(textArea_1);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(131, 30, 4, 24);
		panel_2.add(textArea_2);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		rdbtnNewRadioButton.setBounds(241, 104, 121, 23);
		panel_2.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("New radio button");
		rdbtnNewRadioButton_1.setBounds(147, 207, 121, 23);
		panel_2.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("New radio button");
		rdbtnNewRadioButton_2.setBounds(12, 207, 121, 23);
		panel_2.add(rdbtnNewRadioButton_2);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("New tab", null, panel, null);
		
		JButton btnNewButton_1 = new JButton("New button");
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		panel.add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("New button");
		panel.add(btnNewButton);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_3, null);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		textField = new JTextField();
		panel_3.add(textField, BorderLayout.WEST);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		panel_3.add(textField_1, BorderLayout.CENTER);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		panel_3.add(textField_2, BorderLayout.SOUTH);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		panel_3.add(textField_3, BorderLayout.NORTH);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		panel_3.add(textField_4, BorderLayout.EAST);
		textField_4.setColumns(10);
	}
}

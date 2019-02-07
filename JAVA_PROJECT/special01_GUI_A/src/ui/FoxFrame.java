package ui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;

/*
 * Window Builder plug in 이 설치되있다면, 좀 쉽게 UI 구축이 가능하다.
 *  1. 만들고 싶은 걸 extends 걸어서 설정 (JFrame, JPanel, JDialog .. )
 *  2. 좌측 explorer 에서 파일명 우클릭 해서 open with Windowbuilder editor. 
 *  3. 아래쪽 [source]과 함께 [design] 탭이 생김, [design]을 클릭
 */
public class FoxFrame extends JFrame {
	private JTextField textField;
	private JPasswordField passwordField;
	public FoxFrame() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC544\uC774\uB514");
		lblNewLabel.setFont(new Font("궁서체", Font.PLAIN, 16));
		lblNewLabel.setBounds(340, 179, 57, 15);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(409, 176, 116, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(340, 210, 57, 15);
		getContentPane().add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(409, 207, 116, 21);
		getContentPane().add(passwordField);
		
		JLabel lblNewLabel_2 = new JLabel("\uADF8\uB798\uD53D UI");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("궁서체", Font.PLAIN, 22));
		lblNewLabel_2.setBounds(340, 66, 154, 63);
		getContentPane().add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 35, 154, 193);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(2, 2, 20, 10));
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setForeground(Color.RED);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		panel.add(btnNewButton_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"www.naver.com", "www.google.co.kr"}));
		comboBox.setBounds(340, 35, 154, 21);
		getContentPane().add(comboBox);
		
	}
}

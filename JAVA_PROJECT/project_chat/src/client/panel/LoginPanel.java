package client.panel;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginPanel extends JPanel {
	public JTextField tfId;
	public JPasswordField tfPass;
	public JLabel lbFail;
	public JButton btLogin;
	public JButton btJoin;
	public JLabel lbFind;
	
	public LoginPanel() {
		setBackground(new Color(255, 215, 0));
		setSize(400, 530);
		setLayout(null);
		
		JPanel pnAuth = new JPanel();
		pnAuth.setBounds(12, 10, 383, 507);
		add(pnAuth);
		pnAuth.setBackground(new Color(255, 215, 0));
		pnAuth.setLayout(null);
		
		tfId = new JTextField();
		tfId.setFont(new Font("³ª´®°íµñÄÚµù", Font.PLAIN, 12));
		tfId.setBounds(81, 258, 231, 39);
		pnAuth.add(tfId);
		tfId.setColumns(10);
		
		tfPass = new JPasswordField();
		tfPass.setFont(new Font("³ª´®°íµñÄÚµù", Font.PLAIN, 12));
		tfPass.setBounds(81, 301, 231, 39);
		pnAuth.add(tfPass);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\kgitbank\\Desktop\\image\\kakao3.png"));
		lblNewLabel.setBounds(78, 68, 233, 153);
		pnAuth.add(lblNewLabel);
		
		btLogin = new JButton("\uB85C\uADF8\uC778");
		btLogin.setFont(new Font("±¼¸²", Font.BOLD, 17));
		btLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btLogin.setBounds(80, 348, 234, 32);
		pnAuth.add(btLogin);
		
		lbFail = new JLabel("");
		lbFail.setBounds(83, 422, 231, 21);
		pnAuth.add(lbFail);
		
		btJoin = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btJoin.setFont(new Font("±¼¸²", Font.BOLD, 17));
		btJoin.setBounds(80, 383, 234, 32);
		pnAuth.add(btJoin);
		
		lbFind = new JLabel("\uACC4\uC815\uCC3E\uAE30");
		lbFind.setForeground(Color.BLUE);
		lbFind.setFont(new Font("±¼¸²", Font.PLAIN, 13));
		lbFind.setBounds(171, 465, 57, 15);
		pnAuth.add(lbFind);
		
		ButtonGroup group = new ButtonGroup();
	}
}

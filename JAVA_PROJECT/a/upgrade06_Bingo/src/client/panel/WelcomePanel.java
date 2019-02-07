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
import javax.swing.JButton;

public class WelcomePanel extends JPanel {
	public JTextField tfAuthNick;
	public JPasswordField pfAuthPass;
	public JTextField tfJoinNick;
	public JPasswordField pfJoinPass;
	public JRadioButton rbtAgree;
	public JRadioButton rbtDisagree;
	public JButton btJoin;
	
	
	public WelcomePanel() {
		setSize(500, 350);
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("³ª´®°íµñÄÚµù", Font.PLAIN, 12));
		tabbedPane.setBounds(12, 10, 476, 330);
		add(tabbedPane);
		
		JPanel pnAuth = new JPanel();
		tabbedPane.addTab("\uB85C\uADF8\uC778", null, pnAuth, null);
		pnAuth.setLayout(null);
		
		JLabel lbTmp1 = new JLabel("\uB300\uC804! \uBE59\uACE0 \uBE59\uACE0!! ");
		lbTmp1.setHorizontalAlignment(SwingConstants.CENTER);
		lbTmp1.setFont(new Font("³ª´®°íµñÄÚµù", Font.BOLD | Font.ITALIC, 24));
		lbTmp1.setBounds(12, 74, 447, 45);
		pnAuth.add(lbTmp1);
		
		tfAuthNick = new JTextField();
		tfAuthNick.setFont(new Font("³ª´®°íµñÄÚµù", Font.PLAIN, 12));
		tfAuthNick.setBounds(343, 228, 116, 21);
		pnAuth.add(tfAuthNick);
		tfAuthNick.setColumns(10);
		
		pfAuthPass = new JPasswordField();
		pfAuthPass.setFont(new Font("³ª´®°íµñÄÚµù", Font.PLAIN, 12));
		pfAuthPass.setBounds(343, 259, 116, 21);
		pnAuth.add(pfAuthPass);
		
		JLabel lbTmp2 = new JLabel("\uC0AC\uC6A9\uC790 \uACC4\uC815,\uBE44\uBC88\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694");
		lbTmp2.setFont(new Font("³ª´®°íµñÄÚµù", Font.PLAIN, 13));
		lbTmp2.setHorizontalAlignment(SwingConstants.RIGHT);
		lbTmp2.setBounds(245, 203, 214, 15);
		pnAuth.add(lbTmp2);
		
		JLabel lbTmp3 = new JLabel("\uACC4\uC815\uB2C9\uB134");
		lbTmp3.setHorizontalAlignment(SwingConstants.RIGHT);
		lbTmp3.setFont(new Font("³ª´®°íµñÄÚµù", Font.PLAIN, 11));
		lbTmp3.setBounds(268, 230, 63, 15);
		pnAuth.add(lbTmp3);
		
		JLabel lbTmp4 = new JLabel("\uACC4\uC815\uBE44\uBC88");
		lbTmp4.setHorizontalAlignment(SwingConstants.RIGHT);
		lbTmp4.setFont(new Font("³ª´®°íµñÄÚµù", Font.PLAIN, 11));
		lbTmp4.setBounds(268, 261, 63, 15);
		pnAuth.add(lbTmp4);
		
		JPanel pnJoin = new JPanel();
		pnJoin.setLayout(null);
		tabbedPane.addTab("\uD68C\uC6D0\uAC00\uC785", null, pnJoin, null);
		
		JLabel lbTmp5 = new JLabel("\u3014\uACC4\uC815 \uC0DD\uC131\u3015");
		lbTmp5.setHorizontalAlignment(SwingConstants.CENTER);
		lbTmp5.setFont(new Font("³ª´®°íµñÄÚµù", Font.BOLD | Font.ITALIC, 24));
		lbTmp5.setBounds(12, 10, 447, 45);
		pnJoin.add(lbTmp5);
		
		tfJoinNick = new JTextField();
		tfJoinNick.setFont(new Font("³ª´®°íµñÄÚµù", Font.PLAIN, 12));
		tfJoinNick.setColumns(10);
		tfJoinNick.setBounds(206, 174, 116, 21);
		pnJoin.add(tfJoinNick);
		
		pfJoinPass = new JPasswordField();
		pfJoinPass.setFont(new Font("³ª´®°íµñÄÚµù", Font.PLAIN, 12));
		pfJoinPass.setBounds(206, 205, 116, 21);
		pnJoin.add(pfJoinPass);
		
		JLabel label_2 = new JLabel("\uB2C9\uB124\uC784");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("³ª´®°íµñÄÚµù", Font.PLAIN, 11));
		label_2.setBounds(131, 176, 63, 15);
		pnJoin.add(label_2);
		
		JLabel label_3 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("³ª´®°íµñÄÚµù", Font.PLAIN, 11));
		label_3.setBounds(131, 207, 63, 15);
		pnJoin.add(label_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 53, 447, 97);
		pnJoin.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("³ª´®°íµñÄÚµù", Font.PLAIN, 12));
		textArea.setLineWrap(true);
		textArea.setText("\uC11C\uBE44\uC2A4 \uC774\uC6A9\uC57D\uAD00\r\n\r\n\uC81C1\uC870 (\uC774\uC6A9\uACC4\uC57D\uC758 \uC131\uB9BD)\r\n\uC774\uC6A9\uACC4\uC57D\uC740 \uC774\uC6A9\uC790\uC758 \uC57D\uAD00\uB0B4\uC6A9\uC5D0 \uB300\uD55C \uB3D9\uC758\uC640 \uC774\uC6A9\uC790\uC758 \uC774\uC6A9\uC2E0\uCCAD\uC5D0 \uB300\uD55C  \uC2B9\uB099\uC73C\uB85C \uC131\uB9BD\uD569\uB2C8\uB2E4.\r\n\r\n\uC81C2\uC870 (\uC774\uC6A9\uC2E0\uCCAD)\r\n\uC774\uC6A9\uC2E0\uCCAD\uC740 \uC11C\uBE44\uC2A4\uC758 \uD68C\uC6D0\uC815\uBCF4 \uD654\uBA74\uC5D0\uC11C \uC774\uC6A9\uC790\uAC00  \uC694\uAD6C\uD558\uB294 \uAC00\uC785\uC2E0\uCCAD \uC591\uC2DD\uC5D0 \uAC1C\uC778\uC758 \uC2E0\uC0C1\uC815\uBCF4\uB97C \uAE30\uB85D\uD558\uB294 \uBC29\uC2DD\uC73C\uB85C \uC2E0\uCCAD\uD569\uB2C8\uB2E4.\r\n");
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		rbtAgree = new JRadioButton("\uB3D9\uC758");
		rbtAgree.setFont(new Font("³ª´®°íµñÄÚµù", Font.PLAIN, 11));
		rbtAgree.setBounds(178, 232, 47, 23);
		pnJoin.add(rbtAgree);
		
		rbtDisagree = new JRadioButton("\uBE44\uB3D9\uC758");
		rbtDisagree.setFont(new Font("³ª´®°íµñÄÚµù", Font.PLAIN, 11));
		rbtDisagree.setBounds(242, 232, 63, 23);
		pnJoin.add(rbtDisagree);
		
		btJoin = new JButton("\uAC00\uC785\uC2E0\uCCAD");
		btJoin.setFont(new Font("³ª´®°íµñÄÚµù", Font.PLAIN, 12));
		btJoin.setBounds(150, 261, 172, 32);
		pnJoin.add(btJoin);
	}
}

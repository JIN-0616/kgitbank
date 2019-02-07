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
import java.awt.Color;

public class JoinPanel extends JPanel {
	public JPasswordField tfNewPass;
	public JRadioButton rbtAgree;
	public JRadioButton rbtDisagree;
	public JButton btNewJoin;
	public JTextField tfNewHint;
	public JTextField tfNewId;
	
	public JoinPanel() {
		setSize(400, 530);
		setLayout(null);
		
		ButtonGroup group = new ButtonGroup();
		
		JPanel pnJoin = new JPanel();
		pnJoin.setBackground(new Color(255, 215, 0));
		pnJoin.setBounds(21, 0, 376, 526);
		add(pnJoin);
		pnJoin.setLayout(null);
		
		JLabel lbTmp5 = new JLabel("\u3014\uAE68\uAE68\uC624\uD1A1\uACC4\uC815 \uC815\uBCF4\uC785\uB825\u3015");
		lbTmp5.setHorizontalAlignment(SwingConstants.CENTER);
		lbTmp5.setFont(new Font("³ª´®°íµñÄÚµù", Font.BOLD | Font.ITALIC, 24));
		lbTmp5.setBounds(12, 10, 343, 45);
		pnJoin.add(lbTmp5);
		
		tfNewId = new JTextField();
		tfNewId.setFont(new Font("³ª´®°íµñÄÚµù", Font.PLAIN, 12));
		tfNewId.setColumns(10);
		tfNewId.setBounds(148, 224, 116, 21);
		pnJoin.add(tfNewId);
		
		tfNewPass = new JPasswordField();
		tfNewPass.setFont(new Font("³ª´®°íµñÄÚµù", Font.PLAIN, 12));
		tfNewPass.setBounds(148, 255, 116, 21);
		pnJoin.add(tfNewPass);
		
		JLabel label_2 = new JLabel("\uB2C9\uB124\uC784");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("Dialog", Font.BOLD, 11));
		label_2.setBounds(80, 228, 63, 15);
		pnJoin.add(label_2);
		
		JLabel label_3 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("Dialog", Font.BOLD, 11));
		label_3.setBounds(80, 257, 63, 15);
		pnJoin.add(label_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(16, 51, 347, 97);
		pnJoin.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("³ª´®°íµñÄÚµù", Font.PLAIN, 12));
		textArea.setLineWrap(true);
		textArea.setText("\uC11C\uBE44\uC2A4 \uC774\uC6A9\uC57D\uAD00\r\n\r\n\uC81C1\uC870 (\uC774\uC6A9\uACC4\uC57D\uC758 \uC131\uB9BD)\r\n\uC774\uC6A9\uACC4\uC57D\uC740 \uC774\uC6A9\uC790\uC758 \uC57D\uAD00\uB0B4\uC6A9\uC5D0 \uB300\uD55C \uB3D9\uC758\uC640 \uC774\uC6A9\uC790\uC758 \uC774\uC6A9\uC2E0\uCCAD\uC5D0 \uB300\uD55C  \uC2B9\uB099\uC73C\uB85C \uC131\uB9BD\uD569\uB2C8\uB2E4.\r\n\r\n\uC81C2\uC870 (\uC774\uC6A9\uC2E0\uCCAD)\r\n\uC774\uC6A9\uC2E0\uCCAD\uC740 \uC11C\uBE44\uC2A4\uC758 \uD68C\uC6D0\uC815\uBCF4 \uD654\uBA74\uC5D0\uC11C \uC774\uC6A9\uC790\uAC00  \uC694\uAD6C\uD558\uB294 \uAC00\uC785\uC2E0\uCCAD \uC591\uC2DD\uC5D0 \uAC1C\uC778\uC758 \uC2E0\uC0C1\uC815\uBCF4\uB97C \uAE30\uB85D\uD558\uB294 \uBC29\uC2DD\uC73C\uB85C \uC2E0\uCCAD\uD569\uB2C8\uB2E4.\r\n");
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		rbtAgree = new JRadioButton("\uB3D9\uC758");
		rbtAgree.setBackground(new Color(255, 215, 0));
		rbtAgree.setFont(new Font("³ª´®°íµñÄÚµù", Font.PLAIN, 11));
		rbtAgree.setBounds(121, 163, 47, 23);
		pnJoin.add(rbtAgree);
		
		rbtDisagree = new JRadioButton("\uBE44\uB3D9\uC758");
		rbtDisagree.setBackground(new Color(255, 215, 0));
		rbtDisagree.setFont(new Font("³ª´®°íµñÄÚµù", Font.PLAIN, 11));
		rbtDisagree.setBounds(182, 163, 63, 23);
		pnJoin.add(rbtDisagree);
		group.add(rbtAgree);
		group.add(rbtDisagree);
		
		
		btNewJoin = new JButton("\uAC00\uC785\uC2E0\uCCAD");
		btNewJoin.setFont(new Font("Dialog", Font.BOLD, 12));
		btNewJoin.setBounds(92, 321, 172, 32);
		pnJoin.add(btNewJoin);
		
		JLabel label = new JLabel("\uD78C\uD2B8\uB4F1\uB85D");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("Dialog", Font.BOLD, 11));
		label.setBounds(80, 289, 63, 15);
		pnJoin.add(label);
		
		tfNewHint = new JTextField();
		tfNewHint.setFont(new Font("Dialog", Font.PLAIN, 12));
		tfNewHint.setColumns(10);
		tfNewHint.setBounds(148, 286, 116, 21);
		pnJoin.add(tfNewHint);
	}
}
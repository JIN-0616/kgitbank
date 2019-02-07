package client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import client.handler.BtTransferHandler;
import client.handler.BtnCreateHandler;
import client.handler.TfIdActionHandler;
import javax.swing.JSeparator;

public class BankClientUI extends JFrame {
	public String currentId;
	
	public BankClientNetwork network;
	
	
	public JLabel lbCreate;
	public JButton btnCreate;
	public JTextField tfId;
	public JTabbedPane tabbedPane;
	public JLabel lbCurrent2;
	public JTextField tfTarget;
	public JTextField tfMoney;
	public JPasswordField pfPass;
	public JLabel lbTransfer;
	public JButton btTransfer;
	public JPasswordField passwordField;
	public JLabel lbCurrent1;
	public JLabel lbMain;
	
	public BankClientUI() {
		network = new BankClientNetwork("192.168.10.27");
		setComponents();
		addListeners();
	}

	private void addListeners() {
		tfId.addActionListener(new TfIdActionHandler(this)); 
		btnCreate.addActionListener(new BtnCreateHandler(this)); 
		btTransfer.addActionListener(new BtTransferHandler(this));
	}

	private void setComponents() {
		setFont(new Font("³ª´®°íµñÄÚµù", Font.PLAIN, 15));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("BankSystem");
		setSize(500, 350);

		tabbedPane = new JTabbedPane(JTabbedPane.RIGHT);
		tabbedPane.setFont(new Font("³ª´®°íµñÄÚµù", Font.PLAIN, 12));
		getContentPane().add(tabbedPane, BorderLayout.CENTER);

		JPanel pn1 = new JPanel();
		tabbedPane.addTab("\uBA54\uC778", null, pn1, null);
		pn1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("BANK SYSTEM");
		lblNewLabel_1.setFont(new Font("³ª´®°íµñÄÚµù", Font.BOLD, 24));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(12, 24, 391, 38);
		pn1.add(lblNewLabel_1);

		tfId = new JTextField();
		tfId.setFont(new Font("³ª´®°íµñÄÚµù", Font.PLAIN, 12));
		tfId.setHorizontalAlignment(SwingConstants.CENTER);
		tfId.setBounds(275, 253, 116, 21);
		pn1.add(tfId);
		tfId.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel(
				"\uBD80\uC5EC\uBC1B\uC740 \uACC4\uC88C \uC544\uC774\uB514\uB97C \uC785\uB825\uBC14\uB780\uB2E4.");
		lblNewLabel_2.setFont(new Font("³ª´®°íµñÄÚµù", Font.PLAIN, 12));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(168, 228, 223, 15);
		pn1.add(lblNewLabel_2);
		
		lbMain = new JLabel("[SYSTEM]");
		lbMain.setForeground(Color.RED);
		lbMain.setHorizontalAlignment(SwingConstants.RIGHT);
		lbMain.setFont(new Font("³ª´®°íµñÄÚµù", Font.PLAIN, 11));
		lbMain.setBounds(206, 281, 185, 15);
		pn1.add(lbMain);

		JPanel pn2 = new JPanel();
		tabbedPane.addTab("\uACC4\uC88C\uAC1C\uC124", null, pn2, null);
		pn2.setLayout(null);

		btnCreate = new JButton("\uACC4\uC88C \uAC1C\uC124");
		btnCreate.setFont(new Font("³ª´®°íµñÄÚµù", Font.PLAIN, 13));
		btnCreate.setBounds(153, 110, 97, 37);
		pn2.add(btnCreate);

		JLabel lblNewLabel = new JLabel(
				"\uC0AC\uC6A9\uC790 \uACC4\uC88C\uB97C \uAC1C\uC124\uC2E0\uCCAD\uD569\uB2C8\uB2E4. \uBCC4\uB3C4\uC758 \uC808\uCC28\uB294 \uC5C6\uC2B5\uB2C8\uB2E4.");
		lblNewLabel.setFont(new Font("³ª´®°íµñÄÚµù", Font.PLAIN, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 80, 391, 15);
		pn2.add(lblNewLabel);

		lbCreate = new JLabel("");
		lbCreate.setForeground(Color.RED);
		lbCreate.setFont(new Font("³ª´®°íµñÄÚµù", Font.PLAIN, 11));
		lbCreate.setHorizontalAlignment(SwingConstants.CENTER);
		lbCreate.setBounds(12, 189, 391, 23);
		pn2.add(lbCreate);

		JPanel pn3 = new JPanel();
		tabbedPane.addTab("\uACC4\uC88C\uD655\uC778", null, pn3, null);
		pn3.setLayout(null);

		lbCurrent1 = new JLabel("");
		lbCurrent1.setForeground(Color.BLUE);
		lbCurrent1.setFont(new Font("³ª´®°íµñÄÚµù", Font.PLAIN, 14));
		lbCurrent1.setBounds(12, 10, 148, 28);
		pn3.add(lbCurrent1);

		JLabel label_3 = new JLabel("\uFF0A\uACC4\uC88C \uBE44\uBC00\uBC88\uD638");
		label_3.setFont(new Font("³ª´®°íµñÄÚµù", Font.PLAIN, 12));
		label_3.setBounds(56, 110, 104, 15);
		pn3.add(label_3);

		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setFont(new Font("³ª´®°íµñÄÚµù", Font.PLAIN, 12));
		passwordField.setBounds(192, 106, 152, 21);
		pn3.add(passwordField);

		JButton button = new JButton("\uACC4\uC88C \uD655\uC778");
		button.setFont(new Font("³ª´®°íµñÄÚµù", Font.PLAIN, 12));
		button.setBounds(112, 157, 152, 28);
		pn3.add(button);
		tabbedPane.setEnabledAt(2, false);

		JPanel pn4 = new JPanel();
		tabbedPane.addTab("\uACC4\uC88C\uC774\uCCB4", null, pn4, null);
		pn4.setLayout(null);

		lbCurrent2 = new JLabel("");
		lbCurrent2.setForeground(Color.BLUE);
		lbCurrent2.setFont(new Font("³ª´®°íµñÄÚµù", Font.PLAIN, 14));
		lbCurrent2.setBounds(12, 10, 146, 28);
		pn4.add(lbCurrent2);

		JLabel label = new JLabel("\uFF0A\uC0C1\uB300\uBC29 \uC544\uC774\uB514");
		label.setFont(new Font("³ª´®°íµñÄÚµù", Font.PLAIN, 12));
		label.setBounds(54, 110, 104, 15);
		pn4.add(label);

		tfTarget = new JTextField();
		tfTarget.setFont(new Font("³ª´®°íµñÄÚµù", Font.PLAIN, 12));
		tfTarget.setHorizontalAlignment(SwingConstants.CENTER);
		tfTarget.setBounds(190, 106, 152, 21);
		pn4.add(tfTarget);
		tfTarget.setColumns(10);

		JLabel label_1 = new JLabel("\uFF0A\uC774\uCCB4\uD560 \uAE08\uC561");
		label_1.setFont(new Font("³ª´®°íµñÄÚµù", Font.PLAIN, 12));
		label_1.setBounds(54, 141, 104, 15);
		pn4.add(label_1);

		tfMoney = new JTextField();
		tfMoney.setFont(new Font("³ª´®°íµñÄÚµù", Font.PLAIN, 12));
		tfMoney.setHorizontalAlignment(SwingConstants.CENTER);
		tfMoney.setColumns(10);
		tfMoney.setBounds(190, 137, 152, 21);
		pn4.add(tfMoney);

		JLabel label_2 = new JLabel("\uFF0A\uACC4\uC88C \uBE44\uBC00\uBC88\uD638");
		label_2.setFont(new Font("³ª´®°íµñÄÚµù", Font.PLAIN, 12));
		label_2.setBounds(54, 65, 104, 15);
		pn4.add(label_2);

		pfPass = new JPasswordField();
		pfPass.setHorizontalAlignment(SwingConstants.CENTER);
		pfPass.setFont(new Font("³ª´®°íµñÄÚµù", Font.PLAIN, 12));
		pfPass.setBounds(190, 61, 152, 21);
		pn4.add(pfPass);

		btTransfer = new JButton("\uACC4\uC88C \uC774\uCCB4");
		btTransfer.setFont(new Font("³ª´®°íµñÄÚµù", Font.PLAIN, 12));
		btTransfer.setBounds(110, 185, 152, 28);
		pn4.add(btTransfer);

		lbTransfer = new JLabel("[SYSTEM]");
		lbTransfer.setFont(new Font("³ª´®°íµñÄÚµù", Font.PLAIN, 11));
		lbTransfer.setHorizontalAlignment(SwingConstants.RIGHT);
		lbTransfer.setForeground(Color.RED);
		lbTransfer.setBounds(54, 245, 319, 21);
		pn4.add(lbTransfer);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(54, 92, 291, 2);
		pn4.add(separator);
		tabbedPane.setEnabledAt(3, false);

	}
}

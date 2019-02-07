package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;



class BtConnectHandler implements ActionListener {
	HotelFrame target;
	BtConnectHandler(HotelFrame f) {
		target = f;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String s = target.tf.getText();
		char[] p = target.pf.getPassword();
		target.tf.setEnabled(false);
		target.pf.setEnabled(false);
		target.btConnect.setEnabled(false);
		String rst = "[시스템] 서버 연결중 .. 계정 (" +s +"/" + p[0]+ "******)";
		target.textArea.setText(rst);
	}
}


class BtCancelHandler implements ActionListener {
	HotelFrame target;
	BtCancelHandler(HotelFrame f) {
		target = f;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		target.tf.setEnabled(true);
		target.pf.setEnabled(true);
		target.btConnect.setEnabled(true);
		String rst = target.textArea.getText();
		rst += "\n[시스템] 연결 취소";
		target.textArea.setText(rst);
	}
}



public class HotelFrame extends JFrame {
	JPasswordField pf;
	JTextField tf;
	JButton btConnect;
	JButton btCancel;
	JTextArea textArea;
	
	
	public HotelFrame() {
		init();
		
		ActionListener bch = new BtConnectHandler(this);
		btConnect.addActionListener(bch);
		btCancel.addActionListener(new BtCancelHandler(this));
	}
	
	
	
	private void init() {
		setSize(413,325);
		getContentPane().setLayout(null);
		
		tf = new JTextField();
		tf.setBounds(127, 49, 116, 21);
		getContentPane().add(tf);
		tf.setColumns(10);
		
		pf = new JPasswordField();
		pf.setBounds(127, 80, 116, 21);
		getContentPane().add(pf);
		
		btConnect = new JButton("Connect");
		btConnect.setBounds(81, 111, 97, 23);
		getContentPane().add(btConnect);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 170, 373, 106);
		getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		btCancel = new JButton("Cancel");
		btCancel.setEnabled(false);
		btCancel.setBounds(191, 111, 97, 23);
		getContentPane().add(btCancel);
		
		JLabel lblNewLabel = new JLabel("WELCOME");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(127, 24, 116, 15);
		getContentPane().add(lblNewLabel);
	}
}

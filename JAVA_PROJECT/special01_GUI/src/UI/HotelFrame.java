package UI;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

class BtConnectHandler implements ActionListener{
	HotelFrame target;
	BtConnectHandler(HotelFrame f) {
		target = f;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("BtConnectHandler.actionPerformed.."); //실행 확인문
		String s = target.tf.getText();
		char[] p = target.pf.getPassword();
		target.tf.setEnabled(false); //default true; 비활성화
		target.pf.setEnabled(false);
		target.btConnect.setEnabled(false);
		String txt = "[SYSYEM] connect to server ..."+s+"..."+p[0]+"*****";
		target.textArea.setText(txt);
	}
	
}
class BtCancelHandler implements ActionListener{
	HotelFrame target;
	BtCancelHandler(HotelFrame f) {
		target = f;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//System.out.println("BtCancelHandler.actionPerformed.."); //실행 확인문
		String txt = "";
		target.tf.setText(txt);
		target.pf.setText(txt);
		target.tf.setEnabled(true);
		target.pf.setEnabled(true);
		target.btConnect.setEnabled(true);
		//String rst = "[SYSTEM] 연결 취소"; //재생성방법
		txt +="\n[SYSTEM] 연결 취소"; // 이미 출력한 내용을 재생성하지 않고
									// 추가해서 보여주는 부분
									// 내부처리는 기존내용+새내용 출력이다.
		target.textArea.setText(txt);
	}
	
}

public class HotelFrame extends JFrame{
	//private 풀기 - 외부접근이 안되서 객체값을 타고 내부변수제어가 불가능하므로
	JButton btConnect;
	JButton btCancel;
	JTextArea textArea;
	JPasswordField pf;
	JTextField tf;
	public HotelFrame() {
		init();
		
		ActionListener bch = new BtConnectHandler(this); //하나하나가 아닌 객체 통채로 넘김
		btConnect.addActionListener(bch);
		
		ActionListener bcch = new BtCancelHandler(this);
		btCancel.addActionListener(bcch);
	}
	private void init() { //내부메소드로 묶어서 folding처리하면 보기 편하다

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,300); //하드 코딩
		getContentPane().setLayout(null);
		
		tf = new JTextField();
		tf.setText("WelCome");
		tf.setBounds(12, 10, 116, 23);
		getContentPane().add(tf);
		tf.setColumns(10);
		
		pf = new JPasswordField();
		pf.setBounds(12, 43, 116, 27);
		getContentPane().add(pf);
		
		btConnect = new JButton("Connect");
		btConnect.setBounds(12, 80, 97, 23);
		getContentPane().add(btConnect);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 113, 360, 138);
		getContentPane().add(scrollPane);
		
		btCancel = new JButton("Cancel");
		btCancel.setBounds(130, 80, 97, 23);
		getContentPane().add(btCancel);
		
		textArea = new JTextArea();
		textArea.setEnabled(false);
		textArea.setBounds(12, 113, 360, 138);
		getContentPane().add(textArea);
	}
	
	
	
}

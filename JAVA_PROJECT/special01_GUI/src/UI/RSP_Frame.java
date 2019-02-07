package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DropMode;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class RSP_Frame extends JFrame{
	RSP_Game engine;
	
	JToggleButton p_a;
	JToggleButton p_b;
	JToggleButton p_c;
	JToggleButton c_a;
	JToggleButton c_b;
	JToggleButton c_c;
	JButton btnStart;
	JLabel attackView;
	JTextArea textArea;
	
	String text="준비중\n";
	public RSP_Frame() {
		engine = new RSP_Game();
		
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setFont(new Font("나눔고딕코딩", Font.PLAIN, 20));
		setSize(600,600);
		setType(Type.UTILITY);
		setTitle("====================\uBB35\uCC0C\uBE60 \uAC8C\uC784======================");
		getContentPane().setFont(new Font("나눔고딕코딩", Font.BOLD, 20));
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(23, 388, 530, 143);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		p_a = new JToggleButton("\uBB35");
		p_a.setFont(new Font("나눔고딕코딩", Font.BOLD, 99));
		panel.add(p_a);
		
		p_b = new JToggleButton("\uCC0C");
		p_b.setFont(new Font("나눔고딕코딩", Font.BOLD, 99));
		panel.add(p_b);
		
		p_c = new JToggleButton("\uBE60");
		p_c.setFont(new Font("나눔고딕코딩", Font.BOLD, 99));
		panel.add(p_c);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(128, 228, 310, 150);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(12, 10, 283, 73);
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 0, 0, 0));
		
		c_a = new JToggleButton("\uBB35");
		c_a.setEnabled(false);
		c_a.setFont(new Font("나눔고딕코딩", Font.BOLD, 40));
		panel_3.add(c_a);
		
		c_b = new JToggleButton("\uCC0C");
		c_b.setEnabled(false);
		c_b.setFont(new Font("나눔고딕코딩", Font.BOLD, 40));
		panel_3.add(c_b);
		
		c_c = new JToggleButton("\uBE60");
		c_c.setEnabled(false);
		c_c.setFont(new Font("나눔고딕코딩", Font.BOLD, 40));
		panel_3.add(c_c);
		
		attackView = new JLabel("ready");
		attackView.setHorizontalAlignment(SwingConstants.CENTER);
		attackView.setFont(new Font("나눔고딕코딩", Font.PLAIN, 18));
		attackView.setBounds(65, 104, 151, 36);
		panel_1.add(attackView);
		
		btnStart = new JButton("start");
		btnStart.setBounds(456, 248, 97, 23);
		getContentPane().add(btnStart);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 59, 508, 128);
		getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setLineWrap(true);
		textArea.setBackground(Color.GRAY);
		textArea.setWrapStyleWord(true);
		textArea.setRows(8);
		textArea.setForeground(Color.WHITE);
		textArea.setFont(new Font("나눔고딕코딩", Font.PLAIN, 13));
		
		btnStart.addActionListener(new StartHandler(this));
		p_a.addActionListener(new aHandler(this));
		p_b.addActionListener(new bHandler(this));
		p_c.addActionListener(new cHandler(this));
	}
}

class StartHandler implements ActionListener{
	RSP_Frame target;
	
	public StartHandler(RSP_Frame f) {
		target = f;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		target.engine.start();
		target.p_a.setEnabled(true);
		target.p_b.setEnabled(true);
		target.p_c.setEnabled(true);
		target.btnStart.setEnabled(false);
		String s = (target.engine.attack)? "현재 공격중":"현재 수비중";
		target.attackView.setText(s);
		target.btnStart.setEnabled(false);
	}
}
class aHandler implements ActionListener{
	RSP_Frame target;
	
	public aHandler(RSP_Frame f) {
		target = f;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		target.engine.choice = 0;
		target.engine.input();
		if(target.engine.auto==0) {
			target.c_a.setEnabled(true);
			target.c_b.setEnabled(false);
			target.c_c.setEnabled(false);
		}else if(target.engine.auto==1) {
			target.c_a.setEnabled(false);
			target.c_b.setEnabled(true);
			target.c_c.setEnabled(false);		
		}else if(target.engine.auto==2) {
			target.c_a.setEnabled(false);
			target.c_b.setEnabled(false);
			target.c_c.setEnabled(true);
		}
		target.textArea.setText(target.text +=target.engine.tell());
		if(target.engine.isRun) {
			String s = (target.engine.attack)? " 현재 공격중":"현재 수비중";
			target.attackView.setText(s);		
		}else {
			target.p_a.setEnabled(false);
			target.p_b.setEnabled(false);
			target.p_c.setEnabled(false);
			target.btnStart.setEnabled(true);
		}
	}
}
class bHandler implements ActionListener{
	RSP_Frame target;
	
	public bHandler(RSP_Frame f) {
		target = f;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		target.engine.choice = 1;
		target.engine.input();
		if(target.engine.auto==0) {
			target.c_a.setEnabled(true);
			target.c_b.setEnabled(false);
			target.c_c.setEnabled(false);
		}else if(target.engine.auto==1) {
			target.c_a.setEnabled(false);
			target.c_b.setEnabled(true);
			target.c_c.setEnabled(false);		
		}else if(target.engine.auto==2) {
			target.c_a.setEnabled(false);
			target.c_b.setEnabled(false);
			target.c_c.setEnabled(true);
		}
		target.textArea.setText(target.text +=target.engine.tell());
		if(target.engine.isRun) {
			String s = (target.engine.attack)? " 현재 공격중":"현재 수비중";
			target.attackView.setText(s);		
		}else {
			target.p_a.setEnabled(false);
			target.p_b.setEnabled(false);
			target.p_c.setEnabled(false);
			target.btnStart.setEnabled(true);
		}
	}
}
class cHandler implements ActionListener{
	RSP_Frame target;
	
	public cHandler(RSP_Frame f) {
		target = f;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		target.engine.choice = 2;
		target.engine.input();
		if(target.engine.auto==0) {
			target.c_a.setEnabled(true);
			target.c_b.setEnabled(false);
			target.c_c.setEnabled(false);
		}else if(target.engine.auto==1) {
			target.c_a.setEnabled(false);
			target.c_b.setEnabled(true);
			target.c_c.setEnabled(false);		
		}else if(target.engine.auto==2) {
			target.c_a.setEnabled(false);
			target.c_b.setEnabled(false);
			target.c_c.setEnabled(true);
		}
		target.textArea.setText(target.text +=target.engine.tell());
		if(target.engine.isRun) {
			String s = (target.engine.attack)? " 현재 공격중":"현재 수비중";
			target.attackView.setText(s);		
		}else {
			target.p_a.setEnabled(false);
			target.p_b.setEnabled(false);
			target.p_c.setEnabled(false);
			target.btnStart.setEnabled(true);
		}
	}
}
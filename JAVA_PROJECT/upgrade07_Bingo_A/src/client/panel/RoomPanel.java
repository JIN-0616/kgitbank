package client.panel;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;

public class RoomPanel extends JPanel {
	public JTextField tfInput;
	public JLabel lbRoom;
	public JTextArea taLog;
	
	public RoomPanel() {
		setSize(700, 550);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(492, 262, 196, 247);
		add(scrollPane);
		
		taLog = new JTextArea();
		taLog.setFont(new Font("³ª´®°íµñÄÚµù", Font.PLAIN, 11));
		scrollPane.setViewportView(taLog);
		
		tfInput = new JTextField();
		tfInput.setFont(new Font("³ª´®°íµñÄÚµù", Font.PLAIN, 11));
		tfInput.setBounds(492, 519, 196, 21);
		add(tfInput);
		tfInput.setColumns(10);
		
		lbRoom = new JLabel("");
		lbRoom.setFont(new Font("³ª´®°íµñÄÚµù", Font.BOLD | Font.ITALIC, 15));
		lbRoom.setHorizontalAlignment(SwingConstants.LEFT);
		lbRoom.setBounds(12, 10, 454, 28);
		add(lbRoom);
		
		JButton btLeave = new JButton("L E A V E");
		btLeave.setFont(new Font("³ª´®°íµñÄÚµù", Font.PLAIN, 13));
		btLeave.setBounds(492, 10, 196, 28);
		add(btLeave);
	}
}

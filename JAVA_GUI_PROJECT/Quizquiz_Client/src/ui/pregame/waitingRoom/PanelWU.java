package ui.pregame.waitingRoom;

import java.awt.*;
import javax.swing.*;

public class PanelWU extends JPanel{

	
	public DefaultListModel model;
	public JList list;
	
	
	public PanelWU() {
		initFrame();
		
	}
	
	
	
	public void initFrame() {
		setSize(100, 180);
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		model = new DefaultListModel<>();
		
		list = new JList(model);
		scrollPane.setViewportView(list);
		
//		model.addElement(element);
		
		
	}
}

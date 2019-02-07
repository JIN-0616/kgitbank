package UI;

import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JPanel;

public class DeltaPanel extends JPanel {
	public DeltaPanel() {
		
		LayoutManager mgr = new GridLayout(4,4);
		setLayout(mgr);
		Set<Integer> nums = new LinkedHashSet<>();
		while(nums.size()<16) {
			int p = 1+(int)(Math.random()*32);
			if(nums.add(p)) {
				JButton bt = new JButton(String.valueOf(p));
				add(bt);
			}
		}
	}

}

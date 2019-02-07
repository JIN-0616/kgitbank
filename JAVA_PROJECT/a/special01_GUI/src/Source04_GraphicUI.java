import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ui.GolfFrame;
import ui.HotelFrame;
import ui.IndiaFrame;

public class Source04_GraphicUI {
	public static void main(String[] args) {
		JFrame f = new IndiaFrame();
		f.setVisible(true);
	}
}
/*
	프로젝트가 완성되면  jar를 만들어야될텐데,
	이클립스는 좀더 쉽게 runnable jar 생성이 가능하다.
	
	프로젝트 우클릭 export   >>  runnable jar  >> jar실행시 작동할 main 을 가진 class를 지정.
	위치 잡고 finish

*/
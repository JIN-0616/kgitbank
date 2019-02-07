import javax.swing.JFrame;

import UI.GolfFrame;
import UI.HotelFrame;
import UI.IndiaFrame;
import UI.RSP_Frame;

public class Source04_GraphicUI {
	public static void main(String[] args) {
//		JFrame f = new GolfFrame();
//		f.setVisible(true);
		
//		JFrame f = new HotelFrame();
//		f.setVisible(true);
		
//		JFrame f = new IndiaFrame();
//		f.setVisible(true);
		
		JFrame f = new RSP_Frame();
		f.setVisible(true);
	}
}

/*
	eclipse 에서 프로젝트가 완성되면 jar를 만들어야될텐데
	이클립스에서는 좀더 쉽게 runable jar 생성이 가능하다.
  
  	프로젝트 우클릭 exper => runable Jar >> jar 실행시 작동할 main을 가진 class를 지정
  	위치잡고 finish
  	
  	--> 사용자가 jre만 설치되어있으면 실행가능
  	
  	cf)
  		exit.on.close옵션 적용 추천
  		
  		아니라면 작업관리자 -> javaw.exe 종료
  	
 */

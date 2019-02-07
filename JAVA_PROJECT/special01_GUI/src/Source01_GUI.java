import java.awt.*;
import javax.swing.*;

/*
 * 컬렉션 까지 해서 살펴보았던 객체들은,
 *  실제 어떤 형태(웹,윈도우,안드로이드)의 프로그램을 구현하던,
 *  내부 데이터 처리를 하기 위해서 꼭 알아야되는 필수적인 객체들이었다.
 *  
 * 이 프로젝트에서는 사용자측을 위해서 외관(UserInterface)를 Graphic 화 시키고자 할때
 *  사용되는 객체들을 살펴보려고 한다.
 *  
 * GUI의 구축에 사용되는 객체들은 종류가 다양하고, 객체마다 기능들도 꽤 많다
 * 
 * cf #
 * 		GUI 구축에 사용되는 객체들은 javax.swing 패키지와, java.awt 패키지 이쪽에 설계되어있다.
 * 
 */
public class Source01_GUI {
	public static void main(String[] args) {
		/*
		 * 사용자측에게 제공할 GUI구축은
		 *     기본 Base가 될 Container 계열의 객체를 생성해서
		 *     배치를 어떤식으로 할껀지 설정후 ,
		 *     Component 계열의 객체를 배치시켜 나가는 형태로 생각하면 된다.		 * 
		 */
		/*
		 * 기본 Base가 되는 Container 계열의 객체는 크게 3가지가 있다.
		 *  ->  JFrame(default?기본Base Container), JWindow, JDiaLog 라는 객체이다.
		 */
		
		JFrame f = new JFrame("title"); // 객체생성을 하면 invisible 투명 상태
		//JDialog f = new JDialog(); //사용자창 설정
		//JWindow f = new JWindow(); //타이틀바 없는 순수 창
		
		f.setSize(500, 400); // width, height
		f.setLocation(300, 100); //왼쪽위 0,0기준
		f.setTitle("Graphic UI");	// title 설정, JWindow는 없음
		
		//LayoutManager layout = new GridLayout(1, 2);
		LayoutManager layout = new FlowLayout(0);
		f.setLayout(layout);
		
		JButton bt = new JButton();
		bt.setText("START");
		
		JButton bt2 = new JButton("STOP");
		
		f.add(bt);
		f.add(bt2); //임의설정없으면 component가 frame을 다 차지함
		
		// JFrame Container 는 별도의 설정을 해주지 않으면,
		// 탑재된 컴포넌트를 무조건 full로 나타낸다. 
		
		// 배치를 잡아야되는데,
		
		f.setVisible(true); // 이 setVisible(true)에 의해서 GUI는 나오게 됨
					
		System.out.println("Terminate");
		
		/*
		 * GUI 구축의 큰 흐름을 살펴보고,
		 *  Layout 은 어떤식으로 설정할수 있고
		 *  사용자 UI 구축에 사용할수 있는 Component 형 객체가 어떤것들이 있는지 알아보자.
		 */
	}
}

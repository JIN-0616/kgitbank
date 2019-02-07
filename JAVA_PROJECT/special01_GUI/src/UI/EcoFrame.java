package UI;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class EcoFrame extends JFrame {
	public EcoFrame() {
		setLayout(null);
		
		setSize(900, 440);
		
		DeltaPanel pn1 = new DeltaPanel();
			pn1.setBounds(20,20,300,300);
	//	add(pn1);
		
		DeltaPanel pn2 = new DeltaPanel();
			pn2.setBounds(420,20,300,300);
	//	add(pn2);
		
		// JFrame에 기본적으로 장착되어있는 panel
		// getContendPane()은 실제 프레임이 사용중인 JPanel을 얻어내는 기술
			
		getContentPane().add(pn1); //여기에 add를 시켜도 같은 기능
		
		setContentPane(pn2); // Jrame에 장착된 기본Panel을 바꾸는 기능
		
		//일반적으로 사용시에 직접 add보다는 이 기능으로 add하는 경우가 많다. 
				
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	}	
}
/*
 
	적용시킬 수 있는 레이아웃이나, 컴포넌트나, 특수패널이 더 존재한다.
	이건 코드를 기술해보면서 확인해볼 필요는 없고, tool을 사용해서 하나씩 확인해보자.

	Eclipse 가 아닌 별도의 프로그램이 필요하지 않고, Eclipse에 플러그인을 설치하면 된다.
	google -> WindowBuilder
	https://www.eclipse.org/windowbuilder/ 가서 [download] - [lastest version]
	
	주소창의 웹 경로를 복사
	http://download.eclipse.org/windowbuilder/latest/ (예)
	
	Eclipse - Help -> install new Software
	주소복사 + enter , 선택후 설치 진행	
	
*/
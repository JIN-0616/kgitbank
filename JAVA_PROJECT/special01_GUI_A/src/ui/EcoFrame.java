package ui;

import javax.swing.JFrame;

public class EcoFrame extends JFrame {
	public EcoFrame() {
		setLayout(null);
		
		setSize(900, 440);
		
		DeltaPanel pn1 = new DeltaPanel();
			pn1.setBounds(20,20,300,300);
		// add(pn1);
		
		DeltaPanel pn2 = new DeltaPanel();
			pn2.setBounds(420,20,300,300);
		// add(pn2);
		// getContentPane은 실제 프레임이 사용중인 JPanel을 얻어내는 기능
		getContentPane().add(pn1);	// 여기에 add를 시켜도 같은 기능
		
		setContentPane(pn2);	// JFrame에 장착된 기본Panel을 바꿀수도 있다.
	}
}
/*
 * 적용시킬수 있는 레이아웃이나, 컴포넌트나, 특수패널 이 더 존재한다.
 * 이건 코드로 기술해보면서 확인해볼 필요는 없고, 툴을 사용해서 하나씩 확인해보자.
 * 
 * Eclipse 가 아닌 별도의 프로그램이 필요하진 않고, Eclipse에 플러그인을 설치하면 된다. 
 * 	windowbuilder 를 구글서치엔진으로 검색
 * 
 *  https://www.eclipse.org/windowbuilder/  가서 [download] → [lastest version] → 웹경로를 복사
 * 
 *  http://download.eclipse.org/windowbuilder/latest/   (예)
 *  
 * Eclipse 에서 Help >> Install New Software 
 * 
 * 
 */ 

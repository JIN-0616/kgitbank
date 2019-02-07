/*
	class 가 아닌 다른 키워드를 이용해서 설계

	특수설계

	1. enum
	 : 객체를 설계하면서 해당타입으로 몇개를 미리 선정해서 만들어두고 사용하는 설계

	2. interface
	 : 전부 abstract로 구성된 설계를 하고자 할때 
	  (생성자나, 변수를 만들어들수 없고, 이걸 토대로 만들어질 기능들만 기술해둔 설계)

	 : abstract 만 가질수 있어서, 생략을 할수는 있다.
	 
*/
import javax.swing.JOptionPane;

interface Engine{
	// boolean flag;	변수선언불가
	// Engine(){		생성자 선언 불가
	// }

	//abstract void start();
	//abstract String execute();
	//abstract boolean check(String in);

	void init();
	abstract boolean isRun();
	abstract String execute();
	abstract String check(String in);

	//abstract로 class를 설계하면 - abstract 생략불가
	//인터페이스는 미리 설정해놓을수가 없음
	//오직 실행할 메소드만
}

class OptionPanePlayer {
	Engine engine;

	boolean insert(Engine e){
		if(engine == null){
			engine = e;
			return true;
		}else{
			return false;
		}
	}

	void remove(){
		if(engine != null)
			engine = null;
	}

	void start(){
		if(engine != null){
			engine.init();
			while(engine.isRun()){
				String o = engine.execute();
				String i = JOptionPane.showInputDialog(null, o);
				String r = engine.check(i);
				JOptionPane.showMessageDialog(null, r);
			}
		}else{
			JOptionPane.showMessageDialog(null,"엔진을 먼저 장착해주세요");
		}
	}
}
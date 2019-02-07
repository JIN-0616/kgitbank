/*
	class 가 아닌 다른 키워드를 이용해서 설계

	1. interface
	 : 전부 abstract로 구성된 설계를 하고자 할때 
	 (생성자나, 변수를 만들어둘수 없고, 이걸 토대로 만들어질 기능들만 기술해둔 설계)

	 : abstract 만 가질수 있어서, 생략을 할수는 있다.
*/
import javax.swing.JOptionPane;

interface Engine {
	void init();
	abstract boolean isRun();
	abstract String execute();
	abstract String check(String in);
}

class OptionPanePlayer {
	Engine engine;
	boolean insert(Engine e) {
		if(engine == null) {
			engine = e;
			return true;
		} else {
			return false;
		}
	}
	void remove() {
		if(engine != null)
			engine = null;
	}

	void start() {
		if(engine != null) {
			engine.init();
			while(engine.isRun()) {
				String o =engine.execute();
				String i = JOptionPane.showInputDialog(null, o);
				String r = engine.check(i);
				JOptionPane.showMessageDialog(null, r);
			}
		}else {
			JOptionPane.showMessageDialog(null, "엔진을 먼저 장착해주세요");
		}
	}
}


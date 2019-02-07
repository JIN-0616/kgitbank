/*
	객체는 어떤 형태로 사용될지 모르기 때문에 너무 특정환경에 맞춰서 설계하는게 좋지 않다.
*/
import javax.swing.JOptionPane;

class Source07_EngineUse {
	public static void main(String[] args)	{
		UpDownEngine e1 = new UpDownEngine();
		e1.start();
		JOptionPane.showMessageDialog(null,"[SYSTEM] UpDownEngine STARTED");
		while(e1.isRun()){
			
			JOptionPane.showMessageDialog(null,e1.tell()+"> ");
			int d = Integer.valueOf(JOptionPane.showInputDialog(null));
			String rst = e1.compare(d);
			//System.out.println("[SYSTEM] Press Enter");
			//System.console().readLine();
			JOptionPane.showMessageDialog(null,"[SYSTEM] "+d + " is "+ rst);
		}		
		JOptionPane.showMessageDialog(null,"[SYSTEM] UpDownEngine STOPED");
	}
}
/*
	ConsoleStation cs = new ConsoleStation();
	cs.insert(e1);
	cs.execute();
	cs.play();

	OptionStation os = new OptionStation();
	os.insert(e1);
	os.play();
*/
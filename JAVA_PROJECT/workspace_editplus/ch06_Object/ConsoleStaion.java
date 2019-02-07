import javax.swing.JOptionPane;

class ConsoleStaion_JO {
	UpDownEngine engine;
	
	boolean insert(UpDownEngine e){
		if (engine == null){
			engine = e;
			return true;
		}else{
			return false;
		}
	}
	void play(){
		engine.start();
				JOptionPane.showMessageDialog(null,"[SYSTEM] UpDownEngine STARTED");
		while(engine.isRun()){
			
			JOptionPane.showMessageDialog(null,engine.tell()+"> ");
			int d = Integer.valueOf(JOptionPane.showInputDialog(null));
			String rst = engine.compare(d);
			//System.out.println("[SYSTEM] Press Enter");
			//System.console().readLine();
			JOptionPane.showMessageDialog(null,"[SYSTEM] "+d + " is "+ rst);
		}		
		JOptionPane.showMessageDialog(null,"[SYSTEM] UpDownEngine STOPED");
	}
	void remove(){
		engine =null;
	}
}

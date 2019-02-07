class ConsoleStaion_C {
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
		System.out.println("[SYSTEM] UpDownEngine STARTED");
		while(engine.isRun()){
			System.out.println();
			System.out.println(engine.tell()+"> ");
			int d = Integer.valueOf(System.console().readLine());
			String rst = engine.compare(d);
			//System.out.println("[SYSTEM] Press Enter");
			//System.console().readLine();
			System.out.println("[SYSTEM] "+d + " is "+ rst);

		}
		System.out.println();
		System.out.println("[SYSTEM] UpDownEngine STOPED");

	}
	void remove(){
		engine =null;
	}

}


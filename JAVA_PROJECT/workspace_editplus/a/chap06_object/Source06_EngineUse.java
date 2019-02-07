class Source06_EngineUse {
	public static void main(String[] args) {
		UpDownEngine e1 = new UpDownEngine();
		e1.start();
		System.out.println("[SYSTEM] UpDownEngine STARTED");
		while(e1.isRun() ) { 
			System.out.println();
			System.out.print("[SYSTEM] "+e1.tell() +"> ");
			int d = Integer.valueOf(System.console().readLine());
			String rst = e1.compare(d);
		//	System.out.println("[SYSTEM] Press Enter");
		//	System.console().readLine();
			System.out.println("[SYSTEM] " + d + " is " + rst);
		}
		System.out.println();
		System.out.println("[SYSTEM] UpDownEngine STOPPED");
	}
}


class Source09_EngineStaion {
		select = System.console().readLine();
		/*	==OptionPane 1인용==
		ConsoleStaion_JO c = new ConsoleStaion();
		UpDownEngine e = new UpDownEngine();
		c.insert(e);
		c.play();
		c.remove();
		*/
		
		/*	==Console 1인용==
		ConsoleStaion_C c = new ConsoleStaion_C();
		UpDownEngine e = new UpDownEngine();
		c.insert(e);
		c.play();
		c.remove();
		*/

		// ==Console vsCOM .ver====
		ConsoleStaion_M c = new ConsoleStaion_M();
		UpDownEngine e = new UpDownEngine();
		UpDownEngine f = new UpDownEngine();
		c.insert(e,f);
		c.play();
		c.remove();
		
	}
}

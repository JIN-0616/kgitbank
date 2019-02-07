class Source02_UseSims {
	public static void main(String[] args) 	{
		Guest g = new Guest(23, true);
		System.out.println(g.inform());
		System.console().readLine();
		boolean b = g.handled();
		System.out.println(b);

		HairDesigner hd = new HairDesigner("Â÷È«", 33, true, false );
		System.out.println( hd.inform() );
		System.out.println( hd.detail() );
	}
}

class Source03_RobotUse {
	public static void main(String[] args) {
		Robot r1 =new Robot();
			r1.name = "���";
			r1.type = 2;
		String s1 = r1.greet();
		System.out.println(s1);

		Robot r2 = new Robot();
			r2.name = "���İ�";
			r2.type= 1;
		System.out.println(r2.greet() );
		System.out.println(r2 == r1);
		r2 = r1;
		System.out.println();
		System.out.println(r2.greet() );
		r2.name= "Ÿ�뽺";
		System.out.println(r1.greet());

		System.out.println(r2 == r1);
	}
}

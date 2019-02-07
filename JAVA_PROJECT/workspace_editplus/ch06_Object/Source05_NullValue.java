class Source05_NullValue {
	public static void main(String[] args)	{
		/*
			null 이라는 데이터가 있는, 이 데이터는 객체형변수만 갖을수 있는 데이터이다.
		*/
		//	int a = null; error
		Sphere s = null;
		Robot r = null;
		System.out.println(s == null);
		System.out.println(r != null);
		/*
			객체형변수가 갖는 값이 null 이라는 것은 제어중인 객체가 없는 상황을 나타낸다.
		*/
		//r.greet(); // error

		Legion g1 = new Legion();
			g1.one = new Robot();
			g1.one.name= "비모";
			
			Robot f = new Robot();
			f.name = "알파고";
			g1.other = f;
		String ss = g1.introduce();
		System.out.println(ss);
		
	}
}

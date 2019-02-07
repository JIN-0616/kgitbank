class Source03_RobotUse {
	public static void main(String[] args)	{
		// 설계한 개체 작동확인 test

		Robot r1 = new Robot(); //같은폴더에서는 별도링크과정없이 사용가능
			r1.name = "비모";
			r1.type = 2;
		String s1 = r1.greet(); // 리턴값으로 인사
		System.out.println(s1);

		Robot r2 = new Robot();
			r2.name = "알파고";
			r2.type = 1;
		System.out.println(r2.greet());
		r2 = r1;
		System.out.println();
		System.out.println(r2.greet());
		r2.name = "타노스";
		System.out.println(r1.greet());

		System.out.println(r2 == r1);
	}
}

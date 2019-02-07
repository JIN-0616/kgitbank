class Source05_UseUtils {
	public static void main(String[] args)	{
		Utils u = new Utils();
		int v = u.max(3,5);
		System.out.println(v);
		int vv = Utils.max(5,6);
		System.out.println(vv);
		// 객체지향 이라기보다는 프로시저방식에서
		Math.random();
		/*
			main 에 왜 static 이 있냐...?
		*/
		Source04_Time s = new Source04_Time();
		s.main(null);
		/*
			java.Source05_UseUtils ==>
			main이 static이 아니라면, 객체생성을 해서 call을 해야만 성립이 된다.
			JVM 메인코드 돌릴때 해당객체를 생성시키는 능력이 없어서
		*/
		Source01_UseBot.main(null);
		//  이러한 형식으로 구동된다.
		//  main함수도 수동으로 직접 호출이 가능하다.
		//  단 무한반복하게 (함수내에서 그함수를 다시호출) 하면 터짐

		//  static 이 아니라면 new로 직접 생성해서 사용하는 수 밖에 없다.
		//  이 상황도 private로 외부에서 직접 new 생성을 막을수 있다.
	}
}

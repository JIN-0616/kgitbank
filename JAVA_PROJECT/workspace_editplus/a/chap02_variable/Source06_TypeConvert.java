class Source06_TypeConvert {
	public static void main(String[] args) {
		/*
			데이터 casting 을 해보았는데, 다 되는건 아니다.
			
			수치,문자 데이터 다른 수치문자데이터로 casting이 됨. 그외는 안됨.
			논리데이터는 다른데이터로 casting이 안됨.
			문자열데이터도 다른데이터로 casting이 안됨
		*/
		System.out.println( (int)'나' );
		System.out.println( (char)45207 );
		// System.out.println( (boolean)1 );
		// System.out.println( (String)456 );
		// System.out.println((int)true);
		// System.out.println((String)true);
		// System.out.println(  (int)"가나다" );
		/*
			casting 이 안되는거지 모든 데이터 ↔ String 으로 바꿀수는 있다.
			문자열이 다른데이터 더하면 그 데이터를 문자열화해서 덧셈진행이 되니까.
			이 처리는 casting이 아니라 작업을 따로 설정해야 된다.

			모든 데이터는 String.valueOf(data) 하면 전부 String화 된다.
		*/
		System.out.println("예상수치는 " + 5031 + " 입니다");	
		System.out.println("예상수치는 " + String.valueOf(5031) + " 입니다");	

		String s = String.valueOf(3.14*3*3);
	//	System.console().readLine("input> ");
	//	System.console().readLine(String.valueOf(3));
		/*
			String 을  데이터화 시키려면
				Integer.valueOf();
				Long.valueOf();
				Float.valueOf();
				Double.valueOf();
				Boolean.valueOf();
		*/
		int v1 = Integer.valueOf("4564651");
		System.out.println(v1 +" / " + v1*v1);

		double v2 = Double.valueOf("3123124.3242");
		

	}
}

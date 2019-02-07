class Source08_DataOperation {
	public static void main(String[] args) {
		/*
			문자열데이터"" 역시 지원하는 작업이 존재한다.

			덧셈과 동등비교 를 할수 있다.
		*/
		System.out.println("자바" + "문자열 덧셈");
		//	System.out.println("자바문자열" - "자열"); //불가

		//  System.out.println("자바" > "파이썬"); //불가
		System.out.println("자바" == "파이선");
		System.out.println("자바" == "자바");
		System.out.println("자바" != "파이썬");

		/*
			특이한 점은, 문자열에 더해지는 대상이 문자열이 아니면
			그것을 문자열화 시켜서 덧셈을 한다.
		*/

		System.out.println("자바" + 30); // 30 ==> "30"
		System.out.println("자바" + 30 + 10); // 자바3010
		System.out.println("자바" + (30 + 10)); // 자바40
		System.out.println(10 + 30 + "자바"); // 40자바
		System.out.println((10+30)+"자바"); // 40자바

		System.out.println("하루는 " + (60*60*24) + "초 이다.");
	}
}

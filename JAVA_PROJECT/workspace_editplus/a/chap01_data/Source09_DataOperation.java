class Source09_DataOperation {
	public static void main(String[] args) {
		/*
			논리데이터에 지원하는 계산(연산)
				true, false 
		*/
		// 논리부정
		System.out.println(!true);
		System.out.println(!!true);
		System.out.println(!false);
		// 논리 계산,  &&, ||
		System.out.println( true && true  );	// 전부 true 라면 true , 그게 아니면 false
		System.out.println( false && true  );	// 전부 true 라면 true , 그게 아니면 false
		System.out.println( false || true  );	// 하나라도 true 라면 true , 그게 아니면 false
		System.out.println( false || false || true  );	// 하나라도 true 라면 true , 그게 아니면 false

		// 참고# true, false 써둔 자리에 true ,false 를 만들어내는 계산을 적어도 된다.
		System.out.println(   (32 << 1 == 64 )   &&  (32 >> 1 == 16)       );

		// 조건연산(3항연산)   (true/false) ? true일때 쓸값:false일때 쓸값
		
		System.out.println( false ? 1: -1);
		// 80825 % (60*60)
		System.out.println( 80825 + "초는 " +  ( 80825 / (60*60) <12 ? "오전" : "오후" ) + "이다" );


		// true,false 는 나중에 branch 문이나, loop 문을 만들때도 쓰이게 된다.
	}
}

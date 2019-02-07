class Source07_TypeConvert {
	public static void main(String[] args) {
		/*
			데이터를 casting 을 해보았는데, 다 되는건 아니다.
			수치, 문자 데이터는 다른 수치,문자데이터로 casting 가능, 그 외는 안됨
			논리데이터는 다른데이터로 casting이 불가
			문자열데이터도 다른데이터로 casting이 불가
		*/

		System.out.println( (int)'나');
		System.out.println( (char)45207);
		// # 오류목록 #
		// System.out.println( (boolean)1);
		// System.out.println( (String)345);
		// System.out.println( (int)true);
		// System.out.println( (String)ture);
		// System.out.println( (int)"가나다");
		/*
			casting이 안되는거지 모든 데이터 -> String으로 바꿀수는 있다.
			문자열이 다른데이터와 더하면 그 데이터를 문자열화해서 덧셈진행이 가능.

			모든 데이터는 String.valueof(data) 하면 전부 String화 된다.
		*/
		System.out.println("예상수치는 "+ 5031 + " 입니다.");
		System.out.println("예상추기는 "+ String.valueOf(5031) + " 입니다.");

		//	String S = String.valueOf(3.14*3*3);
		//	System.console().readLine(String.valueOf(12)); //출력문구처리(무조건String만가능) + 입력받기
		/*
			String 을 데이터화 시키려면
				Integer.valueOf();
				Long.valueOf();
				Doutble.valueOf();
				Boolean.valueOf();

			String 으로 변환
				
				String.valueOf();
		*/
		int v1 = Integer.valueOf("345"); //구성, 수치, 범위가 맞아야만 가능
		System.out.println(v1+ " / " + v1*v1);

		// Double v2 = Double.valueOf("312.4124.2323");  // 에러

	}
}

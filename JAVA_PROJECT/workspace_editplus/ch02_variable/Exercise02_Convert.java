class Exercise02_Convert {
	public static void main(String[] args) {
		/*
			사용자로부터 몇시 몇분인지 입력을 받아서,
			그 시간이 하루기준 몇초나 흘렀나 계산해서
			0.xxxxxx 일 정도이다.
			소수점을 3자리까지만 출력되게 해보자.
			※ 4째자리 이후를 0으로 싹 바꾸면 출력을 안함.

			시 입력
			입력처리 킵
			분 입력
			입력처리 킵

			두입력값을 int화해서 몇초째인지 계산을 진행
			그 값이 하루기준 얼마나 묻는지 계산을 진행
			그 값을 소수점 3째자리까지만 만들어내는 작업을 진행

			그리고 사용자가 입력했던 시 분과 함께 계산결과를 출력
		*/
		


		String hour = System.console().readLine("시 입력: ");
		String min = System.console().readLine("분 입력: ");

		int totalTime = Integer.valueOf(hour)*60*60 + Integer.valueOf(min)*60;
		double result = totalTime/(24*60*60.0);
		//System.out.println(result);
		//System.out.println( ((int)(result*1000))/1000.0 );
		double perTime = ((int)(result*1000)) / 1000.0;
		System.out.println(hour+"시 "+min+"분 : "+ perTime+"일");
		
		System.out.println(hour+":" +(Integer.valueOf(min)<10 ? "0":"")+min+ " = " + perTime+"일");
		//분을 00으로 처리할때 한자리수에서 앞에 0을 붙여주는 작업 추가
	}
}

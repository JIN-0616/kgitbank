class Excersie02_Convert {
	public static void main(String[] args) {
		/*
			사용자로부터 몇시 몇분인지 입력을 받아서,
			그래서 그시간이 하루기준 몇초나 흘렀나 계산해서
			0.xxx 일 정도이다.
			소수점을 3자리째까지만 출력되게 해보자. 
			※ 4째자리 이후를 0으로 싹 바꾸면 출력을 안함.
		*/
		System.out.print("시 입력:");
		String hour = System.console().readLine();
		String minute = System.console().readLine("분 입력:");

		int total = Integer.valueOf(hour)*60*60 + Integer.valueOf(minute)*60;
		double rate = (double)total/(60*60*24);
		double simpleRate = (int)(rate*1000)/1000.0;
		System.out.println( hour+":"+ (Integer.valueOf(minute)<10 ? "0":"") +minute +" 는 하루기준 " + simpleRate +" 일 입니다"); 

	}
}

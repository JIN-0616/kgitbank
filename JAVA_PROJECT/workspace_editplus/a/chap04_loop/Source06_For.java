class Source06_For {
	public static void main(String[] args) {
		/*
			for 는 특정 회수만큼 loop 처리를 하는상황 구현에 용이..
		*/
		for(int cnt=1; cnt<=10; cnt++) {
			int r = (int)(Math.random()*5);
			System.out.println("[for loop] " +r);
		}
		// 이 특징을 이용해서.. 제곱값을 계산해보는데 for loop로 처리해보자.
		// 2의 5제곱 ? 32  , 3의 4제곱 ? 81
		int number = 1;
		number *= 3;
		number *= 3;
		number *= 3;
		number *= 3;
		System.out.println("number = "+ number);
		
		System.out.print("숫자 =");
		int n = Integer.valueOf(System.console().readLine());
		System.out.print("몇 제곱 =");
		int step = Integer.valueOf(System.console().readLine());
		/*
			for loop 전에 int 변수 하나 잡아서 1을 설정해두고,
			step 회수만큼 위 1 설정해둔 변수에 n을 곱하는 작업이 일어나게 loop를 구현
		*/
		int result=1;
		// for(  ) 안에다 변수선언을 했다면, for loop가 끝나고 나면 사라지게 된다.
		// for(int c=1, result=1; ........) {
		for(int cnt =1; cnt<=step; cnt++) {	
			result *=n;
		}
		System.out.println(result);
		
	}
}

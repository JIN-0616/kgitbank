class Source05_For {
	public static void main(String[] args) {
		/*
			loop 를 구현하기 위해선 while 이나 for 구문을 구현가능하다.
			이때까지는 while loop 를 이용하는 방법을 살펴보았고,
			for loop 를 사용하는 방법과 상황에 대해서 알아보자.

			for loop 는 while + (loop 시작시 처리할일 + 매 loop 가 해야될일) 을
			한꺼번에 설정할수 있게 해둔 구문이다.
		*/
		int sum = 0;
		int data = (int)(Math.random()*10000);
		int data2 = data;
		System.out.println("data == "+ data);
		while(data>0) {
			sum += data%10;
			data /=10;
		}
		System.out.println("while loop 로.." + sum);
		//===================================================
		int sum2 =0;
		// for (loop시작시할일; 조건; 매 loop 처리마다 할일) 
		// 각 요소를 이용하는건 자유
		for( System.out.println("계산시작.."+data2) ; data2>0 ; System.out.println("한자리처리완료 남은값:"+data2)  ) {
			sum2 += data2 % 10;
			data2 /= 10;
		}
		System.out.println("for loop 로.." + sum2);
		/*
			대부분의 경우, for loop 위 형태보다는 다른형태가 많이 쓰이게 된다.
		*/

	}
}

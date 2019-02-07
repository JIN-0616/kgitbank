class Exercise02_While {
	public static void main(String[] args) {
		/*
			하샤드 수..? 
		*/
		System.out.print("input numeric> " );
		int data = Integer.valueOf(System.console().readLine());
		// while loop를 이용해서 각자리의 합을 얻어내야함.
		int sum = 0; 
		int copy = data;
		while(data>0) {
			sum += data%10;
			data /= 10;
			System.out.println("[loop] sum = "+ sum+"/data = "+data);
		}
		System.out.println("각자리수의 최종 합 : "+sum);
		// 이합이 data를 나눌수 있으면 하샤드 수
		//			그렇지않으면 하샤드 수 아님 이라고 if - else branch
		data = copy;
		if(data%sum ==0 ) {
			System.out.println("하샤드수");
		}else {
			System.out.println("하샤드수 아님");
		}

	}
}

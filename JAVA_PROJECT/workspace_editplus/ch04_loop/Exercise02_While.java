class Exercise02_While {
	public static void main(String[] args)	{
		/*
			하샤드 수..?

			132 ==ok
			1+3+2 ==> 6
			132%6=0
			
			ex 90 27 
		*/
		System.out.print("[main] input number = ");
		int data = Integer.valueOf(System.console().readLine());
		// while 설정을 해서 각 자리의 합을 계산

		// 이 합이 data를 나눌수 있으면 Harshad number
		//				  아니면 not Harshad number  - if else branch process

		// 기존의 data 보존이 필요함

		int r0 = data;
		int sum = 0;
		while(r0 !=0){
			sum += r0%10;
			r0 /=10;
			System.out.println("[Loop] input number = "+r0+", sum = "+sum);
		}
		//if r0 = 0; break;
		System.out.println("[main] 각 자리수의 합 = "+sum);

		if (data%sum==0){
			System.out.println("[main] input number = "+data+" is Harshad number.");
		}else {
			System.out.println("[main] input number = "+data+" is not Harshad number.");
		}
	}
}

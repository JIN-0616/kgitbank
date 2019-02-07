class Source12_LoopControll {
	public static void main(String[] args)	{
		/*
			내부루프 loop에서 continue를 시키는데 전체 loop에 영향을 주고 싶다거나
			내부루프 loop에서 break를 시키는데 전체 loop를 멈추게 한다거나
			switch 안에서 loop를 멈추는 break를 해야한다면...?

			labeled loop (named loop)
		*/

		a : 
		while(Math.random()>0.1){
			System.out.println("main - loop 진입");

			b :
			for(int cnt=1;cnt<=5;cnt++){
				if(Math.random()>0.75){
					System.out.println("외부루프 continue");
					continue a;
				}else if(Math.random()>0.75){
					System.out.println("내부루프 continue");
					continue b; // break; 라고 적어도 됨
					
				}
				System.out.println("내부루프 "+cnt);

			}
			System.out.println("main - loop 회전끝");
		}
		System.out.println("...");

	}
}

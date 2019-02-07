class Source11_LoopControll {
	public static void main(String[] args) 	{
		/*
			내부부분 loop에서 continue를 시키는데 전체 loop에 영향을 주고 싶다거나
			내부부분 loop에서 break를 시키는데 전체 loop를 멈추게 한다거나
			switch 안에서 loop 를 멈추는 break를 해야된다면..?

			labeled loop (named loop)
		*/

		a : 
		while(Math.random()>0.1) {
			System.out.println("main - loop 회전시작");
			b : 
			for(int cnt=1; cnt<=5; cnt++) {
				if(Math.random() >0.75) {
					continue a;
				}
				if(Math.random() >0.75) {
					continue b;	// break; 라고 적어도 된다.
				}
				System.out.println("내부loop " + cnt);
			}

			System.out.println("main - loop 회전끝");
		}

		System.out.println("...");
	}
}

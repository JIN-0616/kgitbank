class Source09_LoopControll {
	public static void main(String[] args) {
		/*
			while 로 구현했던 for 로 구현했던,
			해당 초기 설정을 어떻게 해두엇냐에 따라서 그안에 구현해둔 처리가 작동하게 되는데,

			이걸 break(즉시종료), 
				 continue(현태턴 넘기기)
			를 이용해서 loop 자체를 제어할수 있다.
		*/
		int sum= 0;
		for(int cnt=1; cnt<=5; cnt++) {
			int r =(int)(Math.random()*10);
			if(r%2==0) {
				System.out.println(r + " loop skip..");
				continue;	// 루프 중간에서 주로 설정하고,
				// 처리안해도 상황을 건너띄고자 할때 사용할수 있다.
			}
			System.out.println("r == " + r);
			sum += r;
			System.out.println("current sum == " + sum);
		}
		
	}
}

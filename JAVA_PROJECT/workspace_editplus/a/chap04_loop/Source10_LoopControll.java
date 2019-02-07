class Source10_LoopControll {
	public static void main(String[] args) {
		
		for(int cnt=1; cnt<=10; cnt++) {
			int r = (int)(Math.random()*100);
			if(r/10 == r%10){
				System.out.println("초기설정 상관없이 종료!! " + r);
				break;
			}
			System.out.println("r ==" +r);
		}
		
		/*
			이중 loop 일때는 break와 cotinue가 어떻게 작동하게 되는가..?
			소속되어있는 loop 에 영향을 끼치게 된다.
		*/
		for(int out=1; out<=5; out++) {
			System.out.println("out "+ out);
					
			for(int in=1; in<=5; in++) {
				int r = (int)(Math.random()*3);
				if(r==0)
					continue;
				else if(r==1)
					break;
				System.out.println("in .." + out+"-"+in); 
			}
			System.out.println("out turn end");
		}
		
	}
}

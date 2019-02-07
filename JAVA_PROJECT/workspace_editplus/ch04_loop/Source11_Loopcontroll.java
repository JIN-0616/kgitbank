class Source11_Loopcontroll {
	public static void main(String[] args)	{
		
		for(int cnt=1; cnt<=10; cnt++){
			int r = (int)(Math.random()*100);

			if(r/10 == r%10){
				
				System.out.println("초기설정 상관없이 종료 "+r);
				break; // 반복문 설정 상관없이 loop를 종료
			}
			System.out.println("r == "+ r);
		}
		/*
			이중 loop일때는 break와 continue가 어떻게 작동하게 되는가..?
		*/

		for(int out=1; out<=5; out++){
			System.out.println("out = "+out+"start");
			
			for(int in=1; in<=5;in++){
				int r = (int)(Math.random()*3);
				if(r==0)
					continue; // 소속된 loop에만 영향을 끼치게 됨
				else if(r==1)
					break; // 소속된 loop에만 영향을 끼치게 됨
				System.out.println("in.."+out+"-"+in+"end");
			}
			System.out.println("out turn end");
		}

	}
}

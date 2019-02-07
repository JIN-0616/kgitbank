class Exercise01_While {
	public static void main(String[] args) 	{
		
		/*
			3자리마다 , 컴마처리한 String 을 만들어내보자.
			3번 작업이 돌고나면 str = "," +str;
		*/
		int viewer = 200;
		String str ="";
		int cnt = 0;
		while(viewer  > 0 ) {
			cnt++;
			str = (viewer%10) +str;
			viewer /=10;
			System.out.println("[loop] str = " +str+"/ viewer :"+ viewer +"/ cnt : " +cnt);
			if(cnt%3==0 && viewer  > 0 )
				str = "," +str;
		}
		
		System.out.println("str = " + str);
		System.out.println("viewer = " + viewer);
		
	}
}

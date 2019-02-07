class Source03_While {
	public static void main(String[] args) {
		/*
			do - while 이라는 구문으로도 loop 구현이 가능한데,
			while 과 다른점은,
			진행이후에 더 loop를 할껀지 말껀지 결정된다.
		*/
		int viewer = 0;
		String str ="";
		int cnt = 0;
		do {
			cnt++;
			str = (viewer%10) +str;
			viewer /=10;
			System.out.println("[loop] str = " +str+"/ viewer :"+ viewer +"/ cnt : " +cnt);
			if(cnt%3==0 && viewer  > 0 )
				str = "," +str;
		} while(viewer >0 );
		System.out.println("STR = "+ str);
		//==============================================================

		char c1, c2, c3;
		// char 형 변수 3개에 알파벳을 랜덤 설정해두고 싶다 (대문자로)
		// 전부다 다른 알파벳으로 설정을 하려고 함.
		// 일단 c1,c2,c3  : 'A' ~ 'Z' 중에 랜덤문자를 설정해야됨.
		// c1 == c2 || c1 == c3 || c2 == c3  이상황이라면 다시 한번 더 loop가 돌아가게 해야된다.
		/*
		c1 = (char)(65 + (int)(Math.random()*26 ) );
		c2 = (char)(65 + (int)(Math.random()*26 ) );
		c3 = (char)(65 + (int)(Math.random()*26 ) );
		if(c1==c2 || c1==c3 || c2 == c3) {
			while(c1==c2 || c1==c3 || c2==c3) {
				c1 = (char)(65 + (int)(Math.random()*26 ) );
				c2 = (char)(65 + (int)(Math.random()*26 ) );
				c3 = (char)(65 + (int)(Math.random()*26 ) );
			}
		}
		*/
		do {
			c1 = (char)(65 + (int)(Math.random()*26 ) );
			c2 = (char)(65 + (int)(Math.random()*26 ) );
			c3 = (char)(65 + (int)(Math.random()*26 ) );
			System.out.println("do - loop executed...");
		}while(c1==c2 || c1==c3 || c2==c3);
		System.out.println(c1+".."+c2+".."+c3);
	}
}

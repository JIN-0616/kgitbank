class Source03_While {
	public static void main(String[] args)	{
		/*
			do ~ While 이라는 구문으로도 loop 구현이 가능한데,
			while과 다른점은,
			진행이후에 반복 실행여부를 결정된다.

			do {반복문-일단실행}while(조건);
		*/
		int viewer = 0; //기존 while문이었을때는 0일때 아예 실행 X 였으나 
		String str = "";
		int cnt = 0;

		do{				//do~while은  최소 1번은 실행이 된다.
			cnt++;
			str = (viewer%10) +str;
			viewer /= 10;
			
			System.out.println("[Loop] str =	"+str+"	/ viewer =	"+viewer+"	/ cnt = " +cnt);

			if (cnt%3==0 && viewer!=0) //viewer>0
				str = "," + str;
		}while(viewer >0 );

		System.out.println("str = " +str);
		System.out.println("");
		//===============================================================
		/*
			특정조건에서 do ~ while문을 쓰면 코드가 간결해지는 특성이 있다.
			-일단 배정을 실행하고 조건을 돌려할 경우
		*/

		char c1, c2, c3;
		// char 형 변수 3개에 알파벳(대문자)를 설정해두고 싶다.
		// 전부다 다른 알파벳으로 설정을 하려고 함.
		// 일단 c1, c2 ,c3 : 'A'~ 'Z' 중에 랜덤문자를 설정해야됨.
		// c1==c2 || c1 ==c3 || c2 == c3 이 상황이라면 다시한번더 loop를 실행해야 한다.
		
		do{	
			
			c1 = (char)('A'+(int)(Math.random()*('Z'-'A'+1)) );
			c2 = (char)('A'+(int)(Math.random()*('Z'-'A'+1)) );
			c3 = (char)('A'+(int)(Math.random()*('Z'-'A'+1)) );
			
			//c/[1-3] = (char)('A'+(int)(Math.random()*('Z'-'A'+1)) ); ??
			System.out.println("do - loop excuted");

		}while(c1==c2||c1==c3||c2==c3); // do{}while() ; 주의

		System.out.println(c1 + ","+ c2 + ","+ c3);
		System.out.println("");

	}
}

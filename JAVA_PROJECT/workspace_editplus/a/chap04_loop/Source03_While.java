class Source03_While {
	public static void main(String[] args) {
		/*
			do - while �̶�� �������ε� loop ������ �����ѵ�,
			while �� �ٸ�����,
			�������Ŀ� �� loop�� �Ҳ��� ������ �����ȴ�.
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
		// char �� ���� 3���� ���ĺ��� ���� �����صΰ� �ʹ� (�빮�ڷ�)
		// ���δ� �ٸ� ���ĺ����� ������ �Ϸ��� ��.
		// �ϴ� c1,c2,c3  : 'A' ~ 'Z' �߿� �������ڸ� �����ؾߵ�.
		// c1 == c2 || c1 == c3 || c2 == c3  �̻�Ȳ�̶�� �ٽ� �ѹ� �� loop�� ���ư��� �ؾߵȴ�.
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

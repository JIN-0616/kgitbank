class Exercise01_While {
	public static void main(String[] args) 	{
		
		/*
			3�ڸ����� , �ĸ�ó���� String �� ��������.
			3�� �۾��� ������ str = "," +str;
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

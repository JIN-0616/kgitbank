class Exercise01_While {
	public static void main(String[] args) {
		/*
			3자리마다, 컴마처리한 String을 만들어내보자.

				str = viewer%10+str; // 기존의 값 끝값을 문자열 앞쪽으로 붙임
				viewer /= 10;
				System.out.println("str = "+str+" / viewer = "+viewer);

			3번이 작업이 돌고나면 str = "," +str;			

			문자열처리의 경우 넣는건 가능하나 빼는경우 어려우므로 주의할것

			★★ do ~while이 아닌 while로 처리시 0을 입력값으로 넣으면 ERROR가 난다 ★★
		*/
		int viewer = 461230;
		String str = "";
		int cnt = 0;
		while(viewer != 0){
			cnt++;
			str = (viewer%10) +str;
			viewer /= 10;
			
			System.out.println("[Loop] str =	"+str+"	/ viewer =	"+viewer+"	/ cnt = " +cnt);

			if (cnt%3==0 && viewer!=0) //viewer>0
				str = "," + str;
		}

		System.out.println("str = " +str);


	}
}

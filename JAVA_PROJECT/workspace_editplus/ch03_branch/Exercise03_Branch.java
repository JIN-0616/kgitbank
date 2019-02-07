class Exercise03_Branch {
	public static void main(String[] args) 	{
		/*
			switch - case로 특정년도의 특정달의 일수 계산하기
		*/
		System.out.println("[SYSTEM] 년도 입력 : ");
		int year = Integer.valueOf(System.console().readLine());

		System.out.println("[SYSTEM] 월 입력 : ");
		int month = Integer.valueOf(System.console().readLine());
		/*
			해당년도 해당달이 몇일까지 있는지 계산해서 출력

			if - else 로 month 데이터 유효성 체크 하시고 (1-12 사이일때만 제대로 처리)
			유효데이터일때 작동되는 branch에서
			switch case / 4,6,9,11 의 케이스를 잡아서 말일 출력
			       case / 2 잡아서 말일 출력
				   case / default / 남은 달들 한꺼번에 처리
			※ case 2 처리할때 윤년 처리해야됨 :
				4의배수 년도이며, 100의 배수는 아니어야한다(400의배수는 윤년처리함)
			1900 : 윤년X, 2004 : 윤년O , 2000 : 윤년O, 2100 : 윤년X
			400의 배수거나 혹은 4의 배수이면서, 100의 배수가 아니면 윤년
		*/
		if (month>0 && month<13){
			System.out.println("[SYSTEM] valied data");
			System.out.print("[SYSTEM] "+year+"년 "+month+"월의 말일은 "); 
			switch(month){
				case 4:
				case 6:
				case 9:
				case 11:
					System.out.println("30일이다");
					break;
				case 2:
					if (year%400==0 || (year%4==0 && year%100 !=0))
						System.out.println("29일이다");
					else 
						System.out.println("28일이다");
					break;
				default:
					System.out.println("31일이다");
			}
		}else{
			System.out.println("[SYSTEM] invalid data ");
		}
		System.out.println("[SYSTEM] Exit");

	}
}

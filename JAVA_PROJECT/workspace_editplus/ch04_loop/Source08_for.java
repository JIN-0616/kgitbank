class Source08_for {
	public static void main(String[] args)	{
		/*
			for 는 특정범위의 수치를 이용한 loop처리 구현에도 용의함
		*/
		for(int val = (int)'ㄱ'; val <='ㅎ'; val++){
			System.out.println("val = "+val+ " / "+ (char)val);
		}

		for(int val = (int)'ㅣ'; val >='ㅏ'; val--){
			System.out.println("val = "+val+ " / "+ (char)val);
		}
		System.out.println();

		// 2018년만 처리한다고 전제하고, (입력데이터 -유효데이터로 가정)
		// 몇월 몇일은 1년중 몇일째 되는 날인가..?
		System.out.println("몇월?: ");
		int month= Integer.valueOf(System.console().readLine());
		System.out.println("몇일?: ");
		int day= Integer.valueOf(System.console().readLine());
		int total = 0;
		/*
			month 이전 달까지 누적일수 + day를 더한게 총 일수임.
		*/		
		for (int i=1;i<month;i++){
			switch(i){
			case 4:	case 6:	case 9:	case 11:
				total += 30;
				break;
			case 2:
				total += 28;
				break;
			default:
				total += 31;
			}
			System.out.println(i+"월 까지의 합 "+total+"일");
		}
		total += day;

		
		System.out.println(month+"월 "+ day+"일은 1년중 "+total+"일째 날이다.");
		// 1월1일이 월요일임, 그럼 입력받은 일은 무슨 요일일까 (요일은 7일마다 반복됨)
		// total%7= num
		// switch(total%7){
		int res= total%7;
		String a = ", ";
		switch(res){
			case 1: a+="月요일이다"; break;
			case 2: a+="火요일이다"; break;
			case 3: a+="水요일이다"; break;
			case 4: a+="木요일이다"; break;
			case 5: a+="金요일이다"; break;
			case 6: a+="土요일이다"; break;
			case 0: a+="日요일이다"; 			
		}
		System.out.println(month+"월 "+ day+"일은 1년중 "+total+"일째 날이고 " +a);

	}
}

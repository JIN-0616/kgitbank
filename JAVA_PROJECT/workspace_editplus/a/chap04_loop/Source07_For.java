class Source07_For {
	public static void main(String[] args) {
		/*
			for 는 특정범위의 수치를 이용한 loop 처리 구현에도 용이함.
		*/
		for(int val = (int)'ㄱ'; val <= 'ㅎ'; val++) {
			System.out.println("val = "+val + " / " + (char)val);
		}
		for(int val = (int)'ㅣ'; val >= 'ㅏ'; val -- ) {
			System.out.println("val = "+val + " / " + (char)val);
		}
		System.out.println();
		// 2018년만 처리한다고 전제 하고, 유효한 데이터만 들어왔다고 가정
		// 몇월 몇일은 1년중 몇일째 되는 날인가..?
		System.out.print("몇월? ");
		int month = Integer.valueOf(System.console().readLine());
		System.out.print("몇일? ");
		int day = Integer.valueOf(System.console().readLine());
		int total= 0;
		/*
			month 전달까지 누적일수 + day 를 더한게 총일수임.
		*/
		
		// 1월1일이 월요일임. 그럼 입력받은 일은 무슨요일일까? (요일은 7일마다 반복됨)
		for(int m =1; m<= month-1; m++) {
			int md;
			switch(m) {
			default :
				md = 31;
				break;
			case 4:	case 6:	case 9:	case 11:
				md= 30;			
				break;
			case 2:
				md = 28;
			}
			System.out.println(m+"월의 말일 = " + md);
			total += md;
		}
		System.out.println("전달까지의 누적일수 " + total);
		total += day;
		System.out.println(month+"월 "+ day+"일은 1년중 " +total+"일째 날이다");
		System.out.println(total%7);
	}
}

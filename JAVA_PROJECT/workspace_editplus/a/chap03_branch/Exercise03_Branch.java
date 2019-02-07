class Exercise03_Branch {
	public static void main(String[] args) {
		// swtich-case 로 특정년도의 특정달의 일수 계산하기
		System.out.print("[SYSTEM] 년도 입력 : ");
		int year = Integer.valueOf(System.console().readLine());
		System.out.print("[SYSTEM] 월 입력 : ");
		int month = Integer.valueOf(System.console().readLine());
		// 해당년도 해당달이 몇일까지 있는지 계산해서 출력
		if( month <1 || month >12  ) {
			System.out.println("[SYSTEM] 유효하지 않은 데이터이다.");
		} else {
			System.out.println("[SYSTEM] 유효한 데이터이다.");
			String result = "[SYSTEM] "+year+"년 " + month+"월의 말일은 ";
			switch(month) {
			default :
				result += "31 일이다.";
				break;
			case 4:	case 6:	case 9:	case 11:
				result += "30 일이다.";
				break;
			case 2:
				// if(year%4==0 && year%100 !=0  || year%4==0 && year%400 ==0 )
				if(year %4 != 0) 
					result += "28 일이다.";
				else {
					if(year%100!=0) {	
						result += "29 일이다.";
					} else {
						if(year % 400 == 0) 
							result += "29 일이다.";
						else 
							result += "28 일이다.";
					}
					// if(year%100 !=0 && year %400==0)  / else 로만 나눠도 될듯.
				}
			}
			System.out.println(result);

		}
		



		// if ~ else 로 month 데이터 유효성 체크 하시고 (1~12 사이일때만 제대로 처리)
		// 유효데이터일때 작동되는 branch에서 
		// switch case / 4,6,9,11 이 케이스들을 잡아서 말일 출력
		//		  case / 2 잡아서 말일 출력 
		//        default / 남은 달들 한꺼번에 처리
		// 
		// ※ case 2 처리할때 윤년 처리해야됨 : 
		// 4의배수 년도이며, 100의배수는 아니여야한다.(400의배수는 윤년처리함)
		// 2004 : 윤년 O , 1900 : 윤년X,  2000 : 윤년 O , 2100 : 윤년 X
		// 400의 배수거나 혹은 4의배수이면서, 100의 배수가 아니면 윤년

		 
	}
}

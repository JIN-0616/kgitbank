class Source07_DataOperation {
	public static void main(String[] args) {
		/*
			수치 데이터를 가지고 할수 있는 비교작업들도 이어서 살펴보자.

			크기비교(>, >=, <, <=),  동등비교( ==, !=) 를 지원한다.
			결과는 true, false 로 발생하고 , 이 작업은 실수도 가능하다
		*/
		System.out.println(34 > 10);
		System.out.println( ( 34<<1 ) >= 68);
		System.out.println(( 34>>1) == 17);
		System.out.println((64>>1) != (16<<1) );
		System.out.println( 100.0 > 99.9);

		/*
			문자 데이터(홀따옴표로 표기한) 역시 방금까지 살펴본 작업이 가능한데,
			실제적으로는 정수처럼 처리가 되기 때문에 그렇다.
		*/
		System.out.println('가' + 0);
		System.out.println('가' + '나');
		System.out.println('가' * '나');
		System.out.println('가' < '나');
		System.out.println('가' >> 1);
		
		// 완성형문자등록이 '가' 부터해서 '힣' 까지가 차례대로 번호가 설정되있다.
		// 총 몇개 등록이 되있는걸까?  11172 개
		System.out.println('힣'-'가'+1);
		System.out.println('z'-'a'+1);
		System.out.println('Z'-'A'+1);
		System.out.println('z'-'A'+1);
		System.out.println('A'*1);
		System.out.println('a'+0);
	
	}

}

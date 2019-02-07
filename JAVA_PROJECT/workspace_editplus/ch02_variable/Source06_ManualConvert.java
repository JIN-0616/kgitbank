class Source06_ManualConvert {
	public static void main(String[] args) {
		/*
			실제 데이터는 사용될때 변환해서 사용할수 있다.
			자동으로 일어나는 경우야 신경을 안써도 되지만, 수동으로 변환을 해야될때가 있다.

			i2d, i2f, l2d, l2f : 소수점이하 실수부 .0붙인 실수 데이터로 변환
			d2i, d2l, f2i, f2l : 소수점을 버린 정수 데이터로 변환

			1. 실수데이터로 처리해야만 제대로된 결과가 나올때
			2. 실수데이터의 소수점이하부가 필요없을때
		*/
		
		int tried = 79;			// 총 시도회수
		int success = 34;		// 성공회수

		// 성공률..?					 (1.0*)도 가능함   
		System.out.println("정확도= "+ ((double)success/tried*100)+"%");

		double r = 19.37124;
		System.out.println( (int)r );   // 19 실수 --> 정수 : 소수점을 버리고 정수처리함

		System.out.println( (int)(r*100)/100.0); // 19.37

		//--------------------------------------------------------------------------------
		//팔고자 하는 물건가격
		int price = 227000;
		//출력을 진행하는데, 원가격과 30% 할인된 금액을 출력 (정수 출력)
		
		System.out.println("원가격: "+ price);
		System.out.println("할인가격: "+ (int)(price * 0.7)); //158900.0 -> 158900
		/*
			이렇게 다른 형태로 변환하는걸 type casting 이라고 부른다.
		*/
		
	}
}

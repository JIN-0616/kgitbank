class Source06_UseStock {
	public static void main(String[] args) {
		Stock s = new Stock("현대해상");	
		// 문자열만 설정해서 만들면, product 설정되고, 
		// 가격 500 이 설정되면서 만들어지게 생성자 구현, ammount가 100으로 설정되게
		System.out.println(s.current());

		Stock s1 = new Stock("동성제약", 4500);	
		System.out.println(s1.current());	// product랑 value이 설정되고, ammount 100으로 설정되게
		
		s1.change();	// 가치가 현재 기준 최대 30퍼센트 이내값으로 변동이 되게. 
						// 변동폭은 100단위 고정
		
		System.out.println(s1.current());	
		

	}
}

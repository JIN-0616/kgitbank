class Source07_UseMarket {
	public static void main(String[] args) 	{
		Market m = new Market();

		System.out.println(m.s1.current());
		System.out.println(m.s2.current());
		System.out.println(m.s3.current());
		
		String rst = m.dayOff();	// 
		System.out.println(rst);

		System.out.println(m.s1.current());
		System.out.println(m.s2.current());
		System.out.println(m.s3.current());

		m.buyStock(1, 30);	// 첫번째 숫자가 1이면 s1 , ammount를 증가
		m.buyStock(2, 10);
		m.buyStock(3, 2); 
		System.out.println(m.s1.current());
		System.out.println(m.s2.current());
		System.out.println(m.s3.current());
		m.sellStock(1, 10);	// 1이면 s1 ammount 를 감소
		m.sellStock(2, 10);	// 2이면 s2 ammount 를 감소
		m.sellStock(3, 10);	// 3이면 s3 ammount 를 감소
		System.out.println(m.s1.current());
		System.out.println(m.s2.current());
		System.out.println(m.s3.current());
		int v = m.totalValue();		// 보유중인 주식총 값어치를 계산
		// 
		System.out.println(v);

	}
}

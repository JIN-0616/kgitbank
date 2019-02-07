class Exercise02_Branch {
	public static void main(String[] args) {
		
		// 특정가격을 가진 주식의 상한/하한 계산
		System.out.println("[StockHelper] START");

		System.out.print("[StockHelper] price? ");
		int p = Integer.valueOf(System.console().readLine());
		System.out.println("[StockHelper] input data is " + p);

		// 크게  branch만 나눠두자.. 처리할 branch 와 그렇지 않을 branch
		// 1000이상 ~ 5000미만은 5원단위
		// 5000이상 ~ 10000미만은 10원단위
		// 10000이상 ~ 50000미만은 50원단위
		// 50000이상 ~ 100000미만은 100원단위
		// &&, || 두개가 같이 사용되면  && 계산이 더 빠르다.
		if( (p>=50000 && p<100000 && p%100 ==0) || 
			(p>=10000 && p<50000 && p%50 ==0) ||
			(p>=5000 && p<10000 && p%10 ==0) ||
			(p>=1000 && p<5000 && p%5==0)  ) {
			System.out.println("[StockHelper] data handle..start wait plz");
		} else {
			System.out.println("[StockHelper] invalid data");
		}
		// 30퍼센트 상승이 상승 최대치, 30퍼센트 하락이 하락최대치
		
		
	}
}

class Exercise02_Branch {
	public static void main(String[] args) 	{
		
		//특정가격을 가진 주식의 상한/하한 계산
		System.out.println("[StockHelper] START");

		System.out.print("[StockHelper] Price> ");
		int p = Integer.valueOf(System.console().readLine());
		System.out.println("[StockHelper] input data is " + p);

		// 크게 branch만 나눠두자. 정상적으로 처리할 branch와 그렇지 않을 branch
		// 1,000이상 ~ 5,000미만은 5원단위
		// 5,000이상 ~ 10,000미만은 10원단위
		// 10,000이상 ~ 50,000미만은 50원 단위
		// 50,000이상 ~ 100,000미만은 100원 단위
		/*
		if (p>=1000 && p<5000 && p%5==0){
			System.out.println("[StockHelper] 1000원이상 5000원 미만 5원단위");
		}else if(p>=5000 && p<10000 && p%10==0){
			System.out.println("[StockHelper] 5000원이상 10000원 미만 10원단위");
		}else if(p>=10000 && p<50000 && p%50==0){
			System.out.println("[StockHelper] 10000원이상 50000원 미만 50원단위");
		}else if(p>=50000 && p<100000 && p%100==0){
			System.out.println("[StockHelper] 50000원이상 100000원 미만 100원단위");
		}else{
			System.out.println("[StockHelper] ERROR");
		}
		*/
		// &&, || 두개가 같이 사용되면 && 계산이 더 빠르다
		if ((p>=1000 && p<5000 && p%5==0) ||
			(p>=5000 && p<10000 && p%10==0) || 
			(p>=10000 && p<50000 && p%50==0) ||
			(p>=50000 && p<100000 && p%100==0) ){

			System.out.println("[[StockHelper] data handle. start wait plz");

			if(p>=1000 && p<5000 && p%5==0){
				
			}else if(p>=5000 && p<10000 && p%10==0){

			}else if(p>=10000 && p<50000 && p%50==0){

			}else if(p>=50000 && p<100000 && p%100==0){

			}

		}else{
			System.out.println("[[StockHelper] invakud data");
		}
		// 30퍼센트 상승이 상승 최대치, 30퍼센트 하락이 하락최대치
	}
}

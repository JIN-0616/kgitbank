class StockGamble_YHH {
	public static void main(String[] args) {
		/*
			특정가격(7000원)으로 설정된 주식을 사용자로부터 
			입력받은 금액으로 살수 있는 만큼 계산해서
			몇개 샀다 잔액 얼마다 한번 출력.

			랜덤실수 수치 0.0 ~ 30.0 를 뽑아서, 이 수치를 이용하여
			몇퍼센트 상승했습니다. 가격이 얼마가 됬다라고 출력. (10원단위는 버리자)

			이윤이 얼마가 났습니다.
		*/
		int price = 5+(int)(Math.random()*10);
		price *= 1000;
		System.out.print("한주당 가격: " + price +" / 투자금액 : " );
		int money = Integer.valueOf(System.console().readLine());

		int bought  = money / price;
		System.out.println(bought + "주 매입 성공 / 잔액: ￦" + (money - (bought*price))  );
		System.out.println("...");
		System.out.println("변동 발생!");
		System.out.println("...");

		double rate = (int)(Math.random()*300) / 10.0;

		int cprice = (int)(price + (price*rate/100));
		cprice -= cprice%50;	//  ※ 50원 단위 처리하려고 처음 목적에서 수정

		System.out.println( price +"▷▷"+  cprice+""  );
		System.out.println( rate +"% 상승 (" +  (cprice - price) + ")"  );

		System.out.println("이윤 : " + (cprice*bought - price*bought) );

	}
}

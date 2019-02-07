class StockGamble_KJJ {
	public static void main(String[] args) {
		/*
			특정가격(7000원)으로 설정된 주식을 사용자로부터 
			입력받은 금액으로 살수 있는 만큼 계산해서 
			몇개 샀다. 잔액 얼마다. 한번 출력.
			
			입력 : 총 투자금액

			랜덤실수 수치 0.0 ~ 30.0 를 뽑아서, 이 수치를 이용하여
			몇퍼센트 상승했습니다. 가격이 얼마다 라고 출력.

			#최총출력단위 백원단위로 설정(10원단위이하 버림)

			이윤이 얼마가 났다.

			money -= money%100> 0 ? ....:...;
		*/
		int realmoney = Integer.valueOf(System.console().readLine("초기 투자금액 입력:"));
		int price=7000;
		int buy = realmoney/price;
		System.out.println("한주당 가격: "+price);
		System.out.println("총 "+buy+"주 구매, 잔액 :"+realmoney%price+"원");
		
		double increaseRate = ((int)(Math.random()*301))/1000.0;
		
		increaseRate = ((int)(increaseRate*100))/100.0;
		//System.out.println(increaseRate);

		System.out.print(increaseRate*100 + "% 상승했습니다. 한 주가격은 ");

		double resultMoney = price*(1.0+increaseRate);

		resultMoney -= resultMoney%100 > 0 ? resultMoney-(((int)(resultMoney/100))*100) : 0;
		//System.out.println(resultMoney);
		System.out.println((int)resultMoney +"원입니다.");

		System.out.print("총 자산: "+(int)resultMoney*buy +"원 + 잔액 "+realmoney%price+"원 =");
		System.out.println((int)resultMoney*buy+(realmoney%price));
		System.out.println("최종이윤 : "+( (((int)resultMoney*buy) + (realmoney%price))-realmoney)+"원");
		
		/*
		int price =5+(int)Math.random()*10);
		price *= 1000;
		System.out.print("한주당 가격: " + price + " / 투자금액 : ");
		int money = Integer.valueOf(System.console().readLine());

		int bought = money / price;
		System.out.print(bought+ "주 매입 성공 / 잔액 : " +(money -(bought*price));
		System.out.println();
		System.out.println("변동 발생");
		System.out.println("..");

		double rate = (int)(Math.random()*300)/10.0;

		int cprive =(int)(price+(prive*rate/100));
		cprice = cprice%50; //★ 50원 단위로 처리하려고 처음 목적에서 수정

		System.out.println(price + " >> " +cprice+"");
		System.out.println(rate+"% 상승" + (cprive-price) +")" );
		
		System.out.println("이윤 : "+ (cprive*bought - price*bought));

		
		*/




	}
}

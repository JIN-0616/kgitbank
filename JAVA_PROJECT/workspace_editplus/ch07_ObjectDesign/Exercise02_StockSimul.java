class Exercise02_StockSimul {
	public static void main(String[] args)	{
		/*
			1. Player 객체를 만들때 사용할 이름을 입력
			 이걸 토대로 Player 객체를 생성, 기본자산을 20만원 설정해서
		*/
		Stock.turn++;
		System.out.print("사용자 명 입력 : ");
		String pName = System.console().readLine();
		Player p = new Player(pName, 200000);
		//p.name
		//p.balance
		/*
			2. Market 객체를 생성, 
		*/
		Market m = new Market();
		/*
			3. 반복을 Player 자산 (잔액 + 보유주식의 가치) 이 0이하가 된다거나,
			   7일을 넘어가게되면 작동이 멈추게 설계
		*/
		int val = m.totalValue();
		//System.out.println(p.balance + val);
		while((p.balance + val)>=0 &&  (Stock.turn <8)){
		
			System.out.println(m.s1.current());
			System.out.println(m.s2.current());
			System.out.println(m.s3.current());
			System.out.println(p.current());

			int c, stockNo, cnt ;
			boolean r;
			do{	
				System.out.print("주식 구매(1), 판매(2), 장 마감(턴넘기기)(0) : ");
				c = Integer.valueOf(System.console().readLine());
				switch(c){
				case 1 : // buy
					System.out.print("구매 주식 -번호 입력 (1~3) : ");
					stockNo = Integer.valueOf(System.console().readLine());

					System.out.print("구매 주식 -수량 입력 : ");
					cnt = Integer.valueOf(System.console().readLine());
					
					r = m.buyStock(stockNo, cnt, p);
					System.out.println("==============================================");
					if(r){
						System.out.println("매수가 성공적으로 처리되었습니다.");
					}else{
						System.out.println("매수가 처리가 불가능합니다.");
					}
					System.out.println("==============================================");
					System.out.println(m.s1.current());
					System.out.println(m.s2.current());
					System.out.println(m.s3.current());
					System.out.println(p.current());
					break;
				case 2 : //sell
					System.out.print("판매 주식 -번호 입력 (1~3) : ");
					stockNo = Integer.valueOf(System.console().readLine());
					System.out.print("판매 주식 -수량 입력 : ");
					cnt = Integer.valueOf(System.console().readLine());
					r = m.sellStock(stockNo, cnt, p);
					System.out.println("==============================================");

					if(r){
						System.out.println("매도가 성공적으로 처리되었습니다.");
					}else{
						System.out.println("매도가 처리가 불가능합니다.");
					}
					System.out.println("==============================================");
					System.out.println(m.s1.current());
					System.out.println(m.s2.current());
					System.out.println(m.s3.current());
					System.out.println(p.current());
					break;
				
				}
			}while(c != 0);
			Stock.turn++;
			m.s1.change();
			m.s2.change();
			m.s3.change();
			val = m.totalValue();
		}
		int a = p.balance+val-200000;
		double b = (p.balance+val-200000)/(double)200000;

		System.out.println("==============================================");
		System.out.println("최종날짜 = "+ (Stock.turn-1));
		System.out.println(m.s1.current());
		System.out.println(m.s2.current());
		System.out.println(m.s3.current());
		System.out.println(p.current());
		System.out.println("회수 금액 = " + (p.balance+val));
		System.out.println("투자 금액 = " + 200000);
		System.out.println("==============================================");
		System.out.println("순이익 = " + a);
		System.out.println("수익률 = " + b);

		/*	
			4-1. 반복돌면서 해야할일
				- 현재 마켓에서 관리중인 주식 상태랑, 플레이어 자산을 찍어주고

				- 주식을 1)살껀지 2)팔껀지 3)아무것도 안할껀지 물어봐서 입력만 받아주고,
				 이 입력값에 따라 if 혹은 switch로 brench 처리할수 있게 구역만 나눠주고

				- 마켓 그 다음날로 넘겨주세요
		*/

	}
}

class Exercise02_StockSimul {
	public static void main(String[] args) 	{
		/*
			1. Player 객체를 만들때 사용할 이름을 입력
			이걸토대로 Player 객체를 생성, 기본자산 20만원 설정해서 
			*/
		System.out.print("사용자이름? ");
		String data = System.console().readLine();
		Player p = new Player(data, 200000);
		/*
			2. Market 객체를 생성.
		*/
		Market mk = new Market();
		System.out.println("");
		System.out.println("주식 시장이 7일동안 열리게 됩니다.");
		System.out.println("20만원의 원금을 불려주세요!!");
		
		System.out.println("");
		mk.dayOff();
		while(Stock.turn <= 7 ) {
			
			int c;
			do{
				System.out.println("");
				System.out.println(mk.s1.current());
				System.out.println(mk.s2.current());
				System.out.println(mk.s3.current());
					System.out.print(p.current()+" | 1.매수 2.매도 0.턴종료> ");	
				c = Integer.valueOf(System.console().readLine());
				if(c == 1|| c==2) {
					System.out.print("상품번호(1~3) > ");	
					int sno = Integer.valueOf(System.console().readLine());
					System.out.print("요청개수> ");	
					int cnt = Integer.valueOf(System.console().readLine());

					boolean r=false;
					switch(c) {
					case 1:
						r= mk.buyStock(sno, cnt, p);	
						break;
					case 2:
						r= mk.sellStock(sno, cnt, p);	
						break;
					}
					if(r) 
						System.out.println("주문하신 매수/매도 요청이 처리되었습니다.");
					else 
						System.out.println("주문하신 요청을 처리하지 못했습니다.(자본금부족or매수초과)");
				}
			}while(c != 0);
			mk.dayOff();
			System.out.println("금일의 장이 마감되었습니다.");
			System.out.println("가격변동이 일어납니다.");
		}

		/*
			3. 반복을 Player 자산(잔액+보유주식의가치) 이 0이하가 된다거나, 
			   7일을 넘어가게되면 작동이 멈추게 설계

			4-1 반복돌면서 해야될일
			현재 마켓에서 관리중인 주식 상태랑, 플레이어 자산을 찍어주고
			주식을 1.살껀지 2.팔껀지, 0아무것도 안할껀지 물어바서 입력만 받아주고,
			입력값에 따라 if 혹은 switch로 branch 처리할수 있게 구역만 나눠주고

			

			마켓 그 다음날로 넘겨주세요.
		*/


	}
}

class MukJJiBBar_KJJ {
	public static void main(String[] args) 	{
		/*
			사용자가 컴퓨터간에 대결을 진행하는 묵찌빠 게임의 핵심 branch 작업

			묵찌빠 게임구현시 유지시켜야 되는 데이터는 공격권임(선공권)
		*/
		boolean attack = Math.random()>0.5;
		System.out.println("현재 공격중? " +attack + " / 수비중? " +!attack);
		System.out.print("이번턴의 선택(묵:0, 찌:1, 빠:2) : ");
		int choice = Integer.valueOf(System.console().readLine());
		//==================================================================
		int auto = (int)(Math.random()*3); // 0, 1, 2
		System.out.println("\n===========");
		//System.out.println("AI의 선택 : " + auto);
		System.out.print("나의 선택 : ");
		// String [] mode = new String[] {"묵","찌","빠"};		
		switch(choice) {
		case 0:System.out.println("묵"); break;
		case 1:System.out.println("찌"); break;
		case 2:System.out.println("빠"); break;
		}
		System.out.print("AI의 선택 : ");
		switch(auto) {
		case 0:System.out.println("묵"); break;
		case 1:System.out.println("찌"); break;
		case 2:System.out.println("빠"); break;
		}
		
		/*
		if(choice==0) {
			System.out.println("묵");
			switch(auto){
			case 0: System.out.println("AI의 선택 : 묵"); break;			
			case 1:	System.out.println("AI의 선택 : 찌"); break;	
			case 2: System.out.println("AI의 선택 : 빠"); break;				
			}
		}else if (choice==1){
			System.out.println("찌");
			switch(auto){
			case 0: System.out.println("AI의 선택 : 묵"); break;			
			case 1:	System.out.println("AI의 선택 : 찌"); break;	
			case 2: System.out.println("AI의 선택 : 빠"); break;	
			}
		}else {
			System.out.println("빠");
			switch(auto){
			case 0: System.out.println("AI의 선택 : 묵"); break;			
			case 1:	System.out.println("AI의 선택 : 찌"); break;	
			case 2: System.out.println("AI의 선택 : 빠"); break;	
			}
		}
		*/
		/*
		switch(choice){
			case 0: 
				switch(auto){
				case 0:
					System.out.println("묵");
					System.out.println("AI의 선택 : 묵");
					break;
				case 2:
					System.out.println("묵");
					System.out.println("AI의 선택 : 찌");
					break;
				case 3:
					System.out.println("묵");
					System.out.println("AI의 선택 : 찌");
					break;
				
				}
				break;
			case 1:
				switch(auto){
				case 0:
					System.out.println("찌");
					System.out.println("AI의 선택 : 묵");
					break;
				case 1:
					System.out.println("찌");
					System.out.println("AI의 선택 : 찌");
					break;
				case 2:
					System.out.println("찌");
					System.out.println("AI의 선택 : 빠");
					break;
				}
				break;
			case 2:
				switch(auto){
				case 0:
					System.out.println("빠");
					System.out.println("AI의 선택 : 묵");
					break;
				case 1:
					System.out.println("빠");
					System.out.println("AI의 선택 : 찌");
					break;
				case 2:
					System.out.println("빠");
					System.out.println("AI의 선택 : 빠");
					break;
				}
				break;
			}
			*/
		System.out.println("===========");

		if(choice == auto){
			//게임오버
			System.out.println("승부가 났다!");
			//공격권확인 -> 누구 승리
			// 이 if 안에서 if - else로 나눠서 승자를 다르게 출력하는 작업 구현
			if (attack = true){
				System.out.println("공격자 '나'의 승리!, AI의 패배!");
			}else{
				System.out.println("수비자 '나'의 패배!, AI의 승리!");
			}
		}else{
			System.out.println("승부가 나지 않았다.");
			// 공격권
			// 이 else branch 안에서, branch를 좀더 만들어서,
			// 공격권을 유지하거나, 공격권을 바꿔저야 한다.
			// 공격중에 졌거나, 수비중에 이겼거나 - > 공격권의 변경조건
			if( choice==0 && auto==2|| choice==1 && auto==0|| choice==2 && auto==1 ) {
				if(attack == true) { 
					attack = !attack ;
					System.out.println("공격권이 바뀌었다.");
					System.out.println("현재 공격중? " +attack + " / 수비중? " +!attack);
				}else 
					System.out.println("공격권이 바뀌지 않았다.");	
			}else if( choice==0 && auto==1 || choice==1 && auto==2 || choice==2 && auto==0  ){
				if(attack == false) {
					System.out.println("공격권이 바뀌었다.");
					attack = !attack;
					System.out.println("현재 공격중? " +attack + " / 수비중? " +!attack);
				}else 
					System.out.println("공격권이 바뀌지 않았다.");					
			}else {
				System.out.println("공격권이 바뀌지 않았다.");
				System.out.println("현재 공격중? " +attack + " / 수비중? " +!attack);

		
			}
		}						
	}
}
	/*
		※ boolean 조건 ture false 넣을때 주의 !!

	if (attack){ //true
	
	}else{ // false
	
	}


	*/
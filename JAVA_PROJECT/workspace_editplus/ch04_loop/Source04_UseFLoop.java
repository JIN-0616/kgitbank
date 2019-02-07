class Source04_UseFLoop {
	public static void main(String[] args)	{
		/*
			loop를 이용해서 필요한 데이터를 확보하는 일부분에만 이용해보았는데,
			프로그램의 전체 흐름을 만들어내는데도 사용이 된다.

			예를 들어 묵찌빠 게임을 만들려면, 
			사용자 입력받고, 처리하고, 턴바꿔주는 작업을 크게 loop처리하면 완성된다.

			ex flag 값을 조건으로 잡고, 게임이 종료되는 상황에서 flag값을 변경하면 된다.
		*/
		boolean flag = true;
		boolean attack = Math.random()>0.5;

		System.out.println("대전 묵찌바! - 박살내기 AI");
		System.out.println();

		System.out.println((attack ? "당신":"AI")+"의 공격으로 시작합니다.");

		do {
			System.out.print("이번턴의 선택(묵:0, 찌:1, 빠:2) : ");
			int choice = Integer.valueOf(System.console().readLine());
			if ( choice !=1 || choice !=2 || choice !=3){
				System.out.println("다시");
				continue;
			}
			int auto = (int)(Math.random()*3); // 0, 1, 2
			System.out.println("\n==============");
			System.out.print("나의 선택 : ");
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
			System.out.println("==============\n");

			if(choice == auto){
				System.out.println("승부가 났다!");
				if (attack){
					System.out.println("공격자 '나'의 승리!, AI의 패배!");
				}else{
					System.out.println("수비자 '나'의 패배!, AI의 승리!");
				}
				flag = !flag;
			}else{
				System.out.println("승부가 나지 않았다.");
				if( choice==0 && auto==2|| choice==1 && auto==0|| choice==2 && auto==1 ) {
					if(attack) { 
						attack = !attack ;
						System.out.println("공격권이 바뀌었다. -> AI의 공격");
					}else{
						System.out.println("공격권이 바뀌지 않았다. "+(attack ? "나":"AI")+"의 공격!");	
					}
				}else if( choice==0 && auto==1 || choice==1 && auto==2 || choice==2 && auto==0  ){
					if(attack) {
						System.out.println("공격권이 바뀌지 않았다. "+(attack ? "나":"AI")+"의 공격!");
					}else{
						attack = !attack;
						System.out.println("공격권이 바뀌었다. -> 나의 공격");
					}											
				}else {
					System.out.println("공격권이 바뀌지 않았다. "+(attack ? "나":"AI")+"의 공격!");			
				}
			}	
		}while(flag);
	}
}

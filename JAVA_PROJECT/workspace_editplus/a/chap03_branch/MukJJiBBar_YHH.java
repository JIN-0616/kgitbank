class MukJJiBBar_YHH {
	public static void main(String[] args) {
		/*
			사용자와 컴퓨터간에 대결을 진행하는 묵찌빠 게임의 bra 핵심nch 작업

			묵찌빠 게임구현시 유지시켜야 되는 데이터는 공격권임.
		*/
		boolean attack = Math.random()> 0.5;
		System.out.println("공격중? " + attack + "/ 수비중? " + !attack);
		System.out.print("이번턴의 선택(묵:0, 찌:1, 빠:2) : ");
		int choice = Integer.valueOf(System.console().readLine());
		//============================================================
		int auto = (int)(Math.random()*3);		// 0, 1, 2
		System.out.println();
		System.out.println("AI의 선택 : "+ auto );
		// String[] mode = new String[]{"묵","찌","빠"};
		String status ="사용자:";
		switch(choice){
			case 0:	
				status += "묵 VS ";	
				break;
			case 1:	
				status += "찌 VS ";	
				break;
			case 2:	
				status += "빠 VS ";	
		}

		switch(auto){
			case 0:	
				status += "묵";	
				break;
			case 1:	
				status += "찌";	
				break;
			case 2:	
				status += "빠";	
		}
		status +=":AI";
		System.out.println(status);
		System.out.println();
		// branch 를 만들어서 출력을 해주면 된다.
		if(choice == auto) {
			System.out.println("승부가 났다!" );
			// 이 if branch 안에서 if~ else로 나눠서 승자를 다르게 출력하는 작업 구현
			if(attack) {
				System.out.println("사용자님의 승리입니다.");
			}else {
				System.out.println("AI의 승리입니다.");
			}
		} else {
			System.out.println("승부가 나지 않았다.." );
			if(choice == 0 && auto == 2 || choice==1 && auto ==0 || choice == 2 && auto ==1) {
				if(attack) {
					System.out.println("공격권이 넘어갔습니다.");
				} else {
					System.out.println("다음턴도 수비입니다.");
				}	
				attack= false;		
			} else {
				if(attack) {
					System.out.println("다음턴도 공격입니다.");
				} else {
					System.out.println("공격권을 가져왔습니다.");
				}				
				attack = true;	
			}
			System.out.println("턴종료 ");
		}
		
	}
}

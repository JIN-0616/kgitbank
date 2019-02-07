class Source04_UseLoop {
	public static void main(String[] args) {
		/*
			loop를 이용해서 필요한 데이터를 확보하는 일부분작업에 활용해보았는데,
			loop는 프로그램의 전체 흐름을 만들어내는데도 사용이 된다.
			
			예를 들어 묵찌바 게임을 만드려면
			사용자입력받고, 처리하고, 턴바꿔주는 작업을 크게 loop 처리하면 완성된다.
		*/
		boolean flag = true;
		boolean attack = Math.random()>0.5;

		System.out.println("대전 묵찌빠! - 박살내자 AI");
		System.out.println();
		
		System.out.println((attack ? "당신" : "AI") + "의 공격으로 시작합니다.");
	
		do {
			System.out.print((attack? "공격!!" : "수비..") + "(묵:0, 찌:1, 빠:2) ?");
			int choice = Integer.valueOf(System.console().readLine());
			if(choice !=0 && choice != 1 && choice != 2) {
				System.out.println("똑바로 내세요!!");
				continue;
			}
			System.out.println();
			switch(choice){
			case 0:
				System.out.println("AI는 빠를 냈다!");
				break;
			case 1:
				System.out.println("AI는 묵을 냈다!");
				break;
			case 2:
				System.out.println("AI는 찌를 냈다!");
				break;
			}
			System.out.println();
			if(attack) {
				System.out.println("공격권이 넘어갔다!! ..");
				attack = false;
			} else {
				System.out.println("승부가 났다!! 당신의 패배..");
				flag = false;
			}
		} while(flag);
		
		System.out.println("멍청한 인간같으니라고 ..");
	}
}

class Exercise01_QuizProgram {
	public static void main(String[] args) {
		/*
			1. Stage 객체를 두개 만들어서 준비를 시켜두시고 
			(생성자로 객체에 player 설정해두고)
		*/
		Stage user = new Stage("USER");
		Stage comp = new Stage("COMP");
		/*
			2. 반복설정을 while로 해두는데
			Stage의 round가 10이 될때까지 작동되게 설정
		*/
		System.out.println("[SYSTEM] STAGE START!");
		while(Stage.round <10) {
			System.out.println();
			Stage.execute();
			System.out.println(Stage.current());
			System.out.print("[SYSTEM] INPUT ANSWER! HURRY!! ");
			long t1 = System.currentTimeMillis();
			String in = System.console().readLine();
			long t2 = System.currentTimeMillis();
			user.check(Integer.valueOf(in));
			if(t2 - t1 >3000) {
				System.out.println("[SYSTEM] COMPUTER CALLED " + Stage.answer);
				comp.check(Stage.answer);
			} else {
				if(Math.random()>0.5) {
					System.out.println("[SYSTEM] COMPUTER CALLED " + Stage.answer);
					comp.check(Stage.answer);
				}else {
					System.out.println("[SYSTEM] COMPUTER CALLED " + (Stage.answer -10) );	
					comp.check(Stage.answer -10);
				}
			}
			System.out.println(user.status());
			System.out.println(comp.status());
		}
		/*
			3. 반복문돌면서 처리할일은, Stage 현재 상태 출력해주고
			사용자로부터 입력받아서 check 돌려주고,
			컴퓨터는 사용자가 3초 이내에 풀면 현재 answer에서 10 뺀값으로 체크 돌려서
				일부로 틀리게 해주고
			3초 초과되면 answer 값으로 체크돌려서 무조건 맞히게 처리

			사용자객체와 컴퓨터처리객체에서 check 를 둘다 하고 나면 각자의 status()를 이용해서
			라운드 끝날때마다 현재 상태를 출력
		*/
		/*
			4. 반복작업을 이용해서 10 round 까지 작업을 완료되고 나면, 최종승자를 출력
		*/
	}
}

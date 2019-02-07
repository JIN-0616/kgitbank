class Exercise01_QuizProgram {
	public static void main(String[] args)	{
		/*
			1. Stage 객체를 2개 만들어서 준비를 시켜두시고
			(생성자로 객체에 player 설정해두고)
		*/
		Stage user = new Stage("사용자");
		Stage com = new Stage("컴퓨터");
		/*
			2. 반복 설정을 while로 해두는데 (for가능)
			Stage의 round가 10이 될때까지 작동되게 설정
		*/
		while (Stage.round<10){
			Stage.execute();
			System.out.println(Stage.current());
			
			long t1 = System.currentTimeMillis();
			// String a1 = Integer.valueOf(System.console().readLine());

			String a = System.console().readLine("1:");
			int a1;
			switch(a){
			case "": a1 = 0; break;
			default: a1 = Integer.valueOf(a);
			}


			long t2 = System.currentTimeMillis();
			user.cheak(a1);
			System.out.println((t2-t1)/1000L);
			//System.out.println(((t2-t1)/1000L); 
			//ms -> s로 변환 확인 ????
			int coma = 0;
			if((t2-t1)/1000L>3){
				coma += Stage.answer;
				com.cheak(coma);
				System.out.println("2:"+coma);
			}else{
				if(Math.random()>0.5){
					coma += Stage.answer;
					com.cheak(coma);
					System.out.println("2:"+coma);
				}else{
				coma += (Stage.answer-10);
				com.cheak(coma);
				System.out.println("2:"+coma);
				}
			}

			System.out.println(user.status());
			System.out.println(com.status());		
			System.out.println();
		}

		if (user.score>com.score){
			System.out.println(user.player+" 승리!");
		}else if(user.score<com.score){
			System.out.println(com.player+" 승리!");
		}else{
			System.out.println("무승부!");
		}
		System.out.println();
		/*
			3. 반복문 돌면서 처리할일은, Stage 현재 상태 출력해주고
			사용자로부터 입력받아서 cheak 돌려주고,
			컴퓨터는 사용자가 3초 이내에 풀면 
				현재 answer에서 10 뺀값으로 체크돌려서 일부로 틀리게 해주고
			3초 초과되면 answer 값으로 cheak 돌려서 무조건 맞추게 설정

			사용자객체와 컴퓨터처리객체에서 cheak를 둘다 하고 나면 각자의 status()를 이용해서
			라운드 끝날때마다 현재 점수를 출력
		*/
		/*
			4. 반복작업을 이용해서 10 round 까지 작업을 하면, 최종승자를 출력
		*/

	}
}

class Exercise01_Procedure {
	/*
		프로시저 몇개를 설계해서 그걸 토대로 작동하는 프로그램을 하나 만들어보자.
		업엔다운 ?
			맞춰야되는 숫자는 정해져있고,
			사용자로부터 입력받아서 사용자가 입력한 숫자가 실제 목표보다 낮은숫자다 혹은 높은숫자다
			라는걸 알려주면서 숫자를 맞추게 유도하는 숫자 게임
		
		관리할 데이터는 목표숫자, 범위, 시도한 회수 를 관리하려고 함.
	*/
	// 1~200 사이의 랜덤점수 만들어내는 기능 : 1-0, int random(){...}
	// 특정범위 사이의 랜덤점수를 만들어내는 기능 : int random(int n1, int n2){...}
	// 두 수중에 큰수를 계산해주는 기능 : int greater(int n1, n2){...}
	// 두 수중에 작은수를 계산해주는 기능 : int less(int n1, int n2){...}
	// 정수하나를 만들어내는 기능 : int handle(String data, int min, int max){...}

	/*
			int input;
			switch(input){
			default:
				input = Integer.valueOf(input);
				break;
			case "":
				input = random(min,max);
			}
	*/

	static int random(){
		//return (int)(Math.random()*201); //ERROR
		return 1 + (int)(Math.random()*200);
	}
	static int random(int n1, int n2){
		return n1+(int)(Math.random()*(n2-n1+1));
	}
	/*	
		############################숫자 범위 랜덤 추출하기################################

		= firstNumber + (int)(Math.random() *         numberCount	     );
		= firstNumber + (int)(Math.random() * (lastNumber+firstNumber+1) );

		###################################################################################
	*/
	static int greater(int n1, int n2){
		if (n1>n2)	return n1;
		else		return n2;
		// return n1 > n2 ? n1 : n2;   <- 삼항연산 간단하게 가능 (조건문 ? A : B;)
	}
	static int less(int n1, int n2){
		if (n1>n2)	return n2;
		else		return n1;
	}
	static int handle(String data, int min, int max){// ""(enter처리) switch로 처리 추천 (if 안된다네)
		switch (data){
		default :
			return Integer.valueOf(data);
		case "" :
			return random(min,max);
		}
		/*
		###########################################
		if(data=="") return Integer.valueOf(data);
		else return random(min,max);
		###########################################
		-> ERROR
		*/
	}


	public static void main(String[] args)	{
		
		int min = 1;
		int max = 200;
		int target = random();
		int tried = 0;
		//----------------------------------------------------
		System.out.println("[SYSTEM] UP_AND_DOWN");
		while(tried<10){
			System.out.println("[SYSTEM] "+ (++tried)+" tried ("+min+" - "+max+") : " );
			String in = System.console().readLine();
			int got = handle(in,min,max);
			/*
			if(got == -1){
				got = random(min,max);
			}
			==>이 조건을 Enter입력하면 처리할수있게
			*/
			if(got == target){
				System.out.println("[SYSTEM] CORRECT VALUE !!! "+ target);
				break;
			}else if(got<target){
				System.out.println("[SYSTEM] TARGET VALUE is GREATER THEN "+got);
				min = greater(got, min);
			}else {
				System.out.println("[SYSTEM] TARGET VALUE is LESS THEN "+got);
				max = less(got, max);
			}
		}
		/*
			19:30 Time Limit
			
			여기서 작업했던걸 기반으로,
			컴퓨터와 숫자 더 빨리 맞추기로 바꿔주시면 됩니다.

				1. 맞춰야 되는 수를 사용자와 컴퓨터가 다르게 설정해달라. (독립적)
				 -변수들이 하나씩 더 필요하지 않을까

				2. 사용자턴부터 처리를 하고, 사용자승리? 같은턴? 아니면 같은턴에 컴이 맞추면 동수로?
				 사용자가 맞추면 끝내게 할껀지 아니면 컴퓨터에게 기회를 한번 더 줘서 무승부로 뜨게
				 할건지는 자유 선택

			UpDown_KJJ.class 로 만들어서 완성되면 업로드
				 




		*/


	}
}

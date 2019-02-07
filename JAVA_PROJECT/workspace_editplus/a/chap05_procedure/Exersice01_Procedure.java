class Exersice01_Procedure {
	/*
		프로시져 몇개를 설계해서 그걸 토대로 작동하는 프로그램을 하나 만들어보자.
		업앤다운 ? 
			맞춰야되는 숫자는 정해져있고, 
			사용자로부터 입력받아서 사용자가 입력한 숫자가 실제 목표보다 낮은숫자다 혹은 높은숫자다
			라는걸 알려주면서 숫자를 맞추게 유도하는 숫자 게임

		데이터는 목표숫자, 범위, 시도한 회수 를 관리하려고 함.
	*/

	// 특정범위사이의 랜덤정수를 만들어내는 기능 : int random(int n1, int n2) { .. 
	static int random(int n1, int n2) {
		return n1+(int)(Math.random()*(n2-n1+1) );
	}
	// 1~200사이의 랜덤정수 만들어내는 기능 : int random() { ..
	static int random( ) {
		return random(1, 200);
	}
	
	// 두수중에 큰수를 계산해주는 기능 : int greater(int n1, int n2) { ..
	static int greater(int n1, int n2) {
		return n1> n2 ? n1 : n2;
	}
	// 두수중에 작은수를 계산해주는 기능 : int less(int n1, int n2) { ..
	static int less(int n1, int n2) {
		if(n1<n2)
			return n1;
		else
			return n2;
	}
	// 정수하나를 만들어내는 기능 : int handle(String data, int min, int max) { ..
	static int handle(String data, int min, int max) { 
		int r;
		switch(data){
		case "":
			r = random(min, max);
			break;
		default :
			r = Integer.valueOf(data);
		}
		return r;
	}

	public static void main(String[] args) {
		int min = 1;
		int max = 200;
		int target = random();
		int tried = 0;
		//────────────────────────
		System.out.println("[SYSTEM] UP_AND_DOWN");
		while(tried<10) {
			System.out.print("[SYSTEM] "+ (++tried) + " TRIED ("+min +" ~ "+max+") : ");
			String in = System.console().readLine();
			int got = handle(in, min, max);
				
			handle("",min,max);
			if(got == target) {
				System.out.println("[SYSTEM] CORRECT VALUE !!! " + got);
				break;
			} else if(got<target) {
				System.out.println("[SYSTEM] TARGET VALUE IS GREATER THAN " + got);
				min = greater(got, min);
			} else {
				System.out.println("[SYSTEM] TARGET VALUE IS LESS THAN " + got);
				max = less(got, max);
			}
		}
		/*───────────────────────────────────────────
			여기서 작업했던걸 기반으로,
			컴퓨터와 숫자 더 빨리 맞추기로 바꿔주시면 된다.
			
				1. 맟춰야 되는 숫자는 사용자와 컴퓨터는 다르게 설정해달라. (협동이 아닌 대전)
				 - 변수들이 하나씩 더 필요하지 않을까.
				2. 사용자턴부터 처리를 하고, 사용자가 맞추면 끝나게 할껀지 
	 			아니면 컴퓨터에게 기회를 한번 더 줘서 무승부도 뜨게 할껀지는 자유 선택

			UpDown_이니셜.class 로 만들어서 완성되면 업로드

		─────────────────────────────────────────────*/
	}
}

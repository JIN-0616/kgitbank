class UpDown_YHH {
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
		int t1,t2;
		int min1, min2;
		int max1, max2;
		int tried = 0;
		boolean done1, done2;
		//===================================
		t1 = random();
		t2 = random();
		// t1 = t2 = random();	
		min1 = min2 = 1;
		max1 = max2 = 200;
		done1 = done2 = false;
		System.out.println("[SYSTEM] UPDOWN VS_MODE");
		while(done1 != true && done2 != true) {
			System.out.println();
			System.out.println("[SYSTEM] ROUND "+ ++tried);
			System.out.print("[SYSTEM] YOU ("+min1 +" ~ " + max1+") " );
			String in = System.console().readLine();
			int g1 = handle(in, min1, max1);
			int g2 = handle("", min2, max2);
			System.out.println("[SYSTEM] COM ("+min2 +" ~ " + max2+") " + g2 );
			
			System.out.print("[SYSTEM] PRESS ENTER ");
			System.console().readLine();

			if(g1 > t1) {
				System.out.println("[SYSTEM] YOUR "+ g1 +" IS GREATER ");
				max1 = less(g1, max1);
			} else if(g1 <t1) {
				System.out.println("[SYSTEM] YOUR "+ g1 +" IS LESS ");
				min1 = greater(g1, min1);
			} else {
				System.out.println("[SYSTEM] YOUR "+ g1 +" IS CORRECT!  ");
				done1 = true;
			}

			if(g2 > t2) {
				System.out.println("[SYSTEM] COMS "+ g2 +" IS GREATER ");
				max2 = less(g2, max2);
			}else if(g2 <t2) {
				System.out.println("[SYSTEM] COMS "+ g2 +" IS LESS ");
				min2 = greater(g2, min2);
			}else {
				System.out.println("[SYSTEM] COMS "+ g2 +" IS CORRECT!  ");
				done2 = true;
			}
		}
		/*
			만들면서 가장 번거로웠던 작업은 어떤거였나..?
			만약 이걸 AI나 혹은 사용자 하나 더 껴서 3인 대결로 바꾼다면 어떤점이 제일 번거롭겠는가..?

			프로시져 중심의 언어는 데이터 처리에 중점을 맞추다보니, 관리가 번거롭다.
			추가적인 변수들을 더 설정해야하고, 변경되는 것들도 진행중에 일일이 바꿔줘야 하는 번거로움이 있다.

			데이터처리에 + 데이터관리의 번거로움을 개선한 방식이 등장하는데,
			이게 객체 중심(객체지향)의 프로그래밍이다.
		*/

		
	}
}

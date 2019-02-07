class Exercise01_Convert {
	public static void main(String[] args) {
		/*
			이 프로그램은 덧셈을 막 배우기 시작한 초등학생들을 위한 프로그램이다.
			덧셈문제를 하나 출력해주고 입력을 받아서 정답인지 오답인지만 알려주면 된다.
		*/
		int n1 = 31; // 숫자는 아무렇게나 입력해두고
		int n2 = 33; // 이 변수에도 숫자 세팅을 해두시고
		// n1과 n2의 값은 바뀔수도 있음
			n1 = 10+(int)(Math.random()*40);
			n2 = 10+(int)(Math.random()*40);

		System.out.println("덧셈퀴즈♬♬");
		System.out.println("    "+String.valueOf(n1));
		System.out.println("+   "+String.valueOf(n2));
		System.out.println("-------");
		String r = System.console().readLine( "    " + String.valueOf((n1+n2)/10) ); 
		//readLine()을 사용했으면 받아야한다.
		//n1+n2의 10의자리만 구해서 적어줘라.
		//입력값이 정답이면 정답, 틀리면 오답으로 출력
		//System.out.println(r);
		//System.out.println(((n1+n2)/10)*10 + Integer.valueOf(r));
		System.out.println( ( ((n1+n2)/10)*10 + Integer.valueOf(r) ) == (n1+n2) ? "정답":"오답");

		int ten = (n1+n2)/10
		// ten * 10

		/*
			정수두개 확보 출력
			확보된 두 정수의 10의자리 계산후 출력
			사용자로부터 입력
			-입력받은데이터를 정수화해서 10의 자리계산해돈거에 덧셈
			-그리고 그 수치가 원래 두개의 합과 일치하는지 확인
			-입력받은 데이터를 정수화해서  그 수치가 정수의 합과 비교
						
		*/
	}
}

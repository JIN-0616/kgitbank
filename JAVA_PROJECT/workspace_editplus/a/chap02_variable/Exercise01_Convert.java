class Exercise01_Convert {
	public static void main(String[] args) {
		/*
			이프로그램은 덧셈을 막배우기 시작한 초등학생들을 위한 프로그램이다.
			덧셈문자를 하나 출력해주고 입력을 받아서 정답인지 오답인지만 알려주면 된다.
			
			단, 사용자가 어린점을 감안해서 
			10의자리의 데이터는 미리 설정해주고	1의 자리만 입력받는다.
		*/
		int n1,n2;	// 이 변수에도 숫자 세팅을 해두시고..
		// n1과 n2의 값은 바뀔수도 있음
			n1 =10+(int)(Math.random()*40);
			n2 =10+(int)(Math.random()*40);
		System.out.println("덧셈퀴즈♬♬");
		System.out.println("    "+String.valueOf(n1));
		// String.valueOf(data);  이 처리는  ""+data; 이렇게 해도 결과는 같다.
		System.out.println(" +  "+String.valueOf(n2));
		System.out.println("─────");
		int ten = (n1 + n2) /10;
		System.out.print("    "+ten);
		String in = System.console().readLine();	// readLine() 사용했으면 받아야 한다.
//		String rst = Integer.valueOf(in) + ten*10 == (n1+n2) ? "정답♬♬♬":"오답..ㅜ^ㅜ";
		String rst = Integer.valueOf(in) == (n1+n2)%10 ? "정답♬♬♬":"오답..ㅜ^ㅜ";
		System.out.println(rst);
//		(n1+n2)%10;

	}
}

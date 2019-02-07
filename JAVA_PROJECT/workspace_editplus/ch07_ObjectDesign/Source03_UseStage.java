class Source03_UseStage {
	public static void main(String[] args)	{
		// Stage 객체를 생성하면서 player 가 설정될수 있게 Stage에 constructor를 설계해두자
		// 이 생성자를 쓰는게 어려우면, 
		// player 이름설정하고, score 0 으로 초기화되는 start()프로시저설계
		Stage s1 = new Stage("사용자");
		/*
			Stage s1 = new Stage();
			s1.player = "사용자";
		*/
		Stage s2 = new Stage("컴퓨터");


		System.out.println(s1.status()); // [사용자] - 0점
		System.out.println(s2.status()); // [컴퓨터] - 0점

		// s1.init("client");
		for(int cnt=1; cnt<=3;cnt++){
			Stage.execute();	
			// 이 작업을 시키게 되면, round값 올라가고,
			// 정수 2개 랜덤으로 뽑아서 이거 합 answer 에다 세팅해두고,
			// 퀴즈문자열 만들어두게 작업을 설정
			System.out.println(Stage.round);	// 1
			System.out.println(Stage.question);	// 45 +79 = ?
			System.out.println(Stage.answer);   // 124
			//==========================================================
		}
		// 정수데이터를 넘기게 됬을때, 맞춰야되는 static으로 설정된 answer와 비교해서 일치하면
		// score 10점을 올리고 return true; 아니면 return false; 시키게 구현
		// 개별데이터 관리 - static 불가능, 객체명 접근자 타고 실행
		boolean b1 = s1.cheak(139); 
		System.out.println(b1);
		boolean b2 = s2.cheak(Stage.answer);
		System.out.println(b2); // 100퍼센트 true

		System.out.println(s1.status()); // [사용자] - 0점
		System.out.println(s2.status()); // [컴퓨터] - 10점

		System.out.println(Stage.current());
		// [ROUND-01] 13+21 = ?
	}
}

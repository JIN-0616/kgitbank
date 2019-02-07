class Source05_Switch {
	public static void main(String[] args) 	{
		/*
			switch - case 구문
			 : 범위처리보다는 특정값마다 각각의 branch 를 만들어내는데 적합
			 : 처리가 되는 데이터들은 int, char, String, (살펴보지 않은 enum까지)
			 : 해당 case 작업만 진행되는게 아니기에 break를 써야 될수도 있다.
			 : 동일 케이스 지정이나, 여러 케이스를 묶어서 설정할 수 없다.
			 : if로 branch 만들때와는 다르게 case마다 변수가 따로 할당되지 않는다.
		*/
		int d = (int)(Math.random()*4);
		switch(d){
		case 1 :
			double e = Math.random();

			break;
		//case 3, 4 :
		case 3 : case 4 :
		

		case 5 :
		case 6 :
		// String e = "switch branch"; // case마다 변수가 따로 할당되지 않는다.
		// case 1:
		}
		/*
			if - else 로 나눠둔 branch 안에서 switch case 를 이용해서 branch 를 세분화 가능

			switch - case로 처리해둔 branch 안에서 if ~else를 이용해서 해당 세분화 가능
		*/

	}
}

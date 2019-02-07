class Source05_Switch {
	public static void main(String[] args) {
		/*
			switch - case 구문
			 : 범위처리보다는 특정값마다 각각의 branch 를 만들어내는데 적합
			 : 처리가되는 데이터들은 int,char,String, (살펴보지 않은 enum 까지)
			 : 해당 case 작업만 진행되는게 아니기에 break 를 써야 할수도 있다.
			 : 동일 케이스 지정이나, 여러 케이스를 묶어서 설정할수 없다.
			 : if로 branch 만들때와는 다르게 case 마다 변수가 따로 할당되지 않는다.
		*/
		int d = (int)(Math.random()*4);
		switch(d){
		case 1:
			double e = Math.random();
	
			break;
			// case 3, 4:
		case 3:
		case 4:
		//	String e =  "switch branch";
		//  case 1:
		}
		System.out.println("e == "+e);
		/*
			if ~ else 로 나눠둔 branch 안에서  switch case 를 이용해서 해당 branch 를 세분화가능
			switch -case로 처리해둔 branch 안에서 if ~else 를 이용해서 해당 case 세분화가능
		*/

	}
}

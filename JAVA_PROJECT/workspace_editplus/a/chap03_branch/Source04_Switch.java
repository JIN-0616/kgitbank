class Source04_Switch {
	public static void main(String[] args) {
		/*
			데이터처리과정에서 branch 작업이 필요할때 사용할수 있는 구문에는
			switch -case 라는것도 존재한다.

			if ~ else : 데이터에 상태에 따른 branch 작업
			switch - case  : 데이터 값에 따른 branch 처리
				/ int,char 형 데이터 , String 데이터, enum 데이터에만 사용가능
		*/
		int d = 3;		
		System.out.println("d == " + d +" / switch branch start");
		// switch(데이터를 담고있는 변수)
		switch(d) {
		case 6 :
		case 5 :
			System.out.println("case..5 handle");
			System.out.println("case..5 handle");
			System.out.println("case..5 handle");
			break;
		case 3 :
			System.out.println("case..3 handle");
			System.out.println("case..3 handle");
		default :
			System.out.println("default handle");
		}
		System.out.println("switch branch end");
		/*
			해당 case 만 작동하는게 아니라, 해당 case부터 진행이 된다.
			default 는 case 처리 안된 데이터값일때 작동.
			해당 케이스만 작동시키고 싶다면, 
			다른 케이스 작업설정전에 break 를 설정해두면 된다.
		*/
		/*
		double r = 3.14;
		switch(r) {

		}
		*/
		String str ="java";	// System.console().readLine();
		switch(str) {
		case "java":
		case "JAVA":
			System.out.println("자바 프로그램을 JRE를 통해서 실행시키는 명령어이다");
			break;
		case "javac":
		case "JAVAC":
			System.out.println("자바 소스코드를 JDK를 통해서 프로그램화 시키는 명령어이다");
			break;
		}
	
	}
}

/*
	Rectangle 같은 객체는 어떻게 설계하는건가?
	객체 설계도 소스파일은 java 파일로 만드시면 되고, 
	main 만 없애고 해당 구조를 그대로 사용하면 된다.
*/
class Robot {
	/*
		이 Robot 객체가 만들어지게 될때 
		관리할 데이터 영역 구성은 변수로 선언해두면 된다.
	*/
	String name;
	int type;
	/*
		이 Robot 객체가 만들어지고 난후
		처리할 작업들은 함수로 만들어두면 된다.
	*/
	String greet() {
		String ment="안녕하세요. 당신의 ";
		// 객체 작업을 설계하는 프로시져쪽에서는 객체가 가지게 될 데이터를 이용해서 구현할수 있다.
		// 객체가 해야될 작업 설계할때 static 안붙임..
		switch(type) {
		case 1: 
			ment += "전투로봇 ";	
			break;
		case 2:
			ment += "청소로봇 ";	
			break;
		default :
			ment += "로봇 ";
		}
		ment += name +" 이/가 인사올립니다";
		return ment;
	}
}

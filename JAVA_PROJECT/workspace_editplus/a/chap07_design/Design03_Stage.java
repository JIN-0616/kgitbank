/*
	사용자와 컴퓨터간에 덧셈퀴즈를 진행시키기 위한 객체를 설계.
	공유시켜서 써야될 자원들은 static 설정을 하려고 한다.

	static 없이 Stage 객체를 만들어서 몇개 돌리는데, 같은 효과를 주고 싶다면..?
*/
class Stage {
	static int round;	
	static int answer;
	static String question;
	
	//============================
	String player;
	int score;
	
	Stage(String init) {
		player = init;
	}
	
	String status() {
		return "["+player+"] " +score+"점";
	}
	
	static void execute() {
		round++;
		int n1 = 10+(int)(Math.random()*90);
		int n2 = 10+(int)(Math.random()*90);
		answer = n1 + n2;
		question = n1+" + " + n2 +" = ? ";
	}

	boolean check(int data) {
		if(data == answer) {
			score += 10;
			return true;
		}else {
			return false;
		}
	}

	static String current() {
		// round 하고 question을 출력하기 쉽게 문자열로 만들어서 리턴하게 구현
		// round 값 출력시 1자리수는 앞에 0 추가해서 리턴
		String ret = "[ROUND-";
		if(round<10) {
			ret += "0"+round+"]";
		}else {
			ret += round+"]";	
		}
		ret += " "+question;
		return ret;	
	}


}

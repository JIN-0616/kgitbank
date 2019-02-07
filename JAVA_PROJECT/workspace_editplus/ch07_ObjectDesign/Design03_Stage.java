/*
	사용자와 컴퓨터간에 덧셈퀴즈를 진행시키기 위한 객체를 설계,
	공유시켜서 써야될 자원들은 static 설정을 하려고 한다.

	static 없이 Stage 객체를 만들어서 몇돌리는데,
	같은 효과를 주고 싶다면 ...?
*/
class Stage {
	static int round;
	static int answer;
	static String question;
	//======================================

	String player;
	int score;
	
	Stage(){
		score = 0;
	}

	Stage(String name){
		player = name;
		score = 0;
	}
	void start(String name){
		player = name;
		score = 0;
	}
	
	static void execute(){ //static 없어도 구동은 가능함
		round++;
		int n1 = 10+(int)(Math.random()*90);
		int n2 = 10+(int)(Math.random()*90);
		answer = n1 + n2;
		question = n1 + " + " +n2 + " = ?";
	}
	
	boolean cheak(int num){ //static 불가능함
		if (answer == num){
			score += 10;
			return true;
		}else
			return false;

	}
	/*
		method에 static변수를 붙일때는 주의할것
		내부에 다루는 데이터가 각 객체 개별data를 다루지 않아야!
	*/
	String status(){
		return "["+player+"]"+score+"점";
	}

	static String current(){
		// round 하고 question을 출력하기 쉽게 문자열로 만들어서 리턴하게 구현
		// round 값을 출력시 1자리수는 앞에 0 추가해서 리턴
		String str="";
		if (round<10)
			str = "0"+round;
		else
			str = ""+round;
		return "[ROUND-"+str+"] "+question;
	}
}

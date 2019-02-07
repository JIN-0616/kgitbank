/*
	����ڿ� ��ǻ�Ͱ��� ������� �����Ű�� ���� ��ü�� ����.
	�������Ѽ� ��ߵ� �ڿ����� static ������ �Ϸ��� �Ѵ�.

	static ���� Stage ��ü�� ���� � �����µ�, ���� ȿ���� �ְ� �ʹٸ�..?
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
		return "["+player+"] " +score+"��";
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
		// round �ϰ� question�� ����ϱ� ���� ���ڿ��� ���� �����ϰ� ����
		// round �� ��½� 1�ڸ����� �տ� 0 �߰��ؼ� ����
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

class Source06_For {
	public static void main(String[] args) {
		/*
			for �� Ư�� ȸ����ŭ loop ó���� �ϴ»�Ȳ ������ ����..
		*/
		for(int cnt=1; cnt<=10; cnt++) {
			int r = (int)(Math.random()*5);
			System.out.println("[for loop] " +r);
		}
		// �� Ư¡�� �̿��ؼ�.. �������� ����غ��µ� for loop�� ó���غ���.
		// 2�� 5���� ? 32  , 3�� 4���� ? 81
		int number = 1;
		number *= 3;
		number *= 3;
		number *= 3;
		number *= 3;
		System.out.println("number = "+ number);
		
		System.out.print("���� =");
		int n = Integer.valueOf(System.console().readLine());
		System.out.print("�� ���� =");
		int step = Integer.valueOf(System.console().readLine());
		/*
			for loop ���� int ���� �ϳ� ��Ƽ� 1�� �����صΰ�,
			step ȸ����ŭ �� 1 �����ص� ������ n�� ���ϴ� �۾��� �Ͼ�� loop�� ����
		*/
		int result=1;
		// for(  ) �ȿ��� ���������� �ߴٸ�, for loop�� ������ ���� ������� �ȴ�.
		// for(int c=1, result=1; ........) {
		for(int cnt =1; cnt<=step; cnt++) {	
			result *=n;
		}
		System.out.println(result);
		
	}
}

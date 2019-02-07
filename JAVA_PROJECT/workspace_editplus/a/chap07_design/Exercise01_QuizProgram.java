class Exercise01_QuizProgram {
	public static void main(String[] args) {
		/*
			1. Stage ��ü�� �ΰ� ���� �غ� ���ѵνð� 
			(�����ڷ� ��ü�� player �����صΰ�)
		*/
		Stage user = new Stage("USER");
		Stage comp = new Stage("COMP");
		/*
			2. �ݺ������� while�� �صδµ�
			Stage�� round�� 10�� �ɶ����� �۵��ǰ� ����
		*/
		System.out.println("[SYSTEM] STAGE START!");
		while(Stage.round <10) {
			System.out.println();
			Stage.execute();
			System.out.println(Stage.current());
			System.out.print("[SYSTEM] INPUT ANSWER! HURRY!! ");
			long t1 = System.currentTimeMillis();
			String in = System.console().readLine();
			long t2 = System.currentTimeMillis();
			user.check(Integer.valueOf(in));
			if(t2 - t1 >3000) {
				System.out.println("[SYSTEM] COMPUTER CALLED " + Stage.answer);
				comp.check(Stage.answer);
			} else {
				if(Math.random()>0.5) {
					System.out.println("[SYSTEM] COMPUTER CALLED " + Stage.answer);
					comp.check(Stage.answer);
				}else {
					System.out.println("[SYSTEM] COMPUTER CALLED " + (Stage.answer -10) );	
					comp.check(Stage.answer -10);
				}
			}
			System.out.println(user.status());
			System.out.println(comp.status());
		}
		/*
			3. �ݺ������鼭 ó��������, Stage ���� ���� ������ְ�
			����ڷκ��� �Է¹޾Ƽ� check �����ְ�,
			��ǻ�ʹ� ����ڰ� 3�� �̳��� Ǯ�� ���� answer���� 10 �������� üũ ������
				�Ϻη� Ʋ���� ���ְ�
			3�� �ʰ��Ǹ� answer ������ üũ������ ������ ������ ó��

			����ڰ�ü�� ��ǻ��ó����ü���� check �� �Ѵ� �ϰ� ���� ������ status()�� �̿��ؼ�
			���� ���������� ���� ���¸� ���
		*/
		/*
			4. �ݺ��۾��� �̿��ؼ� 10 round ���� �۾��� �Ϸ�ǰ� ����, �������ڸ� ���
		*/
	}
}

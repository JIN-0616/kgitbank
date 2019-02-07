class Source03_UseStage {
	public static void main(String[] args) {
		// Stage ��ü�� �����ϸ鼭 player �� �����ɼ� �ְ� Stage �� constructor�� �����ص���.
		// �� �����ڸ� ���°� ������, 
		// player�̸� �����ǰ�, score �� 0���� �ʱ�ȭ�Ǵ� start procedure�� ���� �ǰ�,
		Stage s1 = new Stage("�����");
		/*
			Stage s1 = new Stage();
				s1.player = "�����";
		*/
		Stage s2 = new Stage("��ǻ��");
		
		System.out.println(s1.status());	// [�����] 0��
		System.out.println(s2.status());	// [��ǻ��] 0��
		for(int cnt=1; cnt<=3; cnt++) {
			Stage.execute();	
			// �� �۾��� ��Ű�� �Ǹ�, 
			// round�� �ö󰡰�, �����ΰ� �������� �̾Ƽ� �̰� �� answer ���ٰ� �����صΰ�,
			// ����ڿ� �����ΰ� �۾��� ���� 
			System.out.println(Stage.round);	// 1
			System.out.println(Stage.question);	// 45 + 79 = ?
			System.out.println(Stage.answer);	// 124
			//======================================================
		}
		boolean b1 = s1.check(139);	
		// ���������͸� �ѱ�� ������, ����� �Ǵ� static���� ������ answer�� ���ؼ� ��ġ�ϸ�
		// score 10���ø��� return true, �ƴϸ� return false ��Ű�� ����
		System.out.println(b1);

		boolean b2 = s2.check(Stage.answer);
		System.out.println(b2);

		System.out.println(s1.status());	// [�����] 0��
		System.out.println(s2.status());	// [��ǻ��] 10��
		System.out.println(s2.current());	// 
		System.out.println(Stage.current());	// 

	}
}

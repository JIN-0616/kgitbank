class Source02_If {
	public static void main(String[] args) {
		/*
			if ~ else ��  branch �����ϱ�.

			1. else �ʰ� �׻� ���� �̷� �ʿ�� ����.
		*/
		int n1 = 10 + (int)(Math.random() * 90);	// 10 ~ 99
		int n2 = 10 + (int)(Math.random() * 90);	// 10 ~ 99
		System.out.println(n1+".."+n2);
		if( n1 + n2 >=100 ) {
			System.out.println("if branch executed..");
			n2 = 99 - n1;
		}
		System.out.println(n1+".."+n2);
		/*
			2. if ~ else �ܿ� ���� �߰����� branch�� �ʿ��ϴٸ� 
			���� branch�� ����ų�,
		*/
		int target = (int)(Math.random()*10);
		// target ��ġ�� 0~3 ����, 4 ~ 6 ���� 7 ~ 9 ���� �� ���� �ٸ�ó��
		System.out.println("target = " + target);
		if(target <=3) {
			System.out.println("1 branch");
		} else {
			System.out.println("2 branch");
			if(target <=6) {
				System.out.println("2-1 branch");
			} else {
				System.out.println("2-2 branch");
			}
			System.out.println("2 branch end..");
		}
		System.out.println("main - branch");
		/*
			 if else �� ���� �̾ �������� �ִ�.
		*/
		if(target <=3) {

		} else if (target >=4 && target <=6) {	// target >=4 ����Ȯ���� ���ص� ��.

		} else {

		}
		//===============================================================
			
	}
}
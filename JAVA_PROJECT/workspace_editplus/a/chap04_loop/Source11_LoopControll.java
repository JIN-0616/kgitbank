class Source11_LoopControll {
	public static void main(String[] args) 	{
		/*
			���κκ� loop���� continue�� ��Ű�µ� ��ü loop�� ������ �ְ� �ʹٰų�
			���κκ� loop���� break�� ��Ű�µ� ��ü loop�� ���߰� �Ѵٰų�
			switch �ȿ��� loop �� ���ߴ� break�� �ؾߵȴٸ�..?

			labeled loop (named loop)
		*/

		a : 
		while(Math.random()>0.1) {
			System.out.println("main - loop ȸ������");
			b : 
			for(int cnt=1; cnt<=5; cnt++) {
				if(Math.random() >0.75) {
					continue a;
				}
				if(Math.random() >0.75) {
					continue b;	// break; ��� ��� �ȴ�.
				}
				System.out.println("����loop " + cnt);
			}

			System.out.println("main - loop ȸ����");
		}

		System.out.println("...");
	}
}

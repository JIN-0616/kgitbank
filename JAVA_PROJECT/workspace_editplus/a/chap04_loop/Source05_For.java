class Source05_For {
	public static void main(String[] args) {
		/*
			loop �� �����ϱ� ���ؼ� while �̳� for ������ ���������ϴ�.
			�̶������� while loop �� �̿��ϴ� ����� ���캸�Ұ�,
			for loop �� ����ϴ� ����� ��Ȳ�� ���ؼ� �˾ƺ���.

			for loop �� while + (loop ���۽� ó������ + �� loop �� �ؾߵ���) ��
			�Ѳ����� �����Ҽ� �ְ� �ص� �����̴�.
		*/
		int sum = 0;
		int data = (int)(Math.random()*10000);
		int data2 = data;
		System.out.println("data == "+ data);
		while(data>0) {
			sum += data%10;
			data /=10;
		}
		System.out.println("while loop ��.." + sum);
		//===================================================
		int sum2 =0;
		// for (loop���۽�����; ����; �� loop ó������ ����) 
		// �� ��Ҹ� �̿��ϴ°� ����
		for( System.out.println("������.."+data2) ; data2>0 ; System.out.println("���ڸ�ó���Ϸ� ������:"+data2)  ) {
			sum2 += data2 % 10;
			data2 /= 10;
		}
		System.out.println("for loop ��.." + sum2);
		/*
			��κ��� ���, for loop �� ���º��ٴ� �ٸ����°� ���� ���̰� �ȴ�.
		*/

	}
}

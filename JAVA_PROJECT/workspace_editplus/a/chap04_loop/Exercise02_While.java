class Exercise02_While {
	public static void main(String[] args) {
		/*
			�ϻ��� ��..? 
		*/
		System.out.print("input numeric> " );
		int data = Integer.valueOf(System.console().readLine());
		// while loop�� �̿��ؼ� ���ڸ��� ���� ������.
		int sum = 0; 
		int copy = data;
		while(data>0) {
			sum += data%10;
			data /= 10;
			System.out.println("[loop] sum = "+ sum+"/data = "+data);
		}
		System.out.println("���ڸ����� ���� �� : "+sum);
		// ������ data�� ������ ������ �ϻ��� ��
		//			�׷��������� �ϻ��� �� �ƴ� �̶�� if - else branch
		data = copy;
		if(data%sum ==0 ) {
			System.out.println("�ϻ����");
		}else {
			System.out.println("�ϻ���� �ƴ�");
		}

	}
}

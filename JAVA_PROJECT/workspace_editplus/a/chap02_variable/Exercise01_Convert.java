class Exercise01_Convert {
	public static void main(String[] args) {
		/*
			�����α׷��� ������ ������ ������ �ʵ��л����� ���� ���α׷��̴�.
			�������ڸ� �ϳ� ������ְ� �Է��� �޾Ƽ� �������� ���������� �˷��ָ� �ȴ�.
			
			��, ����ڰ� ����� �����ؼ� 
			10���ڸ��� �����ʹ� �̸� �������ְ�	1�� �ڸ��� �Է¹޴´�.
		*/
		int n1,n2;	// �� �������� ���� ������ �صνð�..
		// n1�� n2�� ���� �ٲ���� ����
			n1 =10+(int)(Math.random()*40);
			n2 =10+(int)(Math.random()*40);
		System.out.println("��������ݢ�");
		System.out.println("    "+String.valueOf(n1));
		// String.valueOf(data);  �� ó����  ""+data; �̷��� �ص� ����� ����.
		System.out.println(" +  "+String.valueOf(n2));
		System.out.println("����������");
		int ten = (n1 + n2) /10;
		System.out.print("    "+ten);
		String in = System.console().readLine();	// readLine() ��������� �޾ƾ� �Ѵ�.
//		String rst = Integer.valueOf(in) + ten*10 == (n1+n2) ? "����ݢݢ�":"����..��^��";
		String rst = Integer.valueOf(in) == (n1+n2)%10 ? "����ݢݢ�":"����..��^��";
		System.out.println(rst);
//		(n1+n2)%10;

	}
}

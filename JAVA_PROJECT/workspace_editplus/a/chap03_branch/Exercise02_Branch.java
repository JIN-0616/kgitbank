class Exercise02_Branch {
	public static void main(String[] args) {
		
		// Ư�������� ���� �ֽ��� ����/���� ���
		System.out.println("[StockHelper] START");

		System.out.print("[StockHelper] price? ");
		int p = Integer.valueOf(System.console().readLine());
		System.out.println("[StockHelper] input data is " + p);

		// ũ��  branch�� ��������.. ó���� branch �� �׷��� ���� branch
		// 1000�̻� ~ 5000�̸��� 5������
		// 5000�̻� ~ 10000�̸��� 10������
		// 10000�̻� ~ 50000�̸��� 50������
		// 50000�̻� ~ 100000�̸��� 100������
		// &&, || �ΰ��� ���� ���Ǹ�  && ����� �� ������.
		if( (p>=50000 && p<100000 && p%100 ==0) || 
			(p>=10000 && p<50000 && p%50 ==0) ||
			(p>=5000 && p<10000 && p%10 ==0) ||
			(p>=1000 && p<5000 && p%5==0)  ) {
			System.out.println("[StockHelper] data handle..start wait plz");
		} else {
			System.out.println("[StockHelper] invalid data");
		}
		// 30�ۼ�Ʈ ����� ��� �ִ�ġ, 30�ۼ�Ʈ �϶��� �϶��ִ�ġ
		
		
	}
}

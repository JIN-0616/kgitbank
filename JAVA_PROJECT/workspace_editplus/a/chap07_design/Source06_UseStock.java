class Source06_UseStock {
	public static void main(String[] args) {
		Stock s = new Stock("�����ػ�");	
		// ���ڿ��� �����ؼ� �����, product �����ǰ�, 
		// ���� 500 �� �����Ǹ鼭 ��������� ������ ����, ammount�� 100���� �����ǰ�
		System.out.println(s.current());

		Stock s1 = new Stock("��������", 4500);	
		System.out.println(s1.current());	// product�� value�� �����ǰ�, ammount 100���� �����ǰ�
		
		s1.change();	// ��ġ�� ���� ���� �ִ� 30�ۼ�Ʈ �̳������� ������ �ǰ�. 
						// �������� 100���� ����
		
		System.out.println(s1.current());	
		

	}
}

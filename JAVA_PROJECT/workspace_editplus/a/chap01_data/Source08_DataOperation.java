class Source08_DataOperation {
	public static void main(String[] args) {
		/*
			���ڿ������� ���� �����ϴ� �۾��� �����Ѵ�.

			������ ����� �� �Ҽ� �ִ�.
		*/
		System.out.println( "�ڹ�" + "���ڿ� ����" );
		// System.out.println( "�ڹٹ��ڿ�" - "�ڿ�" );	
		
		// System.out.println( "�ڹ�" > "���̼�" );
		System.out.println( "�ڹ�" == "���̼�" );
		System.out.println( "�ڹ�" == "�ڹ�" );
		System.out.println( "�ڹ�" != "���̼�" );

		/*
			Ư���� ����, 
			���ڿ��� �������� ����� ���ڿ��� �ƴϸ� �װ� ���ڿ�ȭ ���Ѽ� ������ �Ѵ�.
		*/
		System.out.println( "�ڹ�" + 30 );	// 30 --> "30"
		System.out.println( "�ڹ�" + 30 + 10);	// 30 --> "30"
		System.out.println( "�ڹ�" + (30 + 10) );	// 30 --> "30"
		System.out.println(10 + 30  + "�ڹ�");	// 30 --> "30"
		System.out.println((10 + 30 ) + "�ڹ�");	// 30 --> "30"

		System.out.println("�Ϸ�� " + (60*60*24) + "�� �̴�.");



	}
}

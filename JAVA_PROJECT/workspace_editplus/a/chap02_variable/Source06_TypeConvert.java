class Source06_TypeConvert {
	public static void main(String[] args) {
		/*
			������ casting �� �غ��Ҵµ�, �� �Ǵ°� �ƴϴ�.
			
			��ġ,���� ������ �ٸ� ��ġ���ڵ����ͷ� casting�� ��. �׿ܴ� �ȵ�.
			�������ʹ� �ٸ������ͷ� casting�� �ȵ�.
			���ڿ������͵� �ٸ������ͷ� casting�� �ȵ�
		*/
		System.out.println( (int)'��' );
		System.out.println( (char)45207 );
		// System.out.println( (boolean)1 );
		// System.out.println( (String)456 );
		// System.out.println((int)true);
		// System.out.println((String)true);
		// System.out.println(  (int)"������" );
		/*
			casting �� �ȵǴ°��� ��� ������ �� String ���� �ٲܼ��� �ִ�.
			���ڿ��� �ٸ������� ���ϸ� �� �����͸� ���ڿ�ȭ�ؼ� ���������� �Ǵϱ�.
			�� ó���� casting�� �ƴ϶� �۾��� ���� �����ؾ� �ȴ�.

			��� �����ʹ� String.valueOf(data) �ϸ� ���� Stringȭ �ȴ�.
		*/
		System.out.println("�����ġ�� " + 5031 + " �Դϴ�");	
		System.out.println("�����ġ�� " + String.valueOf(5031) + " �Դϴ�");	

		String s = String.valueOf(3.14*3*3);
	//	System.console().readLine("input> ");
	//	System.console().readLine(String.valueOf(3));
		/*
			String ��  ������ȭ ��Ű����
				Integer.valueOf();
				Long.valueOf();
				Float.valueOf();
				Double.valueOf();
				Boolean.valueOf();
		*/
		int v1 = Integer.valueOf("4564651");
		System.out.println(v1 +" / " + v1*v1);

		double v2 = Double.valueOf("3123124.3242");
		

	}
}

class Source05_NullValue {
	public static void main(String[] args) {
		/*	
			null �̶�� �����Ͱ� �ִ�, �� �����ʹ� ��ü�������� ������ �ִ� �������̴�.
		*/
		// int a = null;
		Sphere s = null;
		Robot r = null;
		System.out.println(s == null);	
		System.out.println(r != null);	
		/*
			��ü�������� ���� ���� null �̶�� ���� �������� ��ü�� ���� ��Ȳ�� ��Ÿ����.
		*/
		//	r.greet();
		Legion g1 = new Legion();
			g1.one = new Robot();
			g1.one.name = "���";
		Robot t = new Robot();
			t.name = "���İ�";
			g1.other = t;

		String ss = g1.introduce();
		System.out.println(ss);

	}
}
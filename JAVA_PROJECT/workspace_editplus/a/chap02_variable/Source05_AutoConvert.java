class Source05_AutoConvert {
	public static void main(String[] args) {
		/*
			��ġ�������� int < long < float < double ������ �ڵ����� ��ȯ�� �Ͼ��.
			1. �ٸ�Ÿ���� �����Ͱ� ������ �Ͼ���� ū������ �ڵ���ȯ�� �Ͼ��.
			2. ���������͸� ūŸ�Կ� �����Ϸ��� �Ҷ��� �ڵ���ȯ�� �Ͼ��.
		*/
		int a = 5;
		double d = 10.4;
		long g = 30L;
		
		System.out.println(a + d);
		System.out.println(g >= a);

		double e = a + d;
		
		float t = a;
		System.out.println(t);
		// float ff = d;
	}
}

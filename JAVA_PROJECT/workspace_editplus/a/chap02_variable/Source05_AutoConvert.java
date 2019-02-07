class Source05_AutoConvert {
	public static void main(String[] args) {
		/*
			수치형데이터 int < long < float < double 간에는 자동으로 변환이 일어난다.
			1. 다른타입의 데이터간 연산이 일어날때는 큰쪽으로 자동변환이 일어난다.
			2. 작은데이터를 큰타입에 저장하려고 할때는 자동변환이 일어난다.
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

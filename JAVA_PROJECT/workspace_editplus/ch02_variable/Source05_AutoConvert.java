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

		long t1 = a;
		System.out.println(t1);

		float t2 = a;
		System.out.println(t2);

		//float f3 = d; //큰것을 작은것으로는 오류(자동으로 안됨)
		/*
		15: i2d
	  
		 27: i2l

		47: i2l
		*/
		//자동변환이 일어나는 경우 - 수치연산, 카피연산

	}
}

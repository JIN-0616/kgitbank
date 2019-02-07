/*
	변수활용 / 입력값제어 / 데이터변환을 마무리하기 위해
	확률 프로그램을 만들려고 하는데,
	만들기 전에	랜덤데이터를 만드는법에 대해 알아보자.
*/
class Source09_RandomValue {
	public static void main(String[] args) {
		/*
			랜덤 실수를 만들어서 사용하기 지원한다.
			(정수, 논리, 문자열을 만들려면 응용이 필요하다)
		*/
		Math.random(); 
		// 이걸 사용하면 0.0 <= ...<1.0 미만의 실수수치(double)을 만들수있다.
		System.out.println(Math.random());
		double e = Math.random();
		System.out.println(e);
		System.out.println(e);
		// 정수수치가 필요하면 casting 을 이용하면 된다.
		int v = (int)(Math.random()*10);
		//	  ★(int)Math.random()*0 으로 사용하면 무조건 0만 나온다.
		//0.0 <= ... <10.0 --> 0 <=... <10미만의 정수를 만들수 있다.
		System.out.println(v);
		
		//필요수치가 6~10 인 정수라면,
		int vv = 6 + (int)(Math.random() * 5);	//start+(int)(Math.random()*개수)
		
		//###############0.0 ~ 30.0 사이의 실수수치를 만들려면..?###################
		double v2 = (int)(Math.random()*301)/10.0;
		//0.0 <1.0
		//0.0 <301.0
		//int 0 <=... <=300

		System.out.println(v2);

		// ㄱ ~ ㅎ 까지의 랜덤 문자를 만들려면?
		// 계산할때는 굳이 int로 변환하지 않아도 된다.
		//System.out.println((int)('ㅎ') - (int)('ㄱ')+1); //12622-12593+1 == 30 

		char han = (char)((int)('ㄱ')+(int)(Math.random()*30));
		System.out.println(han);
		
		//==>
		char c1 = (char)('ㄱ' +(int)(Math.random()*('ㅎ'-'ㄱ'+1)));
		System.out.println(c1);

	}
}

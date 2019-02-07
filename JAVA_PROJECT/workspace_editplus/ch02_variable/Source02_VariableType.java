class Source02_VariableType {
	public static void main(String[] args) {
		/*
			수치
			- 정수 : byte , short , int(※) , long
			- 실수 : float , double(※)
			문자 : char
			문자열 : String
			논리 : boolean

			수치계열은 타입자체가 여러개인데, 메모리 효율성과 관련되어 있다.
			
			# 만드는 법

			타입 이름;
		*/
		int v1;
		double v2;
		char v3;
		String v4; //대문자
		boolean v5;
		//====================================================================
		v1 = 13;
		v2 = 43.222;
		v3 = '문';
		v4 = "문자열";
		v5 = true;
		//====================================================================
		// 변수에 들어가져 있다고 치더라도, 앞서 살펴본 연산은 다 가능하다.
		System.out.println(v1);
		System.out.println(v1 << 1);
		System.out.println(v1 / 5); //몫만
		System.out.println(v4 +"이다");
		System.out.println(v5 ? "Accessed":"Denied");

	}
}

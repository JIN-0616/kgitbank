class Source03_VariableRule {
	public static void main(String[] args) {
		/*
			변수를 사용하기 위해서는 몇가지 룰을 알아야 한다.
			1. 데이터 종류에 따라서 정확하게 맞춰서 사용해야 한다.
			2. 변수에 데이터가 설정이 된적이 없다면, 그 값을 사용할수 없다.
			3. 변수 붙이는 이름은 중복사용될수 없고, 안되는 것들이 존재한다.
			4. 변수 이름은 숫자 및 특수문자 로 시작되게 설정할수 없고, 공백포함이 안된다.
			5. 변수 이름은 대소문자는 구분됨.
			6. 사용하기 전에 반드시 만들어져 있어야 한다.
		*/
		int num;
		// String num;
	//	String throws;		// 문법에 사용되는 단어임.
		num = 30;
		System.out.println("variable num's value = " + num);
		// boolean a b;
		// boolean 1a;
		// boolean ~a;
		boolean $b;
		double _b;
//		System.out.println("NUM = " + v1);
		int NUM;
		/*
			알아두면 좋은 것들?
			1. 같은 데이터종류 를 저장할 변수라면 여러개를 동시에 만들어도 됨.
			2. 꼭 만드는 작업과 설정하는 작업을 따로 해야되는건 아니다.
			3. 저장하고자 하는 데이터가 어떤 의미인지 변수명에 드러나게 작명을 하는 습관을 들여야 한다.
			  (길어도 상관없지만, 첫글자는 소문자로 작명하고 복합단어 형태라면 camel 규칙을 따르는게
  			   개발자들간 지키고 있는 암묵적인 룰이다.)
		*/
		int w, l;
		int draw = 40;
		String s1 = System.console().readLine();
		int p1 = 30, p2 = 50;
		int totalTime = 45210;
	}
}

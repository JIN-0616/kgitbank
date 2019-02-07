class Excersice01_Branch {
	public static void main(String[] args) 	{
		/*
			사용자로부터 신장데이터와 체중데이터를 확보해서
			이걸 토대로 신체 질량지수를 계산후
			그 계산 결과에 따라 3개의 branch를 만들어서
			사용자에게 다른 출력이 일어날수 있게 만들어보자.
		*/
		System.out.println("[BIO]건강지수 계산");
		System.out.print("[BIO]신장(단위:m) 입력: ");
		double m = Double.valueOf(System.console().readLine());
		System.out.print("[BIO]체중(단위:kg) 입력: ");
		double kg = Double.valueOf(System.console().readLine());
		//신체질량지수 는 사용자체중/신장의제곱 으로 나누면 됨
		//이 계산결과를 출력 - main
		double t = kg/(m*m);
		System.out.println("[BIO]신체질량지수 : "+ t);

		//저체중 미만 18.5  표준체중 미만 23.0 과체중  이 3개를 기준으로 branch를 만들어서
		//저체중 처리하는 branch 에서는 표준체중에 들어가기 위한 최소 체중을 역계산해서 출력
		//??/(*1.75*1.75) =18.5
		if(t<18.5){
			System.out.println("[BIO]저체중");
			System.out.println("[BIO]표준체중에 들어가기 위한 최소 체중 : "+ 18.5*m*m +"kg");

		//과체중 처리하는 branch 에서는 표준체중에 들어가기 위한 최대 체중을 역계산해서 출력
		//??/(*1.75*1.75) =23.0
		}else if(t>23.0) {		// 18.5<bmi<23.0 이런 계산은 불가
			System.out.println("[BIO]과체중");
			System.out.println("[BIO]표준체중에 들어가기 위한 최대 체중 : "+ 23.0*m*m +"kg");

		//표준체중 처리하는 branch 에서는 
		}else{
			System.out.println("[BIO]표준체중");
		}
		//건강한 육체에 건강한 정신이 깃든다 라고 main branch 합류지점에 출력
		System.out.println("[BIO]건강한 육체에 건강한 정신이 깃든다.");
		System.out.println("[BIO]terminate");
	}	
}
/*
	코드 어시시트가 작동해서 , 원하는 형태의 코드가 잘 작성이 안된다면
	도구 - > 기본설정 >> 파일 -설정 및 구문강조 -> 자바 --> 자동완성 uncheak

*/
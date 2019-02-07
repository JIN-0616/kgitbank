class Source02_If {
	public static void main(String[] args) {
		/*
			if ~ else 로  branch 구현하기.

			1. else 쪽과 항상 쌍을 이룰 필요는 없다.
		*/
		int n1 = 10 + (int)(Math.random() * 90);	// 10 ~ 99
		int n2 = 10 + (int)(Math.random() * 90);	// 10 ~ 99
		System.out.println(n1+".."+n2);
		if( n1 + n2 >=100 ) {
			System.out.println("if branch executed..");
			n2 = 99 - n1;
		}
		System.out.println(n1+".."+n2);
		/*
			2. if ~ else 외에 좀더 추가적인 branch가 필요하다면 
			내부 branch를 만들거나,
		*/
		int target = (int)(Math.random()*10);
		// target 수치가 0~3 구간, 4 ~ 6 구간 7 ~ 9 구간 에 따라서 다른처리
		System.out.println("target = " + target);
		if(target <=3) {
			System.out.println("1 branch");
		} else {
			System.out.println("2 branch");
			if(target <=6) {
				System.out.println("2-1 branch");
			} else {
				System.out.println("2-2 branch");
			}
			System.out.println("2 branch end..");
		}
		System.out.println("main - branch");
		/*
			 if else 를 좀더 이어서 만들어낼수도 있다.
		*/
		if(target <=3) {

		} else if (target >=4 && target <=6) {	// target >=4 상태확인은 안해도 됨.

		} else {

		}
		//===============================================================
			
	}
}

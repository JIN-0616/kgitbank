class Source03_If {
	public static void main(String[] args) 	{
		/*
			if - else branch 만들때 알아둘 것들

			어디쪽 branch 이던, branch 안에 해야될 처리가 작업 하나라면 {} 를 생략 해도 된다.

		*/
		int r = 100;
		boolean flag = Math.random()>0.5;

		System.out.println("r == "+ r + " , " + flag);
		if(flag) //if(flag == ture)  
			r *= 10;
		else
			r += 100;
		System.out.println("r == " +r );
		System.out.println();
		//=======================================================
		// 2. branch 안에서 변수를 만들고 사용할 수 있지만,
		//   이건 해당 branch 에서만 사용가능하다.
		if(Math.random() > 0.3){ // {} 기준으로 내부생성변수
			int d = r/10 + r%10;
			System.out.println("d ==" +d);
		}else {
			String d = "branch";
			System.out.println("d ==" +d);
		}
		// System.out.println("d == " + d); //{}외부에서 사용불가

	}
}

class Source04_Procedure {
	/*
		반복문 연습 , 프로시저 생성 연습
		피보나치 수열
		0,1,1,2,3,5,8,13,21,55,89,144,...

		n번째 피보나치 수를 만들어내는 프로시저를 설계
		int를 만들어내는게 목적이고, int 하나를 받아서 작동되게 fibonachi라는 이름으로 만들면 된다.
	*/
	static int fibonachi(int val){
		int a1 = 0;
		int a2 = 1;
		for (int i=1;i<val;i++){
			int num = a1 + a2;
			//   3     1    2
			a1 = a2;
			//1   2
			a2 = num;
			//2   3
		}
		return a2;
	}
		/*
		if(idx ==1)
			return 1;
		else{
			for (int i=1;i<val;i++){
			int num = a1 + a2;
			//   3     1    2
			a1 = a2;
			//1   2
			a2 = num;
			//2   3
		}
		return a2;
		*/
	/*
        2차원 평면상의 x,y 좌표값 두개(각 int 2개)를 받아서 거리를 계산해주는 프로시저를 설계
		double값 return 하는 목적, int 4개를 작동되게 range라는 이름으로 만들어 달라
		(int x1, int y1, int x2, int y2) , sqrt 사용 0,0,3,4 -> 5.0

		(x2-x1)^2 + (y2-y1)^2 의 값의 제곱근(루트) = 빗변길이 = 좌표평면상 두 점 사이의 거리
	*/
	static double range(int x1, int y1, int x2, int y2){
		double d1 = Math.pow((x2-x1),2);
		//double da1=(x2-x1)*(x2-x1);
		
		double d2 = Math.pow((y2-y1),2);
		//double da2=(y2-y1)*(y2-y1);

		double d = Math.sqrt(d1+d2);

		return d;
		//return Math.sqrt(d1+d2);

		//return Math.sqrt(((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1)));
	}

	public static void main(String[] args)	{
		// 1번째는 아마 고정으로 1, 실제 계산은 2번째 수부터 계산을 하면 되는데
		/*
		int prev = 0;
		int current =1;
		for (int cnt=1;cnt<=5;cnt++){
			int next = prev + current;
			prev = current;
			current = next;
			System.out.println(cnt +" p: "+prev+ " c: "+current);
			return current;
		}
		*/
		// 위 작업을 처리할수 있게 프로시저를 만드시고

		int v = fibonachi(3);
		System.out.println(v); //2
		System.out.println(fibonachi(10)); //55

		System.out.println(range(0,0,3,4)); //5.0
		System.out.println(range(2,1,5,5)); //5.0
		System.out.println(range(0,0,-5,-12)); //13


	}
}

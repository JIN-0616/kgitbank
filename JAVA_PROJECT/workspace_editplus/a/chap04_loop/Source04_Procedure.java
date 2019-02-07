class Source04_Procedure {
	/*
		n번째 피보나치 수를 만들어내는 프로시져를 설계
		int를 만들어내는게 목적이고, int 하나를 받아서 작동되게 fibonachi 라는 이름으로 만들면 된다.
	*/

	/*
		2차원평면상의 좌표 두개 거리를 계산해주는 프로시져를 설계
		double을 만들어내는게 목적이고, int 4개를 받아서 작동되게 range 라는 이름으로 만들어달라
		(int x1, int y1, int x2, int y2)

	*/

	public static void main(String[] args) 	{
		// 1번째는 아마 고정으로 1, 실제 계산은 2번째 수부터만 계산을 하면 되는데..
		// 
		int prev = 0;
		int current = 1;
		for(int cnt=1; cnt<=5; cnt++){
			int next = prev + current;
			prev = current;
			current = next;
			System.out.println(cnt + ") " + prev+" .. " + current);
		}
		// 위 작업을 처리할수 있게 프로시져를 만드시고
		
		int v = fibonachi(3);
		System.out.prinltn(v);	// 2
		System.out.println( fibonachi(10) );	// 55
		System.out.println( fibonachi(15) );	// 610

	}
}

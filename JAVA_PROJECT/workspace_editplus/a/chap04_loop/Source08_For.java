class Source08_For {
	public static void main(String[] args) 	{
		/*
			루프안에서 다시 루프를 구현하는 형태의 구문도 설정가능하다.
		*/
		for(int lv=1; lv<=5; lv++) {
			System.out.println("lv == "+lv);
			for(int step=1; step<=10; step++) {
				System.out.println("step == "+lv+"-"+step);
			}
			System.out.println();
		}
		/*
			이런 형태의 loop 로, 2의 1제곱부터 10제곱까지를 출력해보자.
		*/
		for(int step=1; step<=10; step++) {
			int d = 1;
			for(int cnt=1; cnt<=step; cnt++) {		
				// 바깥쪽 loop의 변화하는 수를 가지고, 내부루프의 조건으로 사용하는 형태가
				// 중복형태의 loop 중 가장 많은 생각이 필요하게 된다.
				d *= 2;
			}
			System.out.println(step +": d == "+ d);
		}
		//=========================================================
		// 1  3  6  10   15   21    28     36      45     55   
		for(int limit=1; limit<=10; limit++) {
			System.out.print("limit == "+ limit );
			int sum =0;
			for(int val =1 ; val <=limit; val++) {
			//	System.out.println(val);
				sum += val;
			}
			System.out.println("/ sum == "+ sum);
		}
		int total = 0;
		for(int num=1; num<=10; num++) {
			System.out.print("num == "+ num );
			total += num;
			System.out.println("/ total == "+ total);
		}
	}
}

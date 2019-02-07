class Source02_While {
	public static void main(String[] args) 	{
		/*
			while 은
			데이터 상태에 따라 작업 처리를 여러번 일어나게 구현하는데 적합하다.
			(for loop는 특정회수만 작업처리가 일어나게 구현하는데 적합함)

			while (상태체크 -> true 반복 /false 종료) { 반복내용}
		*/
		int val = 0;
		int cnt = 0;
		while(val<=100){
			cnt++;
			int r = (int)(Math.random()*10);
			System.out.println("[Loop] r = "+r+ " / val = "+val +" / cnt = "+cnt);
			val += r;
		}

		System.out.println();
		System.out.println("[Main] val = " + val+" cnt = " + cnt);
		System.out.println();

	}
}

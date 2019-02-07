
class Source02_While {
	public static void main(String[] args) {
		/*
			while 은 
			데이터 상태에 따라 작업 처리를 여러번 일어나게 구현하는데 적합하다.
			(for loop 은 특정회수만 작업처리가 일어나게 구현하는데 적합함)
		*/
		int val = 0;
		int cnt = 0;
		while( val <= 100 ) {
			cnt++;
			int r = (int)(Math.random()*10);
			val += r;
			System.out.println("[loop] r = " + r + "/ val = " + val +" .."+cnt+" tried");
		}
		System.out.println("[main] val = " + val);
	}
}

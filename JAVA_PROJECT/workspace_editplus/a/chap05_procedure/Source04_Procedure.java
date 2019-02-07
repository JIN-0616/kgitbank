class Source04_Procedure {

	static int fibonachi(int idx) {
		if(idx ==1) {
			return 1;
		}else {
			int prev=0;
			int current =1;
			for(int cnt=1; cnt<=idx-1; cnt++) {
				int next = prev+current;
				prev = current;
				current = next;
			}
			return current;
		}
	}

	static double range(int x1, int y1, int x2, int y2) {
		// xÂ÷ Á¦°ö, yÂ÷ Á¦°öÀÇ ·çÆ®
		double r = (x1-x2)*(x1-x2) + Math.pow(y1-y2, 2);
		double rst = Math.sqrt(r);
		return rst;
		// return  Math.sqrt(r);
	}

	public static void main(String[] args) 	{
		System.out.println(fibonachi(3));
		int v = fibonachi(10);
		System.out.println("v= "+v);

		System.out.println(range(0,0, 3, 4));
		System.out.println( range(-1,-1, 2, 3) );
		System.out.println( range(0, 0 , -5, -12) );
	}
}

class UpDown_YHH {
	static int random(int n1, int n2) {
		return n1+(int)(Math.random()*(n2-n1+1) );
	}
	// 1~200������ �������� ������ ��� : int random() { ..
	static int random( ) {
		return random(1, 200);
	}
	
	// �μ��߿� ū���� ������ִ� ��� : int greater(int n1, int n2) { ..
	static int greater(int n1, int n2) {
		return n1> n2 ? n1 : n2;
	}
	// �μ��߿� �������� ������ִ� ��� : int less(int n1, int n2) { ..
	static int less(int n1, int n2) {
		if(n1<n2)
			return n1;
		else
			return n2;
	}
	// �����ϳ��� ������ ��� : int handle(String data, int min, int max) { ..
	static int handle(String data, int min, int max) { 
		int r;
		switch(data){
		case "":
			r = random(min, max);
			break;
		default :
			r = Integer.valueOf(data);
		}
		return r;
	}

	public static void main(String[] args) {
		int t1,t2;
		int min1, min2;
		int max1, max2;
		int tried = 0;
		boolean done1, done2;
		//===================================
		t1 = random();
		t2 = random();
		// t1 = t2 = random();	
		min1 = min2 = 1;
		max1 = max2 = 200;
		done1 = done2 = false;
		System.out.println("[SYSTEM] UPDOWN VS_MODE");
		while(done1 != true && done2 != true) {
			System.out.println();
			System.out.println("[SYSTEM] ROUND "+ ++tried);
			System.out.print("[SYSTEM] YOU ("+min1 +" ~ " + max1+") " );
			String in = System.console().readLine();
			int g1 = handle(in, min1, max1);
			int g2 = handle("", min2, max2);
			System.out.println("[SYSTEM] COM ("+min2 +" ~ " + max2+") " + g2 );
			
			System.out.print("[SYSTEM] PRESS ENTER ");
			System.console().readLine();

			if(g1 > t1) {
				System.out.println("[SYSTEM] YOUR "+ g1 +" IS GREATER ");
				max1 = less(g1, max1);
			} else if(g1 <t1) {
				System.out.println("[SYSTEM] YOUR "+ g1 +" IS LESS ");
				min1 = greater(g1, min1);
			} else {
				System.out.println("[SYSTEM] YOUR "+ g1 +" IS CORRECT!  ");
				done1 = true;
			}

			if(g2 > t2) {
				System.out.println("[SYSTEM] COMS "+ g2 +" IS GREATER ");
				max2 = less(g2, max2);
			}else if(g2 <t2) {
				System.out.println("[SYSTEM] COMS "+ g2 +" IS LESS ");
				min2 = greater(g2, min2);
			}else {
				System.out.println("[SYSTEM] COMS "+ g2 +" IS CORRECT!  ");
				done2 = true;
			}
		}
		/*
			����鼭 ���� ���ŷο��� �۾��� ��ſ���..?
			���� �̰� AI�� Ȥ�� ����� �ϳ� �� ���� 3�� ���� �ٲ۴ٸ� ����� ���� ���ŷӰڴ°�..?

			���ν��� �߽��� ���� ������ ó���� ������ ���ߴٺ���, ������ ���ŷӴ�.
			�߰����� �������� �� �����ؾ��ϰ�, ����Ǵ� �͵鵵 �����߿� ������ �ٲ���� �ϴ� ���ŷο��� �ִ�.

			������ó���� + �����Ͱ����� ���ŷο��� ������ ����� �����ϴµ�,
			�̰� ��ü �߽�(��ü����)�� ���α׷����̴�.
		*/

		
	}
}

class Source03_If {
	public static void main(String[] args) 	{
		/*
			if - else branch ���鶧 �˾Ƶ� �͵�.
			
			1. ����� branch �̴�, branch �ȿ� �ؾߵ� ó���� �ϳ���� { } �� �����ص� �ȴ�.
		*/
		int r = 100;
		boolean flag = Math.random()>0.5;
		System.out.println("r == "+ r + " , " + flag);
		if(flag == true)	 // if(flag)
			r *= 10;
		else
			r += 100;

		System.out.println("r == "+ r);
		//====================================================
		// 2. branch �ȿ��� ������ ����� ����Ҽ� ������, 
		// �̰� �ش� branch ������ ��밡���ϴ�.
		if(Math.random() > 0.3) {
			int d = r/10 + r%10;
			System.out.println("d == " + d);
		} else {
			String d = "branch";
			System.out.println("d == " + d);
		}
		// System.out.println("d == " +d);
		
	}
}

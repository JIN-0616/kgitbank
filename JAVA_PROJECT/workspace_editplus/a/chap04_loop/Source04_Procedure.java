class Source04_Procedure {
	/*
		n��° �Ǻ���ġ ���� ������ ���ν����� ����
		int�� �����°� �����̰�, int �ϳ��� �޾Ƽ� �۵��ǰ� fibonachi ��� �̸����� ����� �ȴ�.
	*/

	/*
		2���������� ��ǥ �ΰ� �Ÿ��� ������ִ� ���ν����� ����
		double�� �����°� �����̰�, int 4���� �޾Ƽ� �۵��ǰ� range ��� �̸����� �����޶�
		(int x1, int y1, int x2, int y2)

	*/

	public static void main(String[] args) 	{
		// 1��°�� �Ƹ� �������� 1, ���� ����� 2��° �����͸� ����� �ϸ� �Ǵµ�..
		// 
		int prev = 0;
		int current = 1;
		for(int cnt=1; cnt<=5; cnt++){
			int next = prev + current;
			prev = current;
			current = next;
			System.out.println(cnt + ") " + prev+" .. " + current);
		}
		// �� �۾��� ó���Ҽ� �ְ� ���ν����� ����ð�
		
		int v = fibonachi(3);
		System.out.prinltn(v);	// 2
		System.out.println( fibonachi(10) );	// 55
		System.out.println( fibonachi(15) );	// 610

	}
}

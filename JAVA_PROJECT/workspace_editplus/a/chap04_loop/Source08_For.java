class Source08_For {
	public static void main(String[] args) 	{
		/*
			�����ȿ��� �ٽ� ������ �����ϴ� ������ ������ ���������ϴ�.
		*/
		for(int lv=1; lv<=5; lv++) {
			System.out.println("lv == "+lv);
			for(int step=1; step<=10; step++) {
				System.out.println("step == "+lv+"-"+step);
			}
			System.out.println();
		}
		/*
			�̷� ������ loop ��, 2�� 1�������� 10���������� ����غ���.
		*/
		for(int step=1; step<=10; step++) {
			int d = 1;
			for(int cnt=1; cnt<=step; cnt++) {		
				// �ٱ��� loop�� ��ȭ�ϴ� ���� ������, ���η����� �������� ����ϴ� ���°�
				// �ߺ������� loop �� ���� ���� ������ �ʿ��ϰ� �ȴ�.
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

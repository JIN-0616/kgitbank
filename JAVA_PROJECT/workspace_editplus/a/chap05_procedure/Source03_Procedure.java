/*
	���α׷� ������ �ʿ��� ���ν����� ��� �����Ҳ����� �����̴�.
	�ش� main�� ������ �ִ� ���Ͼȿ� ���� �ǰ�, �׷��� �ʾƵ� �ȴ�.
	���� �����߳Ŀ� ���� ȣ��(���) �ϴ� ����� �޶�����.

	������ ȣ���� �����ϰ� �ϱ� ���� ���α׷��� ����� ���Ͽ� ���� �����غ���.

*/
class Source03_Procedure {
	
	// ���ν�������� ȣ��û����̸�(ȣ���Ҷ� ���޹��� ����������)
	// 1. ������������ 2���� ���޹޾Ƽ� �� ������ ���� ������� ������ gap �̶�� ���ν����� ������� ��
	static int gap(int n1, int n2) {
		System.out.println("gap procedure called.." +n1 +" / "+ n2);
		int d = n1 - n2;
		if(d<0)
			d *= -1;
		System.out.println("procedure done.."+d);
		// ���ν����۾��� ������� ���ν����� ���ߴ� �������� �����ִ� Ű������ return �� �̿��ؼ� ����
		return d;	
	}

	// 2. ���������� 2���� ���޹޾Ƽ� �������� ����ؼ� ������� ������ power ��� ���ν����� ������
	// ���ο��� ������ ���ν��� ���� �ؼ� ����� ������� �޴��� Ȯ��.
	static int power(int n, int step) {
		int r= 1;
		for(int cnt=1; cnt<=step; cnt++) {
			r *= n;
		}
		return r;
	}
	static int power_2(int n, int step) {
		int r= (int)Math.pow(n, step);
		return r;
	}

	// 3. ���������� �ϳ��� �޾Ƽ� 3�ڸ����� �ĸ��� ���� ���ڿ��� ������ ���ν��� �̸� format
	static String format(int val) {
		String str="";
		int cnt=0;
		do {
			str = val%10+str;
			val /=10;
			if(val==0)
				break;
			cnt++;
			if(cnt%3==0)
				str = ","+str;
		}while(val>0);

		return str;
	}

	//����������������������������������������
	public static void main(String[] args) {
		System.out.println("main - start");
		System.out.println(format(1231));
		System.out.println(format(1111231));
		String s1 = format(231);
		// ������ ���ν����� ��� �Ѵٸ�	Math.pow() �� ����� ���·� ���� �ϸ�ȴ�.
		// gap();
		// gap(true, 5);
		System.out.println(gap(5, 11));
		int r = gap(45, 32);
		System.out.println("r == "+ r);
		System.out.println(power(10, 3));
		int rr = power(2, 11);
		System.out.println(rr);
		System.out.println("main - end");
	}
}


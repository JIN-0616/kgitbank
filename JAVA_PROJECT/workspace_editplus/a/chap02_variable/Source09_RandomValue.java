/*
	����Ȱ�� / �Է°����� / �����ͺ�ȯ�� �������ϱ� ����
	Ȯ�� ���α׷��� ������� �ϴµ�, 
	��������� ���������͸� ����¹��� ���� �˾ƺ���.
*/
class Source09_RandomValue {
	public static void main(String[] args) {
		/*
			���� �Ǽ��� ���� ����ϱ� �����Ѵ�. 
			(���� , ��, ���ڿ��� ������� ������ �ʿ��ϴ�)
		*/
		Math.random();	
		// �̰� ����ϸ� 0.0 <=    <1.0 �̸��� �Ǽ���ġ (double)�� ������� �ִ�.
		System.out.println(Math.random());
		double e = Math.random();
		System.out.println(e);
		System.out.println(e);
		// ������ġ�� �ʿ��ϸ� casting �� �̿��ϸ� �ȴ�.
		int v = (int)(Math.random() * 10);		
		// 0.0 <=   <10.0 ���� 0 <=    <10 �̸��������� ����� �ִ�
		System.out.println(v);
		// �ʿ��ġ�� 6 ~ 10 �� �������,
		int vv = 6 + (int)(Math.random() * 5);		// start +(int)(Math.random()*����)
		// 0.0 ~ 30.0 ������ �Ǽ���ġ�� �������..?
		double d1 =(int)(Math.random()*301)/10.0;
		double d2 = Math.random()*30;
		System.out.println("d1 = "+ d1);
		// �� ~ �� ������ ���� ���ڸ� �������..?
		char c1 = (char)('��' + (int)(Math.random() * ('��'-'��'+1)) );
		System.out.println(c1);
	}
}
